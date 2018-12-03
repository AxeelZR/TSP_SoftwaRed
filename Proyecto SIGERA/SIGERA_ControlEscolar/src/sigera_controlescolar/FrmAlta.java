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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
public class FrmAlta extends javax.swing.JFrame {

    BD mBD = new BD();
    ResultSet ListaCarreras;
    ResultSet ClaveCarrera;
    String Clave;
    Date fechaactual = new Date();
    DateFormat Formato = new SimpleDateFormat("MM");
    String FechaActual;
    Date FechaAnyo = new Date();
    DateFormat FormatoAnyo = new SimpleDateFormat("yyyy");
    String FechaAnyoo;
    String NumeroControlNew;
    ResultSet ListaNumControl;
    String NumeroControlAnterior;
    String NumControl;

    /**
     * Creates new form
     */
    public FrmAlta() {
        initComponents();
        FechaActual = "";
        NumeroControlNew = "";
        NumeroControlAnterior = "";
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

        ImageIcon imagen = new ImageIcon("src/imagenes/Guardar.png");
        Icon icono;
        icono = new ImageIcon(imagen.getImage().getScaledInstance(btnGuardarAlumno.getWidth(), btnGuardarAlumno.getHeight(), Image.SCALE_DEFAULT));
        btnGuardarAlumno.setIcon(icono);
        ImageIcon imagen2 = new ImageIcon("src/imagenes/LogoSIGERAControlEscolar.png");
        Icon icono2;
        icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
        lblLogo.setIcon(icono2);
        try {
        } catch (Exception ex) {
            Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        txtNumControl = new javax.swing.JTextField();
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
        jLabel8 = new javax.swing.JLabel();
        cmbSemestre = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        cmbCarreras = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 204));
        setForeground(new java.awt.Color(0, 0, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(9, 9, 9, 9, new java.awt.Color(0, 102, 255)));

        jLabel7.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        jLabel7.setText("Inscripción de Alumnos");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        txtNumControl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNumControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumControlActionPerformed(evt);
            }
        });
        txtNumControl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumControlKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumControlKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumControlKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCURPKeyReleased(evt);
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

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Semestre: ");

        cmbSemestre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbSemestre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbSemestreMouseClicked(evt);
            }
        });
        cmbSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSemestreActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Direccion:");

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        cmbCarreras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbCarreras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CP", "ISC", "IEM", "IGE", "IIA", "IA", "ITICS" }));
        cmbCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCarrerasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDireccion))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbCarreras, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtApellidoPaterno))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtApellidoMaterno)))))
                        .addGap(56, 56, 56)
                        .addComponent(btnGuardarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(33, 33, 33)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(69, 69, 69))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Inscripcion Alumnos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    public void GenerarNoControl() {
        FechaAnyoo = "";
        FechaAnyoo = FormatoAnyo.format(FechaAnyo);
        NumeroControlNew = FechaAnyoo + 1;
        NumControl = NumeroControlNew;
        int Cont = 1;
        try {
            mBD.Conectar();
            ListaNumControl = mBD.ConsultarNumControlUltimo();
            if (!ListaNumControl.equals("")) {
                while (ListaNumControl.next()) {
                    String AnyoBD = ListaNumControl.getString("NoControl");
                    AnyoBD = AnyoBD.substring(0, 4);
                    String Resto = ListaNumControl.getString("NoControl");
                    Resto = Resto.substring(4, Resto.length());
                    //System.out.print("Resto " + Resto);
                    if (FechaAnyoo.equals(AnyoBD)) {
                        int NumeroControlAnterior = Integer.parseInt(AnyoBD + (Integer.parseInt(Resto) + 1));
                        NumControl = String.valueOf(NumeroControlAnterior);
                    } else {
                        FechaAnyoo = "";
                        FechaAnyoo = FormatoAnyo.format(FechaAnyo);
                        NumeroControlNew = FechaAnyoo + 1;
                        NumControl = NumeroControlNew;
                    }
                }
            } else {
                FechaAnyoo = "";
                FechaAnyoo = FormatoAnyo.format(FechaAnyo);
                NumeroControlNew = FechaAnyoo + 1;
                NumControl = NumeroControlNew;
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
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

    private void btnGuardarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAlumnoActionPerformed
        // TODO add your handling code here:
        // TODO adthis.txt
        BD mBD = new BD();
        BD_Usuario mBDU = new BD_Usuario();
        Alumno mAlumno = new Alumno();

        try {
            //mBD.Conectar();
        } catch (Exception ex) {
            Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String NumControl = txtNumControl.getText();
        String ApellidoMaterno = txtApellidoMaterno.getText();
        String ApellidoPaterno = txtApellidoPaterno.getText();
        String CURP = txtCURP.getText();
        String Nombre = txtNombre.getText();
        String Carrera = (String) cmbCarreras.getSelectedItem();
        String Direccion = txtDireccion.getText();
        String Semestre = (String) cmbSemestre.getSelectedItem();

        if ((!"".equals(NumControl)) && (!"".equals(ApellidoMaterno))
                && (!"".equals(ApellidoPaterno)) && (!"".equals(CURP))
                && (!"".equals(Nombre)) && (!"".equals(Direccion))) {

            try {
                ApellidoMaterno = toUpperCammelCase(ApellidoMaterno);
                ApellidoPaterno = toUpperCammelCase(ApellidoPaterno);
                Nombre = toUpperCammelCase(Nombre);
                Direccion = toUpperCammelCase(Direccion);
                mAlumno.setApellidoMaterno(ApellidoMaterno);
                mAlumno.setApellidoPaterno(ApellidoPaterno);
                mAlumno.setCURP(CURP.toUpperCase());
                mAlumno.setNombre(Nombre);
                mAlumno.setCarrera(Carrera);
                mAlumno.setNC(NumControl);
                mAlumno.setDireccion(Direccion);
                mAlumno.setEstado("1");
                mAlumno.setSemestre(Integer.parseInt(Semestre));
                mBD.Conectar();
                //Guardar Alumno
                if (mBD.AltaAlumno(mAlumno)) {
                    DateFormat Formato = new SimpleDateFormat("dd/MM/YYYY");
                    FechaActual = Formato.format(fechaactual);
                    String Msj = "El Alumno " + Nombre + " " + ApellidoPaterno + " ha sido inscrito a la carrera "
                            + " " + Carrera + " en el semestre " + Semestre + " el " + FechaActual;
                    mBDU.GetConnection();
                    SC_Escritura sc = new SC_Escritura();
                    ResultSet Colas = mBDU.ConsultarCola(Carrera);
                    while (Colas.next()) {
                        String NomCola = Colas.getString(1);
                        sc.enviarmsj(NomCola, Msj);
                    }
                    JOptionPane.showMessageDialog(null, "El Alumno " + Nombre + " " + ApellidoPaterno + " ha sido inscrito a la carrera "
                            + " " + Carrera + " en el semestre " + Semestre + " Satisfactoriamentre");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar alumno verifique la informacion \n "
                            + " el alumno ya ha sido inscrito");
                }

                txtNumControl.setText("");
                txtApellidoMaterno.setText("");
                txtApellidoPaterno.setText("");
                txtCURP.setText("");
                txtNombre.setText("");
                txtDireccion.setText("");
                cmbSemestre.setSelectedItem("1");
            } catch (SQLException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (KeyManagementException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TimeoutException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No dejar cajas de texto en blanco"
                    + "\n Favor de proporcionar toda \n la informacion Solicitada");
        }
    }//GEN-LAST:event_btnGuardarAlumnoActionPerformed

    private void txtNumControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumControlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumControlActionPerformed

    private void txtCURPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCURPKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCURPKeyPressed

    private void txtCURPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCURPKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCURPKeyReleased

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtNumControlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumControlKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumControlKeyPressed

    private void txtNumControlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumControlKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumControlKeyReleased

    private void txtNumControlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumControlKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if (Character.isDigit(caracter) || caracter == (char) 8) {

        } else {
            evt.consume();  // ignorar el evento de teclado
            JOptionPane.showMessageDialog(null, "Solo numeros");
        }
    }//GEN-LAST:event_txtNumControlKeyTyped

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
        if (Character.isLetter(c) || c == (char) 8) {

        } else {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo letras");
        }
    }//GEN-LAST:event_txtApellidoPaternoKeyTyped

    private void txtApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMaternoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == (char) 8) {

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
            JOptionPane.showMessageDialog(null, "Solo " + limite + " Caracteres");
        }
        char c = evt.getKeyChar();
        if (Character.isDigit(c) || Character.isLetter(c) || c == (char) 8) {

        } else {
            JOptionPane.showMessageDialog(null, "Solo numeros y letras");
            evt.consume();
        }
    }//GEN-LAST:event_txtCURPKeyTyped

    private void cmbCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCarrerasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCarrerasActionPerformed

    private void cmbSemestreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSemestreMouseClicked
        // TODO add your handling code here:
        if (this.cmbSemestre.getSelectedItem() == "1") {
            this.GenerarNoControl();
            this.txtNumControl.setText(NumControl);
            this.txtNumControl.setEditable(false);
        } else {
            this.txtNumControl.setText("");
            this.txtNumControl.setEditable(true);
        }
    }//GEN-LAST:event_cmbSemestreMouseClicked

    private void cmbSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSemestreActionPerformed
        // TODO add your handling code here:
        if (this.cmbSemestre.getSelectedItem() == "1") {
            this.GenerarNoControl();
            this.txtNumControl.setText(NumControl);
            this.txtNumControl.setEditable(false);
        } else {
            this.txtNumControl.setText("");
            this.txtNumControl.setEditable(true);
        }
    }//GEN-LAST:event_cmbSemestreActionPerformed

    private void btnGuardarAlumnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarAlumnoKeyPressed
        // TODO add your handling code here:
        BD mBD = new BD();
        BD_Usuario mBDU = new BD_Usuario();
        Alumno mAlumno = new Alumno();

        try {
            //mBD.Conectar();
        } catch (Exception ex) {
            Logger.getLogger(FrmModificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String NumControl = txtNumControl.getText();
        String ApellidoMaterno = txtApellidoMaterno.getText();
        String ApellidoPaterno = txtApellidoPaterno.getText();
        String CURP = txtCURP.getText();
        String Nombre = txtNombre.getText();
        String Carrera = (String) cmbCarreras.getSelectedItem();
        String Direccion = txtDireccion.getText();
        String Semestre = (String) cmbSemestre.getSelectedItem();

        if ((!"".equals(NumControl)) && (!"".equals(ApellidoMaterno))
                && (!"".equals(ApellidoPaterno)) && (!"".equals(CURP))
                && (!"".equals(Nombre)) && (!"".equals(Direccion))) {

            try {
                ApellidoMaterno = toUpperCammelCase(ApellidoMaterno);
                ApellidoPaterno = toUpperCammelCase(ApellidoPaterno);
                Nombre = toUpperCammelCase(Nombre);
                Direccion = toUpperCammelCase(Direccion);
                mAlumno.setApellidoMaterno(ApellidoMaterno);
                mAlumno.setApellidoPaterno(ApellidoPaterno);
                mAlumno.setCURP(CURP.toUpperCase());
                mAlumno.setNombre(Nombre);
                mAlumno.setCarrera(Carrera);
                mAlumno.setNC(NumControl);
                mAlumno.setDireccion(Direccion);
                mAlumno.setEstado("1");
                mAlumno.setSemestre(Integer.parseInt(Semestre));
                mBD.Conectar();
                //Guardar Alumno
                if (mBD.AltaAlumno(mAlumno)) {
                    DateFormat Formato = new SimpleDateFormat("dd/MM/YYYY");
                    FechaActual = Formato.format(fechaactual);
                    String Msj = "El Alumno " + Nombre + " " + ApellidoPaterno + " ha sido inscrito a la carrera "
                            + " " + Carrera + " en el semestre " + Semestre + " el " + FechaActual;
                    mBDU.GetConnection();
                    SC_Escritura sc = new SC_Escritura();
                    ResultSet Colas = mBDU.ConsultarCola(Carrera);
                    while (Colas.next()) {
                        String NomCola = Colas.getString(1);
                        sc.enviarmsj(NomCola, Msj);
                    }
                    JOptionPane.showMessageDialog(null, "El Alumno " + Nombre + " " + ApellidoPaterno + " ha sido inscrito a la carrera "
                            + " " + Carrera + " en el semestre " + Semestre + " Satisfactoriamentre");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar alumno verifique la informacion \n "
                            + " el alumno ya ha sido inscrito");
                }
                txtNumControl.setText("");
                txtApellidoMaterno.setText("");
                txtApellidoPaterno.setText("");
                txtCURP.setText("");
                txtNombre.setText("");
                txtDireccion.setText("");
                cmbSemestre.setSelectedItem("1");
            } catch (SQLException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (KeyManagementException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TimeoutException ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No dejar cajas de texto en blanco"
                    + "\n  Favor de proporcionar toda \n la informacion Solicitada");
        }
    }//GEN-LAST:event_btnGuardarAlumnoKeyPressed

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
            java.util.logging.Logger.getLogger(FrmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAlta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarAlumno;
    private javax.swing.JComboBox<String> cmbCarreras;
    private javax.swing.JComboBox<String> cmbSemestre;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumControl;
    // End of variables declaration//GEN-END:variables
}
