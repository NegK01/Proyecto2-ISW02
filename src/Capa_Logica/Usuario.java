/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_Datos.Conexion_SQL;
import Capa_Datos.Obj_Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mao
 */
public class Usuario {
    private Obj_Usuario obj_usuario;
    private final Otros Sql = new Otros();
    public final String tablaUsuarios = "Usuarios";
    
    public int Insert_Usuario(String usuario, String contrasena, int rol, int estado) throws SQLException {
        int id = Otros.Sig_Id(tablaUsuarios);
        obj_usuario = new Obj_Usuario(id, usuario, contrasena, rol, estado);
        return Conexion_SQL.Insert_Usuarios(obj_usuario, tablaUsuarios);
    }
    
    public int Update_Usuario(int id, String usuario, String contrasena, int rol, int estado) throws SQLException {
        obj_usuario = new Obj_Usuario(id, usuario, contrasena, rol, estado);
        return Conexion_SQL.Update_Usuario(obj_usuario, tablaUsuarios);
    }
    
    public ResultSet Consultar_TablaUsuario() throws SQLException {
        return Conexion_SQL.consultar_TablaUsuario(tablaUsuarios);
    }
    
    public ResultSet Consultar_TablaUsuarioFiltro(String filtro) throws SQLException {
        return Conexion_SQL.consultar_TablaUsuarioFiltro(tablaUsuarios, filtro);
    }
    
    public int Consultar_CantAdmins() throws SQLException {
        return Conexion_SQL.Consultar_CantAdmins();
    }
}
