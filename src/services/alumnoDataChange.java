package services;

import repository.conexionDB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import model.alumno;

public class alumnoDataChange {

    public static String mensaje = "";

    public static boolean guardado(alumno a) {
        try {
            String sql = "INSERT INTO alumnoss (nombre, apellido, telefono, correo) VALUES (?, ?, ?, ?)";
            Connection cx = conexionDB.conectar();
            PreparedStatement sentencia = cx.prepareStatement(sql);
            sentencia.setString(1, a.getNombre());
            sentencia.setString(2, a.getApellido());
            sentencia.setString(3, a.getTelefono());
            sentencia.setString(4, a.getCorreo());
            int filas = sentencia.executeUpdate();
            if (filas > 0) {
                mensaje = "alumo guardado correctamente";
                return true;
            }
            mensaje = "no se ha podido guardar el alumno";
            return false;
        } catch (Exception ex) {
            mensaje = ex.getMessage();
            return false;
        }

    }
}
