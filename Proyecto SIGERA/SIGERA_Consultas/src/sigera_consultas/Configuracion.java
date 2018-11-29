/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sigera_consultas;

import BD.*;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * 
 * @author Axel
 */
public class Configuracion {
    Date Fecha_periodo;
    String Nueva_contrasena;
    
    public Configuracion(){
        Fecha_periodo = null;
        Nueva_contrasena = "";
    }
    
    public void CambiarContrasena(String Contrasena,Usuario mUsuario) throws SQLException, Exception{
        BD_Usuario mBD = new BD_Usuario();
        //if (mBD.Conectar()){
            mBD.ModificacionUsuario(Contrasena, mUsuario);
        //}else{
            //JOptionPane.showMessageDialog(null, "Error no se puede conectar con la BD");
        //}
        
    }
    
    public void ConfigurarPeriodo(Date Periodo){
        
    }
}
