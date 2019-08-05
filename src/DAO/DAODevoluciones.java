
package DAO;

import Beans.BeansDespachos;
import Beans.BeansDevoluciones;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DAODevoluciones {

    public boolean Devoluciones(BeansDevoluciones bd) {
        String sql = "UPDATE despachos SET cantidad = cantidad -'" + bd.getDevolucion()
                + "' WHERE referencia = '" + bd.getReferencia() + "' AND nroruta = '"
                + bd.getRuta() + "' AND fecha like '%" + bd.getFecha() + "%'";

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

    public boolean InsertarDevoluciones(BeansDevoluciones bd) {
        String sql = "INSERT INTO devoluciones SET "
                + "referencia = '" + bd.getReferencia() + "', "
                + "cantidad = '" + bd.getDevolucion() + "', "
                + "turno = '" + bd.getTurno() + "', "
                + "despachador = '" + bd.getDespacha() + "', "
                + "observaciones = '" + bd.getObservaciones() + "',"
                + "ruta = '" + bd.getRuta() + "',"
                + "estado ='"+ bd.getEstado()+ "',"
                + "descripcionEs = '"+bd.getDescripcion()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

}
