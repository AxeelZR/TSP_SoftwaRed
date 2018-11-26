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
    int idUsuario;
    String Contrasenia;

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
                System.out.println("Conectionesfull");
                JOptionPane.showMessageDialog(null, "Si conecta");
                Conect = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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
            String SQL = "UPDATE usuario set Contrasenia= '" + Contrasena
                    + "', Semestre = '" + mUsuario.getSemestre() + "' where idUsuario='" + mUsuario.getNombre_Usuario() + "';";
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

}
