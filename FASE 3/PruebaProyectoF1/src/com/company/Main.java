package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.company.Menudeopciones.menu;
import com.company.ventana.de.clientes.CRUD_CLIENTES;
import com.company.ventanade.info.CRUD_INFO;
import com.company.ventanadeproductos.CRUD_PRODUCTS;
import com.company.ventanas.de.usuarios.CRUD;
import com.google.gson.*;

public class Main {
    public static Configuracion configuracion;
    static String ruta = "C:\\Users\\ENRIQUE\\Desktop\\nuevo actializado\\PruebaProyectoF1\\jsons";// estatico la ruta donde estaran mis archivos a ingresar
    public static ArrayList<Usuarios> usuArray = new ArrayList<>();
    public static ArrayList<Productos> prodArray = new ArrayList<>();
    public static ArrayList<Clientes> clienteArray = new ArrayList<>();
    public static ArrayList<Facturas> facArray = new ArrayList<>();
    public static ArrayList<Configuracion> confArray = new ArrayList<>();
    public static int contador, contadorusu = 0;
    public static int contador1, contadorclient = 0;
    public static int contador2, contadorprod = 0;
    public static int contador3, contadorfac = 0;


    public static void main(String[] args) {


        Main conf = new Main();
        conf.Configuracion();


        //CRUD nuevo = new CRUD();
        //nuevo.setVisible(true);

        Loginx.Loginx();

        //CRUD.CRUD();
        //CRUD_CLIENTES.CRUD_CLIENTES();
        //CRUD_INFO.CRUD_INFO();
        //CRUD_PRODUCTS.CRUD_PRODUCTS();

        Main menu = new Main();
        menu.Menu();


    }

    void InicioUsuario() {
        System.out.println("===Inicio de Sesión===");
        System.out.println("Introduzca su Usuario");
        System.out.print(">>>");
        Scanner lec = new Scanner(System.in);
        String usuario = lec.nextLine();

        System.out.println("Introduzca su Contraseña");
        System.out.print(">>>");
        String contraseña = lec.nextLine();

        boolean entrar_menu = true;
        if (entrar_menu) {
            for (int i = 0; i < usuArray.size(); i++) {
                if (usuArray.get(i).getUsername().equals(usuario) && usuArray.get(i).getPassword().equals(contraseña)) {
                    System.out.println("==========Bienvenido al Menu==========");
                    Errors.addToEndFile("errors.log", "\t" + new Date() + "\tInicio de sesión exitoso" + "\n");
                    Menu();
                    entrar_menu = false;

                }
            }
        }
        if (entrar_menu) {
            Errors.addToEndFile("errors.log", "\t" + new Date() + "\tInicio de sesión Fallido" + "\n");
            System.out.println("Usuario o contraseña incorrectos");
            InicioUsuario();
        }

    }

    public void Menu() {
        boolean entrar_menu = true;
        while (entrar_menu == true) {
            System.out.println("");
            System.out.println("===Seleccione lo que desea ejecutar===");
            System.out.println(" 1. Información del Restaurante");
            System.out.println(" 2. Usuarios ");
            System.out.println(" 3. Productos");
            System.out.println(" 4. Clientes");
            System.out.println(" 5. Facturas");
            System.out.println(" 6. Guardar Cambios");
            System.out.println(" 7. Cerrar sesión");
            System.out.println(" 8. Salir del programa");
            System.out.println("====================================");
            System.out.print(">>>Escribir el número de opción: >");

            Scanner lec = new Scanner(System.in);
            int opccion = lec.nextInt();
            while (opccion < 1 || 8 < opccion) {
                System.out.println(">>>Error, Escribir una opción del 1 al 7>>>");
                opccion = lec.nextInt();
            }
            switch (opccion) {
                case 1:
                    VerConfiguracion();
                    break;
                case 2:
                    MenuUsu();
                    break;
                case 3:
                    MenuProd();
                    break;
                case 4:
                    MenuClinte();
                    break;
                case 5:
                    MenuFacturas();
                    break;
                case 6:
                    MenuGuardarCambios();
                    break;

                case 7:
                    System.out.println("Has salido del menú ");
                    InicioUsuario();
                    break;
                case 8:
                    entrar_menu = false;
                    System.exit(0);
                    break;

            }
        }
    }

