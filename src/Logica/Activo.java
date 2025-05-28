/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public class Activo extends EstadoServicio {

    @Override
    public void terminar(Servicio servicio) {
        servicio.setEstado(new Terminado());
    }

    @Override
    public String getNombre() {
        return "ACTIVO";
    }
    
}
