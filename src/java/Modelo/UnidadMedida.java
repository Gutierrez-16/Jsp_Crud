
package Modelo;


public class UnidadMedida {
    private int idUnidadMedida; 
    private String nombreUnidadMedida;
    private String estadoUnidadMedida ;

    public UnidadMedida() {
    }

    public UnidadMedida(int idUnidadMedida, String nombreUnidadMedida, String estadoUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
        this.nombreUnidadMedida = nombreUnidadMedida;
        this.estadoUnidadMedida = estadoUnidadMedida;
    }

    
    public int getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(int idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getNombreUnidadMedida() {
        return nombreUnidadMedida;
    }

    public void setNombreUnidadMedida(String nombreUnidadMedida) {
        this.nombreUnidadMedida = nombreUnidadMedida;
    }

    public String getEstadoUnidadMedida() {
        return estadoUnidadMedida;
    }

    public void setEstadoUnidadMedida(String estadoUnidadMedida) {
        this.estadoUnidadMedida = estadoUnidadMedida;
    }
    
    
}
