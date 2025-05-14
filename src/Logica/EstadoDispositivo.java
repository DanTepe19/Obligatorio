/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public abstract class EstadoDispositivo {
    public abstract void asignarCliente(Dispositivo dispositivo, Cliente cliente);
    public abstract void liberar(Dispositivo dispositivo);
    public abstract String getNombre();
}