    public void MenuUsu() {
        boolean entrar_menu = true;
        while (entrar_menu == true) {
            System.out.println("");
            System.out.println("===Seleccione lo que desea hacer===");
            System.out.println(" 1. Listar Usuarios");
            System.out.println(" 2. Eliminar Usuarios ");
            System.out.println(" 3. Ver Usuario");
            System.out.println(" 4. Volver al Menu");
            System.out.println("====================================");
            System.out.print(">>>Escribir el número de opción: >");
            Scanner lec = new Scanner(System.in);
            int opccion = lec.nextInt();

            switch (opccion) {

                case 1:
                    VerUsuarios();
                    break;
                case 2:
                    //EliminarUsuario();
                    EditarUsuario();

                    break;
                case 3:
                    BuscarUsuario();
                    break;
                case 4:
                    Menu();
                    break;
            }
        }

    }

    public void MenuProd() {
        boolean entrar_menu = true;
        while (entrar_menu == true) {
            System.out.println("");
            System.out.println("===Seleccione lo que desea hacer===");
            System.out.println(" 1. Listar Productos");
            System.out.println(" 2. Eliminar Productos ");
            System.out.println(" 3. Ver Productos");
            System.out.println(" 4. Volver al Menu");
            System.out.println("====================================");
            System.out.print(">>>Escribir el número de opción: >");
            Scanner lec = new Scanner(System.in);
            int opccion = lec.nextInt();

            switch (opccion) {

                case 1:
                    VerProductos();
                    ;
                    break;
                case 2:
                    EliminarProducto();
                    break;
                case 3:
                    BuscarProducto();
                    break;
                case 4:
                    Menu();
                    break;
            }
        }

    }

    public void MenuClinte() {
        boolean entrar_menu = true;
        while (entrar_menu == true) {
            System.out.println("");
            System.out.println("===Seleccione lo que desea hacer===");
            System.out.println(" 1. Listar Clientes");
            System.out.println(" 2. Eliminar Clientes ");
            System.out.println(" 3. Ver Clientes");
            System.out.println(" 4. Volver al Menu");
            System.out.println("====================================");
            System.out.print(">>>Escribir el número de opción: >");
            Scanner lec = new Scanner(System.in);
            int opccion = lec.nextInt();

            switch (opccion) {

                case 1:
                    VerClientes();
                    break;
                case 2:
                    EliminarClientes();
                    break;
                case 3:
                    BuscarClientes();
                    break;
                case 4:
                    Menu();
                    break;
            }
        }

    }

    public void MenuFacturas() {
        boolean entrar_menu = true;
        while (entrar_menu == true) {
            System.out.println("");
            System.out.println("===Seleccione lo que desea hacer===");
            System.out.println(" 1. Listar Facturas");
            System.out.println(" 2. Eliminar Facturas ");
            System.out.println(" 3. Ver Facturas");
            System.out.println(" 4. Volver al Menu");
            System.out.println("====================================");
            System.out.print(">>>Escribir el número de opción: >");
            Scanner lec = new Scanner(System.in);
            int opccion = lec.nextInt();

            switch (opccion) {

                case 1:
                    VerFacturas();
                    break;
                case 2:
                    EliminarFacturas();
                    break;
                case 3:
                    BuscarFacturas();
                    break;
                case 4:
                    Menu();
                    break;
            }
        }

    }

