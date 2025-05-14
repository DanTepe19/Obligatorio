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
public class Finalizado extends EstadoPedido {
    
    @Override
    public void confirmar(Pedido pedido) throws PedidoException {
        throw new PedidoException("El pedido ya fue finalizado.");
    }

    @Override
    public void asignarGestor(Pedido pedido, Gestor gestor) throws PedidoException {
        throw new PedidoException("No se puede asignar gestor a un pedido finalizado.");
    }

    @Override
    public void finalizar(Pedido pedido) throws PedidoException {
        throw new PedidoException("Ya está finalizado.");
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.setEstado(new Entregado());
    }

    @Override
    public String getNombre() {
        return "FINALIZADO";
    }
}
