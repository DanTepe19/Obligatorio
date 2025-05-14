/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author diego
 */
public class ClienteException extends Exception{
    public ClienteException() {
        super();
    }

    public ClienteException(String mensaje) {
        super(mensaje);
    }

    public ClienteException(String mensaje, Exception e) {
        super(mensaje, e);
    }
}
