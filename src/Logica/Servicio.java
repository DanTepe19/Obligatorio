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

    public Servicio(Cliente cliente) {
        this.cliente = cliente;
        this.estado = new Activo();
        this.pedidos = new ArrayList<>();
        this.montoTotal = 0;
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

    public void confirmarPedido(Pedido p) throws PedidoException {
        if(p.getEstado().getNombre().equals("NO_CONFIRMADO")){
            p.confirmar();
            avisar(EventosPedido.CAMBIO_ESTADO_PEDIDO);
            p.restarStock();
            p.getItem().getProcesadora().agregarPedido(p);
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
