package com.company.ventanadeproductos;

import com.company.Main;
import com.company.Menudeopciones.menu;
import com.company.ventana.de.clientes.ventanaEditarCliente;
import com.company.ventana.de.clientes.ventanaEliminarCliente;
import com.company.ventanas.de.usuarios.ventanaCrear;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.ventana.de.clientes.CRUD_CLIENTES.convertir_clientes;
import static com.company.ventanadeproductos.ventanaCrearProductos.prod_agregado;
import static com.company.ventanadeproductos.ventanaEliminarProduct.prod_eliminado;

public class CRUD_PRODUCTS {


    public static void CRUD_PRODUCTS(){
        Object[][] datos1,datos;
        String [] columnas1 = {"Id","name","description","cost","price","ingredientes"};
        //  String [] columnas = {"Ingredientes/nombre","Quanty","units"};
        DefaultTableModel model;
        JTable t;
        JScrollPane sp;

        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int x=screensize.height;
        int y=screensize.width;

        final JFrame f1 =new JFrame("Registro");
        f1.setResizable(false);
        f1.setBounds((y/2)-250,(x/2)-250,900,600);


        JLabel title=new JLabel("                MENU PRODUCTOS"); ////YOUR TITLE
        title.setLayout(null);
        title.setBounds(250,-200,500,500);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        JButton log=new JButton("Editar");
        JButton log2=new JButton("Eliminar");
        JButton log3=new JButton("Agregar");
        JButton log4=new JButton("Regresar al Menu");

        final JTextField usern=new JTextField("LISTA");
        final JPasswordField pass=new JPasswordField("Password");
        usern.setBounds(270,210,300,50 );
        pass.setBounds(270,270,300,50);


        ImageIcon icon = new ImageIcon("images/productos.jpg");
        ImageIcon icon2 = new ImageIcon("images/productos.jpg");
        ImageIcon icon3 = new ImageIcon("images/inicio.jpg");
        ImageIcon icon4 = new ImageIcon("images/inicio.jpg");

        log.setBounds(190,100,150,75);
        log2.setBounds(350,100,150,75);
        log3.setBounds(510,100,150,75);
        //Regresar
        log4.setBounds(630,490,225,75);
        //log3.setBounds(20,20,150,75);

        log.setBorderPainted(false);
        log.setBorder(null);
        log.setMargin(new Insets(0, 0, 0, 0));
        log.setContentAreaFilled(false);
        log.setIcon(icon2);
        log.setRolloverIcon(icon2);
        log.setPressedIcon(icon);
        log.setDisabledIcon(icon);

        log2.setBorderPainted(false);
        log2.setBorder(null);
        log2.setMargin(new Insets(0, 0, 0, 0));
        log2.setContentAreaFilled(false);
        log2.setIcon(icon2);
        log2.setRolloverIcon(icon2);
        log2.setPressedIcon(icon);
        log2.setDisabledIcon(icon);

        log3.setBorderPainted(false);
        log3.setBorder(null);
        log3.setMargin(new Insets(0, 0, 0, 0));
        log3.setContentAreaFilled(false);
        log3.setIcon(icon2);
        log3.setRolloverIcon(icon2);
        log3.setPressedIcon(icon);
        log3.setDisabledIcon(icon);

        log4.setBorderPainted(false);
        log4.setBorder(null);
        log4.setMargin(new Insets(0, 0, 0, 0));
        log4.setContentAreaFilled(false);
        log4.setIcon(icon4);
        log4.setRolloverIcon(icon4);
        log4.setPressedIcon(icon3);
        log4.setDisabledIcon(icon3);

        f1.setLayout(null);
        f1.add(title);
        //f1.add(usern);
        //f1.add(pass);
        f1.setVisible(true);
        f1.add(log);
        f1.add(log2);
        f1.add(log3);
        f1.add(log4);
        datos1= convertir_clientes();
        model = new DefaultTableModel(datos1, columnas1);
        t = new JTable(model);
        t.setLayout(null);

        for (int c = 0; c < t.getColumnCount(); c++)

        {

            Class<?> col_class = t.getColumnClass(c);

            t.setDefaultEditor(col_class, null); // remove editor

        }

        // Debemos agregar esta tabla a un ScrollPane (Este tiene un Scroll para visualizar la tabla)
        sp = new JScrollPane(t);
        // Como usamos un Layout(null); debemos de agregarle el tamaño a cada componente que estemos utilizando
        sp.setBounds(60, 220, 700, 250);
        //model.setColumnIdentifiers(10,10,10,10,10,30);
        sp.setVisible(true);
        // Por ultimo agregamos el ScrollPane que tiene dentro la tabla.
        f1.add(sp);
        f1.repaint();
//        //////////////
        TableColumnModel columnModel = t.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(20);
        columnModel.getColumn(2).setPreferredWidth(20);
        columnModel.getColumn(3).setPreferredWidth(20);
        columnModel.getColumn(4).setPreferredWidth(20);
        columnModel.getColumn(5).setPreferredWidth(200);




        ActionListener al=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (ae.getSource() == log) {
                    ventanaEditarProducts.ventanaEditarProducts();
                    f1.dispose();
                }
                else if (ae.getSource() == log2) {
                    ventanaEliminarProduct.ventanaEliminarProduct();
                    f1.dispose();
                }
                else if (ae.getSource() == log3) {
                    ventanaCrearProductos.ventanaCrearProductos();
                    f1.dispose();
                }
                else if (ae.getSource() == log4) {
                    menu men = new menu();
                    men.setVisible(true);
                    f1.dispose();
                }

            }
        };
        log.addActionListener(al);
        log2.addActionListener(al);
        log3.addActionListener(al);
        log4.addActionListener(al);

    }
    public static Object[][] convertir_clientes(){//conviertiendo usuarios
        int filas = Main.contador2 + prod_agregado - prod_eliminado;//ventanaEliminarCliente.eliminarcliente;
        Object[][] arreglo = new Object[filas][6];
        // Con un simple for, podemos crear el objeto y declararle los valores que necesitamos
        for (int i = 0; i < Main.prodArray.size(); i++) {
            arreglo[i][0]=  Main.prodArray.get(i).getId();
            arreglo[i][1]=  Main.prodArray.get(i).getName();
            arreglo[i][2]=  Main.prodArray.get(i).getDescription();
            arreglo[i][3]=  Main.prodArray.get(i).getCost();
            arreglo[i][4]=  Main.prodArray.get(i).getPrice();
            arreglo[i][5]=  Main.prodArray.get(i).getIngredients();
            //arreglo[i][6]=  ingredients.get(i).getQuantity();
            // arreglo[i][7]=  ingredients.get(i).getUnits();

        }
        // Por ultimoo, retornamos el Object[][]
        return arreglo;
    }










}