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
public class Confirmado extends EstadoPedido {
    
    @Override
    public void confirmar(Pedido pedido) throws PedidoException {
        throw new PedidoException("El pedido ya está confirmado.");
    }

    @Override
    public void asignarGestor(Pedido pedido, Gestor gestor) {
        pedido.setGestor(gestor);
        pedido.setEstado(new EnProceso());
    }

    @Override
    public void finalizar(Pedido pedido) throws PedidoException {
        throw new PedidoException("El pedido aún no está en proceso.");
    }

    @Override
    public void entregar(Pedido pedido) throws PedidoException {
        throw new PedidoException("El pedido aún no está finalizado.");
    }

    @Override
    public String getNombre() {
        return "CONFIRMADO";
    }
    
}
