/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public class DeLaCasa extends TipoCliente {

    @Override
    public double calcularDescuento(Dispositivo dispositivo) {
        double total = 0;
        for (Pedido p : dispositivo.getPedidos()) {
            total += p.getItem().getPrecio();
        }

        return Math.min(500, total);
    }
    
}
