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
    public int obtenerMontoFinal(Servicio servicio) {
        int monto = 0;
        for (Pedido p : servicio.getPedidos()) {
            monto += p.getItem().getPrecio();
        }

        if (monto < 500) {
            monto = 0;
        } else {
            monto = monto - 500;
        }

        servicio.setMontoFinal(monto);
        return monto;
    }

    @Override
    public String obtenerDescripcionDescuento(int monto) {
        return "Tiene hasta $500 de descuento.";
    }

    @Override
    public int obtenerMontoTotal(Servicio servicio) {
        int monto = 0;
        for (Pedido p : servicio.getPedidos()) {
            monto += p.getItem().getPrecio();
        }
        servicio.setMontoTotal(monto);
        return monto;
    }
}

