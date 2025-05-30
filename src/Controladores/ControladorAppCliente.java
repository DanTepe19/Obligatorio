/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Excepciones.PedidoException;
import IU.IVistaAppCliente;
import Logica.CategoriaItem;
import Logica.Cliente;
import Logica.Dispositivo;
import Logica.EventosPedido;
import Logica.Servicio;
import Logica.Fachada;
import Logica.Item;
import Logica.Pedido;
import java.util.ArrayList;
import observer.Observable;
import observer.Observador;

/**
 *
 * @author diego
 */
public class ControladorAppCliente implements Observador{

    private IVistaAppCliente vista;
    private Cliente cliente;
    private Dispositivo dispositivo;
    private Servicio servicio;
    private CategoriaItem categoria;

    public ControladorAppCliente(IVistaAppCliente vista, Cliente cliente) {
        this.vista = vista;
        this.cliente = cliente;
        this.dispositivo = cliente.getDispositivo();
        this.servicio = cliente.getServicio();
        this.servicio.agregarObservador(this);
        this.dispositivo.agregarObservador(this);
        inicializarVista();
    }

    private void inicializarVista() {
        cargarCategorias();
        cargarItems();
    }

    Fachada f = Fachada.getInstancia();

    private void cargarCategorias() {
        vista.mostrarCategorias(f.getCategorias());
    }

    private void cargarItems() {
        vista.mostrarItems(f.obtenerItems());
    }

    private void cargarPedidos() {
        vista.mostrarPedidos(servicio.getPedidos());
    }

    private void cargarMontoTotal() {
        vista.mostrarMontoTotal(servicio.obtenerMontoFinal());
    }

    public void seleccionarCategoria(String selectedCategoria) {
        categoria = f.getCategoria(selectedCategoria);
        ArrayList<Item> items = f.obtenerItemsPorCategoria(categoria);
        vista.mostrarItems(items);
    }

    public Item getItem(String nombreItem) {
        return f.getItem(nombreItem);
    }

    public void agregarPedido(Item item, String comentario) throws PedidoException {
        if (cliente == null) {
            throw new PedidoException("Debe identificarse antes de realizar pedidos");
        }
        if (item == null) {
            throw new PedidoException("Debe seleccionar un ítem");
        }
        if (!item.hayStock()) {
            ArrayList<Pedido> pedidos = servicio.getPedidos();
            ArrayList<Pedido> pedidosParaEliminar = new ArrayList<>();
            for (Pedido p : pedidos) {
                if (p.getItem().equals(item) && p.getEstado().getNombre().equals("NO_CONFIRMADO")) {
                    pedidosParaEliminar.add(p);
                }
            }

            pedidos.removeAll(pedidosParaEliminar);

            throw new PedidoException("Lo sentimos, nos hemos quedado sin stock de " + item.getNombre() + " por lo que lo hemos quitado del pedido del servicio");
        }

        Pedido nuevoPedido = new Pedido(item, dispositivo, comentario);
        nuevoPedido.agregarObservador(this);
        f.agregarPedido(nuevoPedido, servicio);
        //f.obtenerMontoFinal(servicio);
        
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento.equals(EventosPedido.PEDIDO_AGREGADO) || evento.equals(EventosPedido.CAMBIO_ESTADO_PEDIDO) || evento.equals(EventosPedido.PEDIDO_ELIMINADO)){
            cargarPedidos();
            cargarMontoTotal();
        }
    }
    
    public void eliminarPedido(Pedido eliminarPedido) throws PedidoException {
        if(cliente == null){
            throw new PedidoException("Debe identificarse antes de realizar pedidos");
        }
        if(eliminarPedido == null){
            throw new PedidoException("Debe seleccionar un pedido");
        }
        f.eliminarPedido(eliminarPedido, servicio);
    }
    
    public Servicio getServicio(){
        return servicio;
    }
    

}
