package com.company.ventanadeproductos;

import com.company.Main;
import com.company.Productos;
import com.company.ventana.de.clientes.ventanaEditarCliente2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ventanaEditarProducts {

    JButton log;
    static int useredit;
    static Productos contenido;


            public static void ventanaEditarProducts() {

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.height;
        int y = screensize.width;

        final JFrame f1 = new JFrame("Editar Productos");
        f1.setResizable(false);
        f1.setBounds((y / 2) - 250, (x / 2) - 250, 500, 500);


//System.out.println(x+" "+y);
        JLabel title = new JLabel("                  Seleccionar Producto"); ////YOUR TITLE
        JLabel title1 = new JLabel("                  Introduzca el Id de Producto que desea editar");

        title.setLayout(null);
        title.setBounds(45, -200, 500, 500);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        title1.setLayout(null);
        title1.setBounds(45, -100, 500, 500);
        title1.setFont(new Font("Serif", Font.PLAIN, 15));

        final JTextField usern = new JTextField("Id Producto");


        final JPasswordField pass = new JPasswordField("Password");
        usern.setBounds(90, 210, 300, 50);
        pass.setBounds(90, 270, 300, 50);

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
                String useredit1 = usern.getText();
                useredit = Integer.parseInt(useredit1);
                boolean entrar_menu = true;
                if (entrar_menu) {
                    for (int i = 0; i < Main.prodArray.size(); i++) {
                        if (Main.prodArray.get(i).getId() == useredit) {
                            contenido = Main.prodArray.get(i);
                            ventanaEditarProducts2.ventanaEditarProducts2();
                            f1.dispose();
                            //CRUD nuevo = new CRUD();
                            //nuevo.setVisible(true);
                            entrar_menu = false;
                            //f2.runpro();
                            //loginsucc();

                        }
                    }
                }
                if (entrar_menu) {
                    JOptionPane.showMessageDialog(null, "No se encontró el Producto :c");
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

        pass.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent ae) {
                pass.setText("");
            }

        });

        usern.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pass.requestFocusInWindow();
                }
            }
        });

        usern.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usern.selectAll();
            }

        });

        pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pass.selectAll();
            }

        });

        pass.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    String useredit1 = usern.getText();
                    useredit = Integer.parseInt(useredit1);

                    boolean entrar_menu = true;
                    if (entrar_menu) {
                        for (int i = 0; i < Main.prodArray.size(); i++) {
                            if (Main.prodArray.get(i).getId() == useredit) {
                                contenido = Main.prodArray.get(i);
                                ventanaEditarProducts2.ventanaEditarProducts2();
                                f1.dispose();
                                entrar_menu = false;

                                //}

                            }
                        }
                    }
                    if (entrar_menu) {
                        JOptionPane.showMessageDialog(null, "No se encontró el Producto1");
                        usern.requestFocusInWindow();
                    }
                }
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