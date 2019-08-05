
package Beans;


public class BeansRemisionesManuales {
    private String referencia;
    private String ruta;
    private String cliente;
    private String nit;
    private String cantidad;
    private String fecha;
    private String Nremision;

    public BeansRemisionesManuales() {
    }

    public BeansRemisionesManuales(String referencia, String ruta, String cliente, String nit, String cantidad, String fecha, String Nremision) {
        this.referencia = referencia;
        this.ruta = ruta;
        this.cliente = cliente;
        this.nit = nit;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.Nremision = Nremision;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNremision() {
        return Nremision;
    }

    public void setNremision(String Nremision) {
        this.Nremision = Nremision;
    }
    
    
    
    
}
