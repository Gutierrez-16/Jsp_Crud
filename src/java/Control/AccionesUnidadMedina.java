package Control;

import Modelo.UnidadMedida;
import Control.Conexion;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class AccionesUnidadMedina {

    //Conexion cx = new Conexion();
    public static int registrarUnidadMedida(UnidadMedida unidadMedida) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "insert into UnidadMedida(NombreUnidadMedida, EstadoUnidadMedida) values(?,?);";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, unidadMedida.getNombreUnidadMedida());
            ps.setString(2, unidadMedida.getEstadoUnidadMedida());
            status = ps.executeUpdate();
            System.out.println("Registrado UnidadMedida exitoso");
            ps.close();
            cx.desconectar();
        } catch (Exception ed) {
            System.out.println("Error al registrar UnidadMedida");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int actualizarUnidadMedida(UnidadMedida unidadMedida) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "update UnidadMedida set NombreUnidadMedida=?, EstadoUnidadMedida=? where IDUnidadMedida=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, unidadMedida.getNombreUnidadMedida());
            ps.setString(2, unidadMedida.getEstadoUnidadMedida());
            ps.setInt(3, unidadMedida.getIdUnidadMedida());
            status = ps.executeUpdate();
            System.out.println("Actualizacion de la UnidadMedida exitoso");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Actualizar UnidadMedida");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int borrarUnidadMedida(int id) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "delete from UnidadMedida where IDUnidadMedida=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            System.out.println("Eliminacion de la UnidadMedida exitosa");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Eliminar la UnidadMedida");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static UnidadMedida buscarUnidadMedidaoByID(int id) {
        UnidadMedida e = new UnidadMedida();
        Conexion cx = new Conexion();
        int status = 0;
        try {
            //String sql = "update empleados set nom_emp=?, pass_emp=?, email_emp=?, pais_emp=? where id_emp=? ;";
            String sqlSelect = "select * from UnidadMedida where IDUnidadMedida=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sqlSelect);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdUnidadMedida(rs.getInt("IDUnidadMedida"));
                e.setNombreUnidadMedida(rs.getString("NombreUnidadMedida"));
                e.setEstadoUnidadMedida(rs.getString("EstadoUnidadMedida"));
            }
            System.out.println("Se encontro a la UnidadMedida");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Buscar a la UnidadMedida");
            System.out.println(ed.getMessage());
        }
        return e;
    }

    public static List<UnidadMedida> getAllUnidadMedida() {
        List<UnidadMedida> lista = new ArrayList<UnidadMedida>();
        Conexion cx = new Conexion();
        try {
            PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM UnidadMedida");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UnidadMedida u = new UnidadMedida();
                u.setIdUnidadMedida(rs.getInt("IDUnidadMedida"));
                u.setNombreUnidadMedida(rs.getString("NombreUnidadMedida"));
                u.setEstadoUnidadMedida(rs.getString("EstadoUnidadMedida"));
                
                lista.add(u);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ed) {
            System.out.println("Error al Buscar UnidadMedida");
            System.out.println(ed.getMessage());
        }
        return lista;
    }

}
