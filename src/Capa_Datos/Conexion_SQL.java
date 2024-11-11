/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexion_SQL {

    public static Connection getConnection() throws SQLException {
        String CadenaConexion = "jdbc:sqlserver://192.168.0.8:1433;" // ip mao
                + "database=TransportesIIIPatitos;" // -- Nombre de la database nuestra
                + "user=sqlUser;"
                + "password=pass;"
                + "encrypt=true;trustServerCertificate=true;";

        try {
            Connection con = DriverManager.getConnection(CadenaConexion);
            return con;
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }

    // Con esta funcion validamos el inicio de sesion del usuario y obtenemos su rol
    public static int ValidarLoginSQL(Obj_User obj) throws SQLException {
        int resultado = 0;

        try {
            Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
            String qry = "SELECT contrasena, rol FROM Usuarios WHERE usuario = '" + obj.usuario + "'";

            ResultSet res = sql.executeQuery(qry);
            while (res.next()) {
                String passwordAlmacenado = res.getString("contrasena");
                if (passwordAlmacenado.equals(obj.contrasena)) {
                    resultado = res.getInt("rol");
                }
            }
        } catch (SQLException e) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + e.getMessage());
        }
        return resultado;
    }
    
//    public static int SiguienteIdSQL(Obj_User obj) throws SQLException {
//        int resultado = 0;
//
//        try {
//            Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
//            String qry = "SELECT id FROM Usuarios WHERE usuario = " + 1;
//
//            ResultSet res = sql.executeQuery(qry);
//            while (res.next()) {
//                String passwordAlmacenado = res.getString("id");
//                if (passwordAlmacenado.equals(obj.contrasena)) {
//                    resultado = res.getInt("rol");
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("\u001B[31mERROR:\u001B[0m " + e.getMessage());
//        }
//        return resultado;
//    }
}
