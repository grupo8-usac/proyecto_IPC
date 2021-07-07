package com.company.ventanadeproductos;

import com.company.Main;
import com.company.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ventanaCrearProductos {
    static int prod_agregado = 0;
    public static void ventanaCrearProductos() {



        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.height;
        int y = screensize.width;

        final JFrame f1 = new JFrame("Crear Producto");
        f1.setResizable(false);
        f1.setBounds((y / 2) - 250, (x / 2) - 250, 500, 600);


//System.out.println(x+" "+y);
        JLabel title = new JLabel("                  Crear Producto"); ////YOUR TITLE

        title.setLayout(null);
        title.setBounds(45, -200, 500, 500);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        final JTextField id = new JTextField(String.valueOf(Main.contador2+1+prod_agregado));
        id.setEditable(false);
        id.setEnabled(false);


        final JTextField usern = new JTextField("nombre");
        final JTextField address = new JTextField("descripcion");
        final JTextField cost = new JTextField("costo");
        final JTextField price = new JTextField("precio");


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
                String id1 = id.getText();
                int id = Integer.parseInt(id1);

                String nombre = usern.getText();

                String adddres = address.getText();

                String phone1 = cost.getText();
                int phone = Integer.parseInt(phone1);

                String nit1 = price.getText();
                int price = Integer.parseInt(nit1);

                Productos cont = new Productos(id,nombre,adddres,phone,price,null);

                boolean entrar_menu = true;
                if (entrar_menu) {
                    if (id1 != null) {
                        for (int i = 0; i < Main.prodArray.size(); i++) {
                            if (Main.prodArray.get(i).getId() != id) {
                                Main.prodArray.add(cont);
                                f1.dispose();
                                prod_agregado++;
                                JOptionPane.showMessageDialog(null, "Se crearon los productos");
                                entrar_menu = false;

                            }


                        }
                        CRUD_PRODUCTS.CRUD_PRODUCTS();
                    }else {
                        JOptionPane.showMessageDialog(null, "El id del producto ya existe");
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
