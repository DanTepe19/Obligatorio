/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public class Fachada {
    private static final Fachada instancia = new Fachada();
    
    SistemaDispositivos sistemaDispositivos = SistemaDispositivos.getInstancia();
    SistemaClientes sistemaClientes = SistemaClientes.getInstancia();
    SistemaGestores sistemaGestores = SistemaGestores.getInstancia();
    SistemaPedidos sistemaPedidos = SistemaPedidos.getInstancia();
    
    public static Fachada getInstancia(){
        return instancia;
    }
    
    public Gestor loginGestor(String usuario, String password){
        return sistemaGestores.loginGestor(usuario, password);
    }
}
