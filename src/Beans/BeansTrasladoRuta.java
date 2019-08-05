package Beans;


public class BeansTrasladoRuta {
    private String origen;
    private String destino;
    private String referencia;
    private String cantidad;
    private String observaciones;
    private String fecha;

    public BeansTrasladoRuta() {
    }

    public BeansTrasladoRuta(String origen, String destino, String referencia, String cantidad, String observaciones, String fecha) {
        this.origen = origen;
        this.destino = destino;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }
    
     public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
}
