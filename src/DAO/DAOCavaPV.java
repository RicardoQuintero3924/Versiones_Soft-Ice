package DAO;

import Beans.BeansCavaPuntoVenta;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;


public class DAOCavaPV {
    
    public boolean InsertaInvInicial(BeansCavaPuntoVenta bcp){
        Calendar cl = new GregorianCalendar();
        int año = cl.get(Calendar.YEAR) ;
        int mes = cl.get(Calendar.MONTH);
        int dia = cl.get(Calendar.DAY_OF_MONTH);
        mes = mes + 1;
        dia = dia + 1;
        String insert = "INSERT INTO invinicialcavapv SET "
                + "referencia= '"+bcp.getReferencia()+"',"
                + "cantidad = '"+bcp.getCantidad()+"',"
                + "lote = '"+bcp.getLote()+"',"
                + "bajas= '"+bcp.getBajas()+"',"
                + "fecha = '"+año+"-"+mes+"-"+dia+" 12:00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(insert);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft- Ice: "+e);
        }
        return false;
    }//fin del metodo InsertaInvFinal
    
    public boolean InsertaInvFinal(BeansCavaPuntoVenta bcp){
        String insert = "INSERT INTO invfinalcavapv SET "
                + "referencia= '"+bcp.getReferencia()+"',"
                + "cantidad = '"+bcp.getCantidad()+"',"
                + "lote = '"+bcp.getLote()+"',"
                + "bajas= '"+bcp.getBajas()+"'";
          try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(insert);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft- Ice: "+e);
        }
        
        return false;
    }//fin del metodo inserta inventario inicial 
    
    public boolean InsertaInvInicialPVR(BeansCavaPuntoVenta bcp){
        String insert = "INSERT INTO invinicialcavapvr SET "
                + "referencia= '"+bcp.getReferencia()+"',"
                + "cantidad = '"+bcp.getCantidad()+"',"
                + "lote = '"+bcp.getLote()+"',"
                + "bajas= '"+bcp.getBajas()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(insert);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft- Ice: "+e);
        }
        return false;
    }//fin del metodo inserta inventario inicial Rionegro
    
    public boolean InsertaInvFinalPVR(BeansCavaPuntoVenta bcp){
         String insert = "INSERT INTO invfinalcavapvr SET "
                + "referencia= '"+bcp.getReferencia()+"',"
                + "cantidad = '"+bcp.getCantidad()+"',"
                + "lote = '"+bcp.getLote()+"',"
                + "bajas= '"+bcp.getBajas()+"'";
          try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(insert);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft- Ice: "+e);
        }
        
        return false;
    }
}
