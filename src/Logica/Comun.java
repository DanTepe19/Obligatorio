/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public class Comun extends TipoCliente {

    @Override
    public int obtenerMontoFinal(Servicio servicio) {
        return 0;
    }

    @Override
    public String obtenerDescripcionDescuento(int monto) {
        return "";
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
    public int obtenerMontoTotalConfirmados(Servicio servicio) {
        int monto = 0;
        for (Pedido p : servicio.getPedidos()) {
            if(!p.getEstado().getNombre().equals("NO_CONFIRMADO")){
                monto += p.getItem().getPrecio();
            }  
        }
        servicio.setMontoTotal(monto);
        return monto;
    }

}
