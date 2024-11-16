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
    
    public Obj_Vehiculos(){

    }

    // -- Variables ->
    int id;
    String placa;
    String nombre;
    String marca;
    String modelo;
    int id_combustible;
    int activo;

    // -- Constructores ->
    public Obj_Vehiculos(int id, String placa, String nombre, String marca, String modelo, int id_combustible, int activo) {
        this.id = id;
        this.placa = placa;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.id_combustible = id_combustible;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getId_combustible() {
        return id_combustible;
    }

    public void setId_combustible(int id_combustible) {
        this.id_combustible = id_combustible;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
}
