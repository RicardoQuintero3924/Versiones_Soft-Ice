package VistasCC;

import Beans.BeansCavaPuntoVenta;
import DAO.DAOCavaPV;
import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CavaPuntoVenta extends javax.swing.JFrame {

    //FALTA GENERAR LOS METODOS DE CONSULTA, DESCARGA Y OPERATIVO PARA LA CAVA PUNTO DE VENTA.
    public CavaPuntoVenta() {
        initComponents();
        Cargabd();
    }
//TRASLADOS:
int canTIg500;
int canTIg3k;
int canTIg7k;
int canTIg20k;
int canTPr2k;
int canTPr12k;
int canTFr3k;
int canTEs20k;
int canTBl25k;
int canTCb;
int canTPt20k;
int canTPl3k;
int canTPl2k;
int canTPL12k;
int canTPL20k;
//DESPACHOS
int canDIg500;
int canDIg3K; 
int canDIg7K;
int canDIg20K;
int canDPr2K;
int canDPr12K;
int canDFr3K;
int canDEs20K;
int canDBl25K;
int canDCb;
int canDPt20k;
int canDPl3k;
int canDPl2k;
int canDPl12k;
int canDPl20k;
//DEVOLUCIONES
int cantDeIg500;
int cantDeIg3K;
int cantDeIg7K;
int cantDeIg20K;
int cantDePr2K;
int cantDePr12K;
int cantDeFr3K;
int cantDeEs20K;
int cantDeBl25K;
int cantDeCb;
int cantDePt20k;
int cantDePl3k;
int cantDePl2k;
int cantDePl12k;
int cantDePl20k;
//INV INICIAL
int cantIIg500;
int cantIIg3k;
int cantIIg7k;
int cantIIg20k;
int cantIPr2k;
int cantIPr12k;
int cantIFr3k;
int cantIEs20k;
int cantIBl25k;
int cantIBl;
int cantIPt20k;
int cantIPl3k;
int cantIPl2k;
int cantIPl12k;
int cantIPl20k;
//BAJAS
int canBIg500;  
int canBIg3k;
int canBIg7k;
int canBIg20k;
int canBPr2k;
int canBPr12k;
int canBFr3k;
int canBEs20k;
int canBBl25k;
int canBCb;
int canBPt20k;
int canBPl3k;
int canBPl2k;
int canBPl12k;
int canBPl20k;
//INVENTARIRIO FINAL
int CanFIg500;
int CanFIg3k;
int CanFIg7k;
int CanFIg20k;
int CanFPr2k;
int CanFPr12k;
int CanFFr3k;
int CanFEs20k;
int CanFBL25k;
int CanFCb;
int CanFPt20k;
int CanFPl3k;
int CanFPl2k;
int CanFPl12k;
int CanFPl20k;

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

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
    }

    public void guardaInvInicial() {
        String referencia = cbxreferencia.getSelectedItem().toString();
        String cantidad = txtcantidad.getText();
        String bajas = txtbaja.getText();
        String lote = txtlote.getText();

        BeansCavaPuntoVenta bcp = new BeansCavaPuntoVenta();
        bcp.setReferencia(referencia);
        bcp.setCantidad(cantidad);
        bcp.setLote(lote);
        bcp.setBajas(bajas);

        DAOCavaPV dpv = new DAOCavaPV();
        dpv.InsertaInvInicial(bcp);
    }//Guarda el inventario inicial de la cava los colores

    public void guardaInvFinal() {
        String referencia = cbxreferencia.getSelectedItem().toString();
        String cantidad = txtcantidad.getText();
        String bajas = txtbaja.getText();
        String lote = txtlote.getText();

        BeansCavaPuntoVenta bcp = new BeansCavaPuntoVenta();
        bcp.setReferencia(referencia);
        bcp.setCantidad(cantidad);
        bcp.setLote(lote);
        bcp.setBajas(bajas);

        DAOCavaPV dpv = new DAOCavaPV();
        dpv.InsertaInvFinal(bcp);
        JOptionPane.showMessageDialog(null, "INVENTARIO GUARDADO CORRECTAMENTE");
        cbxreferencia.setSelectedItem(" ");
        txtcantidad.setText(" ");
        txtlote.setText(" ");
        txtbaja.setText(" ");
    }//Guarda el inventario final de la cava los colores

    public void guardaInvInicialPVR() {
        String referencia = cbxreferencia.getSelectedItem().toString();
        String cantidad = txtcantidad.getText();
        String bajas = txtbaja.getText();
        String lote = txtlote.getText();

        BeansCavaPuntoVenta bcp = new BeansCavaPuntoVenta();
        bcp.setReferencia(referencia);
        bcp.setCantidad(cantidad);
        bcp.setLote(lote);
        bcp.setBajas(bajas);

        DAOCavaPV dpv = new DAOCavaPV();
        dpv.InsertaInvInicialPVR(bcp);
    }//Guarda el inventario inicial de la cava rionegro

    public void guardaInvFinalPVR() {
        String referencia = cbxreferencia.getSelectedItem().toString();
        String cantidad = txtcantidad.getText();
        String bajas = txtbaja.getText();
        String lote = txtlote.getText();

        BeansCavaPuntoVenta bcp = new BeansCavaPuntoVenta();
        bcp.setReferencia(referencia);
        bcp.setCantidad(cantidad);
        bcp.setLote(lote);
        bcp.setBajas(bajas);

        DAOCavaPV dpv = new DAOCavaPV();
        dpv.InsertaInvFinalPVR(bcp);
        JOptionPane.showMessageDialog(null, "INVENTARIO GUARDADO CORRECTAMENTE");
        cbxreferencia.setSelectedItem(" ");
        txtcantidad.setText(" ");
        txtlote.setText(" ");
        txtbaja.setText(" ");
    }//Guarda el inventario final de la cava rionegro

    public void extraeTraslados() {
        String can;
        String tras = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 500 GRAMOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras);
            while (rs.next()) {
                can = rs.getString("cantidad");
                 canTIg500 = Integer.parseInt(can);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can1;
        String tras1 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras1);
            while (rs.next()) {
                can1 = rs.getString("cantidad");
                 canTIg3k = Integer.parseInt(can1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can2;
        String tras2 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 7 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras2);
            while (rs.next()) {
                can2 = rs.getString("cantidad");
                canTIg7k = Integer.parseInt(can2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can3;
        String tras3 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras3);
            while (rs.next()) {
                can3 = rs.getString("cantidad");
                 canTIg20k = Integer.parseInt(can3);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can4;
        String tras4 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 2 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras4);
            while (rs.next()) {
                can4 = rs.getString("cantidad");
                 canTPr2k = Integer.parseInt(can4);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can5;
        String tras5 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 12 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras5);
            while (rs.next()) {
                can5 = rs.getString("cantidad");
                canTPr12k = Integer.parseInt(can5);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can6;
        String tras6 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'FRESCAMPO 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras6);
            while (rs.next()) {
                can6 = rs.getString("cantidad");
                 canTFr3k = Integer.parseInt(can6);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can7;
        String tras7 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'ESCAMA 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras7);
            while (rs.next()) {
                can7 = rs.getString("cantidad");
                canTEs20k = Integer.parseInt(can7);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can8;
        String tras8 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'BLOQUE 25 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras8);
            while (rs.next()) {
                can8 = rs.getString("cantidad");
                canTBl25k = Integer.parseInt(can8);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can9;
        String tras9 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'CUARTO DE BLOQUE'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras9);
            while (rs.next()) {
                can9 = rs.getString("cantidad");
                canTCb = Integer.parseInt(can9);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can10;
        String tras10 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PICADA TRANSP 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras10);
            while (rs.next()) {
                can10 = rs.getString("cantidad");
                int canTPt20k = Integer.parseInt(can10);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can11;
        String tras11 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras11);
            while (rs.next()) {
                can11 = rs.getString("cantidad");
                int canTPl3k = Integer.parseInt(can11);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can12;
        String tras12 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 2 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras12);
            while (rs.next()) {
                can12 = rs.getString("cantidad");
                int canTPl2k = Integer.parseInt(can12);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can13;
        String tras13 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 12 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras10);
            while (rs.next()) {
                can10 = rs.getString("cantidad");
                int canTPL12k = Integer.parseInt(can10);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can14;
        String tras14 = "SELECT cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras14);
            while (rs.next()) {
                can14 = rs.getString("cantidad");
                int canTPL20k = Integer.parseInt(can14);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

    }//trae los movimientos de los traslados realizados en el rango de tiempo seleccionado

    public void consultaTraslados() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        tbtraslados.setModel(dtm);
        String tras = "SELECT referencia,cantidad FROM traslados WHERE fechaT BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(tras);
            String[] arr = new String[2];
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }//Consulta los traslados en el rango de tiempo indicado

    public void extraeDespachos() {
        String can;
        String des = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 500 GRAMOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des);
            while (rs.next()) {
                can = rs.getString("cantidad");
                int canDIg500 = Integer.parseInt(can);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can1;
        String des1 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des1);
            while (rs.next()) {
                can1 = rs.getString("cantidad");
                int canDIg3K = Integer.parseInt(can1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can2;
        String des2 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 7 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des2);
            while (rs.next()) {
                can2 = rs.getString("cantidad");
                int canDIg7K = Integer.parseInt(can2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can3;
        String des3 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des3);
            while (rs.next()) {
                can3 = rs.getString("cantidad");
                 canDIg20K = Integer.parseInt(can3);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can4;
        String des4 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 2 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des4);
            while (rs.next()) {
                can4 = rs.getString("cantidad");
                int canDPr2K = Integer.parseInt(can4);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can5;
        String des5 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 12 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des5);
            while (rs.next()) {
                can5 = rs.getString("cantidad");
                int canDPr12K = Integer.parseInt(can5);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can6;
        String des6 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'FRESCAMPO 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des6);
            while (rs.next()) {
                can6 = rs.getString("cantidad");
                int canDFr3K = Integer.parseInt(can6);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can7;
        String des7 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'ESCAMA 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des7);
            while (rs.next()) {
                can7 = rs.getString("cantidad");
                int canDEs20K = Integer.parseInt(can7);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can8;
        String des8 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'BLOQUE 25 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des8);
            while (rs.next()) {
                can8 = rs.getString("cantidad");
                int canDBl25K = Integer.parseInt(can8);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can9;
        String des9 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'CUARTO DE BLOQUE'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des9);
            while (rs.next()) {
                can9 = rs.getString("cantidad");
                int canDCb = Integer.parseInt(can9);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can10;
        String des10 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PICADA TRANSP 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des10);
            while (rs.next()) {
                can10 = rs.getString("cantidad");
                int canDPt20k = Integer.parseInt(can10);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can11;
        String des11 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des11);
            while (rs.next()) {
                can11 = rs.getString("cantidad");
                int canDPl3k = Integer.parseInt(can11);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can12;
        String des12 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 2 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des12);
            while (rs.next()) {
                can12 = rs.getString("cantidad");
                int canDPl2k = Integer.parseInt(can12);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can13;
        String des13 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 12 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des13);
            while (rs.next()) {
                can13 = rs.getString("cantidad");
                int canDPl12k = Integer.parseInt(can13);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can14;
        String des14 = "SELECT cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(des14);
            while (rs.next()) {
                can14 = rs.getString("cantidad");
                int canDPl20k = Integer.parseInt(can14);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }//extrae los movimientos de despachos del punto de venta.

    public void consultaDespachos() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String conD = "SELECT referencia,cantidad FROM puntoventadespachos WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59'";
        tbdespacho.setModel(dtm);
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(conD);
            String[] arr = new String[2];
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }//consulta los despachos del punto de venta en el rango de tiempo determinado

    public void extraeDevoluciones() {
        String dev = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 500 GRAMOS'";
        String can;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev);
            while (rs.next()) {
                can = rs.getString("cantidad");
                int cantDeIg500 = Integer.parseInt(can);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev1 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 3 KILOS'";
        String can1;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev1);
            while (rs.next()) {
                can1 = rs.getString("cantidad");
                int cantDeIg3K = Integer.parseInt(can1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev2 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 7 KILOS'";
        String can2;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev2);
            while (rs.next()) {
                can2 = rs.getString("cantidad");
                int cantDeIg7K = Integer.parseInt(can2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev3 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 20 KILOS'";
        String can3;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev3);
            while (rs.next()) {
                can3 = rs.getString("cantidad");
                int cantDeIg20K = Integer.parseInt(can3);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev4 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 2 KILOS'";
        String can4;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev4);
            while (rs.next()) {
                can4 = rs.getString("cantidad");
                int cantDePr2K = Integer.parseInt(can4);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev5 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 12 KILOS'";
        String can5;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev5);
            while (rs.next()) {
                can5 = rs.getString("cantidad");
                int cantDePr12K = Integer.parseInt(can5);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev6 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'FRESCAMPO 3 KILOS'";
        String can6;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev6);
            while (rs.next()) {
                can6 = rs.getString("cantidad");
                int cantDeFr3K = Integer.parseInt(can6);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev7 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'ESCAMA 20 KILOS'";
        String can7;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev7);
            while (rs.next()) {
                can7 = rs.getString("cantidad");
                int cantDeEs20K = Integer.parseInt(can7);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev8 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'BLOQUE 25 KILOS'";
        String can8;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev8);
            while (rs.next()) {
                can8 = rs.getString("cantidad");
                int cantDeBl25K = Integer.parseInt(can8);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev9 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'CUARTO DE BLOQUE'";
        String can9;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev9);
            while (rs.next()) {
                can9 = rs.getString("cantidad");
                int cantDeCb = Integer.parseInt(can9);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev10 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PICADA TRANSP 20 KILOS'";
        String can10;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev10);
            while (rs.next()) {
                can10 = rs.getString("cantidad");
                cantDePt20k = Integer.parseInt(can10);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev11 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 3 KILOS'";
        String can11;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev11);
            while (rs.next()) {
                can11 = rs.getString("cantidad");
                int cantDePl3k = Integer.parseInt(can11);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev12 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 2 KILOS'";
        String can12;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev12);
            while (rs.next()) {
                can12 = rs.getString("cantidad");
                int cantDePl2k = Integer.parseInt(can12);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev13 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 12 KILOS'";
        String can13;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev13);
            while (rs.next()) {
                can13 = rs.getString("cantidad");
                int cantDePl12k = Integer.parseInt(can13);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String dev14 = "SELECT cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 20 KILOS'";
        String can14;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev14);
            while (rs.next()) {
                can14 = rs.getString("cantidad");
                int cantDePl20k = Integer.parseInt(can14);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }//extrae las devoluciones realizadas al punto de venta.

    public void consultaDevoluciones() {
        tbdevolucion.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        tbdevolucion.setModel(dtm);
        String dev = "SELECT referencia,cantidad FROM puntoventadevoluciones WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(dev);
            String[] arr = new String[2];
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }//consulta las devoluciones realizadas al punto de venta.

    public void consultaInvInicialPC() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        tbinicial.setModel(dtm);
        String[] arr = new String[2];
        String cipc = "SELECT referencia,cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(cipc);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }//consulta el inventario inicial de la cava los colores.

    public void extraeInvInicialPc() {
        String eii = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 500 GRAMOS'";
        String cant;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii);
            while (rs.next()) {
                cant = rs.getString("cantidad");
                int cantIIg500 = Integer.parseInt(cant);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii1 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 3 KILOS'";
        String cant1;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii1);
            while (rs.next()) {
                cant1 = rs.getString("cantidad");
                int cantIIg3k = Integer.parseInt(cant1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii2 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 7 KILOS'";
        String cant2;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii2);
            while (rs.next()) {
                cant2 = rs.getString("cantidad");
                int cantIIg7k = Integer.parseInt(cant2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii3 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 20 KILOS'";
        String cant3;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii3);
            while (rs.next()) {
                cant3 = rs.getString("cantidad");
                int cantIIg20k = Integer.parseInt(cant3);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii4 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 2 KILOS'";
        String cant4;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii4);
            while (rs.next()) {
                cant4 = rs.getString("cantidad");
                int cantIPr2k = Integer.parseInt(cant4);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii5 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 12 KILOS'";
        String cant5;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii5);
            while (rs.next()) {
                cant5 = rs.getString("cantidad");
                int cantIPr12k = Integer.parseInt(cant5);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii6 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'FRESCAMPO 3 KILOS'";
        String cant6;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii6);
            while (rs.next()) {
                cant6 = rs.getString("cantidad");
                int cantIFr3k = Integer.parseInt(cant6);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii7 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'ESCAMA 20 KILOS'";
        String cant7;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii7);
            while (rs.next()) {
                cant7 = rs.getString("cantidad");
                int cantIEs20k = Integer.parseInt(cant7);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii8 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'BLOQUE 25 KILOS'";
        String cant8;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii8);
            while (rs.next()) {
                cant8 = rs.getString("cantidad");
                int cantIBl25k = Integer.parseInt(cant8);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii9 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'CUARTO DE BLOQUE'";
        String cant9;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii9);
            while (rs.next()) {
                cant9 = rs.getString("cantidad");
                int cantIBl = Integer.parseInt(cant9);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii10 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PICADA TRANSP 20 KILOS'";
        String cant10;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii10);
            while (rs.next()) {
                cant10 = rs.getString("cantidad");
                int cantIPt20k = Integer.parseInt(cant10);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii11 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 3 KILOS'";
        String cant11;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii11);
            while (rs.next()) {
                cant11 = rs.getString("cantidad");
                 cantIPl3k = Integer.parseInt(cant11);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii12 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 2 KILOS'";
        String cant12;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii12);
            while (rs.next()) {
                cant12 = rs.getString("cantidad");
                int cantIPl2k = Integer.parseInt(cant12);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii13 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 12 KILOS'";
        String cant13;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii13);
            while (rs.next()) {
                cant13 = rs.getString("cantidad");
                int cantIPl12k = Integer.parseInt(cant13);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String eii14 = "SELECT cantidad FROM invinicialcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 20 KILOS'";
        String cant14;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eii14);
            while (rs.next()) {
                cant14 = rs.getString("cantidad");
                int cantIPl20k = Integer.parseInt(cant14);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }//extrae las referencias y las cantidades del inventario inicial

    public void consultaBajas() {
        tbbaja.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        tbbaja.setModel(dtm);
        String CB = "SELECT referencia,bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59'";
        String[] arr = new String[2];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(CB);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice BAJAS: " + e);
        }

    }//consulta el plastico de baja

    public void extraeBajas() {
        String can;
        String eb = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 500 GRAMOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb);
            while (rs.next()) {
                can = rs.getString("bajas");
                int canBIg500 = Integer.parseInt(can);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can1;
        String eb1 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb1);
            while (rs.next()) {
                can1 = rs.getString("bajas");
                int canBIg3k = Integer.parseInt(can1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can2;
        String eb2 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 7 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb2);
            while (rs.next()) {
                can2 = rs.getString("bajas");
                int canBIg7k = Integer.parseInt(can2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can3;
        String eb3 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb3);
            while (rs.next()) {
                can3 = rs.getString("bajas");
                int canBIg20k = Integer.parseInt(can3);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can4;
        String eb4 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 2 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb4);
            while (rs.next()) {
                can4 = rs.getString("bajas");
                 canBPr2k = Integer.parseInt(can4);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can5;
        String eb5 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 12 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb5);
            while (rs.next()) {
                can5 = rs.getString("bajas");
                int canBPr12k = Integer.parseInt(can5);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can6;
        String eb6 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'FRESCAMPO 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb6);
            while (rs.next()) {
                can6 = rs.getString("bajas");
                int canBFr3k = Integer.parseInt(can6);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can7;
        String eb7 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'ESCAMA 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb7);
            while (rs.next()) {
                can7 = rs.getString("bajas");
                int canBEs20k = Integer.parseInt(can7);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can8;
        String eb8 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'BLOQUE 25 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb8);
            while (rs.next()) {
                can8 = rs.getString("bajas");
                int canBBl25k = Integer.parseInt(can8);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can9;
        String eb9 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'CUARTO DE BLOQUE'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb9);
            while (rs.next()) {
                can9 = rs.getString("bajas");
                int canBCb = Integer.parseInt(can9);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can10;
        String eb10 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PICADA TRANSP 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb10);
            while (rs.next()) {
                can10 = rs.getString("bajas");
                int canBPt20k = Integer.parseInt(can10);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can11;
        String eb11 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb11);
            while (rs.next()) {
                can11 = rs.getString("bajas");
                int canBPl3k = Integer.parseInt(can11);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can12;
        String eb12 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 2 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb12);
            while (rs.next()) {
                can12 = rs.getString("bajas");
                int canBPl2k = Integer.parseInt(can12);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can13;
        String eb13 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 12 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb13);
            while (rs.next()) {
                can13 = rs.getString("bajas");
                int canBPl12k = Integer.parseInt(can13);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can14;
        String eb14 = "SELECT bajas FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eb14);
            while (rs.next()) {
                can14 = rs.getString("bajas");
                int canBPl20k = Integer.parseInt(can14);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }//extrae las bajas del plastico.

    public void consultaInvFinPC() {
        tbfinal.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String[] arr = new String[2];
        tbfinal.setModel(dtm);
        String CIF = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(CIF);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }//consulta el inventario final 

    public void extraeInvFinPc() {
        String can;
        String eif = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 500 GRAMOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif);
            while (rs.next()) {
                can = rs.getString("cantidad");
                CanFIg500 = Integer.parseInt(can);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can1;
        String eif1 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif1);
            while (rs.next()) {
                can1 = rs.getString("cantidad");
                CanFIg3k = Integer.parseInt(can1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can2;
        String eif2 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 7 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif2);
            while (rs.next()) {
                can2 = rs.getString("cantidad");
                 CanFIg7k = Integer.parseInt(can2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can3;
        String eif3 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'IGLU 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif3);
            while (rs.next()) {
                can3 = rs.getString("cantidad");
                CanFIg20k = Integer.parseInt(can3);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can4;
        String eif4 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 2 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif4);
            while (rs.next()) {
                can4 = rs.getString("cantidad");
                CanFPr2k = Integer.parseInt(can4);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can5;
        String eif5 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PARRANDA 12 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif5);
            while (rs.next()) {
                can5 = rs.getString("cantidad");
                CanFPr12k = Integer.parseInt(can5);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can6;
        String eif6 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'FRESCAMPO 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif6);
            while (rs.next()) {
                can6 = rs.getString("cantidad");
                 CanFFr3k = Integer.parseInt(can6);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can7;
        String eif7 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'ESCAMA 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif7);
            while (rs.next()) {
                can7 = rs.getString("cantidad");
                 CanFEs20k = Integer.parseInt(can7);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can8;
        String eif8 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'BLOQUE 25 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif8);
            while (rs.next()) {
                can8 = rs.getString("cantidad");
                CanFBL25k = Integer.parseInt(can8);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can9;
        String eif9 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'CUARTO DE BLOQUE'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif9);
            while (rs.next()) {
                can9 = rs.getString("cantidad");
                 CanFCb = Integer.parseInt(can9);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can10;
        String eif10 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'PICADA TRANSP 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif10);
            while (rs.next()) {
                can10 = rs.getString("cantidad");
                 CanFPt20k = Integer.parseInt(can10);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can11;
        String eif11 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 3 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif11);
            while (rs.next()) {
                can11 = rs.getString("cantidad");
                CanFPl3k = Integer.parseInt(can11);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can12;
        String eif12 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 2 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif12);
            while (rs.next()) {
                can12 = rs.getString("cantidad");
                 CanFPl2k = Integer.parseInt(can12);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String can13;
        String eif13 = "SELECT cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 12 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif13);
            while (rs.next()) {
                can13 = rs.getString("cantidad");
                 CanFPl12k = Integer.parseInt(can13);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
         String can14;
        String eif14 = "SELECT referencia,cantidad FROM invfinalcavapv WHERE fecha BETWEEN '" + txtdesde.getText() + " 00:00:00' AND '" + txthasta.getText() + " 23:59:59' AND referencia = 'POLAR 20 KILOS'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(eif14);
            while (rs.next()) {
                can14 = rs.getString("cantidad");
                 CanFPl20k = Integer.parseInt(can14);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }  
    }// extrae el inventario final

    public void insertaDiferencia(String refe, int cant) {
        String insDif = "INSERT INTO diferenciapv SET referencia = '" + refe + "', cantidad = '" + cant + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(insDif);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }

    public void operacion() {
        String ref1 ="IGLU 500 GRAMOS";
        int total = canTIg500 + cantIIg500 + cantDeIg500 - canBIg500 - canDIg500;
        int cant = total - CanFIg500;
        insertaDiferencia(ref1,cant);
        //IGLU 3 KILOS
        String ref2 ="IGLU 3 KILOS";
        int total1 = canTIg3k + cantIIg3k + cantDeIg3K - canBIg3k - canDIg3K;
        int cant1 = total1 - CanFIg3k;
        insertaDiferencia(ref2,cant1);
        //IGLU 7 KILOS
        String ref3 ="IGLU 7 KILOS";
        int total2 = canTIg7k + cantIIg3k + cantDeIg7K - canBIg7k - canDIg7K;
        int cant2 = total2 - CanFIg7k;
        insertaDiferencia(ref3,cant2);
        //IGLU 20 KILOS
        String ref4 = "IGLU 20 KILOS";
        int total3 = canTIg20k + cantIIg20k + cantDeIg20K - canBIg20k - canDIg20K;
        int cant3 = total3 - CanFIg20k;
        insertaDiferencia(ref4,cant3);
        //PARRANDA 2 KILOS
        String ref5 = "PARRANDA 2 KILOS";
        int total4 = canTPr2k + cantIPr2k + cantDePr2K - canBPr2k - canDPr2K;
        int cant4 = CanFPr2k - total4;
        insertaDiferencia(ref5,cant4);
        //PARRANDA 12 KILOS
        String ref6 = "PARRANDA 12 KILOS";
        int total5 = canTPr12k + cantIPr12k + cantDePr12K - canBPr12k - canDPr12K;
        int cant5 = total5 - CanFPr12k;
        insertaDiferencia(ref6,cant5);
        //FRESCAMPO 3 KILOS
        String ref7 = "FRESCAMPO 3 KILOS";
        int total6 = canTFr3k + cantIFr3k + cantDeFr3K - canDFr3K - canBFr3k;
        int cant6 = total6 - CanFFr3k;
        insertaDiferencia(ref7,cant6);
        //ESCAMA 20 KILOS
        String ref8 = "ESCAMA 20 KILOS";
        int total7 = canTEs20k + cantIEs20k + cantDeEs20K - canDEs20K - canBEs20k;
        int cant7 = total7 - CanFEs20k;
        insertaDiferencia(ref8,cant7);
        //BLOQUE 25 KILOS
        String ref9 = "BLOQUE 25 KILOS";
        int total8 = canTBl25k + cantIBl25k + cantDeBl25K - canDBl25K - canBBl25k;
        int cant8 = total8 - CanFBL25k;
        insertaDiferencia(ref9,cant8);
        //CUARTO DE BLOQUE
        String ref10 = "CUARTO DE BLOQUE";
        int total9 = canTCb + cantIBl + cantDeCb - canBCb - canDCb;
        int cant9 = total9 - CanFCb;
        insertaDiferencia(ref10,cant9);
        //PICADA TRANS 20 KILOS
        String ref11 = "PICADA TRANSP 20 KILOS";
        int total10 = canTPt20k + cantIPt20k + cantDePt20k - canBPt20k - canDPt20k;
        int cant10 = total10 - CanFPt20k;
        insertaDiferencia(ref11,cant10);
        //POLAR 3 KILOS
        String ref12 = "POLAR 3 KILOS"; 
        int total11 = canTPl3k + cantIPl3k + cantDePl3k - canBPl3k - canDPl3k;
        int cant11 = total11 - CanFPl3k;
        insertaDiferencia(ref12,cant11);
        //POLAR 7 KILOS
        String ref13 = "POLAR 2 KILOS";
        int total12 = canTPl2k + cantIPl2k + cantDePl2k - canBPl2k - canDPl2k;
        int cant12 = total12 - CanFPl2k;
        insertaDiferencia(ref13,cant12);
        //POLAR 12 KILOS
        String ref14 = "POLAR 12 KILOS";
        int total13 =  canTPL12k + cantIPl12k + cantDePl12k - canBPl12k - canDPl12k;
        int cant13 = total13 - CanFPl12k;
        insertaDiferencia(ref14,cant13);
        //POLAR 20 KILOS
        String ref15 = "POLAR 20 KILOS";
        int total14 = canTPL20k + cantIPl20k + cantDePl20k - canBPl20k - canDPl20k;
        int cant14 = total14 -  CanFPl20k;
        insertaDiferencia(ref15,cant14);
        
    }// realiza la liquidacion de la cava en el dia.
    
    public void consultaOperacion(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String Co = "SELECT referencia,cantidad FROM despedidapv WHERE fechaD BETWEEN '"+txtdesde.getText()+" 00:00:00' AND '"+txthasta.getText() + " 23:59:59'";
        String [] Arr = new String[2];
        tbdiferencia.setModel(dtm);
        try {
          Connection con = Conexion.conectar("mysql");
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(Co);
          while(rs.next()){
              Arr[0] = rs.getString(1);
              Arr[1] = rs.getString(2);
              dtm.addRow(Arr);
          }
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: "
                + "" +e);
        }
    
    
    
    }
    
    public void realizaConsulta() {
        extraeTraslados();
        consultaTraslados();
        extraeDespachos();
        consultaDespachos();
        extraeDevoluciones();
        consultaDevoluciones();
        consultaInvInicialPC();
        extraeInvInicialPc();
        consultaBajas();
        extraeBajas();
        consultaInvFinPC();
        extraeInvFinPc();

    }//metodo que llama todas los metodos para realizar la consulta

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxreferencia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtlote = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtbaja = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbinicial = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbtraslados = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbdespacho = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbdevolucion = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbbaja = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbfinal = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbdiferencia = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtdesde = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txthasta = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btntotal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CAVA PUNTO DE VENTA LOS COLORES");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("CAVA PUNTO DE VENTA LOS COLORES");

        cbxreferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel2.setText("REFERENCIA:");

        jLabel3.setText("CANTIDAD:");

        jLabel4.setText("LOTE:");

        jLabel5.setText("BAJAS:");

        tbinicial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbinicial);

        jLabel6.setText("INV. INICIAL:");

        jLabel7.setText("TRASLADOS:");

        tbtraslados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbtraslados);

        jLabel8.setText("DESPACHOS:");

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
        jScrollPane3.setViewportView(tbdespacho);

        jLabel9.setText("DEVOLUCIONES:");

        tbdevolucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbdevolucion);

        jLabel10.setText("BAJAS:");

        tbbaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbbaja);

        jLabel11.setText("INV. FINAL:");

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
        jScrollPane6.setViewportView(tbfinal);

        jLabel12.setText("DIFERENCIA:");

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
        jScrollPane7.setViewportView(tbdiferencia);

        jLabel13.setText("FECHA INICIAL:");

        jLabel14.setText("FECHA FINAL:");

        btnguardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnconsultar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnconsultar.setText("CONSULTAR");
        btnconsultar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        btntotal.setText("TOTAL");
        btntotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxreferencia, 0, 206, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(txtlote))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbaja, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txthasta, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtdesde))
                                        .addGap(276, 276, 276))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(226, 226, 226)
                                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btntotal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(244, 244, 244))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(129, 129, 129))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnguardar)
                            .addComponent(btnconsultar)
                            .addComponent(btntotal))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2)
                        .addComponent(jScrollPane3)
                        .addComponent(jScrollPane4)
                        .addComponent(jScrollPane5)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardaInvInicial();
        guardaInvFinal();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        realizaConsulta();
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btntotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalActionPerformed
        // TODO add your handling code here:
        operacion();
        consultaOperacion();
    }//GEN-LAST:event_btntotalActionPerformed

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
            java.util.logging.Logger.getLogger(CavaPuntoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CavaPuntoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CavaPuntoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CavaPuntoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CavaPuntoVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btntotal;
    private javax.swing.JComboBox<String> cbxreferencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tbbaja;
    private javax.swing.JTable tbdespacho;
    private javax.swing.JTable tbdevolucion;
    private javax.swing.JTable tbdiferencia;
    private javax.swing.JTable tbfinal;
    private javax.swing.JTable tbinicial;
    private javax.swing.JTable tbtraslados;
    private javax.swing.JTextField txtbaja;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtdesde;
    private javax.swing.JTextField txthasta;
    private javax.swing.JTextField txtlote;
    // End of variables declaration//GEN-END:variables
}
