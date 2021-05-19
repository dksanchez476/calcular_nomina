package co.edu.sena.Model.connection.dao;

import co.edu.sena.Model.connection.beans.Nomina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//importar la conexión

public class NominaDAO {

    //elementos para realizar las transacciones
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    //instancia para usar el metodo que contiene la conexión a la base de datos
    Conexion c = new Conexion();

    //método para registrar el tipo de documento
    public List Listar() {

        String sql = "SELECT * FROM nomina";
        con = c.Connection();
        List<Nomina> listar = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Nomina td = new Nomina();
                td.setNombre(rs.getString(1));
                td.setApellido(rs.getString(2));
                td.setNumDoc(rs.getString(3));
                td.setDiasTrabajados(rs.getByte(4));
                td.setSueldo(rs.getFloat(5));

                listar.add(td);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Nomina.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listar;
    }

    public int Registrar(Nomina td) {
        String sql = "INSERT INTO nomina(nombre,apellido,numDoc,diasTrabajados,sueldo) VALUES (?,?,?,?,?)";
        try {
            //usar la conexión
            con = c.Connection();
            ps = con.prepareStatement(sql);
            ps.setString(1, td.getNombre());
            ps.setString(2, td.getApellido());
            ps.setString(3, td.getNumDoc());
            ps.setByte(4, td.getDiasTrabajados());
            ps.setFloat(5, td.getSueldo());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Nomina.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
