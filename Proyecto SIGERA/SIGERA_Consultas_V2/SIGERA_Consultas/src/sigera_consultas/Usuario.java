/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigera_consultas;

/**
 *
 * @author Yosse
 */
public class Usuario {
    
    String Nombre_Usuario;
    String Contraseña;
    String Carrera;
    
    public Usuario(){
        Nombre_Usuario = "";
        Contraseña = "";
        Carrera = "";
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
    
    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }
    
     public String getContraseña() {
        return Contraseña;
    }

     public String getCarrera() {
        return Carrera;
    }
}
