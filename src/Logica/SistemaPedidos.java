/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import main.DatosPrueba;

/**
 *
 * @author diego
 */
public class SistemaPedidos {
    
    private static SistemaPedidos instancia;
    
    private ArrayList<Pedido> pedidos = new ArrayList();
    private ArrayList<CategoriaItem> categorias = DatosPrueba.getCategorias();
    
    public synchronized static SistemaPedidos getInstancia() {
        if (instancia == null) {
            instancia = new SistemaPedidos();
        }
        return instancia;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public ArrayList<CategoriaItem> getCategorias() {
        return categorias;
    }

    public void realizarPedidos(Cliente cliente) {
        Dispositivo d = cliente.getDispositivo();
        getCategorias();
        obtenerItems();
        d.getPedidos();
        d.getMontoTotal();
    }

    public ArrayList<Item> obtenerItems() {
        ArrayList<Item> items = new ArrayList();
        for(CategoriaItem c : categorias){
            for(Item i : c.getItems()){
                if(!items.contains(i)){
                    items.add(i);
                }
            }
        }
        return items;
    }
    
    public CategoriaItem getCategoria(String nombre){
        for(CategoriaItem c : categorias){
            if(c.getNombre().equals(nombre)){
                return c;
            }
        }
        return null;
    }

    public ArrayList<Item> obtenerItemsPorCategoria(CategoriaItem categoria) {
        ArrayList<Item> items = new ArrayList<>();
        for(Item i : categoria.getItems()){
            if(i.hayStock()){
                items.add(i);
            }
        }
        return items;
     }
    
}
