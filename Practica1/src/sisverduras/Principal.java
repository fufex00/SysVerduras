/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisverduras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;
import objectos.Producto;

/**
 *
 * @author pablo
 */
public class Principal {

      static Producto listaProductos[] = new Producto[10];
    static int k = 0;

    public static void main(String[] args) throws IOException {

        menu();

    }

    private static void imprimirProductos(Producto producto) {
        System.out.println("Codigo: " + producto.getCodigo());
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Precio: " + producto.getPrecio());
    }

    private static void imprimirListaProductos() {
        for (int i = 0; i < k; i++) {
            System.out.println("Codigo: " + listaProductos[i].getCodigo());
            System.out.println("Nombre: " + listaProductos[i].getNombre());
            System.out.println("Precio: " + listaProductos[i].getPrecio());
            System.out.println("Categoría: " + listaProductos[i].getCategoria());
            System.out.println("Fecha Vencimiento: "
                    + listaProductos[i].getFechaVencimiento());
            System.out.println("......................");
        }
    }

    private static void menu() throws IOException {

        System.out.println("Bienvenido a la verduleria");
        System.out.println("");
        System.out.println("1. Módulo de Productos");
        System.out.println("2. Módulo de Clientes");
        System.out.println("3. Salir");
        System.out.println("");
        System.out.println("Ingrese una Opción");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lee = br.readLine();
        switch (lee) {

            case "1": {
                menuProductos();
                break;
            }

        }

    }

    private static void menuProductos() throws IOException {
        System.out.println("Módulo de Productos");
        System.out.println("\n1. Añadir Producto");
        System.out.println("2. Editar Producto");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Ver Lista de Productos");
        System.out.println("5. Regresar al Menú Principal");
        System.out.println("");
        System.out.println("Ingrese una opción");

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String lee = lector.readLine();

        switch (lee) {
            case "1": {
                listaProductos[k] = crearProducto();
                k++;
                menuProductos();
                break;
            }
            case "2": {
                BufferedReader ingresa = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Editar Producto");
                System.out.println("");
                System.out.println("Ingrese el código del producto:");
                Producto producto = buscarProducto(Integer.parseInt(ingresa.readLine()));
                if (producto != null) {
                    editarProducto(producto);
                }else{
                    System.out.println("El producto no ha sido encontrado");
                }
                
                
                menuProductos();
                break;
            }
            case "4": {
                imprimirListaProductos();
                menuProductos();
                break;
            }

            case "5": {
                menu();
                break;
            }
        }

    }

    private static Producto crearProducto() throws IOException {
        Producto nuevo = new Producto();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nombre: ");
        String nombre = lector.readLine();
        nuevo.setNombre(nombre);
        System.out.println("Precio: ");
        nuevo.setPrecio(Double.parseDouble(lector.readLine()));
        System.out.println("Código Producto: ");
        nuevo.setCodigo(Integer.parseInt(lector.readLine()));
        System.out.println("Fecha de Vencimiento: ");
        nuevo.setFechaVencimiento(new Date(lector.readLine()));
        System.out.println("Categoría: ");
        nuevo.setCategoria(lector.readLine());
        return nuevo;
    }

    private static Producto buscarProducto(int cod) {

        for (int i = 0; i < k; i++) {
            if (cod == listaProductos[i].getCodigo()) {
                Producto encontrado;
                encontrado = listaProductos[i];
                return encontrado;
            }
        }

        return null;
    }

    private static void editarProducto(Producto producto) {

        System.out.println("Que datos va a cambiar");

    }

}
