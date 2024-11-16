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

/**
 *
 * @author Usuario & Mao
 */
public class Conexion_SQL {

    public static Connection getConnection() throws SQLException {
        String CadenaConexion = "jdbc:sqlserver://localhost:1433;" // ip mao
                + "database=TransportesIIIPatitos;" // -- Nombre de la database nuestra
                + "user=sa;"
                + "password= ;"
                + "encrypt=true;trustServerCertificate=true;";

        try {   
            Connection con = DriverManager.getConnection(CadenaConexion);
            return con;
        } catch (SQLException e) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + e.getMessage());
            return null;
        }
    }

    // INSERTS
    public static int Insert_TiposMantenimiento(Obj_TipoMantenimiento obj, String tabla) throws SQLException {

        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Insert Into " + tabla + " "
                   + "Values(" + obj.getId() + ","
                   + " '" + obj.getDescripcion()+ "',"
                   + " " + obj.getActivo() + ")";
        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }
    
    public static int Insert_Equipo(Obj_Equipos obj, String tabla) throws SQLException {

        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Insert Into " + tabla + " "
                   + "Values(" + obj.getId() + ","
                   + " '" + obj.getDescripcion()+ "',"
                   + " " + obj.getActivo() + ")";
        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }
    
    public static int Insert_AsignaMantenimiento(Obj_AsignacionMantenimiento obj, String tabla) throws SQLException {

        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Insert Into " + tabla + " "
                   + "Values(" + obj.getId() + ","
                   + " " + obj.getId_vehiculo() + ","
                   + " " + obj.getId_mantenimiento() + ","
                   + " '" + obj.getFecha_asignacion() + "',"
                   + " " + obj.getId_usuario() + ","
                   + " " + obj.getActivo() + ")";
        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }

    // -- Inserta la info del Equipo al table Equipos  
    public static int InsertCombustible(Obj_Combustible Com, String tabla) throws SQLException {

        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Insert Into " + tabla + " "
                   + "Values(" + Com.id + ", "
                   + "'" + Com.nombre + "', "
                   + "" + Com.precio + ", "
                   + "" + Com.activo + ")";

        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }
    
    // -- Inserta la info del Equipo al table Equipos  
    public static int Insert_Usuarios(Obj_Usuario obj, String tabla) throws SQLException {

        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Insert Into " + tabla + " "
                   + "Values(" + obj.getId() + ", "
                   + "'" + obj.getUsuario()+ "', "
                   + "'" + obj.getContrasena() + "', "
                   + "" + obj.getRol()+ ", "
                   + "" + obj.getEstado()+ ")";

        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }
    
    public static int InsertVehiculo(Obj_Vehiculos Veh, String tabla) throws SQLException {

        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Insert Into " + tabla + " "
                   + "Values(" + Veh.id + ", "
                   + "'" + Veh.placa + "', "
                   + "'" + Veh.nombre + "', "
                   + "'" + Veh.marca + "', "
                   + "'" + Veh.modelo + "', "
                   + Veh.id_combustible + ", "
                   + Veh.activo + ")";

        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }

    // CONSULTAS
    // Con esta funcion validamos el inicio de sesion del usuario y obtenemos su rol
    public static int ValidarLoginSQL(Obj_Usuario obj) throws SQLException {
        int resultado = -1;

        try {
            Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
            String qry = "SELECT contrasena, rol FROM Usuarios WHERE usuario = '" + obj.getUsuario()
                       + "' AND estado = 1";

            ResultSet res = sql.executeQuery(qry);
            while (res.next()) {
                String passwordAlmacenado = res.getString("contrasena");
                if (passwordAlmacenado.equals(obj.getContrasena())) {
                    resultado = res.getInt("rol");
                }
            }
        } catch (SQLException e) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + e.getMessage());
        }
        return resultado;
    }

    public static int Sig_IdSQL(String tabla) throws SQLException {
        int Resultado = 1;

        try {
            Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
            String Consulta = "Select Max(id) From " + tabla;

            ResultSet Opr = sql.executeQuery(Consulta);
            while (Opr.next()) {
                Resultado = Opr.getInt(1) + 1;
            }

        } catch (SQLException e) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + e.getMessage());
        }

        return Resultado;
    }
    
    // Funcion que obtenemos la cantidad de admins restantes en la base de datos
    public static int Consultar_CantAdmins() throws SQLException {
        int Resultado = 1;

        try {
            Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
            String Consulta = "SELECT COUNT(*) AS total_roles FROM Usuarios "
                            + "WHERE rol = 1 AND estado = 1";

            ResultSet Opr = sql.executeQuery(Consulta);
            while (Opr.next()) {
                Resultado = Opr.getInt(1);
                System.out.println("\u001B[32mID ACTUAL:\u001B[0m " + Resultado);
            }

        } catch (SQLException e) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + e.getMessage());
        }

        return Resultado;
    }

    public static ResultSet consultar_Tabla(String tabla) throws SQLException {

        try {
            Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
            String Consulta = "Select * "
                    + "From " + tabla;

            ResultSet resultado = sql.executeQuery(Consulta);

            return resultado;

        } catch (SQLException e) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + e.getMessage());
            return null;
        }
    }
    
    public static ResultSet consultar_TablaUsuario(String tabla) throws SQLException {

        try {
            Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
            String Consulta = "Select id, usuario, rol, estado "
                    + "From " + tabla;

            ResultSet resultado = sql.executeQuery(Consulta);

            return resultado;

        } catch (SQLException e) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + e.getMessage());
            return null;
        }
    }
    
    public static ResultSet consultar_Combustibles(String tabla) throws SQLException {

        try {
            Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
            String Consulta = "select *, "
                + "Case "
                + "When activo = 1 theN 'activo' "
                + "When activo = 0 then 'inactivo' "
                + "Else 'Desconocido' "
                + "end as estado_activo "
                + "from " + tabla;

            ResultSet resultado = sql.executeQuery(Consulta);

            return resultado;

        } catch (SQLException e) {
            System.out.println("\u001B[31mERROR:\u001B[0m " + e.getMessage());
            return null;
        }
    }   

    // UPDATES
    // -- Modifica la info del Equipo al table Equipos  
    public static int UpdateCombustible(Obj_Combustible Com, String tabla) throws SQLException {
        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Update " + tabla + " "
                   + "Set nombre = '" + Com.nombre + "',"
                   + "precio = " + Com.precio + ","
                   + "activo = " + Com.activo + " "
                   + "Where id = " + Com.id;
        
        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }
    
    public static int Update_AsignaMantenimiento(Obj_AsignacionMantenimiento obj, String tabla) throws SQLException {
        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Update " + tabla + " "
                   + "Set id_vehiculo = " + obj.getId_vehiculo() + ", "
                   + "id_mantenimiento = " + obj.getId_mantenimiento() + ", "
                   + "fecha_asignacion = '" + obj.getFecha_asignacion() + "', "
                   + "id_usuario = " + obj.getId_usuario()+ ", "
                   + "activo = " + obj.getActivo()+ " "
                   + "Where id = " + obj.getId();
        
        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }
    
    public static int Update_TiposMantenimiento(Obj_TipoMantenimiento obj, String tabla) throws SQLException {
        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Update " + tabla + " "
                   + "Set descripcion = '" + obj.getDescripcion() + "', "
                   + "activo = " + obj.getActivo()+ " "
                   + "Where id = " + obj.getId();
        
        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }
    
    public static int Update_Equipo(Obj_Equipos obj, String tabla) throws SQLException {
        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Update " + tabla + " "
                   + "Set descripcion = '" + obj.getDescripcion() + "', "
                   + "activo = " + obj.getActivo()+ " "
                   + "Where id = " + obj.getId();
        
        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }
    
    public static int Update_Usuario(Obj_Usuario obj, String tabla) throws SQLException {
        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Update " + tabla + " "
                   + "Set usuario = '" + obj.getUsuario() + "', "
                   + "contrasena = '" + obj.getContrasena() + "', "
                   + "rol = " + obj.getRol() + ", "
                   + "estado = " + obj.getEstado() + " "
                   + "Where id = " + obj.getId();
        
        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }

    
    public static int UpdateVehiculo(Obj_Vehiculos Veh, String tabla) throws SQLException {
        int Rows_Affected = 0;
        //Creacion de sentencia para manejo en sql
        Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
        //String que contiene el script de  la operacion de sql
        String Qry = "Update " + tabla + " "
                   + "Set placa = '" + Veh.placa + "',"
                   + "nombre = '" + Veh.nombre + "',"
                   + "marca = '" + Veh.marca + "',"
                   + "modelo = '" + Veh.modelo + "',"
                   + "id_combustible = " + Veh.id_combustible + ","
                   + "activo = " + Veh.activo + " "
                   + "Where id = " + Veh.id;
        
        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }
}
