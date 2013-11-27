/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import java.io.*;
import java.net.*;
import javax.swing.*;
/**
 Clase ConexionCliente, contiene un Socket y los flujos de entrada/salida para comunicarse con
 * el servidor
 * @author ma0
 */
public class Conexion implements Runnable {
    
     Socket media;
     ObjectOutputStream salida;
     ObjectInputStream entrada;
     String nombre,mensaje="";
     Thread hilo;
     boolean conexionExitosa,llegoMensaje,estaActivado,meCerraron;
          /**
      * Crea una conexion desde el cliente hacia el servidor
      * @param s Socket aceptado por el Server Socket
      * @param nombre Cadena para identificar la Conexion
      */
    public Conexion(String nombre, String host)
    {
        this.nombre=nombre;
        conexionExitosa=llegoMensaje=estaActivado=meCerraron=false;
        try
        {
         conectarAServidor(host) ;
        obtenerFlujos();
        salida.flush();
        conexionExitosa=true;
        }catch (IOException e)
        {
           show("Imposible conectar al servidor "+e.toString());
        }
        
        
    }
    /**
     * Conecta el socket al servidor
     * @param servidorChat String con la direccion IP del servidor
     * @throws IOException En caso de no poder terminar la solicitud
     */
    private void conectarAServidor(String servidorChat) throws IOException
   {      
      media = new Socket( InetAddress.getByName( servidorChat ), 5800 );
   }

    /**
     * Asocia los flujos con los flujos del servidor
     * @throws IOException En caso de no poder terminar la solicitud
     */
   private void obtenerFlujos() throws IOException
   {
      salida = new ObjectOutputStream( media.getOutputStream() );      
      salida.flush(); 

      entrada = new ObjectInputStream( media.getInputStream() );
   }
    
    /**
     * Modifica el booleano Llego mensaje
     * @param llegoMensaje booleano
     */
    public void setLlegoMensaje(boolean llegoMensaje) {this.llegoMensaje = llegoMensaje;}
    /**
     * Retorna el mensaje que ha llegado desde el cliente
     * @return String con un mensaje
     */
    public String getMensaje() {return mensaje;}
    /**
     * Pregunta si ha llegado algun mensaje
     * @return booleano con el estado de llegada de mensajes
     */
    public boolean isLlegoMensaje() {return llegoMensaje;}
    /**
     * Verifica si han cerrado un socket
     * @return booleano con el estado del socket
     */
    public boolean ismeCerraron() {return meCerraron;}

    /**
     * Retorna el nombre de la actual conexion al servidor
     * @return String con el nombre de la conexion
     */
    public String getNombre() {return nombre;}
    /**
     * asigna un nombre a la conexion
     * @param nombre String con un nombre
     */
    public void setNombre(String nombre) {this.nombre = nombre;}


    public void iniciarConexion()
    {
        if(conexionExitosa)
        {
            hilo=new Thread(this,nombre);
            estaActivado=true;
            hilo.start();
        }
    }
    
    @Override
    public void run() 
    {
       
        while (estaActivado)
        {
            try
            {
            esperarMensaje();
            }catch ( ClassNotFoundException cnf )
                {JOptionPane.showMessageDialog(null, "Ni idea de que %& mandaron "+nombre);}
            catch ( IOException ioe )
                {JOptionPane.showMessageDialog(null, "Imposible Conectar al Servidor"+nombre);
                cerrarConexion();}

              
        }
    }
        /**  
     * Metodo que espera mensajes de los Sockets del Servidor
     * @throws IOException En caso de que la conexion se interrumpa
     * @throws ClassNotFoundException en caso de que el objeto de llegada no sea un String
     */
    public void esperarMensaje()throws IOException, ClassNotFoundException
    {
        mensaje=(String)entrada.readObject();
        llegoMensaje=true;
    }
        /**
     * Envia un mensaje al socket correspondiente
     * @param mensaje 
     */
    public void mandaMensaje(String mensaje)throws IOException
    {

         salida.writeObject(mensaje);
         salida.flush();
    }
     /**
     * cierra los puertos de entrada/salida del socket
     */
    public void cerrarConexion()
    {
        try
         {
            estaActivado=false;
            entrada.close(); 
            salida.close();
            media.close();
            meCerraron=true;
         }catch( IOException excepcionES ) {
         excepcionES.printStackTrace();
      }
    }
    

   
    
    public static void show(Object o){JOptionPane.showMessageDialog(null, o);}
    public static void cout(Object o){System.out.println(o);}
}
