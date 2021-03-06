package com.company.ventanadefacturas;

import com.company.Facturas;
import com.company.Main;
import com.company.Productos;
import com.company.ventanadeproductos.ventanaEditarProducts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ventanaCrearFactura {

    static int fac_agregado = 0;
    public static void ventanaCrearFactura() {



        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.height;
        int y = screensize.width;

        final JFrame f1 = new JFrame("Crear Factura");
        f1.setResizable(false);
        f1.setBounds((y / 2) - 250, (x / 2) - 250, 500, 600);


//System.out.println(x+" "+y);
        JLabel title = new JLabel("                  Crear Factura"); ////YOUR TITLE

        title.setLayout(null);
        title.setBounds(45, -200, 500, 500);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        final JTextField id = new JTextField(String.valueOf(Main.contador3+1+fac_agregado));
        id.setEditable(false);
        id.setEnabled(false);

        final JTextField client = new JTextField("cliente");
        final JTextField date = new JTextField("fecha");
        final JTextField phone = new JTextField("telefono");



        id.setBounds(90, 100, 300, 50);
        client.setBounds(90, 160, 300, 50);
        date.setBounds(90, 220, 300, 50);
        phone.setBounds(90, 280, 300, 50);


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

                String nombre = client.getText();
                int cliente = Integer.parseInt(nombre);

                String adddres = date.getText();

                String phone1 = phone.getText();
                int phone = Integer.parseInt(phone1);


                Facturas cont = new Facturas(id,cliente,adddres,phone,null);

                boolean entrar_menu = true;
                if (entrar_menu) {
                    if (id1 != null) {
                        for (int i = 0; i < Main.facArray.size(); i++) {
                            if (Main.facArray.get(i).getId() != id) {
                                f1.dispose();
                                Main.facArray.add(cont);
                                fac_agregado++;
                                JOptionPane.showMessageDialog(null, "Se cre?? con exito la factura");
                                entrar_menu = false;
                            }

                        }
                    }

                    JOptionPane.showMessageDialog(null, "Se modificaron los datos");
                    entrar_menu = false;
                }

                if (entrar_menu) {
                    JOptionPane.showMessageDialog(null, "No se encontr?? el producto");
                    client.requestFocusInWindow();
                }
            }
        };

        log.addActionListener(al);

        client.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                String temp = client.getText();
                if (temp.equals("client")) {
                    System.out.println("mouse listener");
                    client.setText("");

                }
            }
        });


        f1.setLayout(null);
        f1.add(title);
        f1.add(id);
        f1.add(client);
        f1.add(date);
        f1.add(phone);
        //f1.add(price);
        //f1.add(pass);
        f1.setVisible(true);
        f1.add(log);

    }
}

