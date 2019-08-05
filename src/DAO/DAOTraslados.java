package DAO;

import Beans.BeansTraslados;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class DAOTraslados {
    public boolean InsertaTraslados(BeansTraslados bt){
        String sql = "INSERT INTO traslados SET "
                   + " origen= '"+bt.getOrigen()+"',"
                   + " destino= '"+ bt.getDestino()+"',"
                   + " transporte ='"+ bt.getTransporte()+"',"
                   + " referencia = '"+bt.getReferencia()+"',"
                   + " cantidad = '"+bt.getCantidad()+"',"
                   + " despachado_por = '"+ bt.getDespachado_por()+"',"
                   + " lote = '"+bt.getLote()+"',"
                   + " observa = '"+bt.getObserva()+"',"
                   + " remision ='"+bt.getRemision()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
}
