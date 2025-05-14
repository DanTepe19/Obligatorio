/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public class Disponible extends EstadoDispositivo {

    @Override
    public void asignarCliente(Dispositivo dispositivo, Cliente cliente) {
        dispositivo.setCliente(cliente);
        dispositivo.setEstado(new Ocupado());
        dispositivo.getPedidos().clear();
        cliente.asignarDispositivo(dispositivo);
    }

    @Override
    public void liberar(Dispositivo dispositivo) {
        
    }

    @Override
    public String getNombre() {
        return "DISPONIBLE";
    }
}