    public void Configuracion() {
        String contenidoconfig = files.getContentOfFile("jsons\\config.json");
        Gson gson = new Gson();

        configuracion = gson.fromJson(contenidoconfig, Configuracion.class);

        if (configuracion.getLoad().equals("bin")) {
            Object object = files.deserialize("binarios\\users.ipcrm");//deserializando el archivo bin
            usuArray = (ArrayList<Usuarios>) object;
            Object object1 = files.deserialize("binarios\\products.ipcrm");
            prodArray = (ArrayList<Productos>) object1;
            Object object2 = files.deserialize("binarios\\clients.ipcrm");
            clienteArray = (ArrayList<Clientes>) object2;
            Object object3 = files.deserialize("binarios\\invoices.ipcrm");
            facArray = (ArrayList<Facturas>) object3;
            //salida_json();// metodo salida del archivo json
        } else if (configuracion.getLoad().equals("json")) {

            Main user = new Main();
            user.Usuarios();

            Main prod = new Main();
            prod.Productos();

            Main client = new Main();
            client.Clientes();

            Main fac = new Main();
            fac.Facturas();
        } else if (configuracion.getLoad() != "bin") {
            if (configuracion.getLoad() != "json") {
                System.out.println("Load de configuración incorrecto");

            }

        }


    }

    void VerConfiguracion() {
        boolean confirmar = true;

        if (confirmar == true) {
            System.out.println("");
            System.out.println("------------------INFORMACIÓN DEL RESTAURANTE------------------");
            System.out.println(configuracion);
            System.out.println("_______________________________________________________________");
            confirmar = false;


        }
        if (confirmar) {
            System.out.println("No se encontró la configuración");
            MenuUsu();
        }

    }

    void Usuarios() {
        String contenidousu = files.getContentOfFile("jsons\\users.json");
        Gson gson = new Gson();
        Usuarios[] usuarios = gson.fromJson(contenidousu, Usuarios[].class);

        for (Usuarios usuario : usuarios) {
            usuArray.add(usuario);
            contadorusu++;
        }


        for (int i = 0; i < usuArray.size(); i++) {
            for (int j = i + 1; j < usuArray.size(); j++) {
                if (usuArray.get(i).getUsername().equals(usuArray.get(j).getUsername())) {
                    usuArray.remove(j);
                    j--;
                }
            }

        }

        for (int i = 0; i < usuArray.size(); i++) {
            contador++;
        }

        Errors.addToEndFile("errors.log", "\t" + new Date() + "\tUSERS: Se eliminaron: " + (contadorusu - contador) + " usuarios por que estaba repetido" + "\n");


    }

