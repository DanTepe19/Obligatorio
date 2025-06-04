/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.GestorException;
import java.util.ArrayList;
import main.DatosPrueba;
import observer.Observable;

/**
 *
 * @author diego
 */
public class SistemaGestores extends Observable {

    private static SistemaGestores instancia;
    private ArrayList<Sesion> sesionesActivas = new ArrayList<>();

    private ArrayList<Gestor> gestores = DatosPrueba.getGestores();

    public synchronized static SistemaGestores getInstancia() {
        if (instancia == null) {
            instancia = new SistemaGestores();
        }
        return instancia;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }

    public Gestor loginGestor(String usuario, String password) throws GestorException {
        for (Sesion s : sesionesActivas) {
            if (s.getUsuario() instanceof Gestor ges && ges.getNombreUsuario().equals(usuario)) {
                throw new GestorException("<html>Acceso denegado. El usuario ya está logueado</html>");
            }
        }

        for (Gestor gestor : gestores) {
            if (gestor.getNombreUsuario().equals(usuario) && gestor.getPassword().equals(password)) {
                sesionesActivas.add(new Sesion(gestor));
                return gestor;
            }
        }

        throw new GestorException("Credenciales incorrectas");
    }

    public void cerrarSesion(Object usuario) {
        sesionesActivas.removeIf(s -> s.getUsuario().equals(usuario));
    }

}
