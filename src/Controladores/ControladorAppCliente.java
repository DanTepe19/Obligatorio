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
import Logica.Fachada;
import Logica.Item;
import Logica.Pedido;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class ControladorAppCliente {

    private IVistaAppCliente vista;
    private Cliente cliente;
    private Dispositivo dispositivo;
    private CategoriaItem categoria;

    public ControladorAppCliente(IVistaAppCliente vista, Cliente cliente) {
        this.vista = vista;
        this.cliente = cliente;
        this.dispositivo = cliente.getDispositivo();
        inicializarVista();
        //observador
    }

    private void inicializarVista() {
        cargarCategorias();
        cargarItems();
        /*cargarPedidos();
        cargarMontoTotal();*/
    }

    Fachada f = Fachada.getInstancia();

    private void cargarCategorias() {
        vista.mostrarCategorias(f.getCategorias());
    }

    private void cargarItems() {
        vista.mostrarItems(f.obtenerItems());
    }

    private void cargarPedidos() {
        vista.mostrarPedidos(dispositivo.getPedidos());
    }

    private void cargarMontoTotal() {
        vista.mostrarMontoTotal(dispositivo.getMontoTotal());
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
            ArrayList<Pedido> pedidos = dispositivo.getPedidos();
            ArrayList<Pedido> pedidosParaEliminar = new ArrayList<>();
            for (Pedido p : pedidos) {
                if (p.getItem().equals(item) && p.estaNoConfirmado()) {
                    pedidosParaEliminar.add(p);
                }
            }

            pedidos.removeAll(pedidosParaEliminar);

            throw new PedidoException("Lo sentimos, nos hemos quedado sin stock de " + item.getNombre() + " por lo que lo hemos quitado del pedido del servicio");
        }

        // Crear y agregar el nuevo pedido si todo está bien
        Pedido nuevoPedido = new Pedido(item, dispositivo, comentario);
        dispositivo.getPedidos().add(nuevoPedido);
    }

}
