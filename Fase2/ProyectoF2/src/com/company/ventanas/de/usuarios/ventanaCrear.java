package com.company.ventanas.de.usuarios;


import com.company.Main;
import com.company.Usuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaCrear{

    JButton log;
 static Usuarios Contenido;
 static int usu_agregado = 0;

    public static void ventanaCrear() {

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.height;
        int y = screensize.width;

        final JFrame f1 = new JFrame("Agregar Usuario");
        f1.setResizable(false);
        f1.setBounds((y / 2) - 250, (x / 2) - 250, 500, 500);


//System.out.println(x+" "+y);
        JLabel title = new JLabel("                Agregar Usuario"); ////YOUR TITLE
        JLabel title1 = new JLabel("               Introduzca el usuario y contraseña que desea agregar");

        title.setLayout(null);
        title.setBounds(45, -200, 500, 500);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        title1.setLayout(null);
        title1.setBounds(45, -100, 500, 500);
        title1.setFont(new Font("Serif", Font.PLAIN, 15));

        final JTextField usern = new JTextField("Usuario");
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

                boolean entrar_menu = true;
                if (entrar_menu) {
                    String user = usern.getText();
                    String passw = String.valueOf(pass.getPassword());
                    Usuarios cont = new Usuarios(user,passw);

                    for (int i = 0; i < Main.usuArray.size(); i++) {
                        if (Main.usuArray.get(i).getUsername().equals(user)) {
                            JOptionPane.showMessageDialog(null, "Este usuario ya existe");
                            entrar_menu = false;
                            break;
                        }
                        else {
                            Main.usuArray.add(cont);
                            JOptionPane.showMessageDialog(null, "Se creó el usuario: "+user);
                            usu_agregado++;
                            entrar_menu = false;
                            break;
                        }

                    }

                }
                if (entrar_menu) {
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

        f1.setLayout(null);
        f1.add(title);
        f1.add(title1);
        f1.add(usern);
        f1.add(pass);
        f1.setVisible(true);
        f1.add(log);
    }


}