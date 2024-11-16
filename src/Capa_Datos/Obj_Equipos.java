/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

/**
 *
 * @author Mao
 */
public class Obj_Equipos {
    private int id;
    private String descripcion;
    private int activo;

    public Obj_Equipos(int id, String descripcion, int activo) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Obj_Equipos(String descripcion, int activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Obj_Equipos() {
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

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
