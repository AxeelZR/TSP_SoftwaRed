/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigera_controlescolar;

import BaseDatos.BD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TaniaEsparza
 */
public class SIGERA_ControlEscolar {

    /**
     * @param args the command line arguments
     */
    public void run(){
        BD mBD = new BD();
        Alumno mAlumno = new Alumno();
        mAlumno.setNombre("Taniaa");
        mAlumno.setApellidoPaterno("Esparza");
        mAlumno.setApellidoMaterno("Ramirez");
        mAlumno.setCURP("ERTTAADSD");
        mAlumno.setNC(14010180);
        mAlumno.setCarrera("ISC");
        mAlumno.setSemestre(9);
        mAlumno.setEstado("Inacivo");
        mAlumno.setDireccion("La chidaaa");
        try {
            mBD.Conectar();
        } catch (Exception ex) {
            Logger.getLogger(SIGERA_ControlEscolar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //mBD.AltaAlumno(mAlumno);
           mBD.ModificacionAlumno("14010174", mAlumno);
        } catch (SQLException ex) {
            Logger.getLogger(SIGERA_ControlEscolar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args){
        // TODO code application logic here
        SIGERA_ControlEscolar mMain = new SIGERA_ControlEscolar();
        mMain.run();
    }
    
}
