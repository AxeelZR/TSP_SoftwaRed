/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;



import java.sql.*;
import javax.swing.JOptionPane;
import sigera_controlescolar.Usuario;
/**
 *
 * @author Yosse
 */
public class BD_Usuario {
    
    private static Connection Conexion = null;
    static Statement Comando;
    String Consulta;
    String Instruccion;
    String Nombre_Usuario;
    String Contraseña;
    String Carrera;
    boolean Estado;
    
    public BD_Usuario(){
        Nombre_Usuario = "";
        Contraseña = "";
        Carrera = "";
        Consulta = "";
        Instruccion = "";
       
    }
    public Connection getConnection() {
      try {
          if(Conexion == null){
              String URL = "jdbc:mysql://www.db4free.net:3306/sigerabd?autoReconnect=true";
              String Pwd = "sigeraisc9";
              String User = "sigeraisc";
              Conexion = DriverManager.getConnection(URL,User,Pwd);
              Comando = Conexion.createStatement();
              System.out.println("Conectionesfull");
              JOptionPane.showMessageDialog(null,"Si conecta");
          }
      } 
      catch(SQLException ex){
          ex.printStackTrace();
        }
      return Conexion;
    }
    public boolean Registrar(Usuario mUsuario) throws SQLException{
       try{
        Consulta = "insert into Usuario(idUsuario,Carrera_Clave,Nombre,Contrasenia,Nombre_Cola) values(null,'?1','?2','?3','?4');";
        Consulta = Consulta.replace("?1", mUsuario.getCarrera());
        Consulta = Consulta.replace("?2", mUsuario.getNombre_Usuario());
        Consulta = Consulta.replace("?3", mUsuario.getContraseña());
        Consulta = Consulta.replace("?4", mUsuario.getNomCola());
        Consulta = "";
        Estado= true;
       }
       catch(Exception e){
           System.out.println(e);
           Estado = false; 
       }
       
           return Estado;
   } 
   public void Desconectar() throws SQLException {
        Conexion.close();
    }
    
}