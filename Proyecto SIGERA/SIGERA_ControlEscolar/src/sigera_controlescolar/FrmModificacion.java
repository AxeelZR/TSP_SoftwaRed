/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigera_controlescolar;

import BaseDatos.BD;
import BaseDatos.BD_Usuario;
import java.awt.Image;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author TaniaEsparza
 */
public class FrmModificacion extends javax.swing.JFrame {

    BD mBD = new BD();
    ResultSet ListaCarreras;
    ResultSet NombreCarrera;
    ResultSet ClaveCarrera;
    String Clave;
    String Nombre;
    Date fechaactual = new Date();
    DateFormat Formato = new SimpleDateFormat("MM");
    String FechaActual;
    String NC;
    String EstadoAI;
    String CarreraAnt;
    String SemestreActual;

    /**
     * Creates new form
     */
    public FrmModificacion(String NoControl) throws SQLException {
        initComponents();
        this.lblNumeroControl.setText(NoControl);
        FechaActual = "";
        FechaActual = Formato.format(fechaactual);
        if (FechaActual.compareTo("08") > 0 && FechaActual.compareTo("12") <= 0) {
            this.cmbSemestre.addItem("1");
            this.cmbSemestre.addItem("3");
            this.cmbSemestre.addItem("5");
            this.cmbSemestre.addItem("7");
            this.cmbSemestre.addItem("9");
        } else {
            this.cmbSemestre.addItem("2");
            this.cmbSemestre.addItem("4");
            this.cmbSemestre.addItem("6");
            this.cmbSemestre.addItem("8");
            this.cmbSemestre.addItem("10");

        }
        ImageIcon imagen = new ImageIcon("imagenes/Guardar.png");
        Icon icono;
        icono = new ImageIcon(imagen.getImage().getScaledInstance(btnGuardarAlumno.getWidth(), btnGuardarAlumno.getHeight(), Image.SCALE_DEFAULT));
        btnGuardarAlumno.setIcon(icono);
        ImageIcon imagen2 = new ImageIcon("imagenes/LogoSIGERAControlEscolar.png");
        Icon icono2;
        icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
        lblLogo.setIcon(icono2);
        BD mBD = new BD();
        try {
            mBD.Conectar();
        } catch (Exception ex) {
            Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ListaCarreras = mBD.ConsultarCarreras();
            while (ListaCarreras.next()) {
                this.cmbCarreras.addItem(ListaCarreras.getString("Clave"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
        }
        NC = this.lblNumeroControl.getText();
        ResultSet ListaAlumno = mBD.ConsultarAlumnoE(NC);
        while (ListaAlumno.next()) {
            if ("1".equals(ListaAlumno.getString("Estado"))) {
                EstadoAI = "Activo";
            } else {
                EstadoAI = "Inactivo";
            }
            ListaAlumno.getString("NoControl");
            this.txtNombre.setText(ListaAlumno.getString("Nombre"));
            this.txtApellidoPaterno.setText(ListaAlumno.getString("Apellido_Paterno"));
            this.txtApellidoMaterno.setText(ListaAlumno.getString("Apellido_Materno"));
            this.txtCURP.setText(ListaAlumno.getString("CURP"));
            this.txtDireccion.setText(ListaAlumno.getString("Direccion"));
            CarreraAnt = ListaAlumno.getString("Carrera_Clave");
            this.cmbCarreras.setSelectedItem(ListaAlumno.getString("Carrera_Clave"));
            this.cmbEstado.setSelectedItem(EstadoAI);
            SemestreActual = ListaAlumno.getString("Semestre");
            this.cmbSemestre.setSelectedItem(ListaAlumno.getString("Semestre"));
        }
    }

    public String toUpperCammelCase(String cadena) {
        cadena = cadena.toLowerCase();
        char[] caracteres = cadena.toCharArray();
        caracteres[0] = Character.toUpperCase(caracteres[0]);
        for (int i = 0; i < cadena.length() - 2; i++) {
            // Es 'palabra'
            if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',') {
                // Reemplazamos
                caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
            }
        }
        String CadenaNueva = String.valueOf(caracteres);
        return CadenaNueva;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtCURP = new javax.swing.JTextField();
        btnGuardarAlumno = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblNumeroControl = new javax.swing.JLabel();
        cmbSemestre = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbCarreras = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 204));
        setForeground(new java.awt.Color(0, 0, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(9, 9, 9, 9, new java.awt.Color(0, 102, 255)));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel1KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        jLabel7.setText("Modificación de Datos");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellidoPaterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPaternoKeyTyped(evt);
            }
        });

        txtApellidoMaterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMaternoKeyTyped(evt);
            }
        });

        txtCURP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCURP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCURPKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCURPKeyTyped(evt);
            }
        });

        btnGuardarAlumno.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarAlumno.setBorder(null);
        btnGuardarAlumno.setBorderPainted(false);
        btnGuardarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAlumnoActionPerformed(evt);
            }
        });
        btnGuardarAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarAlumnoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("No. Control:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Apellido Paterno:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Apellido Materno:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("CURP:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Carrera:");

        lblNumeroControl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblNumeroControl.setText("_____________");

        cmbSemestre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Semestre: ");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Dirección:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Estado:");

        cmbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        cmbCarreras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(41, 41, 41)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblNumeroControl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDireccion)
                                        .addGap(48, 48, 48)))
                                .addComponent(btnGuardarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCURP))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbCarreras, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNumeroControl))
                        .addGap(16, 16, 16)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnGuardarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Inscripcion Alumnos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnGuardarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAlumnoActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        BD mBD = new BD();
        try {
            mBD.Conectar();
        } catch (Exception ex) {
            Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        Alumno mAlumno = new Alumno();
        String NC = this.lblNumeroControl.getText();
        String ApellidoMaterno = txtApellidoMaterno.getText();
        String ApellidoPaterno = txtApellidoPaterno.getText();
        String CURP = txtCURP.getText();
        String Nombre = txtNombre.getText();
        String Carrera = (String) cmbCarreras.getSelectedItem();
        String Direccion = txtDireccion.getText();
        String Estado = (String) cmbEstado.getSelectedItem();
        String Semestre = (String) cmbSemestre.getSelectedItem();

        if ("Activo".equals(Estado)) {
            Estado = "1";
        } else if ("Inactivo".equals(Estado)) {
            Estado = "0";
        }
        if ((!"".equals(ApellidoMaterno))
                && (!"".equals(ApellidoPaterno)) && (!"".equals(CURP))
                && (!"".equals(Nombre)) && (!"".equals(Direccion))) {
            if ((Integer.parseInt(Semestre) == Integer.parseInt(SemestreActual))
                    || (Integer.parseInt(Semestre) == Integer.parseInt(SemestreActual) + 1)) {

                ApellidoMaterno = toUpperCammelCase(ApellidoMaterno);
                ApellidoPaterno = toUpperCammelCase(ApellidoPaterno);
                Nombre = toUpperCammelCase(Nombre);
                Direccion = toUpperCammelCase(Direccion);

                mAlumno.setApellidoMaterno(ApellidoMaterno);
                mAlumno.setApellidoPaterno(ApellidoPaterno);
                mAlumno.setCURP(CURP.toUpperCase());
                mAlumno.setNombre(Nombre);
                mAlumno.setCarrera(Carrera);
                mAlumno.setNC(NC);
                mAlumno.setEstado(Estado);
                mAlumno.setSemestre(Integer.parseInt(Semestre));
                mAlumno.setDireccion(Direccion);

                try {
                    if (mBD.ModificacionAlumno(NC, mAlumno)) {
                        JOptionPane.showMessageDialog(null, "Se Modifico Correctamente el alumno Con Numero de Control "
                                + this.lblNumeroControl.getText());
                        //Escribir en la cola
                        SC_Escritura sc = new SC_Escritura();
                        BD_Usuario mBDU = new BD_Usuario();
                        mBDU.GetConnection();
                        DateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
                        Date fechaactuali = new Date();
                        String FechaActuali = formato.format(fechaactuali);
                        if (!CarreraAnt.equals(Carrera)) {
                            String Msj1 = "El alumno: " + Nombre + " con NC: " + NC
                                    + " ha cambiado de carrera de: " + CarreraAnt + " a " + Carrera + " el " + FechaActuali;
                            //Enviar msj a las colas de las nueva carrera
                            ResultSet Colas = mBDU.ConsultarCola(Carrera);
                            while (Colas.next()) {
                                String NomCola = Colas.getString(1);
                                sc.enviarmsj(NomCola, Msj1);
                            }
                            //Enviar msj a las colas de la nueva carrera
                            Colas = mBDU.ConsultarCola(CarreraAnt);
                            while (Colas.next()) {
                                String NomCola = Colas.getString(1);
                                sc.enviarmsj(NomCola, Msj1);
                            }
                        } else {
                            String Msj1 = "El alumno: " + Nombre + " con NC: " + NC
                                    + " ha sido modificado en alguno de sus datos personales el " + FechaActuali;
                            ResultSet Colas = mBDU.ConsultarCola(Carrera);
                            while (Colas.next()) {
                                String NomCola = Colas.getString(1);
                                sc.enviarmsj(NomCola, Msj1);
                            }
                        }

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (KeyManagementException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TimeoutException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede inscribir a este semestre");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No dejar cajas de texto en blanco"
                    + "\n Favor de proporcionar toda la "
                    + "\n información solicitada");
        }

    }//GEN-LAST:event_btnGuardarAlumnoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtCURPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCURPKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCURPKeyPressed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == (char) 32 || c == (char) 8) {

        } else {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo letras");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPaternoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == (char) 8|| c == (char) 32) {

        } else {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo letras");
        }
    }//GEN-LAST:event_txtApellidoPaternoKeyTyped

    private void txtApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMaternoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == (char) 8|| c == (char) 32) {

        } else {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo letras");
        }
    }//GEN-LAST:event_txtApellidoMaternoKeyTyped

    private void txtCURPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCURPKeyTyped
        // TODO add your handling code here:
        int limite = 18;
        if (this.txtCURP.getText().length() == limite) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo " + limite + " caracteres");
        }
        char c = evt.getKeyChar();
        if (Character.isDigit(c) || Character.isLetter(c) || c == (char) 8) {

        } else {
            JOptionPane.showMessageDialog(null, "Solo números y letras");
            evt.consume();
        }
    }//GEN-LAST:event_txtCURPKeyTyped

    private void btnGuardarAlumnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarAlumnoKeyPressed
        // TODO add your handling code here:
        BD mBD = new BD();
        try {
            mBD.Conectar();
        } catch (Exception ex) {
            Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        Alumno mAlumno = new Alumno();
        String NC = this.lblNumeroControl.getText();
        String ApellidoMaterno = txtApellidoMaterno.getText();
        String ApellidoPaterno = txtApellidoPaterno.getText();
        String CURP = txtCURP.getText();
        String Nombre = txtNombre.getText();
        String Carrera = (String) cmbCarreras.getSelectedItem();
        String Direccion = txtDireccion.getText();
        String Estado = (String) cmbEstado.getSelectedItem();
        String Semestre = (String) cmbSemestre.getSelectedItem();

        if ("Activo".equals(Estado)) {
            Estado = "1";
        } else if ("Inactivo".equals(Estado)) {
            Estado = "0";
        }
        if ((!"".equals(ApellidoMaterno))
                && (!"".equals(ApellidoPaterno)) && (!"".equals(CURP))
                && (!"".equals(Nombre)) && (!"".equals(Direccion))) {
            if ((Integer.parseInt(Semestre) == Integer.parseInt(SemestreActual))
                    || (Integer.parseInt(Semestre) == Integer.parseInt(SemestreActual) + 1)) {

                ApellidoMaterno = toUpperCammelCase(ApellidoMaterno);
                ApellidoPaterno = toUpperCammelCase(ApellidoPaterno);
                Nombre = toUpperCammelCase(Nombre);
                Direccion = toUpperCammelCase(Direccion);

                mAlumno.setApellidoMaterno(ApellidoMaterno);
                mAlumno.setApellidoPaterno(ApellidoPaterno);
                mAlumno.setCURP(CURP.toUpperCase());
                mAlumno.setNombre(Nombre);
                mAlumno.setCarrera(Carrera);
                mAlumno.setNC(NC);
                mAlumno.setEstado(Estado);
                mAlumno.setSemestre(Integer.parseInt(Semestre));
                mAlumno.setDireccion(Direccion);

                try {
                    if (mBD.ModificacionAlumno(NC, mAlumno)) {
                        JOptionPane.showMessageDialog(null, "Se modificó correctamente el alumno Con número de control "
                                + this.lblNumeroControl.getText());
                        //Escribir en la cola
                        SC_Escritura sc = new SC_Escritura();
                        BD_Usuario mBDU = new BD_Usuario();
                        mBDU.GetConnection();
                        DateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
                        Date fechaactuali = new Date();
                        String FechaActuali = formato.format(fechaactuali);
                        if (!CarreraAnt.equals(Carrera)) {
                            String Msj1 = "El alumno: " + Nombre + " con NC: " + NC
                                    + " ha cambiado de carrera de: " + CarreraAnt + " a " + Carrera + " el " + FechaActuali;
                            ResultSet Colas = mBDU.ConsultarCola(Carrera);
                            while (Colas.next()) {
                                String NomCola = Colas.getString(1);
                                sc.enviarmsj(NomCola, Msj1);
                            }
                            //Enviar msj a las colas de la nueva carrera
                            Colas = mBDU.ConsultarCola(CarreraAnt);
                            while (Colas.next()) {
                                String NomCola = Colas.getString(1);
                                sc.enviarmsj(NomCola, Msj1);
                            }
                        } else {
                            String Msj1 = "El alumno: " + Nombre + " con NC: " + NC
                                    + " fue modificado en alguno de sus datos personales el " + FechaActuali;
                            ResultSet Colas = mBDU.ConsultarCola(Carrera);
                            while (Colas.next()) {
                                String NomCola = Colas.getString(1);
                                sc.enviarmsj(NomCola, Msj1);
                            }
                        }

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (KeyManagementException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TimeoutException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede inscribir a este semestre");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No dejar cajas de texto en blanco"
                    + "\n Favor de proporcionar toda la "
                    + "\n información solicitada");
        }
    }//GEN-LAST:event_btnGuardarAlumnoKeyPressed

    private void jPanel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == (char) 8 || Character.isDigit(c) 
                || c == (char)35 || c == (char)32 || c ==(char)46) {

        } else {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No caracteres especiales solo # y .");
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmModificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmModificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmModificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmModificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmModificacion("").setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarAlumno;
    private javax.swing.JComboBox<String> cmbCarreras;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNumeroControl;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
