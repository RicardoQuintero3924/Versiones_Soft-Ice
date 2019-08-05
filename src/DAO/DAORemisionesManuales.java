package DAO;

import Beans.BeansRemisionesManuales;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class DAORemisionesManuales {
    
    public void insertaRemisionesManuales(BeansRemisionesManuales brm){
        
        String insert = "INSERT INTO remisionesmanuales SET "
                + "referencia = '"+ brm.getReferencia()+" ',"
                + "ruta = '"+brm.getRuta()+"',"
                + "cliente = '"+brm.getCliente()+"',"
                + "nit = '"+brm.getNit()+"',"
                + "cantidad = '"+brm.getCantidad()+"',"
                + "fecha ='"+brm.getFecha()+"',"
                + "numeroR= '"+brm.getNremision()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(insert);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR SOFT-ICE: "+ e);
        }
        
        
    }
    
}
