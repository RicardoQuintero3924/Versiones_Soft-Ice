package VistasCC;

import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//ESTA VISTA ME MANEJA LA CONSULTA DE LA LIQUIDACION DE LOS TRANSPORTADORES. LA CUAL SE DEBE GENERAR EN UNA TABLA DONDE SE FILTRE POR FECHA.
// ESTOS METODOS LOS DEBO UTILIZAR EN AJUSTES DE LIQUIDACION DE TRANSPORTADORES.
public final class ResumenFacturacion extends javax.swing.JFrame {

    //VARIABLES QUE EXTRAE DESPACHOS
    //int Iglui2 = 0;
    // int Poi15 = 0;
    // int Esquimali12 = 0;
    //int Articoi12 = 0;
    // int Colsui3 = 0;
    // int Esquii2 = 0;
    //int Polai2 = 0;
    int Polai3 = 0;
    int Polai12 = 0;
    int Polari20 = 0;
    int Escamai20 = 0;
    int Iglui7 = 0;
    int Parrai2 = 0;
    int Frescai2 = 0;
    int Iglucilii20 = 0;
    int Iglui15 = 0;
    int Iglui3 = 0;
    int Frescai3 = 0;
    int bloquei = 0;
    int cbloquei = 0;
    int miglui = 0;
    int parrandai12 = 0;
    int picadai20 = 0;

    //EXTRAE VENTAS
    //int Polar4 = 0;
    //int Polar15 = 0;
    //int Esquimal12 = 0;
    //int Artico12 = 0;
    //int Colsu3 = 0;
    //int Colsu3 = 0;
    //int Iglu2 = 0;
    //int Artico2 = 0;
    //int Polar2 = 0;
    int Polar3 = 0;
    int Polar12 = 0;
    int Polar20 = 0;
    int Escama20 = 0;
    int Iglu7 = 0;
    int Parra2 = 0;
    int Fresca2 = 0;
    int Iglucili20 = 0;
    int Iglu15 = 0;
    int Iglu3 = 0;
    int Fresca3 = 0;
// FALTA IMPLEMENTAR METODO PARA EXTRAER LA REMISIONES MANUALES
    public ResumenFacturacion() {
        initComponents();
        CargarRuta();
        Cargabd();
        btntotal.setVisible(false);

    }

