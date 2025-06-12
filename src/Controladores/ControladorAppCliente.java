/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Excepciones.PedidoException;
import IU.IVistaAppCliente;
import Logica.CategoriaItem;
import Logica.Cliente;
import Logica.Comun;
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
public class ControladorAppCliente implements Observador {

    private IVistaAppCliente vista;
    private Cliente cliente;
    private Dispositivo dispositivo;
    private Servicio servicio;
    private CategoriaItem categoria;
    private ControladorAppGestor controladorAppGestor;

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

    private void cargarPedidosConfirmados() {
        vista.mostrarPedidos(servicio.getPedidosConfirmados());
    }

    private void cargarMontoTotal() {
        vista.mostrarMontoTotal(servicio.obtenerMontoTotal());
    }

    private void cargarMontoTotalConfirmados() {
        vista.mostrarMontoTotal(servicio.obtenerMontoTotalConfirmados());
    }

    private String obtenerDatosBeneficio() {
        String mensaje = "";
        int montoTotal = servicio.obtenerMontoTotal();
        int montoFinal = servicio.obtenerMontoFinal();
        int beneficio = montoTotal - montoFinal;
        if (cliente.getTipo() instanceof Comun) {
            mensaje += "El monto final es: $" + montoTotal;
        } else {
            mensaje += "El monto final es: $" + montoFinal + ". ";
            mensaje += "El monto del beneficio es: $" + beneficio + ". ";
        }
        mensaje += servicio.obtenerDescripcionDescuento();

        return mensaje;
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

        ArrayList<Pedido> pedidos = servicio.getPedidos();
        ArrayList<Pedido> pedidosParaEliminar = new ArrayList<>();

        if (!item.hayStock()) {
            for (Pedido p : pedidos) {
                if (p.getItem().equals(item) && p.getEstado().getNombre().equals("NO_CONFIRMADO")) {
                    pedidosParaEliminar.add(p);
                }
            }

            pedidos.removeAll(pedidosParaEliminar);

            throw new PedidoException("Lo sentimos, nos hemos quedado sin stock de " + item.getNombre() + " por lo que lo hemos quitado del pedido del servicio");
        }

        Pedido nuevoPedido = new Pedido(item, comentario, servicio);
        nuevoPedido.agregarObservador(this);
        f.agregarPedido(nuevoPedido, servicio);

    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (origen instanceof Pedido pedido && evento.equals(EventosPedido.CAMBIO_ESTADO_PEDIDO)) {
            if (pedido.getEstado().getNombre().equals("FINALIZADO")) {
                String mensaje = "Tu pedido '" + pedido.getItem().getNombre() + "' ha sido finalizado. ¡Ya podés retirarlo!";
                vista.mostrarNotificacion(mensaje);
            }
            cargarPedidos();
            cargarMontoTotal();
        } else if (evento.equals(EventosPedido.PEDIDO_AGREGADO) || evento.equals(EventosPedido.PEDIDO_ELIMINADO)) {
            cargarPedidos();
            cargarMontoTotal();
        }
    }

    public void eliminarPedido(Pedido eliminarPedido) throws PedidoException {
        if (cliente == null) {
            throw new PedidoException("Debe identificarse antes de realizar pedidos");
        }
        if (eliminarPedido == null) {
            throw new PedidoException("Debe seleccionar un pedido");
        }
        if(eliminarPedido.getEstado().getNombre().equals("FINALIZADO")){
            throw new PedidoException("Este pedido ya finalizó. Podés ir a retirarlo!");
        }
        if(eliminarPedido.getEstado().getNombre().equals("ENTREGADO")){
            throw new PedidoException("Este pedido ya fue entregado.");
        }
        if(!eliminarPedido.getEstado().getNombre().equals("NO_CONFIRMADO") && !eliminarPedido.getEstado().getNombre().equals("CONFIRMADO") ){
            throw new PedidoException("Un poco tarde... Ya estamos elaborando este pedido!");
        }
        f.eliminarPedido(eliminarPedido, servicio);
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void confirmarPedidos() throws PedidoException {
        ArrayList<Pedido> pedidos = servicio.getPedidos();

        if (cliente == null) {
            throw new PedidoException("Debe identificarse antes de realizar pedidos");
        }
        if (pedidos == null || pedidos.isEmpty()) {
            throw new PedidoException("No hay pedidos nuevos");
        }

        ArrayList<Pedido> pedidosParaEliminar = new ArrayList<>();
        ArrayList<String> itemsYaReportados = new ArrayList<>();
        boolean huboFalloStock = false;
        StringBuilder mensajeError = new StringBuilder();

        for (Pedido p : pedidos) {
            if (!p.getItem().hayStock() && p.getEstado().getNombre().equals("NO_CONFIRMADO")) {
                pedidosParaEliminar.add(p);
                huboFalloStock = true;

                String nombreItem = p.getItem().getNombre();
                if (!itemsYaReportados.contains(nombreItem)) {
                    mensajeError.append("Nos hemos quedado sin stock de ")
                            .append(nombreItem)
                            .append(" y no pudimos avisarte antes!\n");
                    itemsYaReportados.add(nombreItem);
                    p.sumarStock();
                }

                cargarPedidosConfirmados();
                cargarMontoTotalConfirmados();
            } else if (p.getEstado().getNombre().equals("NO_CONFIRMADO")) {
                f.confirmarPedidos(p, servicio);
                p.agregarObservador(controladorAppGestor);
            }
        }

        pedidos.removeAll(pedidosParaEliminar);

        if (huboFalloStock) {
            throw new PedidoException(mensajeError.toString().trim());
        }
    }

    public String finalizarServicio() throws PedidoException {
        try {
            ArrayList<Pedido> pedidos = servicio.getPedidos();
            ArrayList<Pedido> pedidosSinConfirmar = servicio.getPedidosSinConfirmar();
            ArrayList<Pedido> pedidosEnProceso = servicio.getPedidosEnProceso();

            if (cliente == null) {
                throw new PedidoException("Debe identificarse antes de realizar pedidos");
            } else if (pedidos.isEmpty()) {
                throw new PedidoException("");
            } else if (!pedidosSinConfirmar.isEmpty()) {
                throw new PedidoException("Tienes pedidos sin confirmar!");
            }

            StringBuilder mensaje = new StringBuilder();
            mensaje.append(obtenerDatosBeneficio()).append("\n");
            if (!pedidosEnProceso.isEmpty()) {
                mensaje.append("Tenés ").append(pedidosEnProceso.size())
                        .append(" pedidos en proceso. ¡Recordá ir a retirarlos!");
            } else {
                mensaje.append("Pago realizado.");
            }

            return mensaje.toString();
        } finally {
            f.liberarDispositivo(dispositivo);
            f.cerrarSesion(cliente);
        }
    }

}
