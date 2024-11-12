/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_Datos.Conexion_SQL;
import java.sql.SQLException;

/**
 *
 * @author Mao
 */
public class OtrosSQL {
    
    // Funcion para obtener el siguiente id de cualquier tabla
    public int Sig_Id(String tabla) throws SQLException{
        return Conexion_SQL.Sig_IdSQL(tabla);
    }
}
