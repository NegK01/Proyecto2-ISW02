/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

/**
 *
 * @author Mao
 */
public class Obj_TipoMantenimiento {
    private int id;
    private String descripcion;
    private float precio;
    private int activo;

    public Obj_TipoMantenimiento(int id, String descripcion, float precio, int activo) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
    }

    public Obj_TipoMantenimiento(String descripcion, float precio, int activo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
    }

    public Obj_TipoMantenimiento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
