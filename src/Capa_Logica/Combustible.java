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
    private final Otros Sql = new Otros();
    public final String tablaCombustible = "combustibles";

    public int Insert_Combustible(String nombre, int activo) throws SQLException {
        int id = Otros.Sig_Id(tablaCombustible);
        obj_Combustible = new Obj_Combustible(id, nombre, activo);
        return Conexion_SQL.InsertCombustible(obj_Combustible, tablaCombustible);
    }
    
    public int Update_Combustible(int id, String nombre, int activo) throws SQLException {
        obj_Combustible = new Obj_Combustible(id, nombre, activo);
        return Conexion_SQL.UpdateCombustible(obj_Combustible, tablaCombustible);
    }
    
    public ResultSet Consultar_Combustible() throws SQLException {
        return Conexion_SQL.consultar_Combustibles(tablaCombustible);
    }
}
