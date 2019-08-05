package Beans;


public class BeansCavaPuntoVenta {
    private String referencia;
    private String cantidad;
    private String bajas;
    private String lote;

    public BeansCavaPuntoVenta(String referencia, String cantidad, String bajas, String lote) {
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.bajas = bajas;
        this.lote = lote;
    }

    public BeansCavaPuntoVenta() {
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

    public String getBajas() {
        return bajas;
    }

    public void setBajas(String bajas) {
        this.bajas = bajas;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
    
}
