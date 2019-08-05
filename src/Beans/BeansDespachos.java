/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author USER
 */
public class BeansDespachos {

    private String turno;
    private String ruta;
    private String referencia;
    private String cantidad;
    private String lote;
    private String despacho;
    private String planilla;
   // private String observaciones;

    public BeansDespachos() {
    }

    public BeansDespachos(String turno, String ruta, String referencia, String cantidad, String lote, String despacho, String planilla) {
        this.turno = turno;
        this.ruta = ruta;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.lote = lote;
        this.despacho = despacho;
        this.planilla = planilla;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
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

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

   

  

   
}
