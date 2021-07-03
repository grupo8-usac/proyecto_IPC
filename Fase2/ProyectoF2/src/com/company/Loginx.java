package com.company;
import com.company.Menudeopciones.menu;
import com.company.ventanas.de.usuarios.CRUD;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.*;





public class Loginx{


    static int contador,contadorusu=0;
    static int contador1,contadorclient=0;
    static int contador2,contadorprod=0;
    static int contador3,contadorfac=0;



    public static void Loginx(){

        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int x=screensize.height;
        int y=screensize.width;

        final JFrame f1 =new JFrame("Registro");
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setBounds((y/2)-250,(x/2)-250,500,500);


//System.out.println(x+" "+y);
        JLabel title=new JLabel("                  Restaurant Manager"); ////YOUR TITLE

        title.setLayout(null);
        title.setBounds(45,-200,500,500);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        final JTextField usern=new JTextField("Usuario");
        final JPasswordField pass=new JPasswordField("Password");
        usern.setBounds(90,210,300,50 );
        pass.setBounds(90,270,300,50);

        JButton log=new JButton("");

        ImageIcon icon = new ImageIcon("images/login.jpg");
        ImageIcon icon2 = new ImageIcon("images/login2.jpg");

        log.setBounds(160,350,180,60);

        log.setBorderPainted(false);
        log.setBorder(null);
        log.setMargin(new Insets(0, 0, 0, 0));
        log.setContentAreaFilled(false);
        log.setIcon(icon2);
        log.setRolloverIcon(icon2);
        log.setPressedIcon(icon);
        log.setDisabledIcon(icon);



        ActionListener al=new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String user=usern.getText();
                String passw=String.valueOf(pass.getPassword());
                /*Your USername and password goes here, you can add database connectivity if you want*/
                boolean entrar_menu = true;
                if (entrar_menu) {
                    for (int i = 0; i < Main.usuArray.size(); i++) {
                        if (Main.usuArray.get(i).getUsername().equals(user) && Main.usuArray.get(i).getPassword().equals(passw)) {
                            System.out.println("Registro exitoso1");
                            f1.dispose();
                            //CRUD nuevo = new CRUD();
                            //nuevo.setVisible(true);
                            menu nuevo = new menu();
                            nuevo.setVisible(true);
                            //f2.runpro();
                            //loginsucc();

                        }
                    }
                }
                if (entrar_menu) {
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrercta");
                    usern.requestFocusInWindow();
                }
            }
        };


        log.addActionListener(al);

        usern.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                String temp=usern.getText();
                if(temp.equals("Usuario")){
                    System.out.println("mouse listener");
                    usern.setText("");}
            }
        });

        pass.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent ae)
            {
                pass.setText("");
            }

        });

        usern.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    pass.requestFocusInWindow();
                }
            }
        });

        usern.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usern.selectAll();
            }

        }	);

        pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pass.selectAll();
            }

        }	);

        pass.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                    String user = usern.getText();
                    String passw = String.valueOf(pass.getPassword());
                    boolean entrar_menu = true;
                    if (entrar_menu) {
                        for (int i = 0; i < Main.usuArray.size(); i++) {
                            if (Main.usuArray.get(i).getUsername().equals(user) && Main.usuArray.get(i).getPassword().equals(passw)) {
                                System.out.println("Registro exitoso");
                                //CRUD nuevo = new CRUD();
                                //nuevo.setVisible(true);
                                menu nuevo = new menu();
                                nuevo.setVisible(true);
                                Errors.addToEndFile("errors.log", "\t" + new Date() + "\tInicio de sesión exitoso" + "\n");
                                entrar_menu = false;
                                //f2.runpro();
                                //loginsucc();

                            }
                        }
                    }
                    if (entrar_menu) {
                        JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrercta");
                        Errors.addToEndFile("errors.log", "\t" + new Date() + "\tError de sesión " + "\n");
                        usern.requestFocusInWindow();
                    }
                }
            }
        });
        f1.setLayout(null);
        f1.add(title);
        f1.add(usern);
        f1.add(pass);
        f1.setVisible(true);
        f1.add(log);
    }







}