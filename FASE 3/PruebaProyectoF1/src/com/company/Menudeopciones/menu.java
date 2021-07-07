package com.company.Menudeopciones;

import com.company.Loginx;
import com.company.Main;
import com.company.ventana.de.clientes.CRUD_CLIENTES;
import com.company.ventanade.info.CRUD_INFO;
import com.company.ventanadefacturas.CRUD_FACTURA;
import com.company.ventanadeproductos.CRUD_PRODUCTS;
import com.company.ventanas.de.usuarios.CRUD;
import com.company.ventanas.de.usuarios.ventanaCrear;
import com.company.ventanas.de.usuarios.ventanaEditar;
import com.company.ventanas.de.usuarios.ventanaEliminar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame implements ActionListener {

    // JButton b1, b2, b3, b4;//botones a utlizar
    private JPanel panel;
    private Image imagen1;
    private JLabel l1, l2, l3;//etiquetas a usar
    JLabel e1, e2, e3, e4, e5, e6;

    public menu() {


        /////////pinche panel////////////
        panel = new JPanel(); //instanciando panel
        panel.setLayout(null);// desactivando el diseño
        panel.setBackground(Color.lightGray);
        this.getContentPane().add(panel); //agrega panel a ventana

        FondoPanel fond = new FondoPanel();
        ////agregando esa imagen
        this.add(fond);
        this.setContentPane(fond);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JButton b2 = new JButton();
        b2.setBounds(50, 100, 150, 100);
        ImageIcon inf = new ImageIcon("images/restaurant.jpg");
        b2.setIcon(new ImageIcon(inf.getImage().getScaledInstance(140, 90, 50)));
        b2.setBackground(Color.blue);//color del fondo del boton
        b2.setForeground(Color.yellow);//colo de la letra del texto
        b2.setFont(new Font("cooper black", 0, 12));
        b2.setVisible(true);//
        b2.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(b2);

////////////////////////////////////Users/////////////////////////////////////
        JButton b1 = new JButton();
        b1.setBounds(250, 100, 150, 100);
        ImageIcon inf1 = new ImageIcon("images/users.png");
        b1.setIcon(new ImageIcon(inf1.getImage().getScaledInstance(140, 90, 50)));
        b1.setBackground(Color.black);//color del fondo del boton
        b1.setForeground(Color.yellow);//colo de la letra del texto
        b1.setFont(new Font("cooper black", 0, 12));
        b1.setVisible(true);//
        b1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(b1);
//////////////////////////////////////////products//////////////////////////////////////////////////////////////

        JButton b3 = new JButton();
        b3.setBounds(440, 100, 150, 100);
        ImageIcon inf3 = new ImageIcon("images/products.jpg");
        b3.setIcon(new ImageIcon(inf3.getImage().getScaledInstance(140, 90, 50)));
        b3.setBackground(Color.blue);//color del fondo del boton
        b3.setForeground(Color.yellow);//colo de la letra del texto
        b3.setFont(new Font("cooper black", 0, 12));
        b3.setVisible(true);//
        b3.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(b3);

        //////////////////////////////////////////clients//////////////////////////////////////////////////////////////

        JButton b4 = new JButton();
        b4.setBounds(50, 290, 150, 100);
        ImageIcon inf4 = new ImageIcon("images/clients.jpg");
        b4.setIcon(new ImageIcon(inf4.getImage().getScaledInstance(140, 90, 50)));
        b4.setBackground(Color.blue);//color del fondo del boton
        b4.setForeground(Color.yellow);//colo de la letra del texto
        b4.setFont(new Font("cooper black", 0, 12));
        b4.setVisible(true);//
        b4.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(b4);

        //////////////////////////////////////////clients//////////////////////////////////////////////////////////////

        JButton b5 = new JButton();
        b5.setBounds(250, 290, 150, 100);
        ImageIcon inf5 = new ImageIcon("images/factura.png");
        b5.setIcon(new ImageIcon(inf5.getImage().getScaledInstance(140, 90, 50)));
        b5.setBackground(Color.blue);//color del fondo del boton
        b5.setForeground(Color.yellow);//colo de la letra del texto
        b5.setFont(new Font("cooper black", 0, 12));
        b5.setVisible(true);//
        b5.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(b5);

        JButton b6 = new JButton("Close Session");
        b6.setBounds(100, 450, 150, 40);
        b6.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        //ImageIcon inf5 = new ImageIcon("images/factura.png");
        //b5.setIcon(new ImageIcon(inf5.getImage().getScaledInstance(140, 90, 50)));
        b6.setBackground(Color.white);//color del fondo del boton
        b6.setForeground(Color.black);//colo de la letra del texto
        b6.setFont(new Font("cooper black", 0, 12));
        b6.setVisible(true);//
        b6.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(b6);

        JButton b7 = new JButton("Exit the program");
        b7.setBounds(400, 450, 150, 40);
        b7.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//          ImageIcon inf5 = new ImageIcon("images/factura.png");
//          b5.setIcon(new ImageIcon(inf5.getImage().getScaledInstance(140, 90, 50)));
        b7.setBackground(Color.white);//color del fondo del boton
        b7.setForeground(Color.black);//colo de la letra del texto
        b7.setFont(new Font("cooper black", 0, 12));
        b7.setVisible(true);//
        b7.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(b7);

        JButton b8 = new JButton();
        b8.setBounds(460, 290, 150, 100);
        ImageIcon inf8 = new ImageIcon("images/guardar.jpg");
        b8.setIcon(new ImageIcon(inf8.getImage().getScaledInstance(140, 90, 50)));
        b8.setBackground(Color.white);//color del fondo del boton
        b8.setForeground(Color.yellow);//colo de la letra del texto
        b8.setFont(new Font("cooper black", 0, 12));
        b8.setVisible(true);//
        b8.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(b8);
        //////////////////////////////////////////inf//////////////////////////////////////////////////////////////
////////////////////////etiquetas de la interfaaz ////////////////////////////////////////////////////////

        ///////////////////// titulo del menu ///////////////////////////////////////////////////////
        e1 = new JLabel("Welcome to the menu");// instanciamos una Jlabel con el nombre de etiqueta
        e1.setBounds(205, 50, 300, 30);
        e1.setForeground(Color.white);//colo de la letra del texto
        e1.setFont(new Font("cooper black", 0, 25));
        e1.setVisible(true);//
        // boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(e1);

        ///////////////////// informacion///////////////////////////////////////////////////////
        e2 = new JLabel("Restaurant Information");// instanciamos una Jlabel con el nombre de etiqueta
        e2.setBounds(30, 210, 300, 30);
        e2.setForeground(Color.white);//colo de la letra del texto
        e2.setFont(new Font("cooper black", 0, 14));
        e2.setVisible(true);//
        // boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(e2);

        ///////////////////// users///////////////////////////////////////////////////////
        e3 = new JLabel("Users");// instanciamos una Jlabel con el nombre de etiqueta
        e3.setBounds(300, 210, 300, 30);
        e3.setForeground(Color.white);//colo de la letra del texto
        e3.setFont(new Font("cooper black", 0, 14));
        e3.setVisible(true);//
        // boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(e3);


        ///////////////////// products///////////////////////////////////////////////////////
        e4 = new JLabel("Products");// instanciamos una Jlabel con el nombre de etiqueta
        e4.setBounds(490, 210, 300, 30);
        e4.setForeground(Color.white);//colo de la letra del texto
        e4.setFont(new Font("cooper black", 0, 14));
        e4.setVisible(true);//
        // boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(e4);

        ///////////////////// Clients///////////////////////////////////////////////////////
        e5 = new JLabel("Clients");// instanciamos una Jlabel con el nombre de etiqueta
        e5.setBounds(100, 390, 300, 30);
        e5.setForeground(Color.white);//colo de la letra del texto
        e5.setFont(new Font("cooper black", 0, 14));
        e5.setVisible(true);//
        // boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(e5);

        ///////////////////// Facturas ///////////////////////////////////////////////////////
        e6 = new JLabel("Invoices");// instanciamos una Jlabel con el nombre de etiqueta
        e6.setBounds(300, 390, 300, 30);
        e6.setForeground(Color.white);//colo de la letra del texto
        e6.setFont(new Font("cooper black", 0, 14));
        e6.setVisible(true);//
        // boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(e6);


        ///////////////////// guardar cambios  ///////////////////////////////////////////////////////
        e6 = new JLabel("Saves");// instanciamos una Jlabel con el nombre de etiqueta
        e6.setBounds(500, 390, 300, 30);
        e6.setForeground(Color.white);//colo de la letra del texto
        e6.setFont(new Font("cooper black", 0, 14));
        e6.setVisible(true);//
        // boton1.addActionListener(this);// Agregamos el boton a nuestra ventana con add
        this.add(e6);

        /////////////////////Elementos_ventana/////////////////////
        this.setTitle("PROYECTO");
        this.setBounds(650, 550, 650, 550);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2) {
                    CRUD_INFO.CRUD_INFO();
                    dispose();
                } else if (e.getSource() == b1) {
                    CRUD.CRUD();
                    dispose();
                } else if (e.getSource() == b3) {
                    CRUD_PRODUCTS.CRUD_PRODUCTS();
                    dispose();
                } else if (e.getSource() == b4) {
                    CRUD_CLIENTES.CRUD_CLIENTES();
                    dispose();

                } else if (e.getSource() == b5) {
                    CRUD_FACTURA.CRUD_FACTURA();
                    dispose();

                } else if (e.getSource() == b8) {
                    Main conf = new Main();
                    conf.GuardaraJson();
                    dispose();
                    JOptionPane.showMessageDialog(null, "Se guardaron los cambios exitosamente");
                } else if (e.getSource() == b7) {
                    System.exit(7);
                    dispose();
                }
                else if (e.getSource() == b6) {
                    Loginx.Loginx();
                    dispose();

                }

            //GuardaraJson();
            //CRUD.CRUD();
            //CRUD_CLIENTES.CRUD_CLIENTES();
            //CRUD_INFO.CRUD_INFO();
            //CRUD_PRODUCTS.CRUD_PRODUCTS();
        }


    }

    ;
        b1.addActionListener(al);
        b2.addActionListener(al);
        b3.addActionListener(al);
        b4.addActionListener(al);
        b5.addActionListener(al);
        b8.addActionListener(al);
        b7.addActionListener(al);
        b6.addActionListener(al);



}

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

class FondoPanel extends JPanel {

    @Override
    public void paint(Graphics ga) {
        imagen1 = new ImageIcon(getClass().getResource("/images/fondo12.jpg")).getImage();
        ga.drawImage(imagen1, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(ga);

    }
}
}

