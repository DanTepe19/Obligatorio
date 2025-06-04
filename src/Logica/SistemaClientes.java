/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.ClienteException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import main.DatosPrueba;
import observer.Observable;

/**
 *
 * @author diego
 */
public class SistemaClientes extends Observable {

    private static SistemaClientes instancia;
    private ArrayList<Sesion> sesionesActivas = new ArrayList<>();

    private ArrayList<Cliente> clientes = DatosPrueba.getClientes();

    public synchronized static SistemaClientes getInstancia() {
        if (instancia == null) {
            instancia = new SistemaClientes();
        }
        return instancia;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente loginCliente(String usuario, String password, ArrayList<Dispositivo> dispositivos) throws ClienteException {
        int numero = Integer.parseInt(usuario);

        for (Sesion s : sesionesActivas) {
            if (s.getUsuario() instanceof Cliente cli && cli.getNumeroCliente() == numero) {
                throw new ClienteException("<html>Ud. ya está identificado en otro dispositivo</html>");
            }
        }

        for (Cliente cliente : clientes) {
            if (cliente.getNumeroCliente() == numero && cliente.getPassword().equals(password)) {
                for (Dispositivo d : dispositivos) {
                    if (d.getCliente() == null) {
                        d.asignarCliente(cliente);
                        Servicio servicio = new Servicio(cliente);
                        cliente.setServicio(servicio);
                        sesionesActivas.add(new Sesion(cliente));
                        return cliente;
                    }
                }
                throw new ClienteException("<html>Debe primero finalizar el servicio actual</html>");
            }
        }

        throw new ClienteException("Credenciales incorrectas");
    }

    public void cerrarSesion(Object usuario) {
        sesionesActivas.removeIf(s -> s.getUsuario().equals(usuario));
    }

}
