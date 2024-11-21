package Capa_Datos;

/**
 *
 * @author Mao
 */
public class Obj_Tanque {
    private int id;
    private String nombre;
    private double capacidad;
    private int id_combustible;
    private int activo;

    public Obj_Tanque(int id, String nombre, double capacidad, int id_combustible, int activo) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.id_combustible = id_combustible;
        this.activo = activo;
    }

    public Obj_Tanque() {
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

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
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
