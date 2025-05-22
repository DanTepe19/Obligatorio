/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import IU.IVistaAppCliente;
import Logica.Cliente;
import Logica.Dispositivo;
import Logica.Fachada;

/**
 *
 * @author diego
 */
public class ControladorAppCliente {
    
    private IVistaAppCliente vista;
    private Cliente cliente;
    private Dispositivo dispositivo;
    
    public ControladorAppCliente(IVistaAppCliente vista, Cliente cliente){
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
    
}
