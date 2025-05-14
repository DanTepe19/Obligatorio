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
public abstract class EstadoPedido {
    public abstract void confirmar(Pedido pedido) throws PedidoException;
    public abstract void asignarGestor(Pedido pedido, Gestor gestor) throws PedidoException;
    public abstract void finalizar(Pedido pedido) throws PedidoException;
    public abstract void entregar(Pedido pedido) throws PedidoException;
    public abstract String getNombre();  
}
