/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Logica.CategoriaItem;
import Logica.Cliente;
import Logica.Comun;
import Logica.DeLaCasa;
import Logica.Dispositivo;
import Logica.Frecuente;
import Logica.Gestor;
import Logica.Ingrediente;
import Logica.Insumo;
import Logica.Item;
import Logica.Preferencial;
import Logica.Procesadora;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class DatosPrueba {

    public static ArrayList<Dispositivo> dispositivos = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Gestor> gestores = new ArrayList<>();
    public static ArrayList<Procesadora> procesadoras = new ArrayList<>();
    public static ArrayList<CategoriaItem> categorias = new ArrayList<>();
    public static ArrayList<Item> items = new ArrayList<>();
    public static ArrayList<Insumo> insumos = new ArrayList<>();

    public static void cargar() {

        // 1. Insumos
        Insumo aceituna = new Insumo("Aceituna", 100, 20);
        Insumo carne = new Insumo("Carne", 50, 10);
        Insumo papas = new Insumo("Papas", 80, 20);
        Insumo gin = new Insumo("Gin", 30, 10);
        Insumo tonica = new Insumo("Agua Tónica", 40, 10);
        Insumo arroz = new Insumo("Arroz", 60, 15);
        Insumo salmon = new Insumo("Salmón", 40, 10);
        Insumo cafe = new Insumo("Café", 50, 15);
        Insumo aguaMineral = new Insumo("Agua Mineral", 100, 20);
        Insumo queso = new Insumo("Queso", 70, 15);

        insumos.addAll(List.of(aceituna, carne, papas, gin, tonica, arroz, salmon, cafe, aguaMineral, queso));

        // 2. Procesadoras (con listas vacías de ítems y gestores)
        ArrayList<Item> cocinaItems = new ArrayList<>();
        ArrayList<Item> barItems = new ArrayList<>();
        ArrayList<Item> sushiItems = new ArrayList<>();

        ArrayList<Gestor> cocinaGestores = new ArrayList<>();
        ArrayList<Gestor> barGestores = new ArrayList<>();
        ArrayList<Gestor> sushiGestores = new ArrayList<>();

        Procesadora cocina = new Procesadora("Cocina", cocinaItems, cocinaGestores);
        Procesadora bar = new Procesadora("Bar", barItems, barGestores);
        Procesadora barraSushi = new Procesadora("BarraDeSushi", sushiItems, sushiGestores);

        procesadoras.addAll(List.of(cocina, bar, barraSushi));

        // 3. Categorías (con listas vacías de ítems)
        ArrayList<Item> entradaItems = new ArrayList<>();
        ArrayList<Item> principalItems = new ArrayList<>();
        ArrayList<Item> bebidaItems = new ArrayList<>();

        CategoriaItem entrada = new CategoriaItem("Entrada", entradaItems);
        CategoriaItem principal = new CategoriaItem("Principal", principalItems);
        CategoriaItem bebida = new CategoriaItem("Bebida", bebidaItems);

        categorias.addAll(List.of(entrada, principal, bebida));

        // 4. Ítems
        ArrayList<Ingrediente> ingredientesMilanesa = new ArrayList<>();
        ingredientesMilanesa.add(new Ingrediente(carne, 1));
        ingredientesMilanesa.add(new Ingrediente(papas, 3));
        Item milanesa = new Item("Milanesa con fritas", 450f, ingredientesMilanesa, cocina, principal);

        ArrayList<Ingrediente> ingredientesGinTonic = new ArrayList<>();
        ingredientesGinTonic.add(new Ingrediente(gin, 1));
        ingredientesGinTonic.add(new Ingrediente(tonica, 1));
        Item ginTonic = new Item("Gin Tonic", 300f, ingredientesGinTonic, bar, bebida);

        ArrayList<Ingrediente> ingredientesNigiri = new ArrayList<>();
        ingredientesNigiri.add(new Ingrediente(arroz, 2));
        ingredientesNigiri.add(new Ingrediente(salmon, 2));
        Item nigiri = new Item("Nigiri", 320f, ingredientesNigiri, barraSushi, entrada);

        ArrayList<Ingrediente> ingredientesAgua = new ArrayList<>();
        ingredientesAgua.add(new Ingrediente(aguaMineral, 1));
        Item agua = new Item("Agua Mineral", 80f, ingredientesAgua, bar, bebida);

        ArrayList<Ingrediente> ingredientesCafe = new ArrayList<>();
        ingredientesCafe.add(new Ingrediente(cafe, 1));
        Item cafeItem = new Item("Café", 120f, ingredientesCafe, bar, bebida);

        ArrayList<Ingrediente> ingredientesPizza = new ArrayList<>();
        ingredientesPizza.add(new Ingrediente(queso, 2));
        ingredientesPizza.add(new Ingrediente(aceituna, 3));
        Item pizza = new Item("Pizza", 400f, ingredientesPizza, cocina, principal);

        items.addAll(List.of(milanesa, ginTonic, nigiri, agua, cafeItem, pizza));

        // Agregar ítems a sus categorías
        entradaItems.add(nigiri);
        principalItems.add(milanesa);
        principalItems.add(pizza);
        bebidaItems.add(ginTonic);
        bebidaItems.add(agua);
        bebidaItems.add(cafeItem);

        // Agregar ítems a sus procesadoras
        cocinaItems.add(milanesa);
        cocinaItems.add(pizza);
        barItems.add(ginTonic);
        barItems.add(agua);
        barItems.add(cafeItem);
        sushiItems.add(nigiri);

        // 5. Dispositivos
        dispositivos.add(new Dispositivo(1));
        dispositivos.add(new Dispositivo(2));
        dispositivos.add(new Dispositivo(3));

        // 6. Clientes
        clientes.add(new Cliente(1001, "Juan Pérez", "1234", new Comun()));
        clientes.add(new Cliente(1002, "Ana Gómez", "abcd", new Frecuente()));
        clientes.add(new Cliente(1003, "Luis Torres", "pass", new Preferencial()));
        clientes.add(new Cliente(1004, "Marta Ruiz", "0000", new DeLaCasa()));

        // 7. Gestores
        Gestor g1 = new Gestor("chef1", "c1", "Carlos Alberto", cocina);
        Gestor g2 = new Gestor("chef2", "c2", "Cecilia Rodriguez", cocina);
        Gestor g3 = new Gestor("barman1", "b1", "Bruno Goonzález", bar);
        gestores.addAll(List.of(g1, g2, g3));

        // Agregar gestores a sus procesadoras
        cocinaGestores.add(g1);
        cocinaGestores.add(g2);
        barGestores.add(g3);     
    }
  
    //GETS
    public static ArrayList<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Gestor> getGestores() {
        return gestores;
    }

    public static ArrayList<Procesadora> getProcesadoras() {
        return procesadoras;
    }

    public static ArrayList<CategoriaItem> getCategorias() {
        return categorias;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static ArrayList<Insumo> getInsumos() {
        return insumos;
    }
}
