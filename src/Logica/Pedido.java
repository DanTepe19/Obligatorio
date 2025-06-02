/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.PedidoException;
import java.time.LocalDateTime;
import observer.Observable;

/**
 *
 * @author diego
 */
public class Pedido extends Observable{

    private Item item;
    private Gestor gestor;
    private EstadoPedido estado;
    private String comentario;
    private LocalDateTime fechaHora;
    private Servicio servicio;

    public Pedido(Item item, String comentario, Servicio servicio) {
        this.item = item;
        this.gestor = null;
        this.estado = new NoConfirmado();
        this.comentario = comentario;
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
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

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        avisar(EventosPedido.CAMBIO_ESTADO_PEDIDO);
    }

    public void confirmar() throws PedidoException {
        estado.confirmar(this);
        this.fechaHora = LocalDateTime.now();
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

    public void restarStock() {
        item.restarStock(); 
        avisar(EventosPedido.CAMBIO_STOCK);
    }

    public void sumarStock() {
        item.sumarStock();
        avisar(EventosPedido.CAMBIO_STOCK);
    }
    

}
