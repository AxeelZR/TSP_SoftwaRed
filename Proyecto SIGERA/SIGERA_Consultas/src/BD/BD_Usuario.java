/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public BD_Usuario() {
        Nombre_Usuario = "";
        Contraseña = "";
        Carrera = "";
        Consulta = "";
        Instruccion = "";

    }

    public Boolean Conectar() {
        boolean Conect = false;
        try {
            if (Conexion == null) {
                String URL = "jdbc:mysql://www.db4free.net:3306/sigerabd?autoReconnect=true";
                String Pwd = "sigeraisc9";
                String User = "sigeraisc";
                Conexion = DriverManager.getConnection(URL, User, Pwd);
                Comando = Conexion.createStatement();
                Conect = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "                   No hay internet \n Verifique la conexión y vuelva a ejecutar.");
            System.exit(0);
            Conect = false;
        }
        return Conect;
    }

    public boolean Autentificar(String Usuario, String ContraseñaU) throws SQLException {
        try {
            Consulta = "SELECT idUsuario FROM Usuario where Nombre = '?1' and Contrasenia = '?2';";
            Consulta = Consulta.replace("?1", Usuario);
            Consulta = Consulta.replace("?2", ContraseñaU);
            ResultSet Resultado = Comando.executeQuery(Consulta);
            if (Resultado != null && Resultado.next()) {
                Estado = true;
            }
            Consulta = "";
        } catch (Exception e) {
            System.out.println(e);
            Estado = false;
        }

        return Estado;
    }

    public void Desconectar() throws SQLException {
        Conexion.close();
    }

    public Boolean ModificacionUsuario(String Contrasena, Usuario mUsuario) throws SQLException {
        try {
            String SQL = "UPDATE Usuario set Contrasenia= '" + Contrasena
                    + "'where Nombre='" + mUsuario.getNombre_Usuario() + "';";
            Comando.executeUpdate(SQL);
            System.out.println(SQL + " Ejecutado");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ResultSet ConsultarCola(String NombreUsuario) throws SQLException {
        Consulta = "Select Nombre_Cola from Usuario where Nombre = '?1'";
        Consulta = Consulta.replace("?1", NombreUsuario);
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }
    
    public ResultSet ConsultarFechas(int id) throws SQLException {
        Consulta = "SELECT DISTINCT fecha from Historial where idUsuario = '?1'";
        Consulta = Consulta.replace("?1", String.valueOf(id));
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }
    public int Consultarid(String NombreUsuario) throws SQLException {
        Consulta = "Select idUsuario from Usuario where Nombre = '?1'";
        Consulta = Consulta.replace("?1", NombreUsuario);
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        int id=0;
        while(resultado.next()){
            id = Integer.parseInt(resultado.getString(1));
        }
        Consulta = "";
        return id;
    }
    
    public boolean InsertarMsj(int id, String Msj, String Fecha){
        boolean hecho = false;
        String Id = id+"";
        try {
            
            Instruccion = "insert into Historial values(null, '?1', '?2', '?3');";
            Instruccion = Instruccion.replace("?1", Id);
            Instruccion = Instruccion.replace("?2", Msj);
            Instruccion = Instruccion.replace("?3", Fecha);
            this.Comando.executeUpdate(Instruccion);
            hecho = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(BD_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hecho;
    }
    
    public ResultSet ConsultarMsj(int id) throws SQLException {
        String IdUsuario= id+"";
        Consulta = "Select Msj from Historial where idUsuario = '?1'";
        Consulta = Consulta.replace("?1", IdUsuario);
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }

}
