/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.PedidoException;
import observer.Observable;

/**
 *
 * @author diego
 */
public class Pedido extends Observable{

    private Item item;
    private Gestor gestor;
    private Dispositivo dispositivo;
    private EstadoPedido estado;
    private String comentario;

    public Pedido(Item item, Dispositivo dispositivo, String comentario) {
        this.item = item;
        this.dispositivo = dispositivo;
        this.gestor = null;
        this.estado = new NoConfirmado();
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
        avisar(EventosPedido.CAMBIO_ESTADO_PEDIDO);
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
