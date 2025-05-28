/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class SistemaServicios {
    
    private static SistemaServicios instancia;
    
    private ArrayList<Servicio> servicios = new ArrayList<>();
    
    public synchronized static SistemaServicios getInstancia() {
        if (instancia == null) {
            instancia = new SistemaServicios();
        }
        return instancia;
    }
    
}
