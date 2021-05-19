package co.edu.sena.Model.connection.dao;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    //declarar las constantes
    //private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_USER = "root";
    private final String DB_PASS = "";
    private final String DB_HOST = "localhost:3306";
    private final String DB_NAME = "db_nomina";
    private final String URL = "jdbc:mysql://" + DB_HOST + "/" + DB_NAME;

    //elementos Connection;
    Connection con;

    public Connection Connection() {
        try {
            con = DriverManager.getConnection(URL, DB_USER, DB_PASS);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    /*
    public static void main(String[] args) {
        Conexion conn = new Conexion();
        Connection con = conn.Connection();

        System.out.println(con);
    }*/
}
