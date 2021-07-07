package com.company.ventanas.de.usuarios;

import com.company.Main;
import com.company.Menudeopciones.menu;
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

import static com.company.ventanas.de.usuarios.ventanaCrear.usu_agregado;
import static com.company.ventanas.de.usuarios.ventanaEliminar.usu_eliminado;

public class CRUD {




    public static void CRUD(){
        //////
        Object[][] datos2;
        String [] columnas = {"Nombres","Contraseñas"};
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


        JLabel title=new JLabel("                MENU USUARIOS"); ////YOUR TITLE
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


        ImageIcon icon = new ImageIcon("images/usuario.jpg");
        ImageIcon icon2 = new ImageIcon("images/usuario.jpg");
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
        datos2= convertir_Usuarios();

        model = new DefaultTableModel(datos2, columnas);
        t = new JTable(model);
        sp = new JScrollPane(t);
        for (int c = 0; c < t.getColumnCount(); c++)

        {

            Class<?> col_class = t.getColumnClass(c);

            t.setDefaultEditor(col_class, null); // remove editor

        }
        sp.setBounds(60, 220, 700, 200);
        sp.setVisible(true);
        f1.add(sp);
        f1.repaint();



        ActionListener al=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (ae.getSource() == log) {
                    ventanaEditar.ventanaEditar();
                    f1.dispose();
                }
                else if (ae.getSource() == log2) {
                    ventanaEliminar.ventanaEliminar();
                    f1.dispose();
                }
                else if (ae.getSource() == log3) {
                    ventanaCrear.ventanaCrear();
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


    public static Object[][] convertir_Usuarios(){//conviertiendo usuarios
        int filas = Main.contador - usu_eliminado + usu_agregado;
        Object[][] arreglo = new Object[filas][2];
        // Con un simple for, podemos crear el objeto y declararle los valores que necesitamos
        if (Main.usuArray!=null){
            for (int i = 0; i < Main.usuArray.size(); i++) {
                arreglo[i][0]=  Main.usuArray.get(i).getUsername();
                arreglo[i][1]=  Main.usuArray.get(i).getPassword();
            }}
        // Por ultimoo, retornamos el Object[][]
        return arreglo;
    }





}