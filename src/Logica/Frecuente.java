/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public class Frecuente extends TipoCliente {

    @Override
    public double calcularDescuento(Dispositivo dispositivo) {
        double descuento = 0;
        for (Pedido p : dispositivo.getPedidos()) {
            if (p.getItem().getNombre().equalsIgnoreCase("Café")) {
                descuento += p.getItem().getPrecio();
            }
        }
        return descuento;
    }
    
}
