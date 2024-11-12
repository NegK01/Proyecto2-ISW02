/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

/**
 *
 * @author Elias
 */
public class Obj_Combustible {
    
    int        id;
    String     nombre;
    String     precio;
    int        activo;

    public Obj_Combustible(int id, String nombre, String precio, int activo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.activo = activo;
    }

    public Obj_Combustible(String nombre, String precio, int activo) {
        this.nombre = nombre;
        this.precio = precio;
        this.activo = activo;
    }

    public Obj_Combustible() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
}
