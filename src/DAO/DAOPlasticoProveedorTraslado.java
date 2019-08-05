package DAO;

import Beans.BeansPlasticoProveedorTraslados;

import Utils.Conexion;
import VistasCC.PlasticoProveedorTraslado;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOPlasticoProveedorTraslado extends PlasticoProveedorTraslado {

    PlasticoProveedorTraslado ppt = new PlasticoProveedorTraslado();
    
   
    public boolean InsertarPlasticoproveedorTraslado(BeansPlasticoProveedorTraslados bp) {
       
        String sql;
        sql = "INSERT INTO plasticobodegapt SET "
                + "referenciaP = '" + bp.getReferencia() + "',"
                + "tipomovimiento = '" + bp.getTipoMovimiento() + "',"
                + "provienede = '" + bp.getSalida() + "',"
                + "cantidad = '" + bp.getCantidad() + "',"
                + "nroremision = '" + bp.getNroremision() + "',"
                + "lote = '" + bp.getLote() + "'";
        //+ "turno =  '" + +"'";

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

    public boolean InsertarEntradaSalida(BeansPlasticoProveedorTraslados bp) {

        String sql;

        sql = "INSERT INTO suma SET total = ( SELECT SUM(cantidad) FROM plasticobodegapt "
                + "WHERE tipomovimiento = 'ENTRADA' AND referenciaP = '" + bp.getReferencia() + "'), "
                + "resta = (SELECT SUM(cantidad) from plasticobodegapt where tipomovimiento = 'SALIDA' AND referenciaP = '" + bp.getReferencia() + "')"
                + ",referencia = '" + bp.getReferencia() + "'";

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

    public boolean ActualizarResultado(BeansPlasticoProveedorTraslados bp) {
        String sql = "UPDATE suma SET resultados = total - resta WHERE referencia = '" + bp.getReferencia().toString() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            // st.execute("UPDATE suma SET sobra_falta = sobra - falta WHERE referencia = '"+ bp.getReferencia().toString()+"'");
            st.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return true;
    }

    public boolean NullCero(BeansPlasticoProveedorTraslados bp) {

        String sql = "UPDATE suma SET sobra_falta = 0 WHERE ISNULL(sobra_falta) = 1";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return true;
    }

    public boolean InsertarTurno(BeansPlasticoProveedorTraslados bp) {
        String sql = "INSERT INTO plasticobodegapt SET turno = (SELECT descripcion FROM turno WHERE referencia = " + bp.getReferencia().toString() + "'";

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
