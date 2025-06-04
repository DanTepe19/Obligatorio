/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.time.LocalDateTime;

/**
 *
 * @author diego
 */
public class Sesion {

    private Object usuario;
    private LocalDateTime fechaHoraIngreso;

    public Sesion(Object usuario) {
        this.usuario = usuario;
        this.fechaHoraIngreso = LocalDateTime.now();
    }

    public Object getUsuario() {
        return usuario;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }
}
