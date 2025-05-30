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
        int monto = 0;
        for(Pedido p : servicio.getPedidos()){
            if(!p.getItem().getNombre().equals("Agua Mineral")){
                monto += p.getItem().getPrecio();
            }
        }
        if(monto > 2000){
            monto = (int) (monto*0.95);
        }
        servicio.setMontoTotal(monto);
        return monto;
    }
    
}
