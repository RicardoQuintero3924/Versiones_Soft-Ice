package DAO;

import Beans.BeansSobrantesFaltantes;
import Utils.Conexion;
//import VistasCC.PlasticoProveedoresTraslados;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOSobrantesFaltantes {

    public boolean InsertarSobrantesFaltantes(BeansSobrantesFaltantes bf) {
        String sql = "INSERT INTO sobrantes_faltantes SET "
                + "referencia = '" + bf.getReferenciaSF() + "', "
                + "motivo  = '" + bf.getMotivo() + "', "
                + "faltante = '" + bf.getFaltantes() + "', "
                + "observaciones = '" + bf.getObservaciones() + "'";

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

    public boolean InsertaSobraFalta(BeansSobrantesFaltantes bf) {

        String sql = "INSERT INTO suma SET  sobra = (SELECT SUM(faltante) FROM sobrantes_faltantes "
                + "WHERE motivo = 'SOBRANTE' AND referencia ='" + bf.getReferenciaSF() + "'), "
                + "falta = (SELECT SUM(faltante) FROM sobrantes_faltantes WHERE motivo= 'FALTANTE'"
                + " AND referencia = '" + bf.getReferenciaSF() + "'), referencia ='" + bf.getReferenciaSF() + "'";

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

    public boolean RestaResultado(BeansSobrantesFaltantes bf) {
        String sql = "UPDATE suma SET sobra_falta = sobra - falta WHERE referencia = '" + bf.getReferenciaSF().toString() + "'";

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
