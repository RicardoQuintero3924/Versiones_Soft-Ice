package DAO;

import Beans.BeansPuntoVenta;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class DAOPuntoVenta {
    
   public boolean insertaPVentaD (BeansPuntoVenta bpv){
       String sql = "INSERT INTO puntoventadespachos SET "
                  + " ruta = '"+bpv.getRuta()+"',"
                  + " referencia = '"+bpv.getReferencia()+"',"
                  + " cantidad = '"+bpv.getCantidad()+"',"
                  + " placa = '"+bpv.getPlaca()+"',"
                  + " vendedor = '"+bpv.getVendedor()+"',"
                  + " lote = '"+bpv.getLote()+"'";
       
       try {
           Connection con = Conexion.conectar("mysql");
           Statement st = con.createStatement();
           st.execute(sql);
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: "+ e);
       }   
       return false;
   }
    
   public boolean insertaDevolucion (BeansPuntoVenta bpv){
       String sql = "INSERT INTO puntoventadevoluciones SET "
                  + " ruta = '"+bpv.getRuta()+"',"
                  + " referencia = '"+bpv.getReferencia()+"',"
                  + " cantidad = '"+bpv.getCantidad()+"',"
                  + " placa = '"+bpv.getPlaca()+"',"
                  + " vendedor = '"+bpv.getVendedor()+"',"
                  + " lote = '"+bpv.getLote()+"'";
       try {
           Connection con = Conexion.conectar("mysql");
           Statement st = con.createStatement();
           st.execute(sql);
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: "+e);
       }  
       return false;
   }
}
