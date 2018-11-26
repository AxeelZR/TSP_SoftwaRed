/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigera_consultas;

import BD.BD_Usuario;
import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TaniaEsparza
 */
public class SIGERA_Consultas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BD_Usuario mBDU = new BD_Usuario();
        mBDU.Conectar();
        try {
            ResultSet Resu = mBDU.ConsultarCola("Tania");
             while (Resu.next()) {
                 System.out.println(Resu.getString("Nombre_Cola"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(SIGERA_Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
