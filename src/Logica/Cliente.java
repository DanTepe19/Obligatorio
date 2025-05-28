/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author diego
 */
public class Cliente {
    private int numeroCliente;
    private String password;
    private String nombreCompleto;
    private Dispositivo dispositivo;
    private Servicio servicio;
    private TipoCliente tipo;

    public Cliente(int numeroCliente, String password, String nombreCompleto, TipoCliente tipo) {
        this.numeroCliente = numeroCliente;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.tipo = tipo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }
    
    public Dispositivo getDispositivo() {
        return dispositivo;
    }
    
    public void asignarDispositivo(Dispositivo d) {
        this.dispositivo = d;
    }

    public void liberarDispositivo() {
        this.dispositivo = null;
    }

    public double calcularMontoFinal() {
    double total = 0;
    for (Pedido p : servicio.getPedidos()) {
        total += p.getItem().getPrecio();
    }

    double descuento = tipo.calcularDescuento(servicio);
    return Math.max(0, total - descuento);
}
    
}
