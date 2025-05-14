/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public class Preferencial extends TipoCliente {

    @Override
    public double calcularDescuento(Dispositivo dispositivo) {
        double descuento = 0;
        double total = 0;

        for (Pedido p : dispositivo.getPedidos()) {
            Item item = p.getItem();
            total += item.getPrecio();
            if (item.getNombre().equalsIgnoreCase("Agua Mineral")) {
                descuento += item.getPrecio();
            }
        }

        if (total > 2000) {
            descuento += (total - descuento) * 0.05;
        }

        return descuento;
    }
    
}
