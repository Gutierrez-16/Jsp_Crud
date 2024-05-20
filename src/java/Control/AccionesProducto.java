package Control;

import Modelo.Producto;
import Control.Conexion;
import Modelo.Categoria;
import Modelo.Linea;
import Modelo.Marca;
import Modelo.Proveedor;
import Modelo.UnidadMedida;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class AccionesProducto {

    //Conexion cx = new Conexion();
    public static int registrarProducto(Producto producto) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "insert into tbl_Productos(nombre, descripcion, precio, cantidad_stock, fecha_registro,proveedor_id,IDCategoria,IDLinea,IDMarca,IDUnidadMedida) values(?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad_stock());
            ps.setString(5,  producto.getFecha_registro());
            ps.setInt(6, producto.getProveedor_id());
            ps.setInt(7, producto.getIdCategoria());
            ps.setInt(8, producto.getIdLinea());
            ps.setInt(9, producto.getIdMarca());
            ps.setInt(10, producto.getIdUnidadMedida());
            status = ps.executeUpdate();
            System.out.println("Registrado Producto exitoso");
            ps.close();
            cx.desconectar();
        } catch (Exception ed) {
            System.out.println("Error al registrar Producto");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int actualizarProducto(Producto producto) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "update tbl_Productos set nombre=?, descripcion=?, precio=?, cantidad_stock=?, fecha_registro=?, proveedor_id=?,"
                    + "IDCategoria=?,IDLinea=?,IDMarca=?,IDUnidadMedida=?,EstadoProducto=? where producto_id=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad_stock());
            ps.setString(5, producto.getFecha_registro());
            ps.setInt(6, producto.getProveedor_id());
            ps.setInt(7, producto.getIdCategoria());
            ps.setInt(8, producto.getIdLinea());
            ps.setInt(9, producto.getIdMarca());
            ps.setInt(10, producto.getIdUnidadMedida());
            ps.setString(11, producto.getEstadoProducto());
            ps.setInt(12, producto.getProducto_id());
            status = ps.executeUpdate();
            System.out.println("Actualizacion de la Producto exitoso");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Actualizar Producto");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static int borrarProducto(int id) {

        Conexion cx = new Conexion();
        int status = 0;
        try {
            String sql = "delete from tbl_Productos where producto_id=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            System.out.println("Eliminacion de la Producto exitosa");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Eliminar la Producto");
            System.out.println(ed.getMessage());
        }
        return status;
    }

    public static Producto buscarProductooByID(int id) {
        Producto e = new Producto();
        Conexion cx = new Conexion();
        int status = 0;
        try {
            //String sql = "update empleados set nom_emp=?, pass_emp=?, email_emp=?, pais_emp=? where id_emp=? ;";
            String sqlSelect = "select * from tbl_Productos where producto_id=? ;";
            PreparedStatement ps = cx.conectar().prepareStatement(sqlSelect);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setProducto_id(rs.getInt("producto_id"));
                e.setNombre(rs.getString("nombre"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setPrecio(rs.getDouble("precio"));
                e.setCantidad_stock(rs.getInt("cantidad_stock"));
                e.setFecha_registro(rs.getString("fecha_registro"));
                e.setProveedor_id(rs.getInt("proveedor_id"));
                e.setIdCategoria(rs.getInt("IDCategoria"));
                e.setIdLinea(rs.getInt("IDLinea"));
                e.setIdMarca(rs.getInt("IDMarca"));
                e.setIdUnidadMedida(rs.getInt("IDUnidadMedida"));
                e.setEstadoProducto(rs.getString("EstadoProducto"));
            }
            System.out.println("Se encontro a la Producto");
            ps.close();
        } catch (Exception ed) {
            System.out.println("Error al Buscar a la Producto");
            System.out.println(ed.getMessage());
        }
        return e;
    }

    public static List<Producto> getAllProducto() {
        List<Producto> lista = new ArrayList<Producto>();
        Conexion cx = new Conexion();
        try {
            PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM tbl_Productos");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto u = new Producto();
                u.setProducto_id(rs.getInt("producto_id"));
                u.setNombre(rs.getString("nombre"));
                u.setDescripcion(rs.getString("descripcion"));
                u.setPrecio(rs.getDouble("precio"));
                u.setCantidad_stock(rs.getInt("cantidad_stock"));
                u.setFecha_registro(rs.getString("fecha_registro"));
                u.setProveedor_id(rs.getInt("proveedor_id"));
                u.setIdCategoria(rs.getInt("IDCategoria"));
                u.setIdLinea(rs.getInt("IDLinea"));
                u.setIdMarca(rs.getInt("IDMarca"));
                u.setIdUnidadMedida(rs.getInt("IDUnidadMedida"));
                u.setEstadoProducto(rs.getString("EstadoProducto"));
                lista.add(u);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ed) {
            System.out.println("Error al Buscar Producto");
            System.out.println(ed.getMessage());
        }
        return lista;
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
