package com.company.ventanade.info;

import com.company.Main;
import com.company.ventanas.de.usuarios.ventanaCrear;
import com.company.ventanas.de.usuarios.ventanaEditar;
import com.company.ventanas.de.usuarios.ventanaEliminar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRUD_INFO {


    public static void CRUD_INFO() {
        ////////
        Object[][] datos2;
        String[] columnas = {"Nombre", "address", "phone", "load"};
        DefaultTableModel model;
        JTable t;
        JScrollPane sp;
        ///////
        datos2 = convertir_configuracion();


        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.height;
        int y = screensize.width;

        final JFrame f1 = new JFrame("Información");
        f1.setResizable(false);
        f1.setBounds((y / 2) - 250, (x / 2) - 250, 900, 400);


        JLabel title = new JLabel("             MENU INFORMACIÓN"); ////YOUR TITLE
        title.setLayout(null);
        title.setBounds(250, -200, 500, 500);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        JButton log = new JButton("Editar");


        //final JTextField usern=new JTextField("LISTA");
        final JPasswordField pass = new JPasswordField("Password");
        // usern.setBounds(270,210,300,50 );
        pass.setBounds(270, 270, 300, 50);


        ImageIcon icon = new ImageIcon("images/restaurante.jpg");
        ImageIcon icon2 = new ImageIcon("images/restaurante.jpg");
        ImageIcon icon3 = new ImageIcon("images/inicio.jpg");
        ImageIcon icon4 = new ImageIcon("images/inicio.jpg");

        log.setBounds(375, 100, 150, 75);


        log.setBorderPainted(false);
        log.setBorder(null);
        log.setMargin(new Insets(0, 0, 0, 0));
        log.setContentAreaFilled(false);
        log.setIcon(icon2);
        log.setRolloverIcon(icon2);
        log.setPressedIcon(icon);
        log.setDisabledIcon(icon);

        /////////
        model = new DefaultTableModel(datos2, columnas);
        t = new JTable(model);
        sp = new JScrollPane(t);
        for (int c = 0; c < t.getColumnCount(); c++) {

            Class<?> col_class = t.getColumnClass(c);

            t.setDefaultEditor(col_class, null); // remove editor

        }
        sp.setBounds(100, 220, 700, 50);
        sp.setVisible(true);
        f1.add(sp);
        f1.repaint();

        f1.setLayout(null);
        f1.add(title);
        //  f1.add(usern);
        //f1.add(pass);
        f1.setVisible(true);
        f1.add(log);


        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == log) {
                    VentanaEditarInfo.VentanaEditarInfo();
                }

            }
        };
        log.addActionListener(al);


    }

    public static Object[][] convertir_configuracion() {//conviertiendo usuarios
        int filas = 1;
        Object[][] arreglo = new Object[filas][4];
        // Con un simple for, podemos crear el objeto y declararle los valores que necesitamos
        if (Main.configuracion != null) {
            for (int i = 0; i < 1; i++) {
                arreglo[i][0] = Main.configuracion.getName();
                arreglo[i][1] = Main.configuracion.getAddress();
                arreglo[i][2] = Main.configuracion.getPhone();
                arreglo[i][3] = Main.configuracion.getLoad();
            }
        }
        // Por ultimoo, retornamos el Object[][]
        return arreglo;
    }
}