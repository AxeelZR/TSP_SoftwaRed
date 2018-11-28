/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanj
 */
public class BD {
    Connection Conexion;
    Statement Comando;
    String Host;
    String BD;
    String User;
    String Password;
    String Instruccion;
    String Consulta;
    public boolean Conectar() throws Exception {
        Host = "localhost";
        BD = "SIGERA_CONSULTAS";
        User = "root";
        Password = "root";
        try {
            this.Conexion = DriverManager.getConnection("jdbc:mysql://" + Host + "/" + BD +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , User, Password);
            this.Comando = Conexion.createStatement();
            return true;
        } catch (SQLException exc) {
            System.out.println("Error" + exc.toString());
            Conexion.close();
            return false;
        }
    }
    
    public boolean InsertarMsj(String Msj, String Fecha){
        boolean hecho = false;
        try {
            
            Instruccion = "insert into historial values(null, '?1', '?2');";
            Instruccion = Instruccion.replace("?1", Msj);
            Instruccion = Instruccion.replace("?2", Fecha);
            this.Comando.executeUpdate(Instruccion);
            hecho = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hecho;
    }
    
    public ResultSet ConsultarFechas(String Carrera) throws SQLException {
        Consulta = "select fecha from historial;";
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }
    public void Desconectar() throws SQLException{
        Conexion.close();
    }
}
