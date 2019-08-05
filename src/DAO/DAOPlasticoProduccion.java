package DAO;

import Beans.BeansPlasticoProduccion;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOPlasticoProduccion {

    public boolean InsertarDatos(BeansPlasticoProduccion bp) {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        mes = mes + 1;
        hora = hora - 1;
        String sql = "INSERT INTO plasticoproduccion SET "
                + "turno = '" + bp.getTurno() + "' ,"
                + "referencia = '" + bp.getReferencia() + "' ,"
                + "cantidad = '" + bp.getCantidad() + "' ,"
                + "lote = '" + bp.getLote() + "' ,"
                + "plasticoBaja = '" + bp.getPlasticoBaja() + "' ,"
                + "fecha = '"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex);

            return true;
        }

        return false;
    }
    
    public boolean InsertaFinal(BeansPlasticoProduccion bp){
         String sql = "INSERT INTO inventarioinicial SET "
                + "turno = '" + bp.getTurno() + "' ,"
                + "referencia = '" + bp.getReferencia() + "' ,"
                + "cantidad = '" + bp.getCantidad() + "' ,"
                + "lote = '" + bp.getLote() + "' ,"
                + "plasticoBaja = '" + bp.getPlasticoBaja() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex);

            return true;
        }
        
        return false;
    }
    
    
    
    
}
