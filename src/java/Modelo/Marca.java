
package Modelo;


public class Marca {
    private int idMarca; 
    private String nombreMarca;
    private String estadoMarca ;

    public Marca() {
    }

    public Marca(int idMarca, String nombreMarca, String estadoMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.estadoMarca = estadoMarca;
    }

    
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getEstadoMarca() {
        return estadoMarca;
    }

    public void setEstadoMarca(String estadoMarca) {
        this.estadoMarca = estadoMarca;
    }
    
    
    
}
