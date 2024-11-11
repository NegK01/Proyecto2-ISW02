/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Capa_Logica;

import Capa_Interfaz.Frm_Login;
import com.formdev.flatlaf.themes.*;
import java.net.URISyntaxException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Usuario
 * 
 * ------------------------------|
 * - AUTORES --------------------| 
 * - Elías Josué Salas Méndez ---|
 * - Mauricio Oporta Rosales ----|
 * ------------------------------|
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        Frm_Login Ver = new Frm_Login();
        Ver.setLocationRelativeTo(null);
        Ver.setVisible(true);
    }
    
}
