/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

//import java.beans.Statement;
import com.mysql.cj.util.TimeUtil;
import java.sql.*;
import javax.swing.JOptionPane;
import sigera_controlescolar.Alumno;

/**
 *
 * @author TaniaEsparza
 */
public class BD {

    //private java.sql.Statement Comando;
    Connection Conexion;
    Statement Comando;
    String Host;
    String BD;
    String User;
    String Password;
    String Instruccion;
    String Nombre;
    String ApellidoMaterno;
    String ApellidoPaterno;
    String NC;
    String Carrera;
    String CURP;
    int Semestre;
    String Estado;
    String Direccion;
    String Consulta;

    @SuppressWarnings("empity-statement")

    public BD() {
        this.Host = "";
        this.BD = "";
        this.User = "";
        this.Password = "";
        Instruccion = "";
        Nombre = "";
        ApellidoMaterno = "";
        ApellidoPaterno = "";
        NC = "";
        Carrera = "";
        CURP = "";
        Semestre = 0;
        Estado = "";
        Direccion = "";
        Consulta = "";
    }

    public boolean Conectar() throws Exception {
        Host = "localhost";
        BD = "SIGERA";
        User = "root";
        Password = "";
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

    public boolean AltaAlumno(Alumno mAlumno) throws SQLException {
        int i;

        Nombre = mAlumno.getNombre();
        ApellidoPaterno = mAlumno.getApellidoPaterno();
        ApellidoMaterno = mAlumno.getApellidoMaterno();
        NC = mAlumno.getNC();
        Carrera = mAlumno.getCarrera();
        CURP = mAlumno.getCURP();
        Semestre = mAlumno.getSemestre();
        Estado = mAlumno.getEstado();
        Direccion = mAlumno.getDireccion();

        try {

            Instruccion = "insert into Alumno(NoControl,Carrera_Clave, Nombre, Apellido_Paterno, Apellido_Materno, CURP,Semestre,Estado,Direccion) values ('?1','?2','?3','?4', '?5','?6','?7','?8','?9');";
            Instruccion = Instruccion.replace("?1", String.valueOf(NC));
            Instruccion = Instruccion.replace("?2", Carrera);
            Instruccion = Instruccion.replace("?3", Nombre);
            Instruccion = Instruccion.replace("?4", ApellidoPaterno);
            Instruccion = Instruccion.replace("?5", ApellidoMaterno);
            Instruccion = Instruccion.replace("?6", CURP);
            Instruccion = Instruccion.replace("?7", String.valueOf(Semestre));
            Instruccion = Instruccion.replace("?8", Estado);
            Instruccion = Instruccion.replace("?9", Direccion);
            Conectar();
            i = this.Comando.executeUpdate(Instruccion);
            //System.out.print(Instruccion + "Ejecutado");
            JOptionPane.showMessageDialog(null, "El alumno " + Nombre + "/n con numero de control "
                    + NC +" /n ah sido inscrito satisfactoriamente");
            Instruccion = "";
            Nombre = "";
            ApellidoMaterno = "";
            ApellidoPaterno = "";
            NC = "";
            Carrera = "";
            CURP = "";
            Semestre = 0;
            Estado = "";
            Direccion = "";
            return true;
        } catch (Exception ex) {
            System.out.print("Error" + ex);
            return false;
        }

    }

    public Boolean BajaAlumno(String NC) throws SQLException {
        String Estado;
        int i;
        Estado = "0";
        try {
            Instruccion = "update Alumno set Estado ='" + Estado + "'  where NoControl='" + NC + "';";
            i = this.Comando.executeUpdate(Instruccion);
            //System.out.println(Instruccion + "Ejecutado");
            JOptionPane.showMessageDialog(null, "El alumno con numero de control "
                    + NC +" \n ha sido dado de Baja");
            return true;
        } catch (Exception ex) {
            System.out.print("Error" + ex);
            return false;
        }
    }

    public ResultSet ConsultarAlumnoC(String Carrera) throws SQLException {
        Consulta = "select * from Alumno where Carrera_Clave = '" + Carrera + "';";
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }
    
    public ResultSet ConsultarCarreras() throws SQLException {
        Consulta = "SELECT Nombre, Clave FROM carrera;";
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }

    public ResultSet ConsultarClaveCarreras(String NombreCarrera) throws SQLException {
        Consulta = "SELECT Clave FROM carrera where Nombre = '?1';";
        Consulta = Consulta.replace("?1", NombreCarrera);
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }
    
    public ResultSet ConsultarNombreCarreras(String Clave) throws SQLException {
        Consulta = "SELECT Nombre FROM carrera where Clave = '?1';";
        Consulta = Consulta.replace("?1", Clave);
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }
    public ResultSet ConsultarAlumnoE(String NC) throws SQLException {
        Consulta = "select * from Alumno where NoControl ='" + NC + "';";
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }

    public ResultSet ConsultarAlumnoG() throws SQLException {
        Consulta = "select * from Alumno";
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }

    public ResultSet ConsultarNumeroControlG() throws SQLException {
        Consulta = "SELECT NoControl from Alumno";
        ResultSet resultado = this.Comando.executeQuery(Consulta);
        Consulta = "";
        return resultado;
    }
    public void Desconectar() throws SQLException {
        Conexion.close();
    }

    public Boolean ModificacionAlumno(String NCR, Alumno mAlumno) throws SQLException {
        int i = 0;
        
        Nombre = mAlumno.getNombre();
        ApellidoPaterno = mAlumno.getApellidoPaterno();
        ApellidoMaterno = mAlumno.getApellidoMaterno();
        NC = mAlumno.getNC();
        Carrera = mAlumno.getCarrera();
        CURP = mAlumno.getCURP();
        Semestre = mAlumno.getSemestre();
        Estado = mAlumno.getEstado();
        Direccion = mAlumno.getDireccion();

        try {
            Instruccion = "UPDATE `alumno` SET `Carrera_Clave` = '?2', `Nombre` = '?3', `Apellido_Paterno` = '?4', `Apellido_Materno` = '?5', `CURP` = '?6', `Semestre` = '?7', `Estado` = '?8', `Direccion` = '?9' WHERE `alumno`.`NoControl` = '" + NCR + "'; ";
            Instruccion = Instruccion.replace("?1", String.valueOf(NC));
            Instruccion = Instruccion.replace("?2", Carrera);
            Instruccion = Instruccion.replace("?3", Nombre);
            Instruccion = Instruccion.replace("?4", ApellidoPaterno);
            Instruccion = Instruccion.replace("?5", ApellidoMaterno);
            Instruccion = Instruccion.replace("?6", CURP);
            Instruccion = Instruccion.replace("?7", String.valueOf(Semestre));
            Instruccion = Instruccion.replace("?8", Estado);
            Instruccion = Instruccion.replace("?9", Direccion);
            i = this.Comando.executeUpdate(Instruccion);
            //System.out.println(Instruccion + "Ejecutado");
            Instruccion = "";
            Nombre = "";
            ApellidoMaterno = "";
            ApellidoPaterno = "";
            NC = "";
            Carrera = "";
            CURP = "";
            Semestre = 0;
            Estado = "";
            Direccion = "";
            return true;
        } catch (Exception ex) {
            System.out.print("Error" + ex);
            return false;
        }
    }
}
