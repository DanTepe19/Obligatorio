/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IU;

import Logica.Cliente;
import Logica.Fachada;

/**
 *
 * @author diego
 */
public class LoginCliente extends LoginAbstracto{
    
    public LoginCliente() {
        super();
    }

    @Override
    public Object llamarLogin(String usuario, String password) {
        return Fachada.getInstancia().loginCliente(usuario, password);
    }

    @Override
    public void proximoCU(Object usuario) {
        Cliente cliente = (Cliente) usuario;
        AppCliente appCliente = new AppCliente(cliente);
        appCliente.setVisible(true);
    }
    
}
