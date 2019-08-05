
package DAO;

import Beans.BeansConsultaPlastico;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOConsultaPlastico {
    
    public boolean ConsultarResultados(BeansConsultaPlastico bc){
        String sql = "UPDATE suma SET resultados = total - resta WHERE referencia = '"+ bc.getReferencia()+"'";
        
        try {    
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        
    }
   return true;  
}
     public boolean ActualizarResultado(BeansConsultaPlastico bc){
       String sql = "UPDATE suma SET resultados = resultados + sobra WHERE referencia = '"+ bc.getReferencia()+"'";
        
        try {    
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        
    }
         return true;
}
     
     public boolean RestaResultado(BeansConsultaPlastico bc){
         String sql = "UPDATE suma SET resultados = resultados - falta WHERE referencia = '"+bc.getReferencia()+"'";
         
         try {    
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        
    }
         
         
         return true;
     }
}
