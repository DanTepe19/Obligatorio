/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public class Ingrediente {
    private Insumo insumo;
    private int cantidad;

    public Ingrediente(Insumo insumo, int cantidad) {
        this.insumo = insumo;
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void restarStock() {
        insumo.setStockActual(insumo.getStockActual()-cantidad);
    }

    public void sumarStock() {
        insumo.setStockActual(insumo.getStockActual()+cantidad);        
    }
    
    
}
