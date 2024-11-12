/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_Datos.Conexion_SQL;
import Capa_Datos.Obj_Combustible;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mao
 */
public class Combustible {
    private Obj_Combustible obj_Combustible;
    private final OtrosSQL Sql = new OtrosSQL();
    private final String tabla = "combustibles";

    public int Insert_Combustible(String nombre, String precio, int activo) throws SQLException {
        int id = Sql.Sig_Id(tabla);
        obj_Combustible = new Obj_Combustible(id, nombre, precio, activo);
        return Conexion_SQL.InsertCombustible(obj_Combustible, tabla);
    }
    
    public int Update_Combustible(int id, String nombre, String precio, int activo) throws SQLException {
//        int id = Sql.Sig_Id(tabla);
        obj_Combustible = new Obj_Combustible(id, nombre, precio, activo);
        return Conexion_SQL.UpdateCombustible(obj_Combustible, tabla);
    }
 
    public ResultSet Consultar_Combustible() throws SQLException {
        return Conexion_SQL.consulta_Combustibles(tabla);
    }
}
