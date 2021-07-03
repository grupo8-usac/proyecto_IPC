package com.company.ventanas.de.usuarios;


import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana2Editar {

    JButton log;


    public static void ventana2Editar() {


                    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
                    int x = screensize.height;
                    int y = screensize.width;

                    final JFrame f1 = new JFrame("Editar Usario");
                    f1.setResizable(false);
                    f1.setBounds((y / 2) - 250, (x / 2) - 250, 500, 600);


//System.out.println(x+" "+y);
                    JLabel title = new JLabel("                  Editar Usario"); ////YOUR TITLE

                    title.setLayout(null);
                    title.setBounds(45, -200, 500, 500);
                    title.setFont(new Font("Serif", Font.PLAIN, 25));


                    final JTextField usern = new JTextField(ventanaEditar.contenido.getUsername());
                    final JTextField address = new JTextField(ventanaEditar.contenido.getPassword());




                    usern.setBounds(90, 160, 300, 50);
                    address.setBounds(90, 220, 300, 50);



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
                                    for (int i = 0; i < Main.usuArray.size(); i++) {
                                        if (Main.usuArray.get(i).getUsername().equals(ventanaEditar.contenido.getUsername())) {
                                            Main.usuArray.get(i).setUsername(nombre);
                                            f1.dispose();
                                        }

                                    }

                                }
                                String adddres = address.getText();
                                if (adddres != null) {
                                    for (int i = 0; i < Main.usuArray.size(); i++) {
                                        if (Main.usuArray.get(i).getPassword().equals(ventanaEditar.contenido.getPassword())) {
                                            Main.usuArray.get(i).setPassword(adddres);
                                            f1.dispose();
                                        }
                                    }

                                }


                                JOptionPane.showMessageDialog(null, "Se modificaron los datos");
                                entrar_menu = false;
                            }
                            entrar_menu = false;


                            if (entrar_menu) {
                                JOptionPane.showMessageDialog(null, "No se encontró el Usario");
                                usern.requestFocusInWindow();
                            }

                        }
                    };


                    log.addActionListener(al);

                    usern.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            String temp = usern.getText();
                            if (temp.equals("Usario")) {
                                System.out.println("mouse listener");
                                usern.setText("");

                            }
                        }
                    });


                    f1.setLayout(null);
                    f1.add(title);
                    f1.add(usern);
                    f1.add(address);
                    //f1.add(pass);
                    f1.setVisible(true);
                    f1.add(log);

    }
}