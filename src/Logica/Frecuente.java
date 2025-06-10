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
    public int obtenerMontoFinal(Servicio servicio) {
        int monto = 0;
        for(Pedido p : servicio.getPedidos()){
            if(!p.getItem().getNombre().equals("Café")){
                monto += p.getItem().getPrecio();
            }
        }
        servicio.setMontoFinal(monto);
        return monto;
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
    public String obtenerDescripcionDescuento(int monto) {
        return "Paga $0 por todos los cafés consumidos.";
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
