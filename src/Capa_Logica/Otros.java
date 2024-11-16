/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_Datos.Conexion_SQL;
import java.awt.Color;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mao
 */

/*
    [Otros] contiene consultas que todos los archivos necesitan, 
    para evitar repetir codigo, se decidio implementar esta clase 
    con funciones estaticas para su uso rapido y global. Ademas 
    se encuentra la existencia de funciones extras que no tienen
    una asignacion establecida como lo es encriptacion
 */

public class Otros {

    public static Color transparente = new Color(0, 0, 0, 0);

    // Funcion para obtener el siguiente id de cualquier tabla
    public static int Sig_Id(String tabla) throws SQLException {
        return Conexion_SQL.Sig_IdSQL(tabla);
    }

    // Funcion para obtener los datos de una tabla
    public static ResultSet Consultar_Tabla(String tabla) throws SQLException {
        return Conexion_SQL.consultar_Tabla(tabla);
    }

    // Funcion para encriptar
    public static String EncriptarMD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(s.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
