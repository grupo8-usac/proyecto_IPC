package com.company.ventanade.info;

import com.company.Main;
import com.company.ventana.de.clientes.ventanaEditarCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaEditarInfo {


    public static void VentanaEditarInfo() {
        boolean entrar = true;
        if (entrar) {


            Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
            int x = screensize.height;
            int y = screensize.width;

            final JFrame f1 = new JFrame("Editar Información");
            f1.setResizable(false);
            f1.setBounds((y / 2) - 250, (x / 2) - 250, 500, 600);


//System.out.println(x+" "+y);
            JLabel title = new JLabel("                  Editar Información"); ////YOUR TITLE

            title.setLayout(null);
            title.setBounds(45, -200, 500, 500);
            title.setFont(new Font("Serif", Font.PLAIN, 25));


            final JTextField usern = new JTextField(Main.configuracion.getName());
            final JTextField address = new JTextField(Main.configuracion.getAddress());
            final JTextField phone = new JTextField(String.valueOf(Main.configuracion.getPhone()));
            final JTextField load = new JTextField(Main.configuracion.getLoad());


            usern.setBounds(90, 160, 300, 50);
            address.setBounds(90, 220, 300, 50);
            phone.setBounds(90, 280, 300, 50);
            load.setBounds(90, 340, 300, 50);


            JButton log = new JButton("");

            ImageIcon icon = new ImageIcon("images/login.jpg");
            ImageIcon icon2 = new ImageIcon("images/login2.jpg");

            log.setBounds(160, 420, 180, 60);

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

                        String nombre = usern.getText();
                        if (nombre != null) {
                            Main.configuracion.setName(nombre);
                                f1.dispose();
                                entrar_menu = false;

                        }

                        String adddres = address.getText();
                        if (adddres != null) {
                            for (int i = 0; i < Main.clienteArray.size(); i++) {
                                Main.configuracion.setAddress(adddres);
                                f1.dispose();
                                entrar_menu = false;
                            }
                        }

                        String phone1 = phone.getText();
                        int phone = Integer.parseInt(phone1);
                        if (phone1 != null) {
                            for (int i = 0; i < Main.clienteArray.size(); i++) {
                                Main.configuracion.setPhone(phone);
                                f1.dispose();
                                entrar_menu = false;
                            }
                        }

                        String nit1 = load.getText();
                        if (nit1 != null) {
                            for (int i = 0; i < Main.clienteArray.size(); i++) {
                                Main.configuracion.setLoad(nit1);
                                f1.dispose();
                                entrar_menu = false;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Se modificaron los datos");
                        CRUD_INFO.CRUD_INFO();
                        f1.dispose();
                        entrar_menu = false;
                    }

                    if (entrar_menu) {
                        JOptionPane.showMessageDialog(null, "No se encontró el cliente");
                        usern.requestFocusInWindow();
                    }
                }
            };

            entrar = false;
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
            entrar = false;

            f1.setLayout(null);
            f1.add(title);
            f1.add(usern);
            f1.add(address);
            f1.add(phone);
            f1.add(load);
            //f1.add(pass);
            f1.setVisible(true);
            f1.add(log);
        }


    }
}
