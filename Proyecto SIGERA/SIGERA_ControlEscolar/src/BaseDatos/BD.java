/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

//import java.beans.Statement;
import java.sql.*;
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

    @SuppressWarnings("empity-statement")

    public BD() {
        this.Host = "";
        this.BD = "";
        this.User = "";
        this.Password = "";
    }

    public boolean Conectar() throws Exception {
        Host = "localhost";
        BD = "SIGERA";
        User = "root";
        Password = "";
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            this.Conexion = DriverManager.getConnection("jdbc:mysql://" + Host + "/" + BD, User, Password);
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

        String Instruccion = "";
        String Nombre = "";
        String ApellidoMaterno = "";
        String ApellidoPaterno = "";
        String NC = "";
        String Carrera = "";
        String CURP = "";
        int Semestre = 0;
        String Estado = "";
        String Direccion = "";

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
            System.out.print(Instruccion + "Ejecutado");
            return true;
        } catch (Exception ex) {
            System.out.print("Error" + ex);
            return false;
        }
    }

    public Boolean BajaAlumno(String NC) throws SQLException {
        String Instruccion = "";
        String Estado;
        int i;
        Estado = "Inactivo";
        try {
            Instruccion = "update Alumno set Estado ='" + Estado + "'  where NoControl='" + NC + "'  ;";

            i = this.Comando.executeUpdate(Instruccion);
            System.out.println(Instruccion + "Ejecutado");
            return true;
        } catch (Exception ex) {
            System.out.print("Error");
            return false;
        }
    }

    public ResultSet ConsultarAlumnoC(String Carrera) throws SQLException {
        String consulta = "select * from Alumno where Carrera_Clave = '" + Carrera + "';";
        ResultSet resultado = this.Comando.executeQuery(consulta);
        return resultado;
    }

    public ResultSet ConsultarAlumnoE(String NC) throws SQLException {
        String consulta = "select * from Alumno where NoControl ='"+NC+"';";
        ResultSet resultado = this.Comando.executeQuery(consulta);
        if (resultado.getRow() == 0) {
            System.out.println("vacio");
        } else {
            System.out.println("lleno");

        }
        return resultado;
    }

    public ResultSet ConsultarAlumnoG() throws SQLException {
        String consulta = "select * from Alumno";
        ResultSet resultado = this.Comando.executeQuery(consulta);
        return resultado;
    }

    public void Desconectar() throws SQLException {
        Conexion.close();
    }

    public Boolean ModificacionAlumno(String NCR, Alumno mAlumno) throws SQLException {
        int i = 0;
        String Instruccion = "";
        String Nombre = "";
        String ApellidoMaterno = "";
        String ApellidoPaterno = "";
        String NC = "";
        String Carrera = "";
        String CURP = "";
        int Semestre = 0;
        String Estado = "";
        String Direccion = "";

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
            System.out.println(Instruccion + "Ejecutado");
            return true;
        } catch (Exception ex) {
            System.out.print("Error" + ex);
            return false;
        }
    }

}
