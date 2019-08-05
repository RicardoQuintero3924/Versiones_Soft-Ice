package DAO;

import Beans.BeansDespachos;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAODespachos {

    public boolean InsertarDespachos(BeansDespachos bd) {
        String sql = "INSERT INTO despachos SET "
                + "turno = '" + bd.getTurno() + "', "
                + "nroruta = '" + bd.getRuta() + "', "
                + "referencia = '" + bd.getReferencia() + "', "
                + "cantidad = '" + bd.getCantidad() + "', "
                + "lote = '" + bd.getLote() + "', "
                + "despachado_por = '" + bd.getDespacho() + "',"
                + "planilla = '"+bd.getPlanilla()+"'";

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
