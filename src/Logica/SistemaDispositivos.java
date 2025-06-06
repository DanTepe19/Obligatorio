/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import main.DatosPrueba;
import observer.Observable;

/**
 *
 * @author diego
 */
public class SistemaDispositivos extends Observable {
    
    private static SistemaDispositivos instancia;
    
    private ArrayList<Dispositivo> dispositivos = DatosPrueba.getDispositivos();
    
    public synchronized static SistemaDispositivos getInstancia() {
        if (instancia == null) {
            instancia = new SistemaDispositivos();
        }
        return instancia;
    }
    
    public ArrayList<Dispositivo> getDispositivos(){
        return dispositivos;
    }

    public void liberarDispositivo(Dispositivo dispositivo) {
        dispositivo.liberar();
    }
    
}
