/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author danielflj
 */
public class CrearUsuarios extends JFrame {
    
    private final UIManager.LookAndFeelInfo apariencias[];
    private JLabel labelNombres, labelContraseña, labelApellidos, labelCC,labelTitulo,label1;
    private JTextField textNombres, textApellidos, textCC, textContraseña;
    private JRadioButton rButAdmin, rButFuncionario;
    private ButtonGroup grupoBotonesOpcion;
    private JPanel panel1, panel2, panel3;
    private TitledBorder borde1, borde2;
    private JButton buttonCrear;
    private PanelFondo FM;

    public JButton getButtonCrear() {
        return buttonCrear;
    }

    public String getTextCC() {
        return textCC.getText();
    }

    public String getTextContraseña() {
        return textContraseña.getText();
    }
    
    public String getTipo()
    {
        if(rButAdmin.isSelected())
            return "administrador";
        else
            return "funcionario";
    }
    
    private ImageIcon fondoMenu = new ImageIcon(PanelFondo.class.getResource("/images/wood.jpg"));
    
    public CrearUsuarios(){
        
        setUndecorated(true);
        
        borde2 = new TitledBorder("");
        borde2.setTitleColor(Color.WHITE);
        
        FM = new PanelFondo(this.getHeight(),this.getWidth(),fondoMenu);
        FM.setBorder(borde2);
        
        setLayout(new BorderLayout());
        setSize(400,250);
        
        apariencias = UIManager.getInstalledLookAndFeels();
        cambiarAparienciaVisual(1);
        
        labelTitulo = new JLabel("Crear Usuario");
        labelTitulo.setForeground(Color.white);
        labelTitulo.setHorizontalAlignment( SwingConstants.CENTER );
        
        label1 = new JLabel(" ");
        
        grupoBotonesOpcion = new ButtonGroup();
        rButAdmin = new JRadioButton("Administrador",false);
        rButAdmin.setForeground(Color.WHITE);
        rButFuncionario = new JRadioButton("Funcionario",false);
        rButFuncionario.setForeground(Color.WHITE);
        grupoBotonesOpcion.add(rButAdmin);
        grupoBotonesOpcion.add(rButFuncionario);
        buttonCrear = new JButton("Crear");
        buttonCrear.setForeground(Color.white);
        
        borde1= new TitledBorder("Opciones");
        borde1.setTitleColor(Color.WHITE);        
       
        panel1= new JPanel(new GridLayout(1,2));
        //panel1.setSize(300, 400);
        panel1.setOpaque(false);
        panel1.setBorder(borde1);
        panel1.add(rButAdmin);
        panel1.add(rButFuncionario);
        
        panel3 = new JPanel(new BorderLayout());
        panel3.setOpaque(false);
        panel3.add(panel1, BorderLayout.NORTH);
        panel3.add(buttonCrear, BorderLayout.SOUTH);
        
        labelNombres = new JLabel("Nombres");
        labelNombres.setForeground(Color.white);
        labelCC = new JLabel("Cedula");
        labelCC.setForeground(Color.white);
        labelApellidos = new JLabel("Apellidos");
        labelApellidos.setForeground(Color.white);
        labelContraseña = new JLabel("Contraseña");
        labelContraseña.setForeground(Color.white);
        
        textNombres = new JTextField();
        textApellidos = new JTextField();
        textCC = new JTextField();
        textContraseña = new JTextField();
        
        
        panel2 = new JPanel(new GridLayout(4,2));
        //panel2.setSize(300, 400);
        panel2.setOpaque(false);
        panel2.add(labelNombres);
        panel2.add(textNombres);
        panel2.add(labelApellidos);
        panel2.add(textApellidos);
        panel2.add(labelCC);
        panel2.add(textCC);
        panel2.add(labelContraseña);
        panel2.add(textContraseña);
        
        
        
        FM.add(labelTitulo, BorderLayout.NORTH);
        FM.add(panel2, BorderLayout.CENTER);
        FM.add(panel3,BorderLayout.SOUTH);
        
        add(FM, BorderLayout.CENTER);
        
        
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

    public JPanel getFM(){ return FM ;}
}
    
    
