
package Modelo;


public class Linea {
    private int idLinea; 
    private String nombreLinea;
    private String estadoLinea;

    public Linea() {
    }

    public Linea(int idLinea, String nombreLinea, String estadoLinea) {
        this.idLinea = idLinea;
        this.nombreLinea = nombreLinea;
        this.estadoLinea = estadoLinea;
    }

    
    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public String getNombreLinea() {
        return nombreLinea;
    }

    public void setNombreLinea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }

    public String getEstadoLinea() {
        return estadoLinea;
    }

    public void setEstadoLinea(String estadoLinea) {
        this.estadoLinea = estadoLinea;
    }
    
    
    
}
