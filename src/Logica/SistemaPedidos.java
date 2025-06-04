/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.PedidoException;
import java.util.ArrayList;
import main.DatosPrueba;
import observer.Observable;

/**
 *
 * @author diego
 */
public class SistemaPedidos extends Observable {
    
    private static SistemaPedidos instancia;
    
    private ArrayList<Pedido> pedidos = new ArrayList();
    private ArrayList<CategoriaItem> categorias = DatosPrueba.getCategorias();
    private ArrayList<Procesadora> procesadoras = DatosPrueba.getProcesadoras();
    
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

    public Item getItem(String nombreItem) {
        for(CategoriaItem c : categorias){
            for(Item i : c.getItems()){
                if(i.getNombre().equals(nombreItem)){
                    return i;
                }
            }
        }
        return null;
    }

    public void tomarPedido(Pedido pedidoSeleccionado, Gestor gestor) throws PedidoException {
        gestor.tomarPedido(pedidoSeleccionado);
    }

    public void finalizarPedido(Pedido pedido) throws PedidoException{
        pedido.getEstado().finalizar(pedido);
    }

    public void entregarPedido(Pedido pedido) throws PedidoException {
        pedido.getEstado().entregar(pedido);
    }
    
}
