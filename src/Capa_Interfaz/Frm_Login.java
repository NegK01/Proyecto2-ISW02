/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Capa_Interfaz;

import Capa_Logica.Login;
import Capa_Logica.Otros;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mao
 */
public class Frm_Login extends javax.swing.JFrame {

    private final Login login = new Login();
    private Frm_Principal prc;

    public Frm_Login() {
        initComponents();
        setSize(1080, 677);
        setResizable(false);
    }

    /**
     * Creates new form Frm_Login
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Login = new javax.swing.JPanel();
        Lbl_Login = new javax.swing.JLabel();
        Lbl_Username = new javax.swing.JLabel();
        Lbl_Password = new javax.swing.JLabel();
        Btn_Login = new javax.swing.JButton();
        Pnl_Username = new javax.swing.JPanel();
        txt_Usr = new javax.swing.JTextField();
        Pnl_Password = new javax.swing.JPanel();
        txt_Pwd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Login.setBackground(new java.awt.Color(239, 239, 239));
        Pnl_Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Login.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        Lbl_Login.setForeground(new java.awt.Color(0, 0, 0));
        Lbl_Login.setText("Login to your account");
        Pnl_Login.add(Lbl_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 250, 60));

        Lbl_Username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Lbl_Username.setForeground(new java.awt.Color(0, 0, 0));
        Lbl_Username.setText("Username");
        Pnl_Login.add(Lbl_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        Lbl_Password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Lbl_Password.setForeground(new java.awt.Color(0, 0, 0));
        Lbl_Password.setText("Password");
        Pnl_Login.add(Lbl_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        Btn_Login.setBackground(new java.awt.Color(0, 0, 0));
        Btn_Login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Login.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Login.setText("Login now");
        Btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LoginActionPerformed(evt);
            }
        });
        Pnl_Login.add(Btn_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 390, 50));

        Pnl_Username.setBackground(new java.awt.Color(215, 215, 215));
        Pnl_Username.setForeground(new java.awt.Color(51, 51, 51));
        Pnl_Username.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Usr.setBackground(new java.awt.Color(239, 239, 239));
        txt_Usr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Usr.setForeground(new java.awt.Color(102, 102, 102));
        txt_Usr.setBorder(null);
        txt_Usr.setOpaque(true);
        txt_Usr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_UsrKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_UsrKeyTyped(evt);
            }
        });
        Pnl_Username.add(txt_Usr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 20));
        // Custom Mao
        txt_Usr.setOpaque(false);

        Pnl_Login.add(Pnl_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 390, 40));
        // Custom Mao
        Pnl_Username.setOpaque(false);
        Pnl_Username.setBackground(new Color(239, 239, 239));
        Pnl_Username.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        Pnl_Username.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), Color.BLACK, 1.5f, 10));

        Pnl_Password.setBackground(new java.awt.Color(215, 215, 215));
        Pnl_Password.setForeground(new java.awt.Color(51, 51, 51));
        Pnl_Password.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Pwd.setBackground(new java.awt.Color(239, 239, 239));
        txt_Pwd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Pwd.setForeground(new java.awt.Color(102, 102, 102));
        txt_Pwd.setBorder(null);
        txt_Pwd.setOpaque(true);
        txt_Pwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PwdKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PwdKeyTyped(evt);
            }
        });
        Pnl_Password.add(txt_Pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 20));
        // Custom Mao
        txt_Pwd.setOpaque(false);

        Pnl_Login.add(Pnl_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 390, 40));
        // Custom Mao
        Pnl_Password.setOpaque(false);
        Pnl_Password.setBackground(new Color(239, 239, 239));
        Pnl_Password.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        Pnl_Password.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), Color.BLACK, 1.5f, 10));

        getContentPane().add(Pnl_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 540, 360));
        // Custom Mao
        Pnl_Login.setOpaque(false);
        Pnl_Login.setBackground(new Color(239, 239, 239));
        Pnl_Login.putClientProperty(FlatClientProperties.STYLE, "arc: 50");
        Pnl_Login.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), Color.BLACK, 2, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Metodo para asignar focus al siguiente campo de entrada
    private void txt_UsrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UsrKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_Pwd.requestFocus();
        }
    }//GEN-LAST:event_txt_UsrKeyPressed

    // Metodo para consumir caracteres no permitidos
    private void txt_UsrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UsrKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != ' ' || txt_Usr.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_UsrKeyTyped

    // Metodo para asignar focus al siguiente campo de entrada
    private void txt_PwdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PwdKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Btn_Login.doClick();
            txt_Usr.requestFocus();
        }
    }//GEN-LAST:event_txt_PwdKeyPressed

    // Metodo para consumir caracteres no permitidos
    private void txt_PwdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PwdKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != ' ' || new String(txt_Pwd.getPassword()).length() >= 20) { // Numero de telefono max de 8 digitos
            evt.consume();
        }
    }//GEN-LAST:event_txt_PwdKeyTyped

    // Metodo para validar credenciales despues de haber tocado el boton de inicio de sesion
    private void Btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LoginActionPerformed
        try {
            String username = txt_Usr.getText();
            String password = new String(txt_Pwd.getPassword());
            password = Otros.EncriptarMD5(password.strip());

            if (username.isBlank() || password.isBlank()) {
                JOptionPane.showMessageDialog(null, "Ingrese las credenciales correctamente.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int rolLogin = login.ValidarLogin(username, password);
//            rolLogin = 1;
            if (rolLogin != -1) {
                prc = new Frm_Principal(rolLogin);
                prc.setLocationRelativeTo(null);
                prc.setVisible(true); // Mostramos el siguiente Frame
                setVisible(false);  // Ocultamos la ventana actual
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
            }
        } catch (SQLException ex) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + ex.getMessage());
        }
    }//GEN-LAST:event_Btn_LoginActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Login;
    private javax.swing.JLabel Lbl_Login;
    private javax.swing.JLabel Lbl_Password;
    private javax.swing.JLabel Lbl_Username;
    private javax.swing.JPanel Pnl_Login;
    private javax.swing.JPanel Pnl_Password;
    private javax.swing.JPanel Pnl_Username;
    private javax.swing.JPasswordField txt_Pwd;
    private javax.swing.JTextField txt_Usr;
    // End of variables declaration//GEN-END:variables
}
