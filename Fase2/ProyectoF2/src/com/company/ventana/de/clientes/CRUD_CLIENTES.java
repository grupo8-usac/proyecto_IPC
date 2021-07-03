package com.company.ventana.de.clientes;
import com.company.Main;
import com.company.ventanas.de.usuarios.ventanaCrear;
import com.company.ventanas.de.usuarios.ventanaEditar;
import com.company.ventanas.de.usuarios.ventanaEliminar;

import com.company.ventanas.de.usuarios.ventanaEliminar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static com.company.ventana.de.clientes.ventanaCrearCliente.cliente_agregado;
import static com.company.ventana.de.clientes.ventanaEliminarCliente.cliente_eliminado;

public class CRUD_CLIENTES {


    public static void CRUD_CLIENTES(){
        //////
        Object[][] datos1;
        String [] columnas1 = {"Id","address","Nombres","Nit","phone"};
        DefaultTableModel model;
        JTable t;
        JScrollPane sp;
        ///////

        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int x=screensize.height;
        int y=screensize.width;

        final JFrame f1 =new JFrame("Registro");
        f1.setResizable(false);
        f1.setBounds((y/2)-250,(x/2)-250,900,600);


        JLabel title=new JLabel("                MENU CLIENTES"); ////YOUR TITLE
        title.setLayout(null);
        title.setBounds(250,-200,500,500);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        JButton log=new JButton("Editar");
        JButton log2=new JButton("Eliminar");
        JButton log3=new JButton("Agregar");
        JButton log4=new JButton("Regresar al Menu");

        final JPasswordField pass=new JPasswordField("Password");
        pass.setBounds(270,270,300,50);


        ImageIcon icon = new ImageIcon("images/cliente.jpg");
        ImageIcon icon2 = new ImageIcon("images/cliente.jpg");
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
        sp.setBounds(60, 220, 700, 200);
        sp.setVisible(true);
        // Por ultimo agregamos el ScrollPane que tiene dentro la tabla.
        f1.add(sp);
        f1.repaint();




        ActionListener al=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (ae.getSource() == log) {
                    ventanaEditarCliente.ventanaEditarCliente();
                }
                else if (ae.getSource() == log2) {
                    ventanaEliminarCliente.ventanaEliminarCliente();
                }
                else if (ae.getSource() == log3) {
                    ventanaCrearCliente.ventanaCrearCliente();
                }
                else if (ae.getSource() == log4) {

                }

            }
        };
        log.addActionListener(al);
        log2.addActionListener(al);
        log3.addActionListener(al);
        log4.addActionListener(al);

    }




    public static Object[][] convertir_clientes(){//conviertiendo usuarios
        int filas = Main.contador1 - cliente_eliminado + cliente_agregado;
        Object[][] arreglo = new Object[filas][5];
        // Con un simple for, podemos crear el objeto y declararle los valores que necesitamos
        for (int i = 0; i < Main.clienteArray.size(); i++) {
            arreglo[i][0]=  Main.clienteArray.get(i).getId();
            arreglo[i][1]=  Main.clienteArray.get(i).getAddress();
            arreglo[i][2]=  Main.clienteArray.get(i).getName();
            arreglo[i][3]=  Main.clienteArray.get(i).getNit();
            arreglo[i][4]=  Main.clienteArray.get(i).getPhone();
        }
        // Por ultimoo, retornamos el Object[][]
        return arreglo;
    }



}
