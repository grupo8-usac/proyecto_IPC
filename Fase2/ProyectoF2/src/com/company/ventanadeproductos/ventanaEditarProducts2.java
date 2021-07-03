package com.company.ventanadeproductos;

import com.company.Main;
import com.company.ventana.de.clientes.ventanaEditarCliente;
import com.company.ventanas.de.usuarios.ventanaEditar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ventanaEditarProducts2 {
    JButton log;


    public static void ventanaEditarProducts2() {



                    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
                    int x = screensize.height;
                    int y = screensize.width;

                    final JFrame f1 = new JFrame("Editar Producto");
                    f1.setResizable(false);
                    f1.setBounds((y / 2) - 250, (x / 2) - 250, 500, 600);


//System.out.println(x+" "+y);
                    JLabel title = new JLabel("                  Editar Producto"); ////YOUR TITLE

                    title.setLayout(null);
                    title.setBounds(45, -200, 500, 500);
                    title.setFont(new Font("Serif", Font.PLAIN, 25));


                    final JTextField id = new JTextField(String.valueOf(ventanaEditarProducts.contenido.getId()));
                    final JTextField usern = new JTextField(ventanaEditarProducts.contenido.getName());
                    final JTextField address = new JTextField(ventanaEditarProducts.contenido.getDescription());
                    final JTextField cost = new JTextField(String.valueOf(ventanaEditarProducts.contenido.getCost()));
                    final JTextField price = new JTextField(String.valueOf(ventanaEditarProducts.contenido.getPrice()));


                    id.setBounds(90, 100, 300, 50);
                    usern.setBounds(90, 160, 300, 50);
                    address.setBounds(90, 220, 300, 50);
                    cost.setBounds(90, 280, 300, 50);
                    price.setBounds(90, 340, 300, 50);


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

                                String id1 = id.getText();
                                int id = Integer.parseInt(id1);
                                if (id1 != null) {
                                    for (int i = 0; i < Main.prodArray.size(); i++) {
                                        if (Main.prodArray.get(i).getId() == ventanaEditarProducts.contenido.getId()) {
                                            //if (Main.clienteArray.get(i).getId() == ventanaEditarCliente.useredit) {
                                            Main.prodArray.get(i).setId(id);
                                            f1.dispose();
                                            entrar_menu = false;
                                        }

                                    }
                                }

                                String nombre = usern.getText();
                                if (nombre != null) {

                                    for (int i = 0; i < Main.prodArray.size(); i++) {
                                        if (Main.prodArray.get(i).getName().equals(ventanaEditarProducts.contenido.getName())) {
                                            Main.prodArray.get(i).setName(nombre);
                                            f1.dispose();
                                            entrar_menu = false;
                                        }
                                    }
                                }

                                String adddres = address.getText();
                                if (adddres != null) {

                                    for (int i = 0; i < Main.prodArray.size(); i++) {
                                        if (Main.prodArray.get(i).getDescription().equals(ventanaEditarProducts.contenido.getDescription())) {
                                            Main.prodArray.get(i).setDescription(adddres);
                                            f1.dispose();
                                            entrar_menu = false;
                                        }
                                    }
                                }

                                String phone1 = cost.getText();
                                int phone = Integer.parseInt(phone1);
                                if (phone1 != null) {
                                    for (int i = 0; i < Main.prodArray.size(); i++) {
                                        if (Main.prodArray.get(i).getCost() == ventanaEditarProducts.contenido.getCost()) {
                                            Main.prodArray.get(i).setCost(phone);
                                            f1.dispose();
                                            entrar_menu = false;
                                        }
                                    }
                                }

                                String nit1 = price.getText();
                                int price = Integer.parseInt(id1);
                                if (nit1 != null) {
                                    for (int i = 0; i < Main.prodArray.size(); i++) {
                                        if (Main.prodArray.get(i).getPrice() == ventanaEditarProducts.contenido.getPrice()) {
                                            Main.prodArray.get(i).setPrice(price);
                                            f1.dispose();
                                            entrar_menu = false;
                                        }
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "Se modificaron los datos");
                                entrar_menu = false;
                            }

                            if (entrar_menu) {
                                JOptionPane.showMessageDialog(null, "No se encontró el producto");
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


                    f1.setLayout(null);
                    f1.add(title);
                    f1.add(id);
                    f1.add(usern);
                    f1.add(address);
                    f1.add(cost);
                    f1.add(price);
                    //f1.add(pass);
                    f1.setVisible(true);
                    f1.add(log);

    }
}
