/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author diego
 */
public class DispositivoException extends Exception{
    public DispositivoException() {
        super();
    }

    public DispositivoException(String mensaje) {
        super(mensaje);
    }

    public DispositivoException(String mensaje, Exception e) {
        super(mensaje, e);
    }
}
