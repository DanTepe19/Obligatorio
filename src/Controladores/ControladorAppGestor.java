/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import IU.IVistaAppGestor;
import Logica.EventosPedido;
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
    }

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

}
