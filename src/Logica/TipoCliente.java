/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public abstract class TipoCliente {
    
    public abstract int obtenerMontoFinal(Servicio servicio);
    public abstract int obtenerMontoTotal(Servicio servicio);
    public abstract String obtenerDescripcionDescuento(int monto);
    
}
