/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IU;

import Excepciones.GestorException;
import Logica.Fachada;
import Logica.Gestor;

/**
 *
 * @author diego
 */
public class LoginGestor extends LoginAbstracto {
    
    public LoginGestor() {
        super();
    }

    @Override
    public Object llamarLogin(String usuario, String password) throws GestorException {
        return Fachada.getInstancia().loginGestor(usuario, password);
    }

    @Override
    public void proximoCU(Object usuario) {
        Gestor gestor = (Gestor) usuario;
        AppGestor appGestor = new AppGestor(gestor);
        appGestor.setVisible(true);
    }
    
}
