package DAO;

import Beans.BeansTrasladoRuta;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class DAOTrasladosRuta {
    
    public void inserta(BeansTrasladoRuta btr){
        String insert = "INSERT INTO trasladoruta SET "
                      + "origen = '"+btr.getOrigen()+"',"
                      + "destino = '"+btr.getDestino()+"',"
                      + "referencia= '"+btr.getReferencia()+"',"
                      + "cantidad = '"+btr.getCantidad()+"',"
                      + "fecha = '"+btr.getFecha()+"',"
                      + "observaciones = '"+btr.getObservaciones()+"'";
        
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(insert);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR SOFT-ICE: "+ e);
        }
    }
    
}
