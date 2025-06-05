/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IU;

import Logica.CategoriaItem;
import Logica.Item;
import Logica.Pedido;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public interface IVistaAppCliente {
    
    void mostrarCategorias(ArrayList<CategoriaItem> categorias);
    void mostrarItems(ArrayList<Item> items);
    void mostrarPedidos(ArrayList<Pedido> pedidos);
    void mostrarMontoTotal(int montoTotal);
    void mostrarNotificacion(String mensaje);
    void mostrarDatosBeneficio(String mensaje);
    
}
