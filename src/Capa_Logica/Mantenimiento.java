/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_Datos.Conexion_SQL;
import Capa_Datos.Obj_AsignacionMantenimiento;
import Capa_Datos.Obj_TipoMantenimiento;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mao
 */
public class Mantenimiento {
    
    private Obj_AsignacionMantenimiento obj_Asigna;
    private Obj_TipoMantenimiento obj_Tipo;
    private final OtrosSQL Sql = new OtrosSQL();
    private final String tablaAsigna = "asignacion_de_mantenimientos";
    private final String tablaTipos = "tipos_de_mantenimientos";
    
    public int Insert_AsignaMantenimiento(int id_vehiculo, int id_mantenimiento, String fecha_asignacion, int id_usuario, int activo) throws SQLException {
        int id = Sql.Sig_Id(tablaAsigna);
        obj_Asigna = new Obj_AsignacionMantenimiento(id, id_vehiculo, id_mantenimiento, fecha_asignacion, id_usuario, activo);
        return Conexion_SQL.Insert_AsignaMantenimiento(obj_Asigna, tablaAsigna);
    }
    
    public int Update_AsignaMantenimiento(int id, int id_vehiculo, int id_mantenimiento, String fecha_asignacion, int id_usuario, int activo) throws SQLException {
        obj_Asigna = new Obj_AsignacionMantenimiento(id, id_vehiculo, id_mantenimiento, fecha_asignacion, id_usuario, activo);
        return Conexion_SQL.Update_AsignaMantenimiento(obj_Asigna, tablaAsigna);
        // Verificar funcionalidad
    }
    
    public int Insert_TipoMantenimiento(String descripcion, float precio, int activo) throws SQLException {
        int id = Sql.Sig_Id(tablaTipos);
        obj_Tipo = new Obj_TipoMantenimiento(id, descripcion, precio, activo);
        return Conexion_SQL.Insert_TiposMantenimiento(obj_Tipo, tablaTipos);
    }
    
    public int Update_TipoMantenimiento(int id, String descripcion, float precio, int activo) throws SQLException {
        obj_Tipo = new Obj_TipoMantenimiento(id, descripcion, precio, activo);
        return Conexion_SQL.Update_TiposMantenimiento(obj_Tipo, tablaTipos);
    }
    
    public ResultSet Consultar_Tipos() throws SQLException {
        return Conexion_SQL.consultar_Tabla(tablaTipos);
    }
}
