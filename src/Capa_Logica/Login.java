/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_Datos.Conexion_SQL;
import Capa_Datos.Obj_User;
import java.sql.SQLException;

/**
 *
 * @author Mao
 */
public class Login {

    private Obj_User obj_user;

    public boolean ValidarLogin(String usuario, String contrasena) throws SQLException {
        obj_user = new Obj_User(usuario, contrasena);
        int rol = Conexion_SQL.ValidarLoginSQL(obj_user);
        return (rol != 0); // 1-2 True / 0 False
    }
}
