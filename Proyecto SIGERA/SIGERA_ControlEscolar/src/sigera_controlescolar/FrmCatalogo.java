/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigera_controlescolar;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import BaseDatos.*;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author TaniaEsparza
 */
public class FrmCatalogo extends javax.swing.JFrame {

    /**
     * Creates new form FrmCatalogo
     */
    String NC;
    ResultSet ListaCarreras;
    ResultSet ListaNumControl;
    BD mBD = new BD();
    String Estado;
    DefaultTableModel modelo;
    
    public FrmCatalogo() {
        initComponents();
        AutoCompleteDecorator.decorate(cmbNumControl);
        AutoCompleteDecorator.decorate(cmbBuscarCarrera);
        ImageIcon imagen = new ImageIcon("src/imagenes/Agregar.png");
        Icon icono;
        icono = new ImageIcon(imagen.getImage().getScaledInstance(btnAgregar.getWidth(), btnAgregar.getHeight(), Image.SCALE_DEFAULT));
        btnAgregar.setIcon(icono);
        ImageIcon imagen2 = new ImageIcon("src/imagenes/LogoSIGERAControlEscolar.png");
        Icon icono2;
        icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
        lblLogo.setIcon(icono2);
        ImageIcon imagen3 = new ImageIcon("src/imagenes/Eliminar.png");
        Icon icono3;
        icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(btnEliminar.getWidth(), btnEliminar.getHeight(), Image.SCALE_DEFAULT));
        btnEliminar.setIcon(icono3);
        ImageIcon imagen4 = new ImageIcon("src/imagenes/Modificar.png");
        Icon icono4;
        icono4 = new ImageIcon(imagen4.getImage().getScaledInstance(btnModificar.getWidth(), btnModificar.getHeight(), Image.SCALE_DEFAULT));
        btnModificar.setIcon(icono4);
        ImageIcon imagen5 = new ImageIcon("src/imagenes/Administrador.png");
        Icon icono5;
        icono5 = new ImageIcon(imagen5.getImage().getScaledInstance(btnRegistro.getWidth(), btnRegistro.getHeight(), Image.SCALE_DEFAULT));
        btnRegistro.setIcon(icono5);
        this.LlenarTablaAlumnos();
        try {
            mBD = new BD();
            try {
                mBD.Conectar();
            } catch (Exception ex) {
                Logger.getLogger(FrmCatalogo.class.getName()).log(Level.SEVERE, null, ex);
            }
            ListaCarreras = mBD.ConsultarCarreras();
            
            this.cmbBuscarCarrera.addItem("Todos");
            while (ListaCarreras.next()) {
                this.cmbBuscarCarrera.addItem(ListaCarreras.getString("Clave"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            mBD = new BD();
            try {
                mBD.Conectar();
            } catch (Exception ex) {
                Logger.getLogger(FrmCatalogo.class.getName()).log(Level.SEVERE, null, ex);
            }
            ListaNumControl = mBD.ConsultarNumeroControlG();
            this.cmbNumControl.addItem("Todos");
            while (ListaNumControl.next()) {
                this.cmbNumControl.addItem(ListaNumControl.getString("NoControl"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmAlta.class.getName()).log(Level.SEVERE, null, ex);
        }
        NC = "";
    }
    
    public void LlenarTablaAlumnos() {
        BD mBD = new BD();
        try {
            mBD.Conectar();
            ResultSet ListaAlumnos = mBD.ConsultarAlumnoG();
            if (ListaAlumnos != null) {
                Object[] Encabezado = {"No.Control", "Carrera", "Nombre", "Apellido Paterno",
                    "Apellido Materno", "CURP", "Semestre", "Estado", "Direccion"};
                modelo = new DefaultTableModel(null, Encabezado) {
                    @Override
                    public boolean isCellEditable(int fila, int columna) {
                        if (columna > 6) {
                            return true;
                        }
                        return false;
                    }
                };
                
                while (ListaAlumnos.next()) {
                    if ("1".equals(ListaAlumnos.getString("Estado"))) {
                        Estado = "Activo";
                    } else {
                        Estado = "Inactivo";
                    }
                    Object[] actual = {
                        ListaAlumnos.getString("NoControl"),
                        ListaAlumnos.getString("Carrera_Clave"),
                        ListaAlumnos.getString("Nombre"),
                        ListaAlumnos.getString("Apellido_Paterno"),
                        ListaAlumnos.getString("Apellido_Materno"),
                        ListaAlumnos.getString("CURP"),
                        ListaAlumnos.getString("Semestre"),
                        Estado,
                        ListaAlumnos.getString("Direccion")
                    };
                    modelo.addRow(actual);
                }
                this.tblConsultaAlumnos.setModel(modelo);
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmCatalogo.class.getName()).log(Level.SEVERE, null, ex);
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
        cmbBuscarCarrera = new javax.swing.JComboBox<>();
        cmbNumControl = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultaAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnRegistro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(9, 9, 9, 9, new java.awt.Color(0, 102, 255)));

        cmbBuscarCarrera.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbBuscarCarrera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBuscarCarreraItemStateChanged(evt);
            }
        });

        cmbNumControl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbNumControl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNumControlItemStateChanged(evt);
            }
        });

        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        tblConsultaAlumnos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblConsultaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblConsultaAlumnos.setGridColor(new java.awt.Color(102, 102, 102));
        tblConsultaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultaAlumnosMouseClicked(evt);
            }
        });
        tblConsultaAlumnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblConsultaAlumnosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblConsultaAlumnosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblConsultaAlumnos);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        jLabel1.setText("SIGERA");

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setOpaque(true);

        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Busqueda Por Carrera");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Busqueda por Numero Control");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cmbNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(226, 226, 226)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cmbBuscarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(240, 240, 240)))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbBuscarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (!"".equals(NC)) {
            try {
                // TODO add your handling code here:
                FrmModificacion mFrmModificacion = new FrmModificacion(NC);
                mFrmModificacion.setVisible(true);
                NC = "";
            } catch (SQLException ex) {
                Logger.getLogger(FrmCatalogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro por favor");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        FrmAlta mFrmAlta = new FrmAlta();
        mFrmAlta.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // TODO add your handling code here:
        FRM_Registro mFrmRegistro = new FRM_Registro();
        mFrmRegistro.setVisible(true);
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void tblConsultaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultaAlumnosMouseClicked
        // TODO add your handling code here:
        int filaseleccionada = this.tblConsultaAlumnos.getSelectedRow();
        if (filaseleccionada >= 0) {
            NC = (String) tblConsultaAlumnos.getValueAt(filaseleccionada, 0);
            JOptionPane.showMessageDialog(null, NC);
        }
    }//GEN-LAST:event_tblConsultaAlumnosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (!"".equals(NC)) {
            mBD = new BD();
            try {
                mBD.Conectar();
            } catch (Exception ex) {
                Logger.getLogger(FrmCatalogo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                mBD.BajaAlumno(NC);
                mBD.Desconectar();
                this.LlenarTablaAlumnos();
                NC = "";
            } catch (SQLException ex) {
                Logger.getLogger(FrmCatalogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro por favor");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblConsultaAlumnosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblConsultaAlumnosKeyPressed
        // TODO add your handling code here:
        int filaseleccionada = this.tblConsultaAlumnos.getSelectedRow();
        if (filaseleccionada >= 0) {
            NC = (String) tblConsultaAlumnos.getValueAt(filaseleccionada, 0);
            JOptionPane.showMessageDialog(null, NC);
        }
    }//GEN-LAST:event_tblConsultaAlumnosKeyPressed

    private void tblConsultaAlumnosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblConsultaAlumnosKeyReleased
        // TODO add your handling code here:
        int filaseleccionada = this.tblConsultaAlumnos.getSelectedRow();
        if (filaseleccionada >= 0) {
            NC = (String) tblConsultaAlumnos.getValueAt(filaseleccionada, 0);
            JOptionPane.showMessageDialog(null, NC);
        }
    }//GEN-LAST:event_tblConsultaAlumnosKeyReleased

    private void cmbNumControlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNumControlItemStateChanged
        // TODO add your handling code here:
        String query = this.cmbNumControl.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        this.tblConsultaAlumnos.setRowSorter(tr);
        if (query != "Todos") {
            tr.setRowFilter(RowFilter.regexFilter(query));
        } else {
            this.tblConsultaAlumnos.setRowSorter(tr);
        }
        NC = "";
    }//GEN-LAST:event_cmbNumControlItemStateChanged

    private void cmbBuscarCarreraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBuscarCarreraItemStateChanged
        // TODO add your handling code here:
        String query = this.cmbBuscarCarrera.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        this.tblConsultaAlumnos.setRowSorter(tr);
        if (query != "Todos") {
            tr.setRowFilter(RowFilter.regexFilter(query));
        } else {
            this.tblConsultaAlumnos.setRowSorter(tr);
        }
        NC = "";
    }//GEN-LAST:event_cmbBuscarCarreraItemStateChanged

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
            java.util.logging.Logger.getLogger(FrmCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCatalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JComboBox<String> cmbBuscarCarrera;
    private javax.swing.JComboBox<String> cmbNumControl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTable tblConsultaAlumnos;
    // End of variables declaration//GEN-END:variables
}