    public void Conexion(String inser) {
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(inser);
        } catch (SQLException e) {
        }
    }

    public void CargarRuta() {
        String ruta = "SELECT codigo,nombre FROM rutasm";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(ruta);
            while (rs.next()) {
                cbxruta.addItem(rs.getString(1).concat(". ").concat(rs.getString(2)));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR SQL " + e);
        }

    }

    public void Cargabd() {
        //METODO PARA CARGAR LAS REFERENCIAS DE LA BASE DE DATOS
        String sql = "SELECT nombre FROM referencias ";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //  cbxreferencia.addItem(rs.getString(1));

            }
        } catch (SQLException ex) {

        }

    }

    public void ConsultaVentas() {

        DefaultTableModel dtm = new DefaultTableModel();
        //dtm.addColumn("RUTA");
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String[] arr = new String[2];
        String consul = "SELECT Cantidad,Producto FROM venta WHERE Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        String coni = cbxruta.getSelectedItem().toString();

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                //arr[0]= rs.getString(1);
                arr[0] = rs.getString(2);
                arr[1] = rs.getString(1);
                dtm.addRow(arr);
                tbventas.setModel(dtm);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void ConsultaDespachos() {
        DefaultTableModel dtm = new DefaultTableModel();
        //dtm.addColumn("RUTA");
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String[] arr = new String[3];
        String consul = "SELECT referencia,cantidad FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                //arr[0]=rs.getString(1);
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
                tbdespacho.setModel(dtm);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void extraeDespachos() {
      /**  String extraeCantidad = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'POLAR 2 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                Polai2 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }**/
        String extrae1 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'POLAR 3 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae1);
            while (rs.next()) {
                Polai3 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
        }
        String extrae2 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'POLAR 12 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae2);
            while (rs.next()) {
                Polai12 = rs.getInt("CANTIDAD");
                System.out.println(Polai12);

            }
        } catch (SQLException e) {
        }
        /**
         * String extrae3 = "SELECT SUM(cantidad) AS CANTIDAD FROM despachos
         * WHERE nroruta LIKE '%"+cbxruta.getSelectedItem()+"%' AND referencia =
         * 'POLAR 15 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND
         * '" + txthasta.getText() + "'" ; try { Connection con =
         * Conexion.conectar("mysql"); Statement st = con.createStatement();
         * ResultSet rs = st.executeQuery(extrae3); while (rs.next()) { Poi15 =
         * rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { }*
         */
        String extrae4 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'POLAR 20 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae4);
            while (rs.next()) {
                Polari20 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
        }
        String extrae5 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'ESCAMA 20 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae5);
            while (rs.next()) {
                Escamai20 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
        }
        /**
         * String extrae6 = "SELECT SUM(cantidad) AS CANTIDAD FROM despachos
         * WHERE nroruta LIKE '%"+cbxruta.getSelectedItem()+"%' AND referencia =
         * 'ESQUIMAL 12 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "'
         * AND '" + txthasta.getText() + "'" ; try { Connection con =
         * Conexion.conectar("mysql"); Statement st = con.createStatement();
         * ResultSet rs = st.executeQuery(extrae6); while (rs.next()) {
         * Esquimali12 = rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { } String extrae7 = "SELECT SUM(cantidad)
         * AS CANTIDAD FROM despachos WHERE nroruta LIKE
         * '%"+cbxruta.getSelectedItem()+"%' AND referencia = 'ARTICO 12 KILOS'
         * AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" +
         * txthasta.getText() + "'" ; try { Connection con =
         * Conexion.conectar("mysql"); Statement st = con.createStatement();
         * ResultSet rs = st.executeQuery(extrae7); while (rs.next()) {
         * Articoi12 = rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { }*
         */
        String extrae8 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'IGLU 7 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae8);
            while (rs.next()) {
                Iglui7 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
        }
        /**
         * String extrae9 = "SELECT SUM(cantidad) AS CANTIDAD FROM despachos
         * WHERE nroruta LIKE '%"+cbxruta.getSelectedItem()+"%' AND referencia =
         * 'COLSUBSIDIO 3 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "'
         * AND '" + txthasta.getText() + "'" ; try { Connection con =
         * Conexion.conectar("mysql"); Statement st = con.createStatement();
         * ResultSet rs = st.executeQuery(extrae9 ); while (rs.next()) { Colsui3
         * = rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { }*
         */
        String extrae10 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'PARRANDA 2 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae10);
            while (rs.next()) {
                Parrai2 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
        }
        /**
         * String extrae11= "SELECT SUM(cantidad) AS CANTIDAD FROM despachos
         * WHERE nroruta LIKE '%"+cbxruta.getSelectedItem()+"%' AND referencia =
         * 'ESQUIMAL 2 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND
         * '" + txthasta.getText() + "'" ; try { Connection con =
         * Conexion.conectar("mysql"); Statement st = con.createStatement();
         * ResultSet rs = st.executeQuery(extrae11); while (rs.next()) { Esquii2
         * = rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { }*
         */
        String extrae12 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'FRESCAMPO 2 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae12);
            while (rs.next()) {
                Frescai2 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
        }
        String extrae13 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'IGLU CILINDRO 20 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae13);
            while (rs.next()) {
                Iglucilii20 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
        }
        String extrae14 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'IGLU 15 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae14);
            while (rs.next()) {
                Iglui15 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
        }
        String extrae15 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'IGLU 3 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae15);
            while (rs.next()) {
                Iglui3 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
        }
        /**
         * String extrae16 = "SELECT SUM(cantidad) AS CANTIDAD FROM despachos
         * WHERE nroruta LIKE '%"+cbxruta.getSelectedItem()+"%' AND referencia =
         * 'IGLU 2 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '"
         * + txthasta.getText() + "'" ; try { Connection con =
         * Conexion.conectar("mysql"); Statement st = con.createStatement();
         * ResultSet rs = st.executeQuery(extrae16); while (rs.next()) { Iglui2
         * = rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { }*
         */
        String extrae17 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE nroruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND referencia = 'FRESCAMPO 3 KILOS' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae17);
            while (rs.next()) {
                Frescai3 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
        }
    }

    public void extraeRemisiones() {
    //IMPLEMENTAR EL METODO PARA SACAR LA SUMA DE LAS CANTIDADES DE LAS REMISIONES SEGUN EL RANGO DE FECHA
    }

    public void extraeVentas() {
      /**  String consul = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%POLAR 2%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                Polar2 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }**/
        String consul1 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%POLAR 3%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul1);
            while (rs.next()) {
                Polar3 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        String consul2 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%POLAR 12%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul2);
            while (rs.next()) {
                Polar12 = rs.getInt("CANTIDAD");
                //System.out.println(Polar12);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        /**
         * String consul3 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE
         * Producto LIKE '%POLAR 15%' AND Ruta LIKE
         * '%"+cbxruta.getSelectedItem()+"%' AND Fecha BETWEEN
         * '"+txtdesde.getText()+"' AND '"+txthasta.getText()+"'"; try {
         * Connection con = Conexion.conectar("mysql"); Statement st =
         * con.createStatement(); ResultSet rs = st.executeQuery(consul3);
         * while(rs.next()){ Polar15 = rs.getInt("CANTIDAD"); } } catch
         * (SQLException e) { System.out.println(e); }*
         */
        String consul4 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%POLAR 20%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul4);
            while (rs.next()) {
                Polar20 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        String consul5 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%ESCAMA 20%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul5);
            while (rs.next()) {
                Escama20 = rs.getInt("CANTIDAD");
                System.out.println("escama 20 kilos de ventas " + Escama20);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        /**
         * String consul6 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE
         * Producto LIKE '%ESQUIMAL 12%' AND Ruta LIKE
         * '%"+cbxruta.getSelectedItem()+"%' AND Fecha BETWEEN
         * '"+txtdesde.getText()+"' AND '"+txthasta.getText()+"'"; try {
         * Connection con = Conexion.conectar("mysql"); Statement st =
         * con.createStatement(); ResultSet rs = st.executeQuery(consul6);
         * while(rs.next()){ Esquimal12 = rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { System.out.println(e); } String consul7 =
         * "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE
         * '%ARTICO 12%' AND Ruta LIKE '%"+cbxruta.getSelectedItem()+"%' AND
         * Fecha BETWEEN '"+txtdesde.getText()+"' AND '"+txthasta.getText()+"'";
         * try { Connection con = Conexion.conectar("mysql"); Statement st =
         * con.createStatement(); ResultSet rs = st.executeQuery(consul7);
         * while(rs.next()){ Artico12 = rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { System.out.println(e); }*
         */
        String consul8 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%IGLU 7%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul8);
            while (rs.next()) {
                Iglu7 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        /**
         * String consul9 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE
         * Producto LIKE '%COLSUBSIDIO 3%' AND Ruta LIKE
         * '%"+cbxruta.getSelectedItem()+"%' AND Fecha BETWEEN
         * '"+txtdesde.getText()+"' AND '"+txthasta.getText()+"'"; try {
         * Connection con = Conexion.conectar("mysql"); Statement st =
         * con.createStatement(); ResultSet rs = st.executeQuery(consul9);
         * while(rs.next()){ Colsu3 = rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { System.out.println(e); }*
         */
        String consul10 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%PARRANDA 2%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul10);
            while (rs.next()) {
                Parra2 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        /**
         * String consul11 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE
         * Producto LIKE '%ESQUIMAL 2%' AND Ruta LIKE
         * '%"+cbxruta.getSelectedItem()+"%' AND Fecha BETWEEN
         * '"+txtdesde.getText()+"' AND '"+txthasta.getText()+"'"; try {
         * Connection con = Conexion.conectar("mysql"); Statement st =
         * con.createStatement(); ResultSet rs = st.executeQuery(consul11);
         * while(rs.next()){ Esqui2 = rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { System.out.println(e); }*
         */
        String consul12 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%FRESCAMPO 2%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul12);
            while (rs.next()) {
                Fresca2 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        String consul13 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%IGLU 20 KG%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul13);
            while (rs.next()) {
                Iglucili20 = rs.getInt("CANTIDAD");
                System.out.println("Bolsa de hielo iglu 20 kg venta " + Iglucili20);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        String consul14 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%IGLU 15%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul14);
            while (rs.next()) {
                Iglu15 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        String consul15 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%IGLU 3%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul15);
            while (rs.next()) {
                Iglu3 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        /**
         * String consul16 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE
         * Producto LIKE '%IGLU 2%' AND Ruta LIKE
         * '%"+cbxruta.getSelectedItem()+"%' AND Fecha BETWEEN
         * '"+txtdesde.getText()+"' AND '"+txthasta.getText()+"'"; try {
         * Connection con = Conexion.conectar("mysql"); Statement st =
         * con.createStatement(); ResultSet rs = st.executeQuery(consul16);
         * while(rs.next()){ Iglu2 = rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { System.out.println(e); } String consul18 =
         * "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE
         * '%ARTICO 2%' AND Ruta LIKE '%"+cbxruta.getSelectedItem()+"%' AND
         * Fecha BETWEEN '"+txtdesde.getText()+"' AND '"+txthasta.getText()+"'";
         * try { Connection con = Conexion.conectar("mysql"); Statement st =
         * con.createStatement(); ResultSet rs = st.executeQuery(consul18);
         * while(rs.next()){ Artico2 = rs.getInt("CANTIDAD");
         *
         * }
         * } catch (SQLException e) { System.out.println(e); }*
         */
        String consul17 = "SELECT SUM(Cantidad) AS CANTIDAD FROM venta WHERE Producto LIKE '%FRESCAMPO 3%' AND Ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul17);
            while (rs.next()) {
                Fresca3 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void Operaciones() {
        int diferencia;
      /**  diferencia = Polar2 - Polai2;
        String inser = "INSERT INTO resumenfacturacion SET referencia = 'POLAR 2 KILOS', diferencia = " + diferencia + ", despacho = " + Polai2 + ", venta=" + Polar2 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser);**/

        diferencia = Polar3 - Polai3;
        String inser1 = "INSERT INTO resumenfacturacion SET referencia = 'POLAR 4 KILOS', diferencia = " + diferencia + ", despacho = " + Polai3 + ", venta=" + Polar3 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser1);

        diferencia = Polar12 - Polai12;
        String inser2 = "INSERT INTO resumenfacturacion SET referencia = 'POLAR 12 KILOS', diferencia = " + diferencia + ", despacho = " + Polai12 + ", venta=" + Polar12 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser2);

        /**
         * diferencia = Polar15 - Poi15; String inser3 = "INSERT INTO
         * resumenfacturacion SET referencia = 'POLAR 15 KILOS', diferencia =
         * "+diferencia+", despacho = "+Poi15+", venta="+Polar15+", ruta =
         * '"+cbxruta.getSelectedItem()+"'"; Conexion(inser3);*
         */
        diferencia = Polar20 - Polari20;
        String inser4 = "INSERT INTO resumenfacturacion SET referencia = 'POLAR 20 KILOS', diferencia = " + diferencia + ", despacho = " + Polari20 + ", venta=" + Polar20 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser4);

        diferencia = Escama20 - Escamai20;
        String inser5 = "INSERT INTO resumenfacturacion SET referencia = 'ESCAMA 20 KILOS', diferencia = " + diferencia + ", despacho = " + Escamai20 + ", venta=" + Escama20 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser5);

        /**
         * diferencia = Esquimal12 - Esquimali12; String inser7 = "INSERT INTO
         * resumenfacturacion SET referencia = 'ESQUIMAL 12 KILOS', diferencia =
         * "+diferencia+", despacho = "+Esquimali12+", venta="+Esquimal12+",
         * ruta = '"+cbxruta.getSelectedItem()+"'"; Conexion(inser7);
         *
         * diferencia = Artico12 - Articoi12; String inser8 = "INSERT INTO
         * resumenfacturacion SET referencia = 'ARTICO 12 KILOS', diferencia =
         * "+diferencia+", despacho = "+Articoi12+", venta="+Artico12+", ruta =
         * '"+cbxruta.getSelectedItem()+"'"; Conexion(inser8);*
         */
        diferencia = Iglu7 - Iglui7;
        String inser9 = "INSERT INTO resumenfacturacion SET referencia = 'IGLU 7 KILOS', diferencia = " + diferencia + ", despacho = " + Iglui7 + ", venta=" + Iglu7 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser9);

        /**
         * diferencia = Colsu3 - Colsui3; String inser10 = "INSERT INTO
         * resumenfacturacion SET referencia = 'COLSUBSIDIO 3 KILOS', diferencia
         * = "+diferencia+", despacho = "+Colsui3+", venta="+Colsu3+", ruta =
         * '"+cbxruta.getSelectedItem()+"'"; Conexion(inser10);*
         */
        diferencia = Parra2 - Parrai2;
        String inser11 = "INSERT INTO resumenfacturacion SET referencia = 'PARRANDA 2 KILOS', diferencia = " + diferencia + ", despacho = " + Parrai2 + ", venta=" + Parra2 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser11);

        /**
         * diferencia = Esqui2 - Esquii2; String inser12 = "INSERT INTO
         * resumenfacturacion SET referencia = 'ESQUIMAL 2 KILOS', diferencia =
         * "+diferencia+", despacho = "+Esquii2+", venta="+Esqui2+", ruta =
         * '"+cbxruta.getSelectedItem()+"'"; Conexion(inser12);*
         */
        diferencia = Fresca2 - Frescai2;
        String inser13 = "INSERT INTO resumenfacturacion SET referencia = 'FRESCAMPO 2 KILOS', diferencia = " + diferencia + ", despacho = " + Frescai2 + ", venta=" + Fresca2 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser13);

        diferencia = Iglucili20 - Iglucilii20;
        System.out.println(diferencia);
        String inser14 = "INSERT INTO resumenfacturacion SET referencia = 'IGLU CILINDRO 20 KILOS', diferencia = " + diferencia + ", despacho = " + Iglucilii20 + ", venta=" + Iglucili20 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser14);

        diferencia = Iglu15 - Iglui15;
        String inser15 = "INSERT INTO resumenfacturacion SET referencia = 'IGLU 15 KILOS', diferencia = " + diferencia + ", despacho = " + Iglui15 + ", venta=" + Iglu15 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser15);

        diferencia = Iglu3 - Iglui3;
        String inser16 = "INSERT INTO resumenfacturacion SET referencia = 'IGLU 3 KILOS', diferencia = " + diferencia + ", despacho = " + Iglui3 + ", venta=" + Iglu3 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser16);

        /**
         * diferencia = Artico2 + Iglu2 - Iglui2; String inser17 = "INSERT INTO
         * resumenfacturacion SET referencia = 'IGLU 2 KILOS', diferencia =
         * "+diferencia+", despacho = "+Iglui2+", venta="+Iglu2+", ruta =
         * '"+cbxruta.getSelectedItem()+"'"; Conexion(inser17);*
         */
        diferencia = Fresca3 - Frescai3;
        String inser18 = "INSERT INTO resumenfacturacion SET referencia = 'FRESCAMPO 3 KILOS', diferencia = " + diferencia + ", despacho = " + Frescai3 + ", venta=" + Fresca3 + ", ruta = '" + cbxruta.getSelectedItem() + "'";
        Conexion(inser18);
    }

    public void ConsultaDiferencia() {
        DefaultTableModel dtm = new DefaultTableModel();
        //dtm.addColumn("RUTA");
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String[] arr = new String[2];
        String consul = "SELECT referencia,diferencia FROM resumenfacturacion WHERE ruta LIKE '%" + cbxruta.getSelectedItem() + "%' AND  fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                //arr[0]=rs.getString(1);
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
                tbdiferencia.setModel(dtm);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void ConsultaRemisiones() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String arr[] = new String[2];

        String cons = "SELECT referencia,cantidad FROM remisionesmanuales WHERE ruta = '" + txtruta.getText() + "' AND fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
                tbremisiones.setModel(dtm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR SOFT-ICE " + e);
        }

    }

    public void ConsultaObsequio() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String arr[] = new String[2];
        String obs = "SELECT Producto,Cantidad FROM venta WHERE Identificacion = '999' AND Razon_Social = 'OBSEQUIO' AND Ruta = '" + cbxruta.getSelectedItem() + "' AND Fecha BETWEEN '" + txtdesde.getText() + "' AND '" + txthasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(obs);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
                tbobsequio.setModel(dtm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR SOFT-ICE " + e);
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxruta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnconsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdespacho = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbventas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbdiferencia = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtdesde = new javax.swing.JTextField();
        txthasta = new javax.swing.JTextField();
        btntotal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbremisiones = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbobsequio = new javax.swing.JTable();
        txtruta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LIQUIDACION TRANSPORTADORES");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("LIQUIDACION DE TRANSPORTADORES");

        cbxruta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("RUTA:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("FECHA / INICIAL");

        btnconsulta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnconsulta.setText("CONSULTA");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });

        tbdespacho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbdespacho);

        tbventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbventas);

        tbdiferencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbdiferencia);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("DESPACHOS:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("VENTAS:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("DIFERENCIA:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("FECHA FINAL");

        btntotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btntotal.setText("TOTAL");
        btntotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("REMISIONES MANUALES:");

        tbremisiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbremisiones);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("OBSEQUIOS:");

        tbobsequio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbobsequio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxruta, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdesde, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txthasta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btntotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(216, 216, 216)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtdesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txthasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btntotal)
                            .addComponent(btnconsulta))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed

        ConsultaDespachos();
        ConsultaVentas();
        ConsultaRemisiones();
        ConsultaObsequio();
        extraeDespachos();
        extraeVentas();

        btntotal.setVisible(true);

    }//GEN-LAST:event_btnconsultaActionPerformed

    private void btntotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalActionPerformed
        // TODO add your handling code here:
        Operaciones();
        ConsultaDiferencia();

    }//GEN-LAST:event_btntotalActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResumenFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResumenFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResumenFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResumenFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResumenFacturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btntotal;
    private javax.swing.JComboBox<String> cbxruta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tbdespacho;
    private javax.swing.JTable tbdiferencia;
    private javax.swing.JTable tbobsequio;
    private javax.swing.JTable tbremisiones;
    private javax.swing.JTable tbventas;
    private javax.swing.JTextField txtdesde;
    private javax.swing.JTextField txthasta;
    private javax.swing.JTextField txtruta;
    // End of variables declaration//GEN-END:variables
}
