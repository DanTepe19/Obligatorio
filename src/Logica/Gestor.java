/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.PedidoException;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Gestor {

    private String nombreUsuario;
    private String password;
    private String nombreCompleto;
    private Procesadora procesadora;
    private ArrayList<Pedido> pedidos;

    public Gestor(String nombreUsuario, String password, String nombreCompleto, Procesadora procesadora) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.procesadora = procesadora;
        this.pedidos = new ArrayList<>();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Procesadora getProcesadora() {
        return procesadora;
    }

    public void setProcesadora(Procesadora procesadora) {
        this.procesadora = procesadora;
    }

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }

    public void tomarPedido(Pedido pedidoSeleccionado) throws PedidoException {
        pedidoSeleccionado.getEstado().asignarGestor(pedidoSeleccionado, this);
        pedidos.add(pedidoSeleccionado);
        procesadora.eliminarPedido(pedidoSeleccionado);
    }

}
