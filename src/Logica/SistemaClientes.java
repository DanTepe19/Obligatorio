/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import static java.lang.Integer.parseInt;
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
    
    public Cliente loginCliente(String usuario, String password, ArrayList<Dispositivo> dispositivos){
        Cliente cliente;
        int numero = parseInt(usuario);
        for(Cliente c:clientes){
            cliente = (Cliente)c;
            if(cliente.getNumeroCliente() == numero && cliente.getPassword().equals(password)){
                for(Dispositivo d : dispositivos){
                    if(d.getCliente() == null){
                        d.asignarCliente(cliente);
                        break;
                    }
                }
                return cliente;
            }
        }
        return null;
    }
    
}
