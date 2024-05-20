
package Modelo;


public class Categoria {
    private int idCategoria; 
    private String nombreCategoria;
    private String estadoCategoria ;

    public Categoria() {
    }

    public Categoria(int idCategoria, String nombreCategoria, String estadoCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.estadoCategoria = estadoCategoria;
    }

    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(String estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }
    
    
}
