/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigera_controlescolar;

/**
 *
 * @author Yosse
 */
public class Usuario {
    
    String Nombre_Usuario;
    String Contraseña;
    String Carrera;
    String NomCola;
    
    public Usuario(){
        Nombre_Usuario = "";
        Contraseña = "";
        Carrera = "";
        NomCola="";
    }

    
    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

   

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

   
    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }
    public void setNomCola(String NomCola) {
        this.NomCola = NomCola;
    }
    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }
    
     public String getContraseña() {
        return Contraseña;
    }
    public String getNomCola() {
        return NomCola;
    }
     public String getCarrera() {
        return Carrera;
    }
}
