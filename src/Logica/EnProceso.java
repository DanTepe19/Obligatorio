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
public class EnProceso extends EstadoPedido {
    
    @Override
    public void confirmar(Pedido pedido) throws PedidoException {
        throw new PedidoException("El pedido ya está en proceso.");
    }

    @Override
    public void asignarGestor(Pedido pedido, Gestor gestor) throws PedidoException {
        throw new PedidoException("El pedido ya tiene gestor.");
    }

    @Override
    public void finalizar(Pedido pedido) {
        pedido.setEstado(new Finalizado());
    }

    @Override
    public void entregar(Pedido pedido) throws PedidoException {
        throw new PedidoException("Primero debe finalizarse el pedido.");
    }

    @Override
    public String getNombre() {
        return "EN_PROCESO";
    }
}
