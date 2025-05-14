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
public class SistemaClientes {
    
    private static SistemaClientes instancia;
    
    private ArrayList<Cliente> clientes = DatosPrueba.getClientes();
    
    public synchronized static SistemaClientes getInstancia() {
        if (instancia == null) {
            instancia = new SistemaClientes();
        }
        return instancia;
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    
}
