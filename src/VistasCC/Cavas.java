package VistasCC;

import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Cavas extends javax.swing.JFrame {

    int produccion = 0;
    int Polar2 = 0;
    //int Polar3 = 0;
    int Iglu500 = 0;
    int Polar12 = 0;
    int Picadat = 0;
    int Polar20 = 0;
    int Escama20 = 0;
    int Parranda12 = 0;
    int Bloque = 0;
    int Iglu7 = 0;
    int Cbloque = 0;
    int Parra2 = 0;
    int Polar3 = 0;
    int Fresca2 = 0;
    int Iglucili20 = 0;
    int Iglu15 = 0;
    int Iglu3 = 0;
    int Iglu2 = 0;
    int Fresca3 = 0;
    //aqui terminan las variables del metodo extraeProduccion()
    int Polb2 = 0;
    int Iglu500b = 0;
    int Polab12 = 0;
    int Picadatb = 0;
    int Polb20 = 0;
    int Escab20 = 0;
    int Parrab12 = 0;
    int Bloqueb = 0;
    int Igb7 = 0;
    int Cbloqueb = 0;
    int Parb2 = 0;
    int Polarb3 = 0;
    int Fresb2 = 0;
    int Igcib20 = 0;
    int Igb15 = 0;
    int Igb3 = 0;
    int Igb2 = 0;
    int Fresb3 = 0;
    //aqui terminan las variables de extraeBajas
    int Polf2 = 0;
    int Igluf500 = 0;
    int Polaf12 = 0;
    int Picadatf = 0;
    int Polf20 = 0;
    int Escaf20 = 0;
    int Parraf12 = 0;
    int Bloquef = 0;
    int Igf7 = 0;
    int Cbloquef = 0;
    int Parf2 = 0;
    int Polarf3 = 0;
    int Fresf2 = 0;
    int Igcif20 = 0;
    int Igf15 = 0;
    int Igf3 = 0;
    int Igf2 = 0;
    int Fresf3 = 0;
    //aqui terminan las variables del metodo extraeFinal()
    int Polai2 = 0;
    int Iglui500 = 0;
    int Polai12 = 0;
    int Picadati = 0;
    int Polari20 = 0;
    int Escamai20 = 0;
    int Parrandai12 = 0;
    int Bloquei = 0;
    int Iglui7 = 0;
    int Cbloquei = 0;
    int Parrai2 = 0;
    int Polari3 = 0;
    int Frescai2 = 0;
    int Iglucilii20 = 0;
    int Iglui15 = 0;
    int Iglui3 = 0;
    int Iglui2 = 0;
    int Frescai3 = 0;
    //aqui terminan las variables de extraeDespachos()
    int Pol2 = 0;
    int Iglu500in = 0;
    int Pola12 = 0;
    int Picad = 0;
    int Pol20 = 0;
    int Esca20 = 0;
    int Parrand12 = 0;
    int Bloqu = 0;
    int Ig7 = 0;
    int Cbloqu = 0;
    int Par2 = 0;
    int Polar3in = 0;
    int Fres2 = 0;
    int Igci20 = 0;
    int Ig15 = 0;
    int Ig3 = 0;
    int Ig2 = 0;
    int Fres3 = 0;
    int diferencia;
    // aqui terminan las variables globales para inventarioInicial()
    public Cavas() {
        initComponents();
        Cargabd();
        turnos();
        this.cbxturno.addItem("Turno 1");
        this.cbxturno.addItem("Turno 2");
        this.cbxturno.addItem("Turno 3");
        //btnajustes.setEnabled(false); 
        btnajustes.setVisible(false);

    }

    public void turnos() {
        String turno1 = "21:00:00";
        String turno2 = "05:00:00";
        String turno3 = "13:00:00";
        this.cbxdesde.addItem(turno1);
        this.cbxdesde.addItem(turno2);
        this.cbxdesde.addItem(turno3);
        this.cbxhasta.addItem(turno1);
        this.cbxhasta.addItem(turno2);
        this.cbxhasta.addItem(turno3);
    }

    public void Cargabd() {
        //METODO PARA CARGAR LAS REFERENCIAS DE LA BASE DE DATOS
        String sql = "SELECT nombre FROM referenciasmedellin ";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cbxreferencia.addItem(rs.getString(1));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void insertOperario() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        mes = mes + 1;
        hora = hora - 2;
        String insert = "INSERT INTO invfinalcava SET turno = '" + cbxturno.getSelectedItem() + "', referencia='" + cbxreferencia.getSelectedItem() + "', cantidad='" + txtcantidad.getText() + "', lote= '" + txtlote.getText() + "', baja = '" + txtbaja.getText() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(insert);
        } catch (SQLException e) {
            System.out.println(e);
        }
        JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");

    }//ingresa el inventario final de la cava 
    
    //crear metodo para guardar el inventario final de la cava del turno tres. 
    // public void guardaFinal(){}

    public void insertaInicial() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        mes = mes + 1;
        hora = hora + 3;
        String inser = "INSERT INTO invenincava SET cantidad = '" + txtcantidad.getText() + "', referencia= '" + cbxreferencia.getSelectedItem() + "', fecha='" + año + "-" + mes + "-" + dia + " " + hora + ":00:00', turno = '" + cbxturno.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(inser);
        } catch (SQLException e) {
            System.out.println("inicial " + e);
        }

    }//inserta el inventario inicial de la cava

    public void extraeProduccion() {
        String extraeCantidad = "SELECT cantidad  FROM produccion WHERE referencia = 'POLAR 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                Polar2 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae1 = "SELECT cantidad FROM produccion WHERE referencia = 'IGLU 500 GRAMOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae1);
            while (rs.next()) {
                Iglu500 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae2 = "SELECT cantidad FROM produccion WHERE referencia = 'POLAR 12 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae2);
            while (rs.next()) {
                Polar12 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae3 = "SELECT cantidad FROM produccion WHERE referencia = 'PICADA TRANSP 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae3);
            while (rs.next()) {
                Picadat = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae4 = "SELECT cantidad FROM produccion WHERE referencia = 'POLAR 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae4);
            while (rs.next()) {
                Polar20 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae5 = "SELECT cantidad FROM produccion WHERE referencia = 'ESCAMA 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae5);
            while (rs.next()) {
                Escama20 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String extrae6 = "SELECT cantidad FROM produccion WHERE referencia = 'PARRANDA 12 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae6);
            while (rs.next()) {
                Parranda12 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae7 = "SELECT cantidad FROM produccion WHERE referencia = 'BLOQUE 25 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae7);
            while (rs.next()) {
                Bloque = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae8 = "SELECT cantidad FROM produccion WHERE referencia = 'IGLU 7 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae8);
            while (rs.next()) {
                Iglu7 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae9 = "SELECT cantidad FROM produccion WHERE referencia = 'CUARTO DE BLOQUE' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae9);
            while (rs.next()) {
                Cbloque = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae10 = "SELECT cantidad FROM produccion WHERE referencia = 'PARRANDA 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae10);
            while (rs.next()) {
                Parra2 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae11 = "SELECT cantidad FROM produccion WHERE referencia = 'POLAR 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae11);
            while (rs.next()) {
                Polar3 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae12 = "SELECT cantidad FROM produccion WHERE referencia = 'FRESCAMPO 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae12);
            while (rs.next()) {
                Fresca2 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae13 = "SELECT cantidad FROM produccion WHERE referencia = 'IGLU 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae13);
            while (rs.next()) {
                Iglucili20 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae14 = "SELECT cantidad FROM produccion WHERE referencia = 'IGLU 15 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae14);
            while (rs.next()) {
                Iglu15 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae15 = "SELECT cantidad FROM produccion WHERE referencia = 'IGLU 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae15);
            while (rs.next()) {
                Iglu3 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae16 = "SELECT cantidad FROM produccion WHERE referencia = 'IGLU 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae16);
            while (rs.next()) {
                Iglu2 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae17 = "SELECT cantidad FROM produccion WHERE referencia = 'FRESCAMPO 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae17);
            while (rs.next()) {
                Fresca3 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }

    }//extrae la produccion del turno

    public void extraeDespachos() {
        String extraeCantidad = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'POLAR 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                Polai2 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae1 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'IGLU 500 GRAMOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae1);
            while (rs.next()) {
                Iglui500 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae2 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'POLAR 12 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae2);
            while (rs.next()) {
                Polai12 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae3 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'PICADA TRANSP 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae3);
            while (rs.next()) {
                Picadati = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae4 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'POLAR 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae4);
            while (rs.next()) {
                Polari20 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae5 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'ESCAMA 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae5);
            while (rs.next()) {
                Escamai20 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae6 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'PARRANDA 12 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae6);
            while (rs.next()) {
                Parrandai12 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae7 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'BLOQUE 25 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae7);
            while (rs.next()) {
                Bloquei = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae8 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'IGLU 7 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae8);
            while (rs.next()) {
                Iglui7 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae9 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'CUARTO DE BLOQUE' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae9);
            while (rs.next()) {
                Cbloquei = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae10 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'PARRANDA 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae10);
            while (rs.next()) {
                Parrai2 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae11 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'POLAR 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae11);
            while (rs.next()) {
                Polari3 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae12 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'FRESCAMPO 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae12);
            while (rs.next()) {
                Frescai2 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae13 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'IGLU 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae13);
            while (rs.next()) {
                Iglucilii20 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae14 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'IGLU 15 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae14);
            while (rs.next()) {
                Iglui15 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae15 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'IGLU 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae15);
            while (rs.next()) {
                Iglui3 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae16 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'IGLU 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae16);
            while (rs.next()) {
                Iglui2 = rs.getInt("CANTIDAD");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae17 = "SELECT SUM(cantidad) AS CANTIDAD  FROM despachos WHERE referencia = 'FRESCAMPO 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae17);
            while (rs.next()) {
                Frescai3 = rs.getInt("CANTIDAD");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }

    }// extrae los despachos que se realizaron en el turno

    public void extraeInicial() {
        String extraeCantidad = "SELECT cantidad  FROM invenincava WHERE referencia = 'POLAR 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                Pol2 = rs.getInt("cantidad");   
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae1 = "SELECT cantidad FROM invenincava WHERE referencia = 'IGLU 500 GRAMOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae1);
            while (rs.next()) {

                Iglu500in = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae2 = "SELECT cantidad FROM invenincava WHERE referencia = 'POLAR 12 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae2);
            while (rs.next()) {
                Pola12 = rs.getInt("cantidad");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae3 = "SELECT cantidad FROM invenincava WHERE referencia = 'PICADA TRANSP 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae3);
            while (rs.next()) {
                Picad = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae4 = "SELECT cantidad FROM invenincava WHERE referencia = 'POLAR 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae4);
            while (rs.next()) {
                Pol20 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae5 = "SELECT cantidad FROM invenincava WHERE referencia = 'ESCAMA 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae5);
            while (rs.next()) {
                Esca20 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae6 = "SELECT cantidad FROM invenincava WHERE referencia = 'PARRANDA 12 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae6);
            while (rs.next()) {
                Parrand12 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae7 = "SELECT cantidad FROM invenincava WHERE referencia = 'BLOQUE 25 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae7);
            while (rs.next()) {
                Bloqu = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae8 = "SELECT cantidad FROM invenincava WHERE referencia = 'IGLU 7 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae8);
            while (rs.next()) {
                Ig7 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae9 = "SELECT cantidad FROM invenincava WHERE referencia = 'CUARTO DE BLOQUE' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae9
            );
            while (rs.next()) {
                Cbloqu = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
        }
        String extrae10 = "SELECT cantidad FROM invenincava WHERE referencia = 'PARRANDA 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae10);
            while (rs.next()) {
                Par2 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae11 = "SELECT cantidad FROM invenincava WHERE referencia = 'POLAR 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae11);
            while (rs.next()) {
                Polar3in = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae12 = "SELECT cantidad FROM invenincava WHERE referencia = 'FRESCAMPO 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae12);
            while (rs.next()) {
                Fres2 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae13 = "SELECT cantidad FROM invenincava WHERE referencia = 'IGLU 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae13);
            while (rs.next()) {
                Igci20 = rs.getInt("cantidad");

                
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae14 = "SELECT cantidad FROM invenincava WHERE referencia = 'IGLU 15 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae14);
            while (rs.next()) {
                Ig15 = rs.getInt("cantidad");

                
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae15 = "SELECT cantidad FROM invenincava WHERE referencia = 'IGLU 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae15);
            while (rs.next()) {
                Ig3 = rs.getInt("cantidad");  
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae16 = "SELECT cantidad FROM invenincava WHERE referencia = 'IGLU 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae16);
            while (rs.next()) {
                Ig2 = rs.getInt("cantidad");

               
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae17 = "SELECT cantidad FROM invenincava WHERE referencia = 'FRESCAMPO 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae17);
            while (rs.next()) {
                Fres3 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }

    }// extrae el inventario inicial

    public void extraeFinal() {

        String extraeCantidad = "SELECT cantidad  FROM invfinalcava WHERE referencia = 'POLAR 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                Polf2 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae1 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'IGLU 500 GRAMOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae1);
            while (rs.next()) {

                Igluf500 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae2 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'POLAR 12 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae2);
            while (rs.next()) {
                Polaf12 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae3 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'PICADA TRANSP 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae3);
            while (rs.next()) {
                Picadatf = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae4 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'POLAR 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae4);
            while (rs.next()) {
                Polf20 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae5 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'ESCAMA 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae5);
            while (rs.next()) {
                Escaf20 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae6 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'PARRANDA 12 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae6);
            while (rs.next()) {
                Parraf12 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae7 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'BLOQUE 25 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae7);
            while (rs.next()) {
                Bloquef = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae8 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'IGLU 7 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae8);
            while (rs.next()) {
                Igf7 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae9 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'CUARTO DE BLOQUE' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae9
            );
            while (rs.next()) {
                Cbloquef = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae10 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'PARRANDA 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae10);
            while (rs.next()) {
                Parf2 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae11 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'POLAR 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae11);
            while (rs.next()) {
                Polarf3 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae12 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'FRESCAMPO 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae12);
            while (rs.next()) {
                Fresf2 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae13 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'IGLU 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae13);
            while (rs.next()) {
                Igcif20 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae14 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'IGLU 15 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae14);
            while (rs.next()) {
                Igf15 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae15 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'IGLU 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae15);
            while (rs.next()) {
                Igf3 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae16 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'IGLU 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae16);
            while (rs.next()) {
                Igf2 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae17 = "SELECT cantidad FROM invfinalcava WHERE referencia = 'FRESCAMPO 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae17);
            while (rs.next()) {
                Fresf3 = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }

    }// extrae el inventario final de la cava

    public void extraebajas() {

        String extraeCantidad = "SELECT baja  FROM invfinalcava WHERE referencia = 'POLAR 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                Polb2 = rs.getInt("baja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae1 = "SELECT baja FROM invfinalcava WHERE referencia = 'IGLU 500 GRAMOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae1);
            while (rs.next()) {

                Iglu500b = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae2 = "SELECT baja FROM invfinalcava WHERE referencia = 'POLAR 12 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae2);
            while (rs.next()) {
                Polab12 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae3 = "SELECT baja FROM invfinalcava WHERE referencia = 'PICADA TRANSP 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae3);
            while (rs.next()) {
                Picadatb = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae4 = "SELECT baja FROM invfinalcava WHERE referencia = 'POLAR 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae4);
            while (rs.next()) {
                Polb20 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae5 = "SELECT baja FROM invfinalcava WHERE referencia = 'ESCAMA 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae5);
            while (rs.next()) {
                Escab20 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae6 = "SELECT baja FROM invfinalcava WHERE referencia = 'PARRANDA 12 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae6);
            while (rs.next()) {
                Parrab12 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae7 = "SELECT baja FROM invfinalcava WHERE referencia = 'BLOQUE 25 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae7);
            while (rs.next()) {
                Bloqueb = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae8 = "SELECT baja FROM invfinalcava WHERE referencia = 'IGLU 7 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae8);
            while (rs.next()) {
                Igb7 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae9 = "SELECT baja FROM invfinalcava WHERE referencia = 'CUARTO DE BLOQUE' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae9
            );
            while (rs.next()) {
                Cbloqueb = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae10 = "SELECT baja FROM invfinalcava WHERE referencia = 'PARRANDA 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae10);
            while (rs.next()) {
                Parb2 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae11 = "SELECT baja FROM invfinalcava WHERE referencia = 'POLAR 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae11);
            while (rs.next()) {
                Polarb3 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae12 = "SELECT baja FROM invfinalcava WHERE referencia = 'FRESCAMPO 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae12);
            while (rs.next()) {
                Fresb2 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae13 = "SELECT baja FROM invfinalcava WHERE referencia = 'IGLU 20 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae13);
            while (rs.next()) {
                Igcib20 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae14 = "SELECT baja FROM invfinalcava WHERE referencia = 'IGLU 15 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae14);
            while (rs.next()) {
                Igb15 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae15 = "SELECT baja FROM invfinalcava WHERE referencia = 'IGLU 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae15);
            while (rs.next()) {
                Igb3 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae16 = "SELECT baja FROM invfinalcava WHERE referencia = 'IGLU 2 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae16);
            while (rs.next()) {
                Igb2 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String extrae17 = "SELECT baja FROM invfinalcava WHERE referencia = 'FRESCAMPO 3 KILOS' AND fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae17);
            while (rs.next()) {
                Fresb3 = rs.getInt("baja");

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }

    }// extrae las bajas de plastico de la cava

    public void visualizaProduccion() {
        tbproduccion.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("PRODUCCION");
        String[] arr = new String[2];
        String extraeCantidad = "SELECT referencia,cantidad  FROM produccion WHERE fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                tbproduccion.setModel(dtm);
                dtm.addRow(arr);
              
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
    }// muestra la informacion de la produccion del turno

    public void visualizaDespachos() {
        tbdespachos.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("DESPACHOS");
        String[] arr = new String[2];
        String extraeCantidad = "SELECT referencia,cantidad  FROM despachos WHERE fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                tbdespachos.setModel(dtm);
                dtm.addRow(arr);
               
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
    }// muestra la informacion de los despachos del turno

    public void visualizaInvInicial() {
        tbinvInicial.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String[] arr = new String[2];
        String extraeCantidad = "SELECT referencia,cantidad  FROM invenincava WHERE fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                tbinvInicial.setModel(dtm);
                dtm.addRow(arr);
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
    }

    public void visualizaBajas() {
        tbbajas.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String[] arr = new String[2];
        String extraeCantidad = "SELECT referencia,baja  FROM invfinalcava WHERE fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                tbbajas.setModel(dtm);
                dtm.addRow(arr);
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
    }

    public void visualizaInvFinal() {
        tbfinal.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String[] arr = new String[2];
        String extraeCantidad = "SELECT referencia,cantidad  FROM invfinalcava WHERE fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                tbfinal.setModel(dtm);
                dtm.addRow(arr);
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
    }

    public void operaciones() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        mes = mes +1;
        hora = hora - 2;
        int operacion;
        operacion = Polar2 + Pol2 - Polb2 - Polai2;
        diferencia = operacion - Polf2;
        String refe = "INSERT INTO descuadre SET referencia = 'POLAR 2 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Iglu500 + Iglu500in - Iglu500b - Iglui500;
        diferencia = operacion - Igluf500;
        String refe1 = "INSERT INTO descuadre SET referencia='IGLU 500 GRAMOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Polar12 + Pola12 - Polab12 - Polai12;
        diferencia = operacion - Polaf12;
        String refe2 = "INSERT INTO descuadre SET referencia='POLAR 12 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Picadat + Picad - Picadatb - Picadati;
        diferencia = operacion - Picadatf;
        String refe3 = "INSERT INTO descuadre SET referencia='PICADA TRANSP 20 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe3);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Polar20 + Pol20 - Polb20 - Polari20;
        diferencia = operacion - Polf20;
        String refe4 = "INSERT INTO descuadre SET referencia='POLAR 20 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe4);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Escama20 + Esca20 - Escab20 - Escamai20;
        diferencia = operacion - Escaf20;
        String refe5 = "INSERT INTO descuadre SET referencia = 'ESCAMA 20 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe5);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Parranda12 + Parrand12 - Parrab12 - Parrandai12;
        diferencia = operacion - Parraf12;
        String refe6 = "INSERT INTO descuadre SET referencia = 'PARRANDA 12 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe6);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Bloque + Bloqu - Bloqueb - Bloquei;
        diferencia = operacion - Bloquef;
        String refe7 = "INSERT INTO descuadre SET referencia = 'BLOQUE 25 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe7);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Iglu7 + Ig7 - Igb7 - Iglui7;
        diferencia = operacion - Igf7;
        String refe8 = "INSERT INTO descuadre SET referencia = 'IGLU 7 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe8);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Cbloque + Cbloqu - Cbloqueb - Cbloquei;
        diferencia = operacion - Cbloquef;
        String refe9 = "INSERT INTO descuadre SET referencia = 'CUARTO DE BLOQUE', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe9);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Parra2 + Par2 - Parb2 - Parrai2;
        diferencia = operacion - Parf2;
        String refe10 = "INSERT INTO descuadre SET referencia = 'PARRANDA 2 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem()+ "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe10);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Polar3 + Polar3in - Polarb3 - Polari3;
        diferencia = operacion - Polarf3;
        String refe11 = "INSERT INTO descuadre SET referencia = 'POLAR 3 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe11);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Fresca2 + Fres2 - Fresb2 - Frescai2;
        diferencia = operacion - Fresf2;
        String refe12 = "INSERT INTO descuadre SET referencia = 'FRESCAMPO 2 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe12);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Iglucili20 + Igci20 - Igcib20 - Iglucilii20;
        diferencia = operacion - Igcif20;
        String refe13 = "INSERT INTO descuadre SET referencia = 'IGLU 20 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem()+ "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe13);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Iglu15 + Ig15 - Igb15 - Iglui15;
        diferencia = operacion - Igf15;
        String refe14 = "INSERT INTO descuadre SET referencia = 'IGLU 15 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe14);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

        operacion = Iglu3 + Ig3 - Igb3 - Iglui3;
        diferencia = operacion - Igf3;
        String refe15 = "INSERT INTO descuadre SET referencia = 'IGLU 3 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe15);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Iglu2 + Ig2 - Igb2 - Iglui2;
        diferencia = operacion - Igf2;
        String refe16 = "INSERT INTO descuadre SET referencia = 'IGLU 2 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe16);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        operacion = Fresca3 + Fres3 - Fresb3 - Frescai3;
        diferencia = operacion - Fresf3;
        String refe17 = "INSERT INTO descuadre SET referencia = 'IGLU 2 KILOS', cantidad='" + diferencia + "', turno='" + cbxturno.getSelectedItem() + "', fecha='"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(refe17);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }// realiza las operaciones de la cava

    public void visualizaOperaciones() {
        tbdiferencia.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String[] arr = new String[2];
        String extraeCantidad = "SELECT referencia,cantidad  FROM descuadre WHERE fecha BETWEEN '" + txtfecha.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txthasta.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                tbdiferencia.setModel(dtm);
                dtm.addRow(arr);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void ajusteDiferenciaInicial() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int diaB = fecha.get(Calendar.DAY_OF_MONTH);
        diaB = diaB - 1;
        mes = mes + 1;
        String referencia = cbxreferencia.getSelectedItem().toString();
        String turno = cbxturno.getSelectedItem().toString();
        String turno1 = "Turno 1";
        String turno2 = "Turno 2";
        String turno3 = "Turno 3";
        if (turno.equals(turno3)) {
            String actualiza = "UPDATE invinincava SET cantidad = cantidad +" + diferencia + " WHERE referencia = '" + referencia + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaB + " 22:00:00' AND '" + año + "-" + mes + "-" + dia + " 06:00:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                PreparedStatement st = (PreparedStatement) con.createStatement();
                st.execute(actualiza);
            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            if (turno.equals(turno1)) {
                String actualiza = "UPDATE invinincava SET cantidad = cantidad +" + diferencia + " WHERE referencia = '" + referencia + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 06:00:00' AND '" + año + "-" + mes + "-" + dia + " 14:00:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    st.execute(actualiza);
                } catch (SQLException e) {
                    System.out.println(e);
                }

            } else {
                if (turno.equals(turno2)) {
                    String actualiza = "UPDATE invinincava SET cantidad = cantidad +" + diferencia + " WHERE referencia = '" + referencia + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaB + " 14:00:00' AND '" + año + "-" + mes + "-" + dia + " 22:00:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        st.execute(actualiza);
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                }
            }

        }
    }

    public void ajustaDiferenciaFinal() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int diaB = fecha.get(Calendar.DAY_OF_MONTH);
        diaB = diaB - 1;
        mes = mes + 1;
        String referencia = cbxreferencia.getSelectedItem().toString();
        String turno = cbxturno.getSelectedItem().toString();
        String turno1 = "Turno 1";
        String turno2 = "Turno 2";
        String turno3 = "Turno 3";
        if (turno.equals(turno1)) {
            String actualiza = "UPDATE invfinalcava SET cantidad = cantidad +" + diferencia + " WHERE referencia = '" + referencia + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaB + " 22:00:00' AND '" + año + "-" + mes + "-" + dia + " 06:00:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                PreparedStatement st = (PreparedStatement) con.createStatement();
                st.execute(actualiza);
            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            if (turno.equals(turno2)) {
                String actualiza = "UPDATE invfinalcava SET cantidad = cantidad +" + diferencia + " WHERE referencia = '" + referencia + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 06:00:00' AND '" + año + "-" + mes + "-" + dia + " 14:00:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    st.execute(actualiza);
                } catch (SQLException e) {
                    System.out.println(e);
                }

            } else {
                if (turno.equals(turno3)) {
                    String actualiza = "UPDATE invfinalcava SET cantidad = cantidad +" + diferencia + " WHERE referencia = '" + referencia + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaB + " 14:00:00' AND '" + año + "-" + mes + "-" + dia + " 22:00:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        st.execute(actualiza);
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                }
            }

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
        jLabel2 = new javax.swing.JLabel();
        cbxreferencia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxturno = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtlote = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtbaja = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbproduccion = new javax.swing.JTable();
        btnconsulta = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        txtfecha = new javax.swing.JTextField();
        cbxdesde = new javax.swing.JComboBox<>();
        cbxhasta = new javax.swing.JComboBox<>();
        btntotal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdespachos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbbajas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbinvInicial = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbfinal = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbdiferencia = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnajustes = new javax.swing.JButton();
        txthasta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CAVAS");
        setIconImage(getIconImage());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 56)); // NOI18N
        jLabel1.setText("CAVAS");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("TURNO");

        cbxreferencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbxreferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("REFERENCIA");

        cbxturno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("CANTIDAD");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("LOTE");

        txtlote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("BOLSAS DE BAJA");

        tbproduccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tbproduccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbproduccion);

        btnconsulta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnconsulta.setText("CONSULTAR");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        cbxdesde.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbxdesde.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        cbxhasta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbxhasta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        btntotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btntotal.setText("TOTAL");
        btntotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("FECHA");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("PRODUCCION");

        tbdespachos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbdespachos);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("DESPACHOS");

        tbbajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbbajas);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("BAJAS EN CAVA");

        tbinvInicial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbinvInicial);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("INVENTARIO INICIAL");

        tbfinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbfinal);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("INVENTARIO FINAL");

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
        jScrollPane6.setViewportView(tbdiferencia);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("DIFERENCIA");

        btnajustes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnajustes.setText("AJUSTES");
        btnajustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajustesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel1))
                                    .addComponent(txtbaja, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(223, 223, 223))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnconsulta))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxdesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txthasta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntotal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnajustes, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxhasta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar)
                    .addComponent(btnconsulta)
                    .addComponent(btntotal)
                    .addComponent(btnajustes))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxdesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxhasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtloteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloteActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        insertOperario();
        insertaInicial();
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
        // TODO add your handling code here:
        extraeProduccion();
        extraeDespachos();
        extraeInicial();
        extraebajas();
        extraeFinal();
        visualizaProduccion();
        visualizaDespachos();
        visualizaInvInicial();
        visualizaBajas();
        visualizaInvFinal();
        visualizaOperaciones();

    }//GEN-LAST:event_btnconsultaActionPerformed

    private void btntotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalActionPerformed
        // TODO add your handling code here:
        operaciones();

        btnajustes.setEnabled(true);
        btntotal.setEnabled(false);
    }//GEN-LAST:event_btntotalActionPerformed

    private void btnajustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajustesActionPerformed
        // TODO add your handling code here:

        ajusteDiferenciaInicial();
        ajustaDiferenciaFinal();
        btntotal.setEnabled(true);
    }//GEN-LAST:event_btnajustesActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Cavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cavas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnajustes;
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btntotal;
    private javax.swing.JComboBox<String> cbxdesde;
    private javax.swing.JComboBox<String> cbxhasta;
    private javax.swing.JComboBox<String> cbxreferencia;
    private javax.swing.JComboBox<String> cbxturno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tbbajas;
    private javax.swing.JTable tbdespachos;
    private javax.swing.JTable tbdiferencia;
    private javax.swing.JTable tbfinal;
    private javax.swing.JTable tbinvInicial;
    private javax.swing.JTable tbproduccion;
    private javax.swing.JTextField txtbaja;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txthasta;
    private javax.swing.JTextField txtlote;
    // End of variables declaration//GEN-END:variables
}
