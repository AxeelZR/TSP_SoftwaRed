/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;



import java.sql.*;
import javax.swing.JOptionPane;
import sigera_consultas.Usuario;
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
    public static Connection getConnection() {
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
     public boolean Autentificar (String Usuario, String ContraseñaU) throws SQLException{
       try{
        Consulta = "SELECT id_Usuario FROM Usuario where Nombre = '?1' and Contrasenia = '?2';";
        Consulta = Consulta.replace("?1", Usuario);
        Consulta = Consulta.replace("?2", ContraseñaU);
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