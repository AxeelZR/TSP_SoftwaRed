/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.*;
import javax.swing.JOptionPane;
import sigera_controlescolar.Alumno;
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

    public BD_Usuario() {
        Nombre_Usuario = "";
        Contraseña = "";
        Carrera = "";
        Consulta = "";
        Instruccion = "";

    }

    public Connection GetConnection() {
        try {
            if (Conexion == null) {
                String Url = "jdbc:mysql://www.db4free.net:3306/sigerabd?autoReconnect=true";
                String Pwd = "sigeraisc9";
                String User = "sigeraisc";
                Conexion = DriverManager.getConnection(Url, User, Pwd);
                Comando = Conexion.createStatement();
                //System.out.println("Conectionesfull");
                //JOptionPane.showMessageDialog(null,"Si conecta");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Conexion;
    }

    public boolean Registrar(Usuario mUsuario) throws SQLException {
        try {
            Instruccion = "insert into Usuario(idUsuario,Carrera_Clave,Nombre,Contrasenia,Nombre_Cola) values(null,'?1','?2','?3','?4');";
            Instruccion = Instruccion.replace("?1", mUsuario.getCarrera());
            Instruccion = Instruccion.replace("?2", mUsuario.getNombre_Usuario());
            Instruccion = Instruccion.replace("?3", mUsuario.getContraseña());
            Instruccion = Instruccion.replace("?4", mUsuario.getNomCola());
            Comando.executeUpdate(Instruccion);
            Instruccion = "";
            Estado = true;
        } catch (Exception e) {
            System.out.println(e);
            Estado = false;
        }

        return Estado;
    }

    public ResultSet ConsultarCola(String Carrera) throws SQLException {
        Consulta = "Select Nombre_Cola from Usuario where Carrera_Clave = '?1'";
        Consulta = Consulta.replace("?1", Carrera);
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }

    public ResultSet ConsultarUsuarios() throws SQLException {
        Consulta = "select * from Usuario";
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }

    public boolean EliminarUsuario(String Nombre) throws SQLException {
        try {
            Instruccion = "Delete from Usuario where Nombre = '?1';";
            Instruccion = Instruccion.replace("?1", Nombre);
            Comando.executeUpdate(Instruccion);
            JOptionPane.showMessageDialog(null, "Se elimino el usuario " + Nombre);
            Instruccion = "";
            Estado = true;
        } catch (Exception e) {
            System.out.println(e);
            Estado = false;
        }
        return Estado;
    }

    public void Desconectar() throws SQLException {
        Conexion.close();
    }

}
