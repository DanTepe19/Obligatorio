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
    
    //private ArrayList<Pedido> pedidos = DatosPrueba.getPedidos();
    
    public synchronized static SistemaPedidos getInstancia() {
        if (instancia == null) {
            instancia = new SistemaPedidos();
        }
        return instancia;
    }
    
    /*public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }*/
    
}
