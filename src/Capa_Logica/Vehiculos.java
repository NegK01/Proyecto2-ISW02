/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_Datos.*;
import Capa_Datos.Obj_Combustible;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Elias
 */
public class Vehiculos {
    
    private Obj_Vehiculos obj_vehiculo;
    private final Otros Sql = new Otros();
    private final String tabla = "vehiculos";

    public int Insert_Vehiculo(String placa, String nombre, String marca, String modelo, int id_combustible, int activo) throws SQLException {
        int id = Sql.Sig_Id(tabla);
        obj_vehiculo = new Obj_Vehiculos(id, placa, nombre, marca, modelo, id_combustible, activo);
        return Conexion_SQL.InsertVehiculo(obj_vehiculo, tabla);
    }
    
    public int Update_Vehiculo(int id, String placa, String nombre, String marca, String modelo, int id_combustible, int activo) throws SQLException {
        obj_vehiculo = new Obj_Vehiculos(id, placa, nombre, marca, modelo, id_combustible, activo);
        return Conexion_SQL.UpdateVehiculo(obj_vehiculo, tabla);
    }
 
    public ResultSet Consultar_Vehiculo() throws SQLException {
        return Conexion_SQL.consultar_Tabla(tabla);
    }
}
