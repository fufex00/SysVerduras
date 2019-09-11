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
import java.util.logging.Level;
import java.util.logging.Logger;
import objectos.Cliente;
import objectos.Persona;
import objectos.Producto;

/**
 *
 * @author pablo
 */
public class Principal {

    public static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    static Producto listaProductos[] = new Producto[10];
    static Cliente listaClientes[] = new Cliente[15];
    static int k = 0;

    public static void main(String[] args) throws IOException {

        menu();

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
            case "2": {
                menuCliente();
                break;
            }
            case "3": {
                System.exit(0);
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
                } else {
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

    private static void menuCliente() throws IOException {
        System.out.println("Módulo de Clientes");
        System.out.println("\n1. Añadir Cliente");
        System.out.println("2. Editar Cliente");
        System.out.println("3. Eliminar Cliente");
        System.out.println("4. Ver Lista de Clientes");
        System.out.println("5. Regresar al Menú Principal");
        System.out.println("");
        System.out.println("Ingrese una opción");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selection = br.readLine();

        switch (selection) {
            case "1":
                listaClientes[k] = (Cliente) crearCliente();
                k++;
                menuCliente();
                break;
            case "2": {
                System.out.println("Editar Cliente");
                System.out.println("");
                System.out.println("Ingrese el ID del cliente:");
                Cliente client = buscarCliente(Integer.parseInt(br.readLine()));
                if (client != null) {
                    editarCliente(client);
                } else {
                    System.out.println("El cliente no ha sido encontrado");
                }

                menuCliente();
                break;
            }
            case "3" : {
                eliminarCliente();
                break;
            }
            case "4": {
                imprimirListaClientes();
                menuCliente();
                break;
            }
            case "5": {
                menu();
                break;
            }

        }
    }

    private static Persona crearCliente() throws IOException {
        Cliente client = new Cliente();
        System.out.println("Cedula: ");
        int id = Integer.parseInt(lector.readLine());
        client.setId(id);
        System.out.println("Nombre: ");
        String name = lector.readLine();
        client.setName(name);
        System.out.println("Posee credito \n1: Si\n2: No ");
        client.setCredito(asignarCredito());
        System.out.println("Cuánto es el limite de credito? ");
        String limit = lector.readLine();
        client.setLimiteCredito(Integer.parseInt(limit));
        System.out.println("Cuanto es el plazo de tiempo para cancelar la "
                + "deuda? ");
        String debttTime = lector.readLine();
        client.setPlazo(Integer.parseInt(debttTime));
        System.out.println("Digite el numero de cuenta del Cliente ");
        String account = lector.readLine();
        client.setNumeroCuenta(account);

        return client;

    }

    private static void editarCliente(Cliente client) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("¿Qué datos va a cambiar?");
        System.out.println("1. para la cedula");
        System.out.println("2. para el nombre");
        System.out.println("3. para el credito");
        String eleccion = lector.readLine();
        switch (eleccion) {
            case "1":
                System.out.println("Digite la cedula para corregir: ");
                int cedula = Integer.parseInt(lector.readLine());
                client.setId(cedula);
                break;
            case "2":
                System.out.println("Digite el nombre a corregir:");
                String nombre = lector.readLine();
                client.setName(nombre);
                break;
            case "3":
                System.out.println("Posee credito:");
                System.out.println("1: Si\n2: No ");
                client.setCredito(asignarCredito());
                System.out.println("Cuanto es el plazo de tiempo para cancelar la "
                        + "deuda? ");
                String tiempoLimite = lector.readLine();
                client.setPlazo(Integer.parseInt(tiempoLimite));
                System.out.println("Digite el numero de cuenta del Cliente ");
                String cuenta = lector.readLine();
                client.setNumeroCuenta(cuenta);
                break;
        }
        System.out.println("Si desea volver al menu principal digite: 1, si "
                + "desea volver al menu de clientes presione: 2");
        int p = Integer.parseInt(lector.readLine());
        if(p==1)
        {
        menu();    
        }
        else
        {
        menuCliente();    
        }
    }

    private static Cliente buscarCliente(int cod) {

        for (int i = 0; i < k; i++) {
            if (cod == listaClientes[i].getId()) {
                Cliente found;
                found = listaClientes[i];
                return found;
            }
        }

        return null;
    }

    private static void imprimirListaClientes() {
        for (int i = 0; i < k; i++) {
            System.out.println("ID: " + listaClientes[i].getId());
            System.out.println("Nombre: " + listaClientes[i].getName());
            System.out.println("Credito: " + listaClientes[i].isCredito());
            System.out.println("Limite de Credito: " + listaClientes[i].getLimiteCredito());
            System.out.println("Plazo: " + listaClientes[i].getPlazo());
            System.out.println("Numero de Cuenta: " + listaClientes[i].getNumeroCuenta());
            System.out.println("......................");
        }
    }

    private static boolean asignarCredito() {
        System.out.println("Posee Credito? ");
        System.out.println("1: Si\n2: No ");
        boolean credito = false;
        int credit;
        try {
            credit = Integer.parseInt(lector.readLine());
            switch (credit) {
                case 1:
                    credito = true;
                    break;
                case 2:
                    credito = false;
                    break;
                default:
                    System.out.println("Esta opcion no existe.");
                    asignarCredito();
                    break;
            }
        } catch (IOException ex) {
            System.out.println("Escoja la opcion utilizando numeros.");
            asignarCredito();
        }
        return credito;

    }

    private static void eliminarCliente() {
        
    }
    
    

}
