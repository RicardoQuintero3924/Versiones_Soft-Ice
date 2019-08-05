package Beans;

import VistasCC.PlasticoProveedorTraslado;

public class BeansPlasticoProveedorTraslados extends PlasticoProveedorTraslado {

    private String TipoMovimiento;
    //private String Entrada;
    private String Salida;
    private String Referencia;
    private String cantidad;
    private String nroremision;
    // private String costoporunidad;
    // private String costototal;
    private String saldo;
 
    private String lote;
    private String turno;

    public BeansPlasticoProveedorTraslados() {
    }

    public BeansPlasticoProveedorTraslados(String TipoMovimiento, String Salida, String Referencia, String cantidad, String nroremision, String saldo, String opc, String lote, String turno) {
        this.TipoMovimiento = TipoMovimiento;
        this.Salida = Salida;
        this.Referencia = Referencia;
        this.cantidad = cantidad;
        this.nroremision = nroremision;
        this.saldo = saldo;
        this.lote = lote;
        this.turno = turno;
    }

    public String getTipoMovimiento() {
        return TipoMovimiento;
    }

    public void setTipoMovimiento(String TipoMovimiento) {
        this.TipoMovimiento = TipoMovimiento;
    }

    /*public String getEntrada() {
        return Entrada;
    }

    public void setEntrada(String Entrada) {
        this.Entrada = Entrada;
    }
     */
    public String getSalida() {
        return Salida;
    }

    public void setSalida(String Salida) {
        this.Salida = Salida;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /*  public String getCostoporunidad() {
        return costoporunidad;
    }

    public void setCostoporunidad(String costoporunidad) {
        this.costoporunidad = costoporunidad;
    }

    public String getCostototal() {
        return costototal;
    }

    public void setCostototal(String costototal) {
        this.costototal = costototal;
    }
     */
 /* public String getNroreferencia() {
        return nroreferencia;
    }

    public void setNroreferencia(String nroreferencia) {
        this.nroreferencia = nroreferencia;
    }
     */
    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getNroremision() {
        return nroremision;
    }

    public void setNroremision(String nroremision) {
        this.nroremision = nroremision;
    }

  

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

}
