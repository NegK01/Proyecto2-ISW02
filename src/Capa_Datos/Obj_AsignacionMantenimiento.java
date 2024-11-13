/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

/**
 *
 * @author Mao
 */
public class Obj_AsignacionMantenimiento {
    private int id;
    private int id_vehiculo;
    private int id_mantenimiento;
    private String fecha_asignacion;
    private int id_usuario;
    private int activo;

    public Obj_AsignacionMantenimiento(int id, int id_vehiculo, int id_mantenimiento, String fecha_asignacion, int id_usuario, int activo) {
        this.id = id;
        this.id_vehiculo = id_vehiculo;
        this.id_mantenimiento = id_mantenimiento;
        this.fecha_asignacion = fecha_asignacion;
        this.id_usuario = id_usuario;
        this.activo = activo;
    }

    public Obj_AsignacionMantenimiento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_mantenimiento() {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
    }

    public String getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(String fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
}
