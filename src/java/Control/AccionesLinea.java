package Control;

import Modelo.Linea;
import Control.Conexion;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class AccionesLinea {

    //Conexion cx = new Conexion();
    public static int registrarLinea(Linea linea) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "insert into Linea(NombreLinea, EstadoLinea) values(?,?);";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, linea.getNombreLinea());
            ps.setString(2, linea.getEstadoLinea());
            status = ps.executeUpdate();
            System.out.println("Registrado Linea exitoso");
            ps.close();
            cx.desconectar();
        } catch (Exception ed) {
            System.out.println("Error al registrar Linea");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int actualizarLinea(Linea linea) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "update Linea set NombreLinea=?, EstadoLinea=? where IDLinea=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, linea.getNombreLinea());
            ps.setString(2, linea.getEstadoLinea());
            ps.setInt(3, linea.getIdLinea());
            status = ps.executeUpdate();
            System.out.println("Actualizacion de la Linea exitoso");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Actualizar Linea");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int borrarLinea(int id) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "delete from Linea where IDLinea=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            System.out.println("Eliminacion de la Linea exitosa");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Eliminar la Linea");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static Linea buscarLineaoByID(int id) {
        Linea e = new Linea();
        Conexion cx = new Conexion();
        int status = 0;
        try {
            //String sql = "update empleados set nom_emp=?, pass_emp=?, email_emp=?, pais_emp=? where id_emp=? ;";
            String sqlSelect = "select * from Linea where IDLinea=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sqlSelect);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdLinea(rs.getInt("IDLinea"));
                e.setNombreLinea(rs.getString("NombreLinea"));
                e.setEstadoLinea(rs.getString("EstadoLinea"));
            }
            System.out.println("Se encontro a la Linea");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Buscar a la Linea");
            System.out.println(ed.getMessage());
        }
        return e;
    }

    public static List<Linea> getAllLinea() {
        List<Linea> lista = new ArrayList<Linea>();
        Conexion cx = new Conexion();
        try {
            PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM Linea");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Linea u = new Linea();
                u.setIdLinea(rs.getInt("IDLinea"));
                u.setNombreLinea(rs.getString("NombreLinea"));
                u.setEstadoLinea(rs.getString("EstadoLinea"));
                
                lista.add(u);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ed) {
            System.out.println("Error al Buscar Linea");
            System.out.println(ed.getMessage());
        }
        return lista;
    }

}
