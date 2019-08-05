
package DAO;
import Beans.BeansNotaCredito;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author USER
 */
public class DAONotaCredito {
    public boolean InsertarNotaCredito(BeansNotaCredito bn){
        String sql = "INSERT INTO notascredito SET "
                
                + "numeroNC = '"+bn.getNumeroNC()+"', "
                + "referencia = '"+bn.getReferencianc()+"', "
                + "cantidad = '"+bn.getCantidadnc()+"', "
                + "autorizadopor = '"+bn.getAutorizadorpor()+"', "
                + "abierta_cerrada = '"+ bn.getAbierta_cerrada()+"'";
        //generar consultas de las dos tablas y generar tabla de referencias ademas generar las operaciones.
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
