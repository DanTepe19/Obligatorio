/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IU;

import Logica.Fachada;

/**
 *
 * @author diego
 */
public class LoginGestor extends LoginAbstracto {
    
    public LoginGestor() {
        super();
    }

    @Override
    public Object llamarLogin(String usuario, String password) {
        return Fachada.getInstancia().loginGestor(usuario, password);
    }

    @Override
    public void proximoCU(Object usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
