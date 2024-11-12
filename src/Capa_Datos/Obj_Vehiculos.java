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
public class Obj_Vehiculos {
    
    // -- Variables ->
    int     id;
    String  placa;
    String  modelo;
    String  tipo_combustible;
    double  kilometraje;
    String  ubicacion_puerto;
    int     activo;

    // -- Constructores ->
    public Obj_Vehiculos(int id, String placa, String modelo, String tipo_combustible, double kilometraje, String ubicacion_puerto, int activo) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.tipo_combustible = tipo_combustible;
        this.kilometraje = kilometraje;
        this.ubicacion_puerto = ubicacion_puerto;
        this.activo = activo;
    }
    
    
    // -- Getters & Setters ->
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getUbicacion_puerto() {
        return ubicacion_puerto;
    }

    public void setUbicacion_puerto(String ubicacion_puerto) {
        this.ubicacion_puerto = ubicacion_puerto;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
}
