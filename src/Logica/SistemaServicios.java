/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import observer.Observable;

/**
 *
 * @author diego
 */
public class SistemaServicios extends Observable {
    
    private static SistemaServicios instancia;
    
    private ArrayList<Servicio> servicios = new ArrayList<>();
    
    public synchronized static SistemaServicios getInstancia() {
        if (instancia == null) {
            instancia = new SistemaServicios();
        }
        return instancia;
    }

    public void agregarPedido(Pedido nuevoPedido, Servicio servicio) {
       servicio.agregarPedido(nuevoPedido);
    }
    
    public void eliminarPedido(Pedido eliminarPedido, Servicio servicio){
        if( servicio != null){
            servicio.eliminarPedido(eliminarPedido);
        }
    }

    public int obtenerMontoFinal(Servicio servicio) {
        return servicio.obtenerMontoFinal();
    }
}
