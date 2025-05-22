/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Item {

    private String nombre;
    private int precio;
    private ArrayList<Ingrediente> ingredientes;
    private Procesadora procesadora;
    private CategoriaItem categoria;

    public Item(String nombre, int precio, ArrayList<Ingrediente> ingredientes, Procesadora procesadora, CategoriaItem categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
        this.procesadora = procesadora;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Procesadora getProcesadora() {
        return procesadora;
    }

    public void setProcesadora(Procesadora procesadora) {
        this.procesadora = procesadora;
    }

    public CategoriaItem getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaItem categoria) {
        this.categoria = categoria;
    }
    
    

}
