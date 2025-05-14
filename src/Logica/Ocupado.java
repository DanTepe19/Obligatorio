/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public class Ocupado extends EstadoDispositivo {

    @Override
    public void asignarCliente(Dispositivo dispositivo, Cliente cliente) {
        throw new IllegalStateException("El dispositivo ya está ocupado.");
    }

    @Override
    public void liberar(Dispositivo dispositivo) {
        Cliente cliente = dispositivo.getCliente();
        if (cliente != null) {
            cliente.liberarDispositivo();
        }
        dispositivo.setCliente(null);
        dispositivo.getPedidos().clear();
        dispositivo.setEstado(new Disponible());
    }

    @Override
    public String getNombre() {
        return "OCUPADO";
    }
}
