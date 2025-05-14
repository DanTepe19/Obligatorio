/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author diego
 */
public class PedidoException extends Exception{
    public PedidoException() {
        super();
    }

    public PedidoException(String mensaje) {
        super(mensaje);
    }

    public PedidoException(String mensaje, Exception e) {
        super(mensaje, e);
    }
}
