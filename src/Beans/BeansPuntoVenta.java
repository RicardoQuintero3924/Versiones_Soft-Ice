package Beans;


public class BeansPuntoVenta {
    private String ruta;
    private String referencia;
    private String cantidad;
    private String lote;
    private String placa;
    private String vendedor;
    

    public BeansPuntoVenta() {
    }

    public BeansPuntoVenta(String ruta, String referencia, String cantidad, String lote, String placa, String vendedor) {
        this.ruta = ruta;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.lote = lote;
        this.placa = placa;
        this.vendedor = vendedor;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

  
    
}
