package Capa_Logica;

import Capa_Datos.Conexion_SQL;
import Capa_Datos.Obj_Tanque;
import java.sql.SQLException;

/**
 *
 * @author Mao
 */
public class Tanque {
    
    private Obj_Tanque obj_Tanque;
    private final Otros Sql = new Otros();
    public final String tablaTanque = "tanques_combustible";
    
    public int Insert_Tanque(String nombre, double capacidad, int id_combustible, int activo) throws SQLException {
        int id = Otros.Sig_Id(tablaTanque);
        obj_Tanque = new Obj_Tanque(id, nombre, capacidad, id_combustible, activo);
        return Conexion_SQL.Insert_Tanque(obj_Tanque, tablaTanque);
    }
    
    public int Update_Tanque(int id, String nombre, double capacidad, int id_combustible, int activo) throws SQLException {
        obj_Tanque = new Obj_Tanque(id, nombre, capacidad, id_combustible, activo);
        return Conexion_SQL.Update_Tanque(obj_Tanque, tablaTanque);
    }
}
