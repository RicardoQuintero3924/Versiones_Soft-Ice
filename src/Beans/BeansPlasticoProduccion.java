package Beans;

public class BeansPlasticoProduccion {

    private String Turno;
    private String referencia;
    private String cantidad;
    private String lote;
    private String PlasticoBaja;

    public BeansPlasticoProduccion() {
    }

    public BeansPlasticoProduccion(String Turno, String referencia, String cantidad, String lote, String PlasticoBaja) {
        this.Turno = Turno;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.lote = lote;
        this.PlasticoBaja = PlasticoBaja;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPlasticoBaja() {
        return PlasticoBaja;
    }

    public void setPlasticoBaja(String PlasticoBaja) {
        this.PlasticoBaja = PlasticoBaja;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

}
