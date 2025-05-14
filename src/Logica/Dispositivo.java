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
public class Dispositivo {

    private int numero;
    private EstadoDispositivo estado;
    private Cliente cliente;
    private ArrayList<Pedido> pedidos;

    public Dispositivo(int numero) {
        this.numero = numero;
        this.estado = new Disponible();
        this.pedidos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EstadoDispositivo getEstado() {
        return estado;
    }

    public void setEstado(EstadoDispositivo estado) {
        this.estado = estado;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void asignarCliente(Cliente c) {
        estado.asignarCliente(this, c);
    }

    public void liberar() {
        estado.liberar(this);
    }

    public void confirmarPedidos() throws PedidoException {
        for (Pedido p : pedidos) {
            if (p.getEstado() instanceof NoConfirmado) {
                p.confirmar();
            }
        }
    }
}
