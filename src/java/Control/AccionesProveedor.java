package Control;

import Modelo.Proveedor;
import Control.Conexion;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class AccionesProveedor {

    //Conexion cx = new Conexion();
    public static int registrarProveedor(Proveedor proveedor) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "insert into tbl_Proveedores(nombre, contacto, telefono, direccion, ciudad,pais) values(?,?,?,?,?,?);";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getContacto());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getDireccion());
            ps.setString(5, proveedor.getCiudad());
            ps.setString(6, proveedor.getPais());
            status = ps.executeUpdate();
            System.out.println("Registrado Proveedor exitoso");
            ps.close();
            cx.desconectar();
        } catch (Exception ed) {
            System.out.println("Error al registrar Proveedor");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int actualizarProveedor(Proveedor proveedor) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "update tbl_Proveedores set nombre=?, contacto=?, telefono=?, direccion=?, ciudad=?, pais=?,EstadoProveedor=? where proveedor_id=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getContacto());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getDireccion());
            ps.setString(5, proveedor.getCiudad());
            ps.setString(6, proveedor.getPais());
            ps.setString(7, proveedor.getEstadoProveedor());
            ps.setInt(8, proveedor.getProveedor_id());
            status = ps.executeUpdate();
            System.out.println("Actualizacion de la Proveedor exitoso");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Actualizar Proveedor");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int borrarProveedor(int id) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "delete from tbl_Proveedores where proveedor_id=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            System.out.println("Eliminacion de la Persona exitosa");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Eliminar la persona");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static Proveedor buscarProveedoroByID(int id) {
        Proveedor e = new Proveedor();
        Conexion cx = new Conexion();
        int status = 0;
        try {
            //String sql = "update empleados set nom_emp=?, pass_emp=?, email_emp=?, pais_emp=? where id_emp=? ;";
            String sqlSelect = "select * from tbl_Proveedores where proveedor_id=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sqlSelect);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setProveedor_id(rs.getInt("proveedor_id"));
                e.setNombre(rs.getString("nombre"));
                e.setContacto(rs.getString("contacto"));
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                e.setCiudad(rs.getString("ciudad"));
                e.setPais(rs.getString("pais"));
                e.setEstadoProveedor(rs.getString("EstadoProveedor"));
            }
            System.out.println("Se encontro a la Proveedor");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Buscar a la Proveedor");
            System.out.println(ed.getMessage());
        }
        return e;
    }

    public static List<Proveedor> getAllProveedor() {
        List<Proveedor> lista = new ArrayList<Proveedor>();
        Conexion cx = new Conexion();
        try {
            PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM tbl_Proveedores");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor u = new Proveedor();
                u.setProveedor_id(rs.getInt("proveedor_id"));
                u.setNombre(rs.getString("nombre"));
                u.setContacto(rs.getString("contacto"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setCiudad(rs.getString("ciudad"));
                u.setPais(rs.getString("pais"));
                u.setEstadoProveedor(rs.getString("EstadoProveedor"));
                
                lista.add(u);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ed) {
            System.out.println("Error al Buscar Proveedor");
            System.out.println(ed.getMessage());
        }
        return lista;
    }

}
