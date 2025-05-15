/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import main.DatosPrueba;

/**
 *
 * @author diego
 */
public class SistemaGestores {
    
    private static SistemaGestores instancia;
    
    private ArrayList<Gestor> gestores = DatosPrueba.getGestores();
    
    public synchronized static SistemaGestores getInstancia() {
        if (instancia == null) {
            instancia = new SistemaGestores();
        }
        return instancia;
    }
    
    public ArrayList<Gestor> getGestores(){
        return gestores;
    }
    
    public Gestor loginGestor(String usuario, String password){
        Gestor gestor;
        for(Gestor g:gestores){
            gestor = (Gestor)g;
            if(gestor.getNombreUsuario().equals(usuario) && gestor.getPassword().equals(password)){
                return gestor;
            }
        }
        return null;
    }
    
}
