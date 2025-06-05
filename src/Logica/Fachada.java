/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.ClienteException;
import Excepciones.GestorException;
import Excepciones.PedidoException;
import java.util.ArrayList;
import observer.Observable;
import observer.Observador;

/**
 *
 * @author diego
 */
public class Fachada extends Observable implements Observador {
    private static final Fachada instancia = new Fachada();
    
    SistemaDispositivos sistemaDispositivos = SistemaDispositivos.getInstancia();
    SistemaClientes sistemaClientes = SistemaClientes.getInstancia();
    SistemaGestores sistemaGestores = SistemaGestores.getInstancia();
    SistemaPedidos sistemaPedidos = SistemaPedidos.getInstancia();
    SistemaServicios sistemaServicios = SistemaServicios.getInstancia();
    
    public static Fachada getInstancia(){
        return instancia;
    }
    
    public Gestor loginGestor(String usuario, String password) throws GestorException{
        return sistemaGestores.loginGestor(usuario, password);
    }
    
    public Cliente loginCliente(String usuario, String password) throws ClienteException{
        return sistemaClientes.loginCliente(usuario, password, getDispositivos());
    }
    
    public ArrayList<Dispositivo> getDispositivos(){
        return sistemaDispositivos.getDispositivos();
    }
    
    public ArrayList<CategoriaItem> getCategorias(){
        return sistemaPedidos.getCategorias();
    }

    public ArrayList<Item> obtenerItems() {
        return sistemaPedidos.obtenerItems();
    }
    
    public CategoriaItem getCategoria(String nombre){
        return sistemaPedidos.getCategoria(nombre);
    }

    public ArrayList<Item> obtenerItemsPorCategoria(CategoriaItem categoria) {
        return sistemaPedidos.obtenerItemsPorCategoria(categoria);
    }

    public Item getItem(String nombreItem) {
        return sistemaPedidos.getItem(nombreItem);
    }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void agregarPedido(Pedido nuevoPedido, Servicio servicio) {
        sistemaServicios.agregarPedido(nuevoPedido, servicio);
    }
    
    public void eliminarPedido(Pedido eliminarPedido, Servicio servicio){
        sistemaServicios.eliminarPedido(eliminarPedido, servicio);
    }
    
    public int obtenerMontoFinal(Servicio servicio){
        return sistemaServicios.obtenerMontoFinal(servicio);
    }

    public void confirmarPedidos(Pedido p, Servicio servicio) throws PedidoException {
        sistemaServicios.confirmarPedido(p, servicio);
    }

    public void liberarDispositivo(Dispositivo dispositivo) {
        sistemaDispositivos.liberarDispositivo(dispositivo);
    }

    public void tomarPedido(Pedido pedidoSeleccionado, Gestor gestor) throws PedidoException {
        sistemaPedidos.tomarPedido(pedidoSeleccionado, gestor);
    }

    public void finalizarPedido(Pedido pedido) throws PedidoException {
        sistemaPedidos.finalizarPedido(pedido);
    }

    public void entregarPedido(Pedido pedido) throws PedidoException {
        sistemaPedidos.entregarPedido(pedido);
    }
    
    public void cerrarSesion(Object usuario){
        if(usuario instanceof Cliente){
            sistemaClientes.cerrarSesion(usuario);
        } else {
            sistemaGestores.cerrarSesion(usuario);
        }
    }
}
