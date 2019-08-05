package Beans;

public class BeansConsultaPlastico {

    private String referencia;
    private String Desde;
    private String hasta;

    public BeansConsultaPlastico() {
    }

    public BeansConsultaPlastico(String referencia, String Desde, String hasta) {
        this.referencia = referencia;
        this.Desde = Desde;
        this.hasta = hasta;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDesde() {
        return Desde;
    }

    public void setDesde(String Desde) {
        this.Desde = Desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

}
