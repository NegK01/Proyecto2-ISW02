/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_Datos.Conexion_SQL;
import Capa_Datos.Obj_Usuario;
import java.sql.SQLException;

/**
 *
 * @author Mao
 */
public class Login {

    private Obj_Usuario obj_user;

    public int ValidarLogin(String usuario, String contrasena) throws SQLException {
        obj_user = new Obj_Usuario(usuario, contrasena);
        return Conexion_SQL.ValidarLoginSQL(obj_user); // Retorna el rol (1 / 2)
    }
}
