package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexionDB {

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio2", "root", "");
            return cx;
        } catch (Exception e) {
            return null;
        }
    }
}
