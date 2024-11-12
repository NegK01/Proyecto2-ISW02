/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_Datos.Conexion_SQL;
import Capa_Datos.Obj_AsignacionMantenimiento;
import java.sql.SQLException;

/**
 *
 * @author Mao
 */
public class Mantenimiento {
    
    private Obj_AsignacionMantenimiento obj_AsignaMantenimiento;
    private final OtrosSQL Sql = new OtrosSQL();
    private final String tabla = "asignacion_de_mantenimientos";
    
    public int Insert_AsignaMantenimiento(int id_vehiculo, int id_mantenimiento, String fecha_asignacion, int id_usuario) throws SQLException {
        int id = Sql.Sig_Id("asignacion_de_mantenimientos");
        obj_AsignaMantenimiento = new Obj_AsignacionMantenimiento(id, id_vehiculo, id_mantenimiento, fecha_asignacion, id_usuario);
        return Conexion_SQL.Insert_AsignaMantenimiento(obj_AsignaMantenimiento, tabla);
    }
    
}
