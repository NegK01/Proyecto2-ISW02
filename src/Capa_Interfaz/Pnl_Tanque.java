/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Capa_Interfaz;

import Capa_Datos.Conexion_SQL;
import Capa_Logica.Combustible;
import Capa_Logica.Tanque;
import Capa_Logica.Otros;
import Capa_Logica.Tanque;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mao
 */
public class Pnl_Tanque extends javax.swing.JPanel {

    /**
     * Creates new form Pnl_Tanque
     */
    private final Tanque tanque = new Tanque();
    private int id_actual = 1;
    private int id_actualCombustible = 1;
    private Otros otros = new Otros();
    private Combustible combustible = new Combustible();
    private String tablaTanque;

    public Pnl_Tanque() {
        this.tablaTanque = tanque.tablaTanque;
        initComponents();
        Llenar_Tabla();
        Llenar_Table_Combustibles();
        Listeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Tanques = new javax.swing.JTable();
        Txt_NombreTanque = new javax.swing.JTextField();
        Cmb_Actividad1 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        Txt_Capacidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Combustibles = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        Lbl_Id = new javax.swing.JLabel();
        Lbl_Combustible = new javax.swing.JLabel();
        labelpro = new javax.swing.JLabel();
        labelpro6 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(246, 246, 246));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.setIcon(new FlatSVGIcon("Imagenes/GuardarContenido.svg"));
        jButton4.setBackground(Otros.transparente);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 330, 35));

        jButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton5.setIcon(new FlatSVGIcon("Imagenes/ModificarContenido.svg"));
        jButton5.setBackground(Otros.transparente);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 330, 35));

        Tbl_Tanques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tbl_Tanques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_TanquesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tbl_Tanques);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 430, 230));

        Txt_NombreTanque.setBackground(new java.awt.Color(204, 204, 204));
        Txt_NombreTanque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Txt_NombreTanque.setForeground(new java.awt.Color(102, 102, 102));
        Txt_NombreTanque.setBackground(Otros.transparente);
        Txt_NombreTanque.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Txt_NombreTanque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_NombreTanqueActionPerformed(evt);
            }
        });
        Txt_NombreTanque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_NombreTanqueKeyPressed(evt);
            }
        });
        jPanel3.add(Txt_NombreTanque, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 320, 70));

        Cmb_Actividad1.setBackground(new java.awt.Color(204, 204, 204));
        Cmb_Actividad1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cmb_Actividad1.setForeground(new java.awt.Color(102, 102, 102));
        Cmb_Actividad1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactivo", "Activo" }));
        Cmb_Actividad1.setBackground(Otros.transparente);
        Cmb_Actividad1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(Cmb_Actividad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 320, 40));

        jRadioButton1.setIcon(new FlatSVGIcon("Imagenes/Filtro_MostrarTodos.svg"));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setSelectedIcon(new FlatSVGIcon("Imagenes/Filtro_MostrarTodosSelected.svg"));
        jPanel3.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, 70, -1));

        jRadioButton2.setIcon(new FlatSVGIcon("Imagenes/Filtro_MostrarActivos.svg"));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelectedIcon(new FlatSVGIcon("Imagenes/Filtro_MostrarActivosSelected.svg"));
        jPanel3.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, 80, -1));

        jRadioButton3.setIcon(new FlatSVGIcon("Imagenes/Filtro_MostrarInactivos.svg"));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setSelectedIcon(new FlatSVGIcon("Imagenes/Filtro_MostrarInactivosSelected.svg"));
        jPanel3.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 560, 90, -1));

        jButton1.setToolTipText("");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setIcon(new FlatSVGIcon("Imagenes/NuevoRegistro.svg"));
        jButton1.setBackground(Otros.transparente);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 330, 35));

        Txt_Capacidad.setBackground(new java.awt.Color(204, 204, 204));
        Txt_Capacidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Txt_Capacidad.setForeground(new java.awt.Color(102, 102, 102));
        Txt_Capacidad.setBackground(Otros.transparente);
        Txt_Capacidad.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Txt_Capacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_CapacidadActionPerformed(evt);
            }
        });
        Txt_Capacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_CapacidadKeyPressed(evt);
            }
        });
        jPanel3.add(Txt_Capacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 320, 70));

        jLabel10.setIcon(new FlatSVGIcon("Imagenes/ParteEquipo_Nombre.svg"));
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 350, 90));

        jLabel5.setIcon(new FlatSVGIcon("Imagenes/ParteEquipo_Estado.svg"));
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 350, 90));

        jLabel9.setIcon(new FlatSVGIcon("Imagenes/ParteEquipo_Nombre.svg"));
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 350, 90));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 430, 10));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Seleccione la linea del combustible del vehiculo, (solo de un sutil click)");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, 30));

        Tbl_Combustibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tbl_Combustibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_CombustiblesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tbl_Combustibles);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 300, 160));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Combustible:");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 110, 40));

        Lbl_Id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Lbl_Id.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(Lbl_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 100, 30));

        Lbl_Combustible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Lbl_Combustible.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(Lbl_Combustible, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 100, 30));

        labelpro.setIcon(new FlatSVGIcon("Imagenes/Vehiculo_Id.svg"));
        jPanel3.add(labelpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 140, 80));

        labelpro6.setIcon(new FlatSVGIcon("Imagenes/Vehiculo_Combustible.svg"));
        jPanel3.add(labelpro6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 140, 80));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 940, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void Listeners() {
        ActionListener listener = (ActionEvent e) -> {
            if (jRadioButton1.isSelected()) {
                Llenar_TablaFiltro(Otros.filtroTodos);
            } else if (jRadioButton2.isSelected()) {
                Llenar_TablaFiltro(Otros.filtroActivos);
            } else if (jRadioButton3.isSelected()) {
                Llenar_TablaFiltro(Otros.filtroInactivos);
            }
        };
        jRadioButton1.addActionListener(listener);
        jRadioButton2.addActionListener(listener);
        jRadioButton3.addActionListener(listener);
    }

    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            String nombreTanque = Txt_NombreTanque.getText().strip();
            double capacidad = Double.parseDouble(Txt_Capacidad.getText().strip());
            int id_combustible = Integer.parseInt(Lbl_Id.getText());
            int actividad = Cmb_Actividad1.getSelectedIndex();

            int resultado = tanque.Insert_Tanque(nombreTanque, capacidad, id_combustible, actividad);
            if (resultado != 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente.", "Info", JOptionPane.INFORMATION_MESSAGE);
                Llenar_Tabla();
                jRadioButton1.setSelected(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("\u001B[31mERROR:\u001B[0m " + ex.toString());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            int id = 2;
            String nombreTanque = Txt_NombreTanque.getText().strip();
            double capacidad = Double.parseDouble(Txt_Capacidad.getText().strip());
            int id_combustible = Integer.parseInt(Lbl_Id.getText());
            int actividad = Cmb_Actividad1.getSelectedIndex();

            int resultado = tanque.Update_Tanque(id, nombreTanque, capacidad, id_combustible, actividad);
            if (resultado != 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente.", "Info", JOptionPane.INFORMATION_MESSAGE);
                Llenar_Tabla();
                jRadioButton1.setSelected(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("\u001B[31mERROR:\u001B[0m " + ex.toString());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Tbl_TanquesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_TanquesMouseClicked
        //        try {
        //            id_actual = Sql.Sig_Id(tabla);
        //        } catch (SQLException ex) {
        //            System.out.println("\u001B[31mERROR:\u001B[0m " + ex.getMessage());
        //        }

        int row = Tbl_Tanques.getSelectedRow();
        String verificar = "inactivo";
        
        
        DefaultTableModel Modelo = (DefaultTableModel) Tbl_Tanques.getModel();
        
        Txt_NombreTanque.setText(String.valueOf(Modelo.getValueAt(row, 1)));
        Txt_Capacidad.setText(String.valueOf(Modelo.getValueAt(row, 2)));
        id_actual = (int) Modelo.getValueAt(row, 0);
    }//GEN-LAST:event_Tbl_TanquesMouseClicked

    private void Txt_NombreTanqueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_NombreTanqueKeyPressed
        //        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        //            Txt_Precio.requestFocus();
        //        }
    }//GEN-LAST:event_Txt_NombreTanqueKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Txt_NombreTanque.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Txt_NombreTanqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_NombreTanqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_NombreTanqueActionPerformed

    private void Txt_CapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_CapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_CapacidadActionPerformed

    private void Txt_CapacidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_CapacidadKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_CapacidadKeyPressed

    private void Tbl_CombustiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_CombustiblesMouseClicked
        int row = Tbl_Combustibles.getSelectedRow();
        String actividad = "inactivo";

        DefaultTableModel Modelo = (DefaultTableModel) Tbl_Combustibles.getModel();
        actividad = String.valueOf(Modelo.getValueAt(row, 2));

        if (actividad.equals("activo")) {
            Lbl_Id.setText(String.valueOf( Modelo.getValueAt(row, 0)));
            Lbl_Combustible.setText(String.valueOf(Modelo.getValueAt(row, 1)));
        } else {
            JOptionPane.showMessageDialog(null, "Combustible no disponible actualmente, espera a que esté disponible o activo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Tbl_CombustiblesMouseClicked

    public void Llenar_Table_Combustibles() {
        try {
            ResultSet Res = combustible.Consultar_Combustible();
            Tbl_Combustibles.setModel(DbUtils.resultSetToTableModel(Res));
        } catch (SQLException ex) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + ex.getMessage());
        }
    }
    
    public void Llenar_Tabla() {
        try {
            ResultSet Res = Otros.Consultar_Tabla(tablaTanque);
            Tbl_Tanques.setModel(DbUtils.resultSetToTableModel(Res));
        } catch (SQLException ex) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + ex.getMessage());
        }
    }

    public void Llenar_TablaFiltro(String filtro) {
        try {
            ResultSet Res = Otros.Consultar_TablaFiltro(tablaTanque, filtro);
            Tbl_Tanques.setModel(DbUtils.resultSetToTableModel(Res));
        } catch (SQLException ex) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cmb_Actividad1;
    private javax.swing.JLabel Lbl_Combustible;
    private javax.swing.JLabel Lbl_Id;
    private javax.swing.JTable Tbl_Combustibles;
    private javax.swing.JTable Tbl_Tanques;
    private javax.swing.JTextField Txt_Capacidad;
    private javax.swing.JTextField Txt_NombreTanque;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelpro;
    private javax.swing.JLabel labelpro6;
    // End of variables declaration//GEN-END:variables
}
