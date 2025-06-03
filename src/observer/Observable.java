/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import java.util.ArrayList;

/**
 *
 * @author facun
 */
public class Observable {

    private ArrayList<Observador> observadores = new ArrayList<Observador>();

    public void agregarObservador(Observador o) {
    if (o != null) {
        observadores.add(o);
    }
       
}

    public void removerObservador(Observador o) {
        observadores.remove(o);
    }
    
    public void avisar(Object evento){
        for(Observador o : observadores){
            o.actualizar(this, evento);
        }
    }
}
