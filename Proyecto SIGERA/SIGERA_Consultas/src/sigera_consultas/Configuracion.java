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


    public void CambiarContrasena(String Contrasena, Usuario mUsuario) throws SQLException, Exception {
        BD_Usuario mBD = new BD_Usuario();
        mBD.ModificacionUsuario(Contrasena, mUsuario);
    }
}
