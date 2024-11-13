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
        String CadenaConexion = "jdbc:sqlserver://192.168.0.6:1433;" // ip mao
                + "database=TransportesIIIPatitos;" // -- Nombre de la database nuestra
                + "user=sqlUser;"
                + "password=pass;"
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
                   + " " + obj.getPrecio()+ ","
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
                   + " " + obj.getPrecio()+ ","
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

    // CONSULTAS
    // Con esta funcion validamos el inicio de sesion del usuario y obtenemos su rol
    public static int ValidarLoginSQL(Obj_User obj) throws SQLException {
        int resultado = 0;

        try {
            Statement sql = (Statement) Conexion_SQL.getConnection().createStatement();
            String qry = "SELECT contrasena, rol FROM Usuarios WHERE usuario = '" + obj.getNombre() + "'";

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
                   + "precio = " + obj.getPrecio()+ ", "
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
                   + "precio = " + obj.getPrecio()+ ", "
                   + "activo = " + obj.getActivo()+ " "
                   + "Where id = " + obj.getId();
        
        Rows_Affected = sql.executeUpdate(Qry);

        return Rows_Affected;
    }

}
