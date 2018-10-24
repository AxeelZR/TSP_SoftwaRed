/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigera_controlescolar;

/**
 *
 * @author Alejandro
 */
public class Alumno {
    private int NC;
    private String Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String CURP;
    private String Carrera;


    public Alumno(int NC, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String CURP, String Carrera) {
        this.NC = NC;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.CURP = CURP;
        this.Carrera = Carrera;
    }
    
    public int getNC() {
        return NC;
    }

    public void setNC(int NC) {
        this.NC = NC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }
}
