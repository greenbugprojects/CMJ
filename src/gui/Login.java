/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author danielflj
 */
public class Login extends JFrame {
    
    
    
    private final ImageIcon fondoSesion = new ImageIcon(PanelFondo.class.getResource("/images/wood.jpg"));
    private final ImageIcon imagenUsuario = new ImageIcon(PanelFondo.class.getResource("/images/usuario.png"));

    
    private TitledBorder bordeSesion;
    private JTextField campoNombreUsuario;
    private JPasswordField campoContraseña;
    private JLabel labelUsuario, labelContraseña, labelRegistrado;
    private JButton botonIniciarSesion, botonRegistrarse;
    private final UIManager.LookAndFeelInfo apariencias[];
    private JPanel panelCentral, panelSur;
    private String username;
    
    public Login(){
        
        setUndecorated(true);
        
        setLayout(new BorderLayout());
        setSize(300,400);
        
        apariencias = UIManager.getInstalledLookAndFeels();
        cambiarAparienciaVisual(1);
        
        PanelFondo panelFondoSesion = new PanelFondo(this.getHeight(),this.getWidth(),fondoSesion);
        panelFondoSesion.setLayout(new BorderLayout());
        
        PanelFondo ImagenUsuario = new PanelFondo(500,500,imagenUsuario);
        ImagenUsuario.setLayout(new FlowLayout());
        
        
        add(panelFondoSesion,BorderLayout.CENTER); 
        
        panelCentral = new JPanel();
        panelCentral.setOpaque(false);
        panelCentral.setLayout(new GridLayout(7,1,0,0));
        panelFondoSesion.add(panelCentral, BorderLayout.CENTER);
        
        bordeSesion = new TitledBorder("Iniciar Sesión");
        bordeSesion.setTitleColor(Color.white);
        panelFondoSesion.setBorder(bordeSesion);
        
        
        JPanel panelConFlow6 = new JPanel();
        panelConFlow6.setOpaque(false);
        panelConFlow6.add(ImagenUsuario);
        
        panelCentral.add(panelConFlow6);
        
        
        
        labelUsuario = new JLabel("Nombre de usuario: ");
        labelUsuario.setForeground(Color.white);
        JPanel panelConFlow4 =  new JPanel();
        panelConFlow4.add(labelUsuario);
        panelConFlow4.setOpaque(false);
        panelCentral.add(panelConFlow4);
        
        
        campoNombreUsuario = new JTextField(8);
        JPanel panelConFlow1 =  new JPanel();
        panelConFlow1.add(campoNombreUsuario);
        panelConFlow1.setOpaque(false);
        panelCentral.add(panelConFlow1);
        
        labelContraseña = new JLabel("Contraseña: ");
        labelContraseña.setForeground(Color.white);
        JPanel panelConFlow5 = new JPanel();
        panelConFlow5.add(labelContraseña);
        panelConFlow5.setOpaque(false);
        panelCentral.add(panelConFlow5);
        
        campoContraseña = new JPasswordField(8);
        JPanel panelConFlow2 = new JPanel();
        panelConFlow2.add(campoContraseña);
        panelConFlow2.setOpaque(false);
        panelCentral.add(panelConFlow2);
        
        JLabel labelVacio = new JLabel();
        panelCentral.add(labelVacio);
        
        botonIniciarSesion = new JButton("Iniciar Sesión");
        //botonIniciarSesion.addActionListener(this);
                
                
               
        JPanel panelConFlow3 = new JPanel();
        panelConFlow3.add(botonIniciarSesion);
        panelConFlow3.setOpaque(false);
        panelCentral.add(panelConFlow3);
        
        
        panelSur = new JPanel();
        panelSur.setOpaque(false);
        panelFondoSesion.add(panelSur, BorderLayout.SOUTH);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        
        }
        
        private void cambiarAparienciaVisual(int valor) {
        try // cambia la apariencia visual
        {
            // establece la apariencia visual para esta aplicación
            UIManager.setLookAndFeel(apariencias[ valor].getClassName());
            // actualiza los componentes en esta aplicación
            SwingUtilities.updateComponentTreeUI(this);
        } // fin de try
        catch (Exception excepcion) {
        } // fin de catch
    }
        
        public JButton getBotonIniciarSesion()
        {
            return botonIniciarSesion;
        }
        
        public String getUsuario()
        {
            return campoNombreUsuario.getText();
        }
        
        public String getPass()
        {
            return this.campoContraseña.getText();
        }

    
}
