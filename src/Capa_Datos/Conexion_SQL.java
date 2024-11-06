/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexion_SQL {
    
    
    public static Connection getConnection() throws SQLException {
        String CadenaConexion = "jdbc:sqlserver://192.168.0.8:1433;" // ip mao
                + "database=TransportesIIIPatitos;" // -- Nombre de la database nuestra
                + "user=sa;"
                + "password=lol12345;" // -- Contraseña *personal*
                + "encrypt=true;trustServerCertificate=true;";

        try {
            Connection con = DriverManager.getConnection(CadenaConexion);
            return con;
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
}
