package Control;

import Modelo.Categoria;
import Control.Conexion;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class AccionesCategoria {

    //Conexion cx = new Conexion();
    public static int registrarCategoria(Categoria categoria) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "insert into Categoria(NombreCategoria) values(?);";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, categoria.getNombreCategoria());
            status = ps.executeUpdate();
            System.out.println("Registrado Categoria exitoso");
            ps.close();
            cx.desconectar();
        } catch (Exception ed) {
            System.out.println("Error al registrar Categoria");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int actualizarCategoria(Categoria categoria) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "update Categoria set NombreCategoria=?, EstadoCategoria=? where IDCategoria=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, categoria.getNombreCategoria());
            ps.setString(2, categoria.getEstadoCategoria());
            ps.setInt(3, categoria.getIdCategoria());
            status = ps.executeUpdate();
            System.out.println("Actualizacion de la Categoria exitoso");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Actualizar Categoria");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int borrarCategoria(int id) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "delete from Categoria where IDCategoria=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            System.out.println("Eliminacion de la Categoria exitosa");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Eliminar la Categoria");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static Categoria buscarCategoriaoByID(int id) {
        Categoria e = new Categoria();
        Conexion cx = new Conexion();
        int status = 0;
        try {
            //String sql = "update empleados set nom_emp=?, pass_emp=?, email_emp=?, pais_emp=? where id_emp=? ;";
            String sqlSelect = "select * from Categoria where IDCategoria=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sqlSelect);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdCategoria(rs.getInt("IDCategoria"));
                e.setNombreCategoria(rs.getString("NombreCategoria"));
                e.setEstadoCategoria(rs.getString("EstadoCategoria"));
            }
            System.out.println("Se encontro a la Categoria");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Buscar a la Categoria");
            System.out.println(ed.getMessage());
        }
        return e;
    }

    public static List<Categoria> getAllCategoria() {
        List<Categoria> lista = new ArrayList<Categoria>();
        Conexion cx = new Conexion();
        try {
            PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM Categoria");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categoria u = new Categoria();
                u.setIdCategoria(rs.getInt("IDCategoria"));
                u.setNombreCategoria(rs.getString("NombreCategoria"));
                u.setEstadoCategoria(rs.getString("EstadoCategoria"));
                
                lista.add(u);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ed) {
            System.out.println("Error al Buscar Categoria");
            System.out.println(ed.getMessage());
        }
        return lista;
    }

}