    void VerUsuarios() {

        boolean confirmar = true;
        if (confirmar == true) {
            System.out.println("--------------Lisata de Usuarios--------------");
            System.out.println("");
            for (int i = 0; i < usuArray.size(); i++) {
                if (usuArray.get(i).getUsername() != null) {
                    System.out.println("------------------Usuario: " + (i + 1) + "------------------");
                    System.out.print(usuArray.get(i));
                    System.out.println("______________________________________________");
                    System.out.print("");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el usuario");
            MenuUsu();
        }
    }

    public void EliminarUsuario() {

        System.out.println("Introduzca el User del usuario que desea eliminar");
        System.out.print(">>>");
        Scanner lect = new Scanner(System.in);
        String usuario = lect.nextLine();
        boolean confirmar = true;
        if (confirmar == true) {

            for (int i = 0; i < usuArray.size(); i++) {
                if (usuArray.get(i).getUsername().equals(usuario)) {
                    usuArray.remove(i);
                    System.out.println("______________________________________________");
                    System.out.println("         Usuario " + usuario + " eliminado");
                    System.out.println("______________________________________________");
                    Errors.addToEndFile("errors.log", "\t" + new Date() + "\tUSERS: Se eliminó el usuario: " + usuario + "\n");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el usuario");
            MenuUsu();
        }
            /*while (confirmar == false) {
                System.out.println("No se encontró el usuario");
                confirmar = true;
            }*/
    }

    public void EditarUsuario() {

        System.out.println("Introduzca el User del usuario que desea nodificar");
        System.out.print(">>>");
        Scanner lectu = new Scanner(System.in);
        String usuario = lectu.nextLine();
        System.out.println("Introduzca el nuevo User del usuario r");
        System.out.print(">>>");
        Scanner lect = new Scanner(System.in);
        String usuarionew = lect.nextLine();
        boolean confirmar = true;
        if (confirmar == true) {

            for (int i = 0; i < usuArray.size(); i++) {
                if (usuArray.get(i).getUsername().equals(usuario)) {
                    //usuArray.remove(i);
                    usuArray.get(i).setUsername(usuarionew);
                    System.out.println("______________________________________________");
                    System.out.println("         Usuario " + usuario + " modificado");
                    System.out.println("______________________________________________");
                    Errors.addToEndFile("errors.log", "\t" + new Date() + "\tUSERS: Se eliminó el usuario: " + usuario + "\n");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el usuario");
            MenuUsu();
        }
            /*while (confirmar == false) {
                System.out.println("No se encontró el usuario");
                confirmar = true;
            }*/
    }

    public void BuscarUsuario() {

        System.out.println("Introduzca el Id del producto que desea buscar");
        System.out.print(">>>");
        Scanner lect = new Scanner(System.in);
        String producto = lect.nextLine();

        int posicionUser = -1;
        boolean confirmar = true;
        if (confirmar == true) {
            for (int i = 0; i < usuArray.size(); i++) {
                if (usuArray.get(i).getUsername().equals(producto)) {
                    System.out.println("__________________________________________________");
                    System.out.print("Usuario Encontrado: " + usuArray.get(i));
                    System.out.println("__________________________________________________");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el usuario");
        }
            /*while (confirmar == false) {
                System.out.println("No se encontró el usuario");
                confirmar = true;
            }*/
    }

    public void Productos() {
        String contenidoprod = files.getContentOfFile("jsons\\products.json");
        Gson gson = new Gson();
        Productos[] productos = gson.fromJson(contenidoprod, Productos[].class);

        for (Productos producto : productos) {
            prodArray.add(producto);
            contadorprod++;
        }
        for (int i = 0; i < prodArray.size(); i++) {
            for (int j = i + 1; j < prodArray.size(); j++) {
                if (prodArray.get(i).getId() == (prodArray.get(j).getId())) {
                    prodArray.remove(j);
                    j--;
                }
            }
        }
        for (int i = 0; i < prodArray.size(); i++) {
            contador2++;
        }

        Errors.addToEndFile("errors.log", "\t" + new Date() + "\tPRODUCTS: Se eliminaron: " + (contadorprod - contador2) + " productos por que estaba repetido" + "\n");


    }

    void VerProductos() {
        boolean confirmar = true;
        if (confirmar == true) {
            System.out.println("----------------------Lisata de Productos----------------------");
            System.out.println("");
            for (int i = 0; i < prodArray.size(); i++) {
                if (prodArray.get(i) != null) {
                    System.out.println("--------------------------Producto: " + (i + 1) + "--------------------------");
                    System.out.print(prodArray.get(i));
                    System.out.println("Ingredientes: " + prodArray.get(i).getIngredients());
                    System.out.println("_______________________________________________________________");
                    System.out.print("");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el producto");
            MenuProd();
        }
    }

    public void EliminarProducto() {

        System.out.println("Introduzca el Id del producto que desea eliminar");
        System.out.print(">>>");
        Scanner lect = new Scanner(System.in);
        String producto = lect.nextLine();
        int producto1 = Integer.parseInt(producto);

        int posicionUser = -1;
        boolean confirmar = true;
        if (confirmar == true) {
            for (int i = 0; i < prodArray.size(); i++) {
                if (prodArray.get(i).getId() == producto1) {
                    prodArray.remove(i);
                    System.out.println("_______________________________________________________________");
                    System.out.println("         Producto: " + producto1 + " eliminado");
                    System.out.println("_______________________________________________________________");
                    Errors.addToEndFile("errors.log", "\t" + new Date() + "\tPRODUCTS: Se eliminó el producto: " + producto1 + "\n");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el producto");
        }
            /*while (confirmar == false) {
                System.out.println("No se encontró el usuario");
                confirmar = true;
            }*/
    }

    public void BuscarProducto() {

        System.out.println("Introduzca el Id del producto que desea buscar");
        System.out.print(">>>");
        Scanner lect = new Scanner(System.in);
        String producto = lect.nextLine();
        int producto1 = Integer.parseInt(producto);

        int posicionUser = -1;
        boolean confirmar = true;
        if (confirmar == true) {
            for (int i = 0; i < prodArray.size(); i++) {
                if (prodArray.get(i).getId() == producto1) {
                    System.out.println("--------------------------Producto Encontrado--------------------------");
                    System.out.print(prodArray.get(i));
                    System.out.println("Ingredientes: " + prodArray.get(i).getIngredients());
                    System.out.println("_______________________________________________________________");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el producto");
        }
            /*while (confirmar == false) {
                System.out.println("No se encontró el usuario");
                confirmar = true;
            }*/
    }

    public void Clientes() {

        String contenidocliente = files.getContentOfFile("jsons\\clients.json");
        Gson gson = new Gson();
        Clientes[] clientes = gson.fromJson(contenidocliente, Clientes[].class);

        for (Clientes cliente : clientes) {
            clienteArray.add(cliente);
            contadorclient++;
        }
        for (int i = 0; i < clienteArray.size(); i++) {
            for (int j = i + 1; j < clienteArray.size(); j++) {
                if (clienteArray.get(i).getId() == (clienteArray.get(j).getId())) {
                    clienteArray.remove(j);
                    j--;
                }
            }
        }
        for (int i = 0; i < clienteArray.size(); i++) {
            contador1++;
        }

        Errors.addToEndFile("errors.log", "\t" + new Date() + "\tCLIENTS: Se eliminaron: " + (contadorclient - contador1) + " clientes por que estaba repetido" + "\n");

    }

    void VerClientes() {
        boolean confirmar = true;
        if (confirmar == true) {
            System.out.println("----------------------Lisata de Clientes----------------------");
            System.out.println("");
            for (int i = 0; i < clienteArray.size(); i++) {
                if (clienteArray.get(i) != null) {
                    System.out.println("--------------------------Clientes: " + (i + 1) + "--------------------------");
                    System.out.print(clienteArray.get(i));
                    System.out.println("_______________________________________________________________");
                    System.out.print("");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el cliente");
            MenuProd();
        }
    }

    public void EditarClientes() {

        System.out.println("Introduzca el User del usuario que desea nodificar");
        System.out.print(">>>");
        Scanner lectu = new Scanner(System.in);
        int cliente = lectu.nextInt();
        System.out.println("Introduzca el nuevo User del usuario r");
        System.out.print(">>>");
        Scanner lect = new Scanner(System.in);
        int usuarionew = lect.nextInt();
        boolean confirmar = true;
        if (confirmar == true) {

            for (int i = 0; i < clienteArray.size(); i++) {
                if (clienteArray.get(i).getId() == cliente) {
                    //usuArray.remove(i);
                    clienteArray.get(i).setId(usuarionew);
                    System.out.println("______________________________________________");
                    System.out.println("         Usuario " + cliente + " modificado");
                    System.out.println("______________________________________________");
                    Errors.addToEndFile("errors.log", "\t" + new Date() + "\tUSERS: Se eliminó el usuario: " + cliente + "\n");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el usuario");
            MenuUsu();
        }
            /*while (confirmar == false) {
                System.out.println("No se encontró el usuario");
                confirmar = true;
            }*/
    }

    public void EliminarClientes() {

        System.out.println("Introduzca el Id del cliente que desea eliminar");
        System.out.print(">>>");
        Scanner lect = new Scanner(System.in);
        String producto = lect.nextLine();
        int cliente1 = Integer.parseInt(producto);

        int posicionUser = -1;
        boolean confirmar = true;
        if (confirmar == true) {
            for (int i = 0; i < clienteArray.size(); i++) {
                if (clienteArray.get(i).getId() == cliente1) {
                    clienteArray.remove(i);
                    System.out.println("_______________________________________________________________");
                    System.out.println("         Cliente: " + cliente1 + " eliminado");
                    System.out.println("_______________________________________________________________");
                    Errors.addToEndFile("errors.log", "\t" + new Date() + "\tCLIENTS: Se eliminó el cliente: " + cliente1 + "\n");

                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el Cliente");
        }
            /*while (confirmar == false) {
                System.out.println("No se encontró el usuario");
                confirmar = true;
            }*/
    }

    public void BuscarClientes() {

        System.out.println("Introduzca el Id del Cliente que desea encontrar");
        System.out.print(">>>");
        Scanner lect = new Scanner(System.in);
        String producto = lect.nextLine();
        int cliente1 = Integer.parseInt(producto);

        int posicionUser = -1;
        boolean confirmar = true;
        if (confirmar == true) {
            for (int i = 0; i < clienteArray.size(); i++) {
                if (clienteArray.get(i).getId() == cliente1) {
                    System.out.println("--------------------------Cliente Encontrado--------------------------");
                    System.out.print("Cliente Encontrado: " + clienteArray.get(i));
                    System.out.println("______________________________________________________________________");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el cliente");
        }
            /*while (confirmar == false) {
                System.out.println("No se encontró el usuario");
                confirmar = true;
            }*/
    }

    public void Facturas() {
        String contenidofac = files.getContentOfFile("jsons\\invoices.json");
        Gson gson = new Gson();
        Facturas[] facturas = gson.fromJson(contenidofac, Facturas[].class);

        for (Facturas factura : facturas) {
            facArray.add(factura);
            contadorfac++;
        }
        for (int i = 0; i < facArray.size(); i++) {
            for (int j = i + 1; j < facArray.size(); j++) {
                if (facArray.get(i).getId() == (facArray.get(j).getId())) {
                    facArray.remove(j);
                    j--;
                }
            }
        }
        for (int i = 0; i < facArray.size(); i++) {
            contador3++;
        }

        Errors.addToEndFile("errors.log", "\t" + new Date() + "\tINVOICES: Se eliminaron: " + (contadorfac - contador3) + " facturas por que estaba repetido" + "\n");


    }

    void VerFacturas() {
        boolean confirmar = true;
        if (confirmar == true) {
            System.out.println("-------------------Lisata de Facturas-------------------");
            System.out.println("");
            for (int i = 0; i < facArray.size(); i++) {
                if (facArray.get(i) != null) {
                    System.out.println("-----------------------Factura: " + (i + 1) + "-----------------------");
                    System.out.print(facArray.get(i));
                    System.out.println("Productos: " + facArray.get(i).getProducts());
                    System.out.println("_________________________________________________________");
                    System.out.print("");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró la factura");
            MenuProd();
        }
    }

    public void EliminarFacturas() {

        System.out.println("Introduzca el Id de la factura que desea eliminar");
        System.out.print(">>>");
        Scanner lect = new Scanner(System.in);
        String producto = lect.nextLine();
        int cliente1 = Integer.parseInt(producto);

        int posicionUser = -1;
        boolean confirmar = true;
        if (confirmar == true) {
            for (int i = 0; i < facArray.size(); i++) {
                if (facArray.get(i).getId() == cliente1) {
                    facArray.remove(i);
                    System.out.println("_________________________________________________________");
                    System.out.println("         Factura " + cliente1 + " eliminado");
                    System.out.println("_________________________________________________________");
                    Errors.addToEndFile("errors.log", "\t" + new Date() + "\tINVOICES: Se eliminó el producto: " + cliente1 + "\n");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró la Factura");
        }
            /*while (confirmar == false) {
                System.out.println("No se encontró el usuario");
                confirmar = true;
            }*/
    }

    public void BuscarFacturas() {

        System.out.println("Introduzca el Id la factura que desea encontrar");
        System.out.print(">>>");
        Scanner lect = new Scanner(System.in);
        String producto = lect.nextLine();
        int factura = Integer.parseInt(producto);

        int posicionUser = -1;
        boolean confirmar = true;
        if (confirmar == true) {
            for (int i = 0; i < facArray.size(); i++) {
                if (facArray.get(i).getId() == factura) {
                    System.out.println("-----------------------Factura Encontrada-----------------------");
                    System.out.print(facArray.get(i));
                    System.out.println("Productos: " + facArray.get(i).getProducts());
                    System.out.println("________________________________________________________________");
                    confirmar = false;
                }
            }

        }
        if (confirmar) {
            System.out.println("No se encontró el cliente");
        }
            /*while (confirmar == false) {
                System.out.println("No se encontró el usuario");
                confirmar = true;
            }*/
    }

    /* public void GuardarCambios(){
        if(configuracion.getLoad().equals("bin")) {
            files.serializar("binarios\\users.ipcrm", usuArray);
            files.serializar("binarios\\products.ipcrm", prodArray);
            files.serializar("binarios\\clients.ipcrm", clienteArray);
            files.serializar("binarios\\invoices.ipcrm" , facArray);
            System.out.println("Serializaste los archivos a Binario");
        }else if (configuracion.getLoad().equals("json")){
            Gson gson = new Gson();
            files.serializar("binarios\\users.ipcrm", usuArray);
            files.serializar("binarios\\products.ipcrm", prodArray);
            files.serializar("binarios\\clients.ipcrm", clienteArray);
            files.serializar("binarios\\invoices.ipcrm", facArray);
            System.out.println("Serializaste los archivos a Binario");

            String jsonusuario = gson.toJson(usuArray);
            files.writeOnFile("jsons\\users.json",jsonusuario, false);
            String jsonclientes = gson.toJson(clienteArray);
            files.writeOnFile("jsons\\clients.json",jsonclientes, false);
            String jsonproductos = gson.toJson(prodArray);
            files.writeOnFile("jsons\\products.json",jsonproductos, false);
            String jsonfac = gson.toJson(facArray);
            files.writeOnFile("jsons\\invoices.json",jsonfac, false);
            System.out.println("Serializaste los archivos a Json");
        }else {
            System.out.println("El load es incorrecto");
        }*/


    public void MenuGuardarCambios() {
        boolean entrar_menu = true;
        while (entrar_menu == true) {
            System.out.println("");
            System.out.println("===Seleccione cómo desea guardar los datos===");
            System.out.println(" 1. Guardar a Json");
            System.out.println(" 2. Guardar a Bin");
            System.out.println(" 3. Volver al Menú");
            System.out.println(" 4. Salir del programa");
            System.out.println("====================================");
            System.out.print(">>>Escribir el número de opción: >");
            Scanner lec = new Scanner(System.in);
            int opccion = lec.nextInt();

            switch (opccion) {

                case 1:
                    GuardaraJson();
                    break;
                case 2:
                    GuardaraBinario();
                    break;
                case 3:
                    Menu();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    public void GuardaraJson() {
        Gson gson = new Gson();
        String jsonusuario = gson.toJson(usuArray);
        files.writeOnFile("jsons\\users.json", jsonusuario, false);
        String jsonclientes = gson.toJson(clienteArray);
        files.writeOnFile("jsons\\clients.json", jsonclientes, false);
        String jsonproductos = gson.toJson(prodArray);
        files.writeOnFile("jsons\\products.json", jsonproductos, false);
        String jsonfac = gson.toJson(facArray);
        files.writeOnFile("jsons\\invoices.json", jsonfac, false);
        System.out.println("Serializaste los archivos a Json");

    }
    public void GuardaraBinario() {
        files.serializar("binarios\\users.ipcrm", usuArray);
        files.serializar("binarios\\products.ipcrm", prodArray);
        files.serializar("binarios\\clients.ipcrm", clienteArray);
        files.serializar("binarios\\invoices.ipcrm", facArray);
        System.out.println("Serializaste los archivos a Binario");
    }


}
