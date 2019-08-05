package Beans;

public class BeansDevoluciones {

    private String fecha;
    private String ruta;
    private String referencia;
    private String devolucion;
    private String turno;
    private String Despacha;
    private String observaciones;
    private String estado;
    private String descripcion;

    
     public BeansDevoluciones() {
    }

    public BeansDevoluciones(String fecha, String ruta, String referencia, String devolucion, String turno, String Despacha, String observaciones, String estado, String descripcion) {
        this.fecha = fecha;
        this.ruta = ruta;
        this.referencia = referencia;
        this.devolucion = devolucion;
        this.turno = turno;
        this.Despacha = Despacha;
        this.observaciones = observaciones;
        this.estado = estado;
        this.descripcion = descripcion;
    }
     
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDespacha() {
        return Despacha;
    }

    public void setDespacha(String Despacha) {
        this.Despacha = Despacha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(String devolucion) {
        this.devolucion = devolucion;
    }

}
