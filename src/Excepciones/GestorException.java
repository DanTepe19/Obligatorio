/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author diego
 */
public class GestorException extends Exception{
    public GestorException() {
        super();
    }

    public GestorException(String mensaje) {
        super(mensaje);
    }

    public GestorException(String mensaje, Exception e) {
        super(mensaje, e);
    }
}
