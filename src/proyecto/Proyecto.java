/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import Conexion.Conexion;
import gui.CrearUsuarios;
import gui.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author danielflj
 */
public class Proyecto implements ActionListener{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Proyecto cmj=new Proyecto();
    }
    //Ventanaas
    Login ventanaLogin;
    CrearUsuarios ventanaCrearUsuarios;
    
    JButton botonEntrar;
    JButton botonCrearUsuario;
    Conexion conexion;
    
    public Proyecto()
    {
        cargarGUILogin();
        
    }

    private void cargarGUILogin() 
    {
        ventanaLogin=new Login();
        cargarEventosLogin();
    }
    
    private void cargarGUICrearUsuarios() 
    {
        ventanaCrearUsuarios=new CrearUsuarios();
        cargarEventosCrearUsuario();
    }

    private void cargarEventosLogin() 
    {
        botonEntrar=ventanaLogin.getBotonIniciarSesion();
        botonEntrar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    solicitudIniciarSesion();
                } catch (IOException  ex) {
                    Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
    
    private void cargarEventosCrearUsuario() 
    {
        botonCrearUsuario=ventanaCrearUsuarios.getButtonCrear();
        botonCrearUsuario.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    crearUsuario();
                } catch (IOException  ex) {
                    Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
    
    private void crearUsuario() throws IOException, ClassNotFoundException
    {
        String usuario= ventanaCrearUsuarios.getTextCC();
        String contra = ventanaCrearUsuarios.getTextContraseña();
        String tipo= ventanaCrearUsuarios.getTipo();
        String Estado="";
        conexion.mandaMensaje("/cmd/ crearUsuario "+usuario+" "+contra+" "+tipo);
        conexion.esperarMensaje();
        if(conexion.isLlegoMensaje())
        {
              Estado=conexion.getMensaje();
        }
       
        if(Estado.equals("/cmd/ usuarioCreado"))
        {
          JOptionPane.showMessageDialog(null,"Usuario Creado Correctamente");
          ventanaLogin=null;
          

        }else
        {
            JOptionPane.showMessageDialog(null,"Usuario No Creado");
        }
    }

    private void solicitudIniciarSesion()throws IOException, ClassNotFoundException
    {
        String usuario= ventanaLogin.getUsuario();
        String contra = ventanaLogin.getPass(); 
        conexion=new Conexion(usuario,"localhost"); 
        String Estado="";
      conexion.mandaMensaje("autentificar "+usuario+" "+contra);
      conexion.esperarMensaje();
      if(conexion.isLlegoMensaje())
      {
          Estado=conexion.getMensaje();
      }
       
      if(Estado.equals("/cmd/ Aceptada"))
      {
          JOptionPane.showMessageDialog(null,"Conexion Exitosa");
          ventanaLogin.dispose();
          ventanaLogin=null;
          cargarGUICrearUsuarios();

      }else
   {
       JOptionPane.showMessageDialog(null,"Conexion No Aprobada");
   }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
