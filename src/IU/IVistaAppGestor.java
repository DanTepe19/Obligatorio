/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IU;

import Logica.Pedido;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public interface IVistaAppGestor {
    
    void mostrarPedidosPendientes(ArrayList<Pedido> pedidos);
    void mostrarPedidosGestor(ArrayList<Pedido> pedidos);
    void mostrarMensaje(Pedido pedido);
    
}
