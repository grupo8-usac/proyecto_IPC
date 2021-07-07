package com.company.ventana.de.clientes;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ventanaEliminarCliente {

    JButton log;
    public static int cliente_eliminado=0;


    public static void ventanaEliminarCliente() {

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.height;
        int y = screensize.width;

        final JFrame f1 = new JFrame("Eliminar");
        f1.setResizable(false);
        f1.setBounds((y / 2) - 250, (x / 2) - 250, 500, 500);


//System.out.println(x+" "+y);
        JLabel title = new JLabel("                  Eliminar Cliente"); ////YOUR TITLE
        JLabel title1 = new JLabel("                  Introduzca el cliente que desea eliminar");

        title.setLayout(null);
        title.setBounds(45, -200, 500, 500);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        title1.setLayout(null);
        title1.setBounds(45, -100, 500, 500);
        title1.setFont(new Font("Serif", Font.PLAIN, 15));

        final JTextField usern = new JTextField("Id Cliente");
        usern.setBounds(90, 210, 300, 50);

        JButton log = new JButton("");

        ImageIcon icon = new ImageIcon("images/login.jpg");
        ImageIcon icon2 = new ImageIcon("images/login2.jpg");

        log.setBounds(160, 350, 180, 60);

        log.setBorderPainted(false);
        log.setBorder(null);
        log.setMargin(new Insets(0, 0, 0, 0));
        log.setContentAreaFilled(false);
        log.setIcon(icon2);
        log.setRolloverIcon(icon2);
        log.setPressedIcon(icon);
        log.setDisabledIcon(icon);


        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String user = usern.getText();
                int id = Integer.parseInt(user);

                /*Your USername and password goes here, you can add database connectivity if you want*/
                boolean entrar_menu = true;
                if (entrar_menu) {
                    for (int i = 0; i < Main.clienteArray.size(); i++) {
                        JOptionPane.showMessageDialog(null, "Está seguro que desea eliminar a: "+Main.clienteArray.get(i).getName()+"?");
                        if (Main.clienteArray.get(i).getId() == id) {
                            JOptionPane.showMessageDialog(null, "Se eliminó el cliente"+Main.clienteArray.get(i).getName());
                            Main.clienteArray.remove(i);
                            cliente_eliminado++;

                            f1.dispose();
                            CRUD_CLIENTES.CRUD_CLIENTES();
                            entrar_menu = false;
                            //f2.runpro();
                            //loginsucc();

                        }
                    }
                }
                if (entrar_menu) {
                    JOptionPane.showMessageDialog(null, "No se encontró en cliente");
                    usern.requestFocusInWindow();
                }
            }
        };


        log.addActionListener(al);

        usern.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                String temp = usern.getText();
                if (temp.equals("Usuario")) {
                    System.out.println("mouse listener");
                    usern.setText("");
                }
            }
        });



        usern.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usern.selectAll();
            }

        });


        f1.setLayout(null);
        f1.add(title);
        f1.add(title1);
        f1.add(usern);
        //f1.add(pass);
        f1.setVisible(true);
        f1.add(log);
    }


}