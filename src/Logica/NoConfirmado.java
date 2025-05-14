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
public class NoConfirmado extends EstadoPedido {

    @Override
    public void confirmar(Pedido pedido) throws PedidoException {
        pedido.setEstado(new Confirmado());
    }

    @Override
    public void asignarGestor(Pedido pedido, Gestor gestor) throws PedidoException {
        throw new PedidoException("No se puede asignar gestor si el pedido no está confirmado.");
    }

    @Override
    public void finalizar(Pedido pedido) throws PedidoException {
        throw new PedidoException("El pedido no puede finalizarse sin estar confirmado.");
    }

    @Override
    public void entregar(Pedido pedido) throws PedidoException {
        throw new PedidoException("El pedido no puede entregarse sin estar confirmado.");
    }

    @Override
    public String getNombre() {
        return "NO_CONFIRMADO";
    }
    
}
