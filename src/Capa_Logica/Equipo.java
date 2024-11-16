/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_Datos.Conexion_SQL;
import Capa_Datos.Obj_Equipos;
import java.sql.SQLException;

/**
 *
 * @author Mao
 */
public class Equipo {
    
    private Obj_Equipos obj_Equipos;
    private final Otros Sql = new Otros();
    public final String tablaTipos = "partes_de_equipos";
    
    public int Insert_Equipo(String descripcion, int activo) throws SQLException {
        int id = Otros.Sig_Id(tablaTipos);
        obj_Equipos = new Obj_Equipos(id, descripcion, activo);
        return Conexion_SQL.Insert_Equipo(obj_Equipos, tablaTipos);
    }
    
    public int Update_Equipo(int id, String descripcion, int activo) throws SQLException {
        obj_Equipos = new Obj_Equipos(id, descripcion, activo);
        return Conexion_SQL.Update_Equipo(obj_Equipos, tablaTipos);
    }
}
