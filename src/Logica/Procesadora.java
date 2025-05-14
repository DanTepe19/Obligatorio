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
public class Procesadora {
    private String nombre;
    private ArrayList<Item> items;
    private ArrayList<Gestor> gestores;

    public Procesadora(String nombre, ArrayList<Item> items, ArrayList<Gestor> gestores) {
        this.nombre = nombre;
        this.items = items;
        this.gestores = gestores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }

    public void setGestores(ArrayList<Gestor> gestores) {
        this.gestores = gestores;
    }
    
    public void agregarGestor(Gestor g){
        gestores.add(g);
    }
}
