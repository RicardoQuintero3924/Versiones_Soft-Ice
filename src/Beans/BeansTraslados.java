package Beans;

public class BeansTraslados {

    private String origen;
    private String destino;
    private String transporte;
    private String referencia;
    private int cantidad;
    private String despachado_por;
    private String lote;
    private String observa;
    private String remision;

    public BeansTraslados() {
    }

    public BeansTraslados(String origen, String destino, String transporte, String referencia, int cantidad, String despachado_por, String lote, String observa, String remision) {
        this.origen = origen;
        this.destino = destino;
        this.transporte = transporte;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.despachado_por = despachado_por;
        this.lote = lote;
        this.observa = observa;
        this.remision = remision;
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

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDespachado_por() {
        return despachado_por;
    }

    public void setDespachado_por(String despachado_por) {
        this.despachado_por = despachado_por;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getObserva() {
        return observa;
    }

    public void setObserva(String observa) {
        this.observa = observa;
    }

    public String getRemision() {
        return remision;
    }

    public void setRemision(String remision) {
        this.remision = remision;
    }

}
