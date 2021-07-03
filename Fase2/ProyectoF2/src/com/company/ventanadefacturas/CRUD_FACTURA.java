package com.company.ventanadefacturas;

import com.company.Main;
import com.company.ventanade.info.VentanaEditarInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.ventanadefacturas.ventanaCrearFactura.fac_agregado;


public class CRUD_FACTURA {

    public static void CRUD_FACTURA(){
        ////////
        Object[][] datos2;
        String[] columnas = {"id", "cliente", "date", "phone","Productos"};
        DefaultTableModel model;
        JTable t;
        JScrollPane sp;
        ///////
        datos2 = convertir_clientes();

        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int x=screensize.height;
        int y=screensize.width;

        final JFrame f1 =new JFrame("Menú Factura");
        f1.setResizable(false);
        f1.setBounds((y/2)-250,(x/2)-250,900,600);


        JLabel title=new JLabel("             MENU FACTURAS"); ////YOUR TITLE
        title.setLayout(null);
        title.setBounds(250,-200,500,500);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        JButton log=new JButton("Crear");


        final JTextField usern=new JTextField("LISTA");
        final JPasswordField pass=new JPasswordField("Password");
        usern.setBounds(270,210,300,50 );
        pass.setBounds(270,270,300,50);


        ImageIcon icon = new ImageIcon("images/factura.jpg");
        ImageIcon icon2 = new ImageIcon("images/factura.jpg");
        ImageIcon icon3 = new ImageIcon("images/inicio.jpg");
        ImageIcon icon4 = new ImageIcon("images/inicio.jpg");

        log.setBounds(375,100,150,75);


        log.setBorderPainted(false);
        log.setBorder(null);
        log.setMargin(new Insets(0, 0, 0, 0));
        log.setContentAreaFilled(false);
        log.setIcon(icon2);
        log.setRolloverIcon(icon2);
        log.setPressedIcon(icon);
        log.setDisabledIcon(icon);

        f1.setLayout(null);
        f1.add(title);
        //f1.add(usern);
        //f1.add(pass);
        f1.setVisible(true);
        f1.add(log);
        //datos2= convertir_clientes();
        model = new DefaultTableModel(datos2, columnas);
        t = new JTable(model);
        t.setLayout(null);

        for (int c = 0; c < t.getColumnCount(); c++)

        {

            Class<?> col_class = t.getColumnClass(c);

            t.setDefaultEditor(col_class, null); // remove editor

        }

        // Debemos agregar esta tabla a un ScrollPane (Este tiene un Scroll para visualizar la tabla)
        sp = new JScrollPane(t);
        // Como usamos un Layout(null); debemos de agregarle el tamaño a cada componente que estemos utilizando
        sp.setBounds(60, 220, 700, 250);
        //model.setColumnIdentifiers(10,10,10,10,10,30);
        sp.setVisible(true);
        // Por ultimo agregamos el ScrollPane que tiene dentro la tabla.
        f1.add(sp);
        f1.repaint();
//        //////////////
        TableColumnModel columnModel = t.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(20);
        columnModel.getColumn(2).setPreferredWidth(20);
        columnModel.getColumn(3).setPreferredWidth(20);
        columnModel.getColumn(4).setPreferredWidth(200);





        ActionListener al=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (ae.getSource() == log) {
                    ventanaCrearFactura.ventanaCrearFactura();
                }

            }
        };
        log.addActionListener(al);



    }
    public static Object[][] convertir_clientes(){//conviertiendo usuarios
        int filas = Main.contador3  + fac_agregado;//ventanaEliminarCliente.eliminarcliente;
        Object[][] arreglo = new Object[filas][6];
        // Con un simple for, podemos crear el objeto y declararle los valores que necesitamos
        for (int i = 0; i < Main.facArray.size(); i++) {
            arreglo[i][0]=  Main.facArray.get(i).getId();
            arreglo[i][1]=  Main.facArray.get(i).getClient();
            arreglo[i][2]=  Main.facArray.get(i).getDate();
            arreglo[i][3]=  Main.facArray.get(i).getPhone();
            arreglo[i][4]=  Main.facArray.get(i).getProducts();
            //arreglo[i][6]=  ingredients.get(i).getQuantity();
            // arreglo[i][7]=  ingredients.get(i).getUnits();

        }
        // Por ultimoo, retornamos el Object[][]
        return arreglo;
    }









}