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
    public int obtenerMontoFinal(Servicio servicio) {
        int monto = obtenerMontoTotal(servicio);
        if (monto > 2000) {
            int montoFinal = 0;
            for (Pedido p : servicio.getPedidos()) {
                if (!p.getItem().getNombre().equals("Agua Mineral")) {
                    montoFinal += p.getItem().getPrecio();
                }
            }
            montoFinal = (int) (montoFinal * 0.95);
            servicio.setMontoFinal(montoFinal);
            return montoFinal;
        } else {
            int montoFinal = 0;
            for (Pedido p : servicio.getPedidos()) {
                if (!p.getItem().getNombre().equals("Agua Mineral")) {
                    montoFinal += p.getItem().getPrecio();
                }
            }
            servicio.setMontoFinal(montoFinal);
            return montoFinal;
        }
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

    @Override
    public String obtenerDescripcionDescuento(int montoTotal) {
        String mensaje = "Pagas $0 por todas las aguas consumidas.";
        if (montoTotal > 2000) {
            mensaje += " Aplica 5% de desucento por monto mayor a $2000.";
        }
        return mensaje;
    }

    @Override
    public int obtenerMontoTotalConfirmados(Servicio servicio) {
        int monto = 0;
        for (Pedido p : servicio.getPedidos()) {
            if (!p.getEstado().getNombre().equals("NO_CONFIRMADO")) {
                monto += p.getItem().getPrecio();
            }
        }
        servicio.setMontoTotal(monto);
        return monto;
    }

}
