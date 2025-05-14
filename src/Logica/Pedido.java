/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.PedidoException;

/**
 *
 * @author diego
 */
public class Pedido {

    private Item item;
    private Gestor gestor;
    private Dispositivo dispositivo;
    private EstadoPedido estado;

    public Pedido(Item item, Dispositivo dispositivo) {
        this.item = item;
        this.dispositivo = dispositivo;
        this.gestor = null;
        this.estado = new NoConfirmado();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void confirmar() throws PedidoException {
        estado.confirmar(this);
    }

    public void asignarGestor(Gestor gestor) throws PedidoException {
        estado.asignarGestor(this, gestor);
    }

    public void marcarFinalizado() throws PedidoException {
        estado.finalizar(this);
    }

    public void marcarEntregado() throws PedidoException {
        estado.entregar(this);
    }

}
