/*
 * @carlochess @miltonln @daniel @Mauricio
 * Chess Player
 * CMD Univalle
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel{
    //------------------------
    // Atributos Interfaz
    //------------------------
    ImageIcon fondo;
    
    //------------------------
    // Constructor
    //------------------------
    
    /**
     * constructor de la clase le entran las dimenciones de la imagen y 
     * la imagen a dibujar
     * @param a
     * @param b
     * @param fondoEx 
     */
    PanelFondo(int a, int b ,ImageIcon fondoEx)
    {   
        fondo = fondoEx;
        this.setLayout(new BorderLayout());
        setOpaque(false);
        setSize(a,b);
    }
    //------------------------
    // Métodos
    //------------------------
    
    /**
     * permite cambiar el fondo mientras la aplicacion se ejecuta
     * @param fnd 
     */
    public void AsignarFondo(ImageIcon fnd)
    {
        fondo=fnd;
    } 
    
    
    /**
     * metodo sobrecargardo de la clase JPanel que dibuja la imagen en el 
     * fondo del panel
     * @param g 
     */
    @Override
    public void paintComponent( Graphics g )
    {
      g.drawImage(fondo.getImage(),0,0,this.getSize().width,this.getSize().height,null);
      super.paintComponent(g);
    }
    
}
