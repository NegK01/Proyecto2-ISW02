/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

/**
 *
 * @author Usuario
 */


// -- Objeto para los datos del Usuario ->
public class Obj_User {

    // -- Variables ->
    String     Usuario;
    String  Contraseña;
    String         Rol;
    
    // -- Constructor ->
    public Obj_User(String Usuario, String Contraseña, String Rol) {
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Rol = Rol;
    }
    
    // -- Getters Y Setters ->

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }
    
}
