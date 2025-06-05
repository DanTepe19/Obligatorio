/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Excepciones.PedidoException;
import IU.IVistaAppGestor;
import IU.Mensaje;
import Logica.EventosPedido;
import Logica.Fachada;
import Logica.Gestor;
import Logica.Pedido;
import Logica.Procesadora;
import observer.Observable;
import observer.Observador;

/**
 *
 * @author diego
 */
public class ControladorAppGestor implements Observador {

    private Gestor gestor;
    private Procesadora procesadora;
    private IVistaAppGestor vista;

    public ControladorAppGestor(IVistaAppGestor vista, Gestor gestor) {
        this.vista = vista;
        this.gestor = gestor;
        this.procesadora = gestor.getProcesadora();
        this.procesadora.agregarObservador(this);
        inicializarVista();
    }

    private void inicializarVista() {
        cargarPedidosPendientes();
        cargarPedidosGestor();
        registrarObservadoresEnPedidos();
    }

    Fachada f = Fachada.getInstancia();

    @Override
    public void actualizar(Observable origen, Object evento) {

        if (evento instanceof Pedido p) {
            p.agregarObservador(this);
            cargarPedidosPendientes();
            cargarPedidosGestor();
        } else if (evento.equals(EventosPedido.PEDIDO_AGREGADO) || evento.equals(EventosPedido.CAMBIO_ESTADO_PEDIDO) || evento.equals(EventosPedido.PEDIDO_ELIMINADO)) {
            cargarPedidosPendientes();
            cargarPedidosGestor();
        }
    }

    private void cargarPedidosPendientes() {
        vista.mostrarPedidosPendientes(procesadora.getPedidos());
    }

    private void cargarPedidosGestor() {
        vista.mostrarPedidosGestor(gestor.getPedidos());
    }

    public void tomarPedido(Pedido pedidoSeleccionado) throws PedidoException {
        if (pedidoSeleccionado == null) {
            throw new PedidoException("Debe seleccionar un pedido");
        }
        f.tomarPedido(pedidoSeleccionado, gestor);
    }

    public void finalizarPedido(Pedido pedido) throws PedidoException {
        if (pedido == null) {
            throw new PedidoException("Debe seleccionar un pedido");
        }
        if (pedido.getEstado().getNombre().equals("FINALIZADO")) {
            throw new PedidoException("El pedido ya está finalizado");
        }
        if (pedido.getEstado().getNombre().equals("ENTREGADO")) {
            throw new PedidoException("El pedido ya está entregado");
        }

        f.finalizarPedido(pedido);

    }

    public void entregarPedido(Pedido pedido) throws PedidoException {
        if (pedido == null) {
            throw new PedidoException("Debe seleccionar un pedido");
        }
        if (!pedido.getEstado().getNombre().equals("FINALIZADO") && !pedido.getEstado().getNombre().equals("ENTREGADO")) {
            throw new PedidoException("Debe finalizar el pedido");
        }
        if (pedido.getEstado().getNombre().equals("ENTREGADO")) {
            throw new PedidoException("El pedido ya está entregado");
        }

        f.entregarPedido(pedido);
    }

    private void registrarObservadoresEnPedidos() {
        for (Pedido p : procesadora.getPedidos()) {
            if (!p.tieneObservador(this)) {
                p.agregarObservador(this);
            }
        }
        for (Pedido p : gestor.getPedidos()) {
            if (!p.tieneObservador(this)) {
                p.agregarObservador(this);
            }
        }
    }

}
