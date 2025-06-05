/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.PedidoException;
import java.util.ArrayList;
import observer.Observable;

/**
 *
 * @author diego
 */
public class Servicio extends Observable {
    
    private Cliente cliente;
    private EstadoServicio estado;
    private ArrayList<Pedido> pedidos;
    private int montoTotal;
    private int montoFinal;

    public Servicio(Cliente cliente) {
        this.cliente = cliente;
        this.estado = new Activo();
        this.pedidos = new ArrayList<>();
        this.montoTotal = 0;
        this.montoFinal = 0;
    }

    public int getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(int montoFinal) {
        this.montoFinal = montoFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoServicio getEstado() {
        return estado;
    }

    public void setEstado(EstadoServicio estado) {
        this.estado = estado;
        avisar(EventosServicio.CAMBIO_ESTADO_SERVICIO);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    public void confirmarPedidos() throws PedidoException {
        for (Pedido p : pedidos) {
            if (p.getEstado() instanceof NoConfirmado) {
                p.confirmar();
            }
        }
    }

    public void agregarPedido(Pedido nuevoPedido) {
        if(nuevoPedido != null){
            pedidos.add(nuevoPedido);
            avisar(EventosPedido.PEDIDO_AGREGADO);
        }
    }
    
    public void eliminarPedido(Pedido p){
        if(pedidos.remove(p)){
            avisar(EventosPedido.PEDIDO_ELIMINADO);
            p.sumarStock();
        }
        
    }

    public int obtenerMontoFinal() {
        return cliente.getTipo().obtenerMontoFinal(this);
    }
    
    public int obtenerMontoTotal() {
        return cliente.getTipo().obtenerMontoTotal(this);
    }
    
    public String obtenerDescripcionDescuento(){
        return cliente.getTipo().obtenerDescripcionDescuento(montoTotal);
    }

    public void confirmarPedido(Pedido p) throws PedidoException {
        if(p.getEstado().getNombre().equals("NO_CONFIRMADO")){
            p.confirmar();
            p.restarStock();
            p.getItem().getProcesadora().agregarPedido(p);
            p.getItem().getProcesadora().avisar(p);
            avisar(EventosPedido.CAMBIO_ESTADO_PEDIDO);
        }
    }
    
    public ArrayList<Pedido> getPedidosSinConfirmar(){
        ArrayList<Pedido> pedidosSinConfirmar  = new ArrayList<>();
        for(Pedido p : pedidos){
            if(p.getEstado().getNombre() == "NO_CONFIRMADO"){
                pedidosSinConfirmar.add(p);
            }
        }
        return pedidosSinConfirmar;
    }

    public ArrayList<Pedido> getPedidosConfirmados() {
        ArrayList<Pedido> pedidosConfirmados  = new ArrayList<>();
        for(Pedido p : pedidos){
            if(p.getEstado().getNombre() == "CONFIRMADO"){
                pedidosConfirmados.add(p);
            }
        }
        return pedidosConfirmados;
    }

    public ArrayList<Pedido> getPedidosEnProceso() {
        ArrayList<Pedido> pedidosProcesados  = new ArrayList<>();
        for(Pedido p : pedidos){
            if(p.getEstado().getNombre() == "EN_PROCESO"){
                pedidosProcesados.add(p);
            }
        }
        return pedidosProcesados;
    }
    
    
}
