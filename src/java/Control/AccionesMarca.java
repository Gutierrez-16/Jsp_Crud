package Control;

import Modelo.Marca;
import Control.Conexion;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class AccionesMarca {

    //Conexion cx = new Conexion();
    public static int registrarMarca(Marca marca) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "insert into Marca(NombreMarca) values(?);";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, marca.getNombreMarca());
            status = ps.executeUpdate();
            System.out.println("Registrado Marca exitoso");
            ps.close();
            cx.desconectar();
        } catch (Exception ed) {
            System.out.println("Error al registrar Marca");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int actualizarMarca(Marca marca) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "update Marca set NombreMarca=?, EstadoMarca=? where IDMarca=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, marca.getNombreMarca());
            ps.setString(2, marca.getEstadoMarca());
            ps.setInt(3, marca.getIdMarca());
            status = ps.executeUpdate();
            System.out.println("Actualizacion de la Marca exitoso");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Actualizar Marca");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int borrarMarca(int id) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "delete from Marca where IDMarca=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            System.out.println("Eliminacion de la Marca exitosa");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Eliminar la Marca");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static Marca buscarMarcaoByID(int id) {
        Marca e = new Marca();
        Conexion cx = new Conexion();
        int status = 0;
        try {
            //String sql = "update empleados set nom_emp=?, pass_emp=?, email_emp=?, pais_emp=? where id_emp=? ;";
            String sqlSelect = "select * from Marca where IDMarca=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sqlSelect);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdMarca(rs.getInt("IDMarca"));
                e.setNombreMarca(rs.getString("NombreMarca"));
                e.setEstadoMarca(rs.getString("EstadoMarca"));
            }
            System.out.println("Se encontro a la Marca");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Buscar a la Marca");
            System.out.println(ed.getMessage());
        }
        return e;
    }

    public static List<Marca> getAllMarca() {
        List<Marca> lista = new ArrayList<Marca>();
        Conexion cx = new Conexion();
        try {
            PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM Marca");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Marca u = new Marca();
                u.setIdMarca(rs.getInt("IDMarca"));
                u.setNombreMarca(rs.getString("NombreMarca"));
                u.setEstadoMarca(rs.getString("EstadoMarca"));
                
                lista.add(u);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ed) {
            System.out.println("Error al Buscar Marca");
            System.out.println(ed.getMessage());
        }
        return lista;
    }

}
