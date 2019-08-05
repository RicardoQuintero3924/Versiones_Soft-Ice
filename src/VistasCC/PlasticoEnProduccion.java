package VistasCC;

import Beans.BeansPlasticoProduccion;
import DAO.DAOPlasticoProduccion;
import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PlasticoEnProduccion extends javax.swing.JFrame {

    double produccion = 0;
    //inventario inicial
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
        int cantIPl2k;
        int cantIPl12k;
        int cantIPl20k;
        int cantIPl3k;
        int cantIReem;
    //inventario plastico recibido
        int canTIg500;
        int canTIg3k;
        int canTIg7k;
        int canTIg20k;
        int canTPr2k;
        int canTPr12k;
        int canTFr3k;
        int canTEs20k;
        int canTBl25k;
        int canTBl;
        int canTPt20k;
        int canTPl3k;
        int canTPl2k;
        int canTPL12k;
        int canTPL20k;
        int canTReem;
        //bajas
        int canBIg500;
        int canBIg3k;
        int canBIg7k;
        int canBIg20k;
        int canBPr12k;
        int canBPr2k;
        int canBFr3k;
        int canBEs20k;
        int canBBl25k;
        int canBCb;
        int canBPt20k;
        int canBPl3k;
        int canBPl2k;
        int canBPl12k;
        int canBPl20k;
        int canBReem;
        // inventario final
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
        int CanFRee;
        

    public PlasticoEnProduccion() {
        initComponents();
        Cargabd();
        turnos();
        this.cbxturno.addItem("Turno 1");
        this.cbxturno.addItem("Turno 2");
        this.cbxturno.addItem("Turno 3");

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
    }

   
   

    public void ingresarinicial() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        mes = mes + 1;
        hora = hora + 3;

        String ingresa = "INSERT INTO inventarioinicial SET cantidad= " + txtcantidad.getText() + ",referencia = '" + cbxreferencia.getSelectedItem() + "', fecha = '" + año + "-" + mes + ":" + dia + " " + hora + ":00:00', turno = '" + cbxturno.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(ingresa);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void inventFinal(int inicial,int Pfinal,int Precibido, int baja, String refe) {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        mes = mes + 1;
        hora = hora - 2;
        produccion = inicial - Pfinal + Precibido - baja;
        String insertaProduccion = "INSERT INTO produccion SET referencia = '" +refe+ "', cantidad = " + produccion+", fecha = '"+año+"-"+mes+"-"+dia+" "+hora+":00:00'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.executeUpdate(insertaProduccion);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }//fin del metodo inventFinal

    public void kilosProducidos() {
        double kilosp;
        double tonelada;
        double media;
        double tone;
        String Pol2 = "POLAR 2 KILOS";
        String Pol4 = "POLAR 3 KILOS";//SE CAMBIO LA DESCRIPCION DE LA REFERENCIA PARA INSTALACION MEDELLIN
        String Pol12 = "POLAR 12 KILOS";
        String Pol15 = "IGLU 500 GRAMOS";//SE CAMBIO LA DESCRIPCION DE LA REFERENCIA PARA INSTALACION MEDELLIN
        String Pol20 = "POLAR 20 KILOS";
        String Escama = "ESCAMA 20 KILOS";
        String Esquimal = "PARRANDA 12 KILOS";//SE CAMBIO LA DESCRIPCION DE LA REFERENCIA PARA INSTALACION MEDELLIN
        String Artico = "PICADA TRANSP 20 KILOS";//SE CAMBIO LA DESCRIPCION DE LA REFERENCIA PARA INSTALACION MEDELLIN
        String Igl7 = "IGLU 7 KILOS";
        String Colsub3 = "CUARTO DE BLOQUE";//SE CAMBIO LA DESCRIPCION DE LA REFERENCIA PARA INSTALACION MEDELLIN
        String Parr2 = "PARRANDA 2 KILOS";
        String Esquima2 = "BLOQUE 25 KILOS";//SE CAMBIO LA DESCRIPCION DE LA REFERENCIA PARA INSTALACION MEDELLIN
        String fresca2 = "FRESCAMPO 2 KILOS";
        String IgluCil20 = "IGLU 20 KILOS";
        String Igl15 = "IGLU 15 KILOS";
        String Igl3 = "IGLU 3 KILOS";
        String Igl2 = "IGLU 2 KILOS";
        String Fres3 = "FRESCAMPO 3 KILOS";

        String referencia = cbxreferencia.getSelectedItem().toString();
        if (referencia.equals(Pol2)) {
            kilosp = produccion * 2.3;
            tonelada = kilosp / 1000;
            String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + kilosp + "', toneladas = '" + tonelada + "'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                st.execute(Ik);
            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            if (referencia.equals(Pol4)) {
                kilosp = produccion * 3.3;
                tonelada = kilosp / 1000;
                String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + kilosp + "', toneladas = '" + tonelada + "'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    st.execute(Ik);
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else {
                if (referencia.equals(Pol12)) {
                    kilosp = produccion * 12.3;
                    tonelada = kilosp / 1000;
                    String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + kilosp + "', toneladas = '" + tonelada + "'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        st.execute(Ik);
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                } else {
                    if (referencia.equals(Pol15)) {
                        kilosp = produccion * 0.5;
                        tonelada = kilosp / 1000;
                        String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + kilosp + "', toneladas = '" + tonelada + "'";
                        try {
                            Connection con = Conexion.conectar("mysql");
                            Statement st = con.createStatement();
                            st.execute(Ik);
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                    } else {
                        if (referencia.equals(Pol20)) {
                            kilosp = produccion * 20.3;
                            tonelada = kilosp / 1000;
                            String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + kilosp + "', toneladas = '" + tonelada + "'";
                            try {
                                Connection con = Conexion.conectar("mysql");
                                Statement st = con.createStatement();
                                st.execute(Ik);
                            } catch (SQLException e) {
                                System.out.println(e);
                            }
                        } else {
                            if (referencia.equals(Escama)) {
                                media = produccion * 20.3;
                                tone = media / 1000;
                                String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                try {
                                    Connection con = Conexion.conectar("mysql");
                                    Statement st = con.createStatement();
                                    st.execute(Ik);
                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                            } else {
                                if (referencia.equals(Esquimal)) {
                                    media = produccion * 12.3;
                                    tone = media / 1000;
                                    String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                    try {
                                        Connection con = Conexion.conectar("mysql");
                                        Statement st = con.createStatement();
                                        st.execute(Ik);
                                    } catch (SQLException e) {
                                        System.out.println(e);
                                    }
                                } else {
                                    if (referencia.equals(Esquima2)) {
                                        media = produccion * 25.3;
                                        tone = media / 1000;
                                        String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                        try {
                                            Connection con = Conexion.conectar("mysql");
                                            Statement st = con.createStatement();
                                            st.execute(Ik);
                                        } catch (SQLException e) {
                                            System.out.println(e);
                                        }
                                    } else {
                                        if (referencia.equals(Artico)) {
                                            media = produccion * 20.3;
                                            tone = media / 1000;
                                            String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                            try {
                                                Connection con = Conexion.conectar("mysql");
                                                Statement st = con.createStatement();
                                                st.execute(Ik);
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        } else {
                                            if (referencia.equals(Igl7)) {
                                                media = produccion * 7.3;
                                                tone = media / 1000;
                                                String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                                try {
                                                    Connection con = Conexion.conectar("mysql");
                                                    Statement st = con.createStatement();
                                                    st.execute(Ik);
                                                } catch (SQLException e) {
                                                    System.out.println(e);
                                                }
                                            } else {
                                                if (referencia.equals(Colsub3)) {
                                                    media = produccion * 6.3;
                                                    tone = media / 1000;
                                                    String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                                    try {
                                                        Connection con = Conexion.conectar("mysql");
                                                        Statement st = con.createStatement();
                                                        st.execute(Ik);
                                                    } catch (SQLException e) {
                                                        System.out.println(e);
                                                    }
                                                } else {
                                                    if (referencia.equals(Parr2)) {
                                                        media = produccion * 2.3;
                                                        tone = media / 1000;
                                                        String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                                        try {
                                                            Connection con = Conexion.conectar("mysql");
                                                            Statement st = con.createStatement();
                                                            st.execute(Ik);
                                                        } catch (SQLException e) {
                                                            System.out.println(e);
                                                        }
                                                    } else {
                                                        if (referencia.equals(fresca2)) {
                                                            media = produccion * 2.3;
                                                            tone = media / 1000;
                                                            String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                                            try {
                                                                Connection con = Conexion.conectar("mysql");
                                                                Statement st = con.createStatement();
                                                                st.execute(Ik);
                                                            } catch (SQLException e) {
                                                                System.out.println(e);
                                                            }
                                                        } else {
                                                            if (referencia.equals(IgluCil20)) {
                                                                media = produccion * 20.3;
                                                                tone = media / 1000;
                                                                String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                                                try {
                                                                    Connection con = Conexion.conectar("mysql");
                                                                    Statement st = con.createStatement();
                                                                    st.execute(Ik);
                                                                } catch (SQLException e) {
                                                                    System.out.println(e);
                                                                }
                                                            } else {
                                                                if (referencia.equals(Igl15)) {
                                                                    media = produccion * 15.3;
                                                                    tone = media / 1000;
                                                                    String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                                                    try {
                                                                        Connection con = Conexion.conectar("mysql");
                                                                        Statement st = con.createStatement();
                                                                        st.execute(Ik);
                                                                    } catch (SQLException e) {
                                                                        System.out.println(e);
                                                                    }
                                                                } else {
                                                                    if (referencia.equals(Igl2)) {
                                                                        media = produccion * 2.3;
                                                                        tone = media / 1000;
                                                                        String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                                                        try {
                                                                            Connection con = Conexion.conectar("mysql");
                                                                            Statement st = con.createStatement();
                                                                            st.execute(Ik);
                                                                        } catch (SQLException e) {
                                                                            System.out.println(e);
                                                                        }
                                                                    } else {
                                                                        if (referencia.equals(Igl3)) {
                                                                            media = produccion * 3.3;
                                                                            tone = media / 1000;
                                                                            String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                                                            try {
                                                                                Connection con = Conexion.conectar("mysql");
                                                                                Statement st = con.createStatement();
                                                                                st.execute(Ik);
                                                                            } catch (SQLException e) {
                                                                                System.out.println(e);
                                                                            }
                                                                        } else {
                                                                            if (referencia.equals(Fres3)) {
                                                                                media = produccion * 3.3;
                                                                                tone = media / 1000;
                                                                                String Ik = "INSERT INTO kilosproducidos SET referencia = '" + referencia + "', kilosp = '" + media + "', toneladas = '" + tone + "'";
                                                                                try {
                                                                                    Connection con = Conexion.conectar("mysql");
                                                                                    Statement st = con.createStatement();
                                                                                    st.execute(Ik);
                                                                                } catch (SQLException e) {
                                                                                    System.out.println(e);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }// VISUALIZA EL TOTAL DE LOS KILOS PRODUCIDOS POR TURNO

    public boolean Cargabd() {
        String sql = "SELECT nombre FROM referenciasmedellin";
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
        return true;
    }//carga las referencias de productos de medellin

    public void ConsultaTablas(String Test) {
        tbplasrecibido.setModel(new DefaultTableModel());
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("REFERENCIA");
        modelo.addColumn("CANTIDAD");
        String[] Plaspro = new String[2];
        try {

            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT referenciaP,cantidad FROM plasticobodegapt WHERE provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'");

            while (rs.next()) {

                Plaspro[0] = rs.getString(1);
                Plaspro[1] = rs.getString(2);
                modelo.addRow(Plaspro);
                tbplasrecibido.setModel(modelo);
                tbplasrecibido.getColumnModel().getColumn(0).setPreferredWidth(200);
                tbplasrecibido.getColumnModel().getColumn(1).setPreferredWidth(50);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
    public void extraeInventarioInicial() {
        String Ex = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'IGLU 500 GRAMOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex);
            while (rs.next()) {
                cantIIg500 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex2 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'IGLU 3 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex2);
            while (rs.next()) {
                cantIIg3k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex3 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'IGLU 7 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex3);
            while (rs.next()) {
                cantIIg7k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex4 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'IGLU 20 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex4);
            while (rs.next()) {
                cantIIg20k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex5 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'PARRANDA 2 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex5);
            while (rs.next()) {
                cantIPr2k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex6 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'PARRANDA 12 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex6);
            while (rs.next()) {
                cantIPr12k = rs.getInt("cantidad");
                System.out.println("parranda 12 kilos: "+cantIPr12k);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex7 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'FRESCAMPO 3 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex7);
            while (rs.next()) {
                cantIFr3k = rs.getInt("cantidad");
                System.out.println("frescampo 3 kilos: "+cantIFr3k);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex8 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'ESCAMA 20 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex8);
            while (rs.next()) {
                cantIEs20k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex9 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'BLOQUE 25 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex9);
            while (rs.next()) {
                cantIBl25k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex10 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'CUARTO DE BLOQUE' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex10);
            while (rs.next()) {
                cantIBl = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex11 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'PICADA TRANSP 20 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex11);
            while (rs.next()) {
                cantIPt20k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex12 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'POLAR 2 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex12);
            while (rs.next()) {
                cantIPl2k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex13 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'POLAR 12 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex13);
            while (rs.next()) {
                cantIPl12k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex14 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'POLAR 20 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex14);
            while (rs.next()) {
                cantIPl20k = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex15 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'POLAR 3 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex15);
            while (rs.next()) {

                cantIPl3k = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }
        String Ex16 = "SELECT cantidad FROM inventarioinicial WHERE referencia = 'REEMPAQUE' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Ex16);
            while (rs.next()) {

                cantIReem = rs.getInt("cantidad");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR Soft-Ice: " + e);
        }

    }//extrae inventario inicial para operacion

    public void extraePlasticoRecibido() {
        String PR = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'IGLU 500 GRAMOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR);
            while (rs.next()) {
                canTIg500 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR1 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'IGLU 3 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR1);
            while (rs.next()) {
                canTIg3k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR2 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'IGLU 7 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR2);
            while (rs.next()) {
                canTIg7k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR3 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'IGLU 20 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR3);
            while (rs.next()) {
                canTIg20k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR4 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'PARRANDA 2 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR4);
            while (rs.next()) {
                canTPr2k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR5 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'PARRANDA 12 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR5);
            while (rs.next()) {
                canTPr12k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR6 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'FRESCAMPO 3 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR6);
            while (rs.next()) {
                canTFr3k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR7 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'ESCAMA 20 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR7);
            while (rs.next()) {
                canTEs20k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR8 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'BLOQUE 25 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR8);
            while (rs.next()) {
                canTBl25k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR9 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'CUARTO DE BLOQUE' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR9);
            while (rs.next()) {
                canTBl = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR10 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'PICADA TRANSP 20 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR10);
            while (rs.next()) {
                canTPt20k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR11 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'POLAR 3 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR11);
            while (rs.next()) {
                canTPl3k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR12 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'POLAR 2 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR12);
            while (rs.next()) {
                canTPl2k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR13 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'POLAR 12 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR13);
            while (rs.next()) {
                canTPL12k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR14 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'POLAR 20 KILOS' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR14);
            while (rs.next()) {
                canTPL20k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String PR15 = "SELECT cantidad FROM plasticobodegapt WHERE referenciaP = 'REEMPAQUE' AND provienede = 'produccion' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PR15);
            while (rs.next()) {
                canTReem = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

    }//EXTRAE EL PLASTICO RECIBIDO DE LA BODEGA

    public void extraeBajas() {
        String EB = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'IGLU 500 GRAMOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB);
            while (rs.next()) {
                canBIg500 = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB1 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'IGLU 3 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB1);
            while (rs.next()) {
                canBIg3k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB2 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'IGLU 7 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB2);
            while (rs.next()) {
                canBIg7k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB3 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'IGLU 20 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB3);
            while (rs.next()) {
                canBIg20k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB4 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'PARRANDA 12 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB4);
            while (rs.next()) {
                canBPr12k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB5 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'PARRANDA 2 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB5);
            while (rs.next()) {
                canBPr2k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB6 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'FRESCAMPO 3 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB6);
            while (rs.next()) {
                canBFr3k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB7 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'ESCAMA 20 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB7);
            while (rs.next()) {
                canBEs20k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB8 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'BLOQUE 25 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB8);
            while (rs.next()) {
                canBBl25k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB9 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'CUARTO DE BLOQUE' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB9);
            while (rs.next()) {
                canBCb = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB10 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'PICADA TRANSP 20 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB10);
            while (rs.next()) {
                canBPt20k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB11 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'POLAR 3 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB11);
            while (rs.next()) {
                canBPl3k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB12 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'POLAR 2 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB12);
            while (rs.next()) {
                canBPl2k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB13 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'POLAR 12 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB13);
            while (rs.next()) {
                canBPl12k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB14 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'POLAR 20 KILOS' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB14);
            while (rs.next()) {
                canBPl20k = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        String EB15 = "SELECT plasticoBaja FROM plasticoproduccion WHERE referencia = 'REEMPAQUE' AND fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EB15);
            while (rs.next()) {
                canBReem = rs.getInt("plasticoBaja");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

    }//EXTARE LAS BAJAS DEL PLASTICO

    public void extraeFinal() {
        String EF ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'IGLU 500 GRAMOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF);
            while(rs.next()){
                CanFIg500 = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String EF1 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'IGLU 3 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF1);
            while(rs.next()){
                CanFIg3k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String EF2 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'IGLU 7 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF2);
            while(rs.next()){
                CanFIg7k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String EF3 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'IGLU 20 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF3);
            while(rs.next()){
                CanFIg20k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
         String EF4 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'PARRANDA 2 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF4);
            while(rs.next()){
                CanFPr2k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String EF5 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'PARRANDA 12 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF5);
            while(rs.next()){
                CanFPr12k = rs.getInt("cantidad");
                System.out.println("parranda 12 kilos: "+ CanFPr12k);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String EF6 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'FRESCAMPO 3 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF6);
            while(rs.next()){
                CanFFr3k = rs.getInt("cantidad");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String EF7 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'ESCAMA 20 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF7);
            while(rs.next()){
                CanFEs20k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String EF8 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'BLOQUE 25 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF8);
            while(rs.next()){
                 CanFBL25k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String EF9 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'CUARTO DE BLOQUE' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF9);
            while(rs.next()){
                 CanFCb = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String EF10 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'PICADA TRANSP 20 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF10);
            while(rs.next()){
                 CanFPt20k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String EF11 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'POLAR 3 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF11);
            while(rs.next()){
                 CanFPl3k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
         String EF12 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'POLAR 2 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF12);
            while(rs.next()){
                 CanFPl2k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        } 
        String EF13 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'POLAR 12 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF13);
            while(rs.next()){
                 CanFPl12k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String EF14 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'POLAR 20 KILOS' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF14);
            while(rs.next()){
                 CanFPl20k = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        } 
        String EF15 ="SELECT cantidad FROM plasticoproduccion WHERE referencia= 'REEMPAQUE' AND fecha BETWEEN'"+txtfecha1.getText()+" "+cbxdesde.getSelectedItem()+"' AND '"+txtfecha2.getText()+" "+cbxhasta.getSelectedItem()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(EF15);
            while(rs.next()){
                 CanFRee = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
    }//extrae inventario final
    
    public void operacionTotal(){
        
        String refe  = "IGLU 500 GRAMOS";
        inventFinal( cantIIg500,CanFIg500, canTIg500,canBIg500,refe);
        String refe1 = "IGLU 3 KILOS";
        inventFinal(cantIIg3k,CanFIg3k, canTIg3k,canBIg3k,refe1);
        String refe2= "IGLU 7 KILOS";
        inventFinal(cantIIg7k,CanFIg7k, canTIg7k,canBIg7k,refe2);
        String refe3= "IGLU 20 KILOS";
        inventFinal(cantIIg20k,CanFIg20k, canTIg20k,canBIg20k,refe3);
        String refe4 = "PARRANDA 2 KILOS";
        inventFinal(cantIPr2k,CanFPr2k, canTPr2k,canBPr2k,refe4);
        String refe5 = "PARRANDA 12 KILOS";
        inventFinal(cantIPr12k,CanFPr12k, canTPr12k,canBPr12k,refe5);
        String refe6 = "FRESCAMPO 3 KILOS";
        inventFinal(cantIFr3k,CanFFr3k, canTFr3k,canBFr3k,refe6);
        String refe7 = "ESCAMA 20 KILOS";
        inventFinal(cantIEs20k,CanFEs20k, canTEs20k,canBEs20k,refe7);
        String refe8 = "BLOQUE 25 KILOS";
        inventFinal(cantIBl25k,CanFBL25k, canTBl25k,canBBl25k,refe8);
        String refe9 = "CUARTO DE BLOQUE";
        inventFinal(cantIBl,CanFCb, canTBl,canBCb,refe9);
        String refe10 = "PICADA TRANSP 20 KILOS";
        inventFinal(cantIPt20k,CanFPt20k, canTPt20k,canBPt20k,refe10);
        String refe11 = "POLAR 2 KILOS";
        inventFinal(cantIPl2k,CanFPl2k, canTPl2k,canBPl2k,refe11);
        String refer12 = "POLAR 3 KILOS";
        inventFinal(cantIPl3k,CanFPl3k, canTPl3k,canBPl3k,refer12);
        String refe13 = "POLAR 12 KILOS";
        inventFinal(cantIPl12k,CanFPl12k, canTPL12k,canBPl12k,refe13);
        String refe14 = "POLAR 20 KILOS";
        inventFinal(cantIPl20k,CanFPl20k, canTPL20k,canBPl20k,refe14);
        String refe15 = "REEMPAQUE";
        inventFinal(cantIReem,CanFRee, canTReem,canBReem,refe15);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxturno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxreferencia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtlote = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtplasticobaja = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbplasBaja = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbplasrecibido = new javax.swing.JTable();
        txtfecha1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtfecha2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbinicial = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbproduccion = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btnTotal = new javax.swing.JButton();
        cbxdesde = new javax.swing.JComboBox<>();
        cbxhasta = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbfinal = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PLASTICO EN PRODUCCION");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("PLASTICO EN PRODUCCION");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("TURNO");

        cbxturno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxturno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("REFERENCIA");

        cbxreferencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxreferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("CANTIDAD");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("LOTE");

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnconsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnconsultar.setText("CONSULTAR");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("PLASTICO DE BAJA");

        tbplasBaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbplasBaja);

        tbplasrecibido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbplasrecibido);

        jLabel7.setText("FECHA: aaaa-mm-dd");

        jLabel8.setText("PLASTICO RECIBIDO");

        jLabel9.setText("PLASTICO BAJA");

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
        jScrollPane3.setViewportView(tbinicial);

        jLabel10.setText("INVENTARIO INICIAL ");

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
        jScrollPane4.setViewportView(tbproduccion);

        jLabel11.setText("PRODUCCION TOTAL");

        btnTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnTotal.setText("TOTAL PRODUCCION");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        cbxdesde.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DESDE" }));

        cbxhasta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HASTA" }));

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

        jLabel12.setText("INVENTARIO FINAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(45, 45, 45)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtplasticobaja, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(153, 153, 153)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnconsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTotal)
                        .addGap(372, 372, 372))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtfecha1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxdesde, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxhasta, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtplasticobaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addGap(98, 98, 98))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTotal)
                                    .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)))
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxdesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxhasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        String turno = cbxturno.getSelectedItem().toString();
        String referencia = cbxreferencia.getSelectedItem().toString();
        String cantidad = txtcantidad.getText();
        String lote = txtlote.getText();
        String plasticoBaja = txtplasticobaja.getText();
        ingresarinicial();

        BeansPlasticoProduccion bp = new BeansPlasticoProduccion();
        bp.setTurno(turno);
        bp.setReferencia(referencia);
        bp.setCantidad(cantidad);
        bp.setLote(lote);
        bp.setPlasticoBaja(plasticoBaja);

        DAOPlasticoProduccion dao = new DAOPlasticoProduccion();
        dao.InsertarDatos(bp);
        //dao.InsertaFinal(bp);
        JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
        cbxturno.setSelectedItem("");
        cbxreferencia.setSelectedItem("");
        txtcantidad.setText("");
        txtlote.setText("");
        txtplasticobaja.setText("");

    }//GEN-LAST:event_btnguardarActionPerformed
    public void PlasticoBaja(String test) {
        tbplasBaja.setModel(new DefaultTableModel());
        DefaultTableModel Baja = new DefaultTableModel();
        Baja.addColumn("REFERENCIA");
        Baja.addColumn("CANTIDAD");

        String[] PlasBaja = new String[2];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT referencia,plasticoBaja FROM plasticoproduccion WHERE fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'");

            while (rs.next()) {
                PlasBaja[0] = rs.getString(1);
                PlasBaja[1] = rs.getString(2);
                Baja.addRow(PlasBaja);
                tbplasBaja.setModel(Baja);
                tbplasBaja.getColumnModel().getColumn(0).setPreferredWidth(200);
                tbplasBaja.getColumnModel().getColumn(1).setPreferredWidth(50);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void InventarioFinal(String test) {
        tbfinal.setModel(new DefaultTableModel());
        DefaultTableModel inve = new DefaultTableModel();
        inve.addColumn("REFERENCIA");
        inve.addColumn("CANTIDAD");
        String[] inven = new String[2];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT referencia,cantidad FROM plasticoproduccion WHERE fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'");

            while (rs.next()) {
                inven[0] = rs.getString(1);
                inven[1] = rs.getString(2);
                inve.addRow(inven);
                tbfinal.setModel(inve);
                tbfinal.getColumnModel().getColumn(0).setPreferredWidth(200);
                tbfinal.getColumnModel().getColumn(1).setPreferredWidth(50);
            }

        } catch (SQLException exc) {
            System.out.println(exc);
        }
    }

    public void InventarioInicial() {
        tbinicial.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String[] reci = new String[2];
        String fin = "SELECT referencia,cantidad FROM inventarioinicial WHERE fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(fin);
            while (rs.next()) {
                reci[0] = rs.getString(1);
                reci[1] = rs.getString(2);
                dtm.addRow(reci);
                tbinicial.setModel(dtm);
                tbinicial.getColumnModel().getColumn(0).setPreferredWidth(200);
                tbinicial.getColumnModel().getColumn(1).setPreferredWidth(50);
            }
        } catch (SQLException e) {
        }

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

    public void produccion(String test) {
        tbproduccion.setModel(new DefaultTableModel());
        DefaultTableModel prod = new DefaultTableModel();
        prod.addColumn("REFERENCIA");
        prod.addColumn("CANTIDAD");
        String[] produ = new String[2];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT referencia,cantidad FROM produccion WHERE fecha BETWEEN '" + txtfecha1.getText() + " " + cbxdesde.getSelectedItem() + "' AND '" + txtfecha2.getText() + " " + cbxhasta.getSelectedItem() + "'");
            while (rs.next()) {
                produ[0] = rs.getString(1);
                produ[1] = rs.getString(2);
                prod.addRow(produ);
                tbproduccion.setModel(prod);
                tbproduccion.getColumnModel().getColumn(0).setPreferredWidth(200);
                tbproduccion.getColumnModel().getColumn(1).setPreferredWidth(50);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }
    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed

        this.ConsultaTablas(txtfecha1.getText());
        this.ConsultaTablas(txtfecha2.getText());
        this.ConsultaTablas(cbxdesde.getSelectedItem().toString());
        this.ConsultaTablas(cbxhasta.getSelectedItem().toString());
        this.PlasticoBaja(txtfecha1.getText());
        this.PlasticoBaja(txtfecha2.getText());
        this.PlasticoBaja(cbxdesde.getSelectedItem().toString());
        this.PlasticoBaja(cbxhasta.getSelectedItem().toString());
        this.InventarioFinal(txtfecha1.getText());
        this.InventarioFinal(txtfecha2.getText());
        this.InventarioFinal(cbxdesde.getSelectedItem().toString());
        this.InventarioFinal(cbxhasta.getSelectedItem().toString());
        this.InventarioInicial();
         this.produccion(txtfecha1.getText());
        this.produccion(txtfecha2.getText());
        this.produccion(cbxdesde.getSelectedItem().toString());
        this.produccion(cbxhasta.getSelectedItem().toString());
        //tbplasBaja.setModel(new DefaultTableModel());
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        extraeInventarioInicial();
         extraePlasticoRecibido();
        extraeBajas();
        extraeFinal();
        kilosProducidos();
        operacionTotal();
        this.produccion(txtfecha1.getText());
        this.produccion(txtfecha2.getText());
        this.produccion(cbxdesde.getSelectedItem().toString());
        this.produccion(cbxhasta.getSelectedItem().toString());
        this.produccion(cbxturno.getSelectedItem().toString());
    }//GEN-LAST:event_btnTotalActionPerformed

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
            java.util.logging.Logger.getLogger(PlasticoEnProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlasticoEnProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlasticoEnProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlasticoEnProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlasticoEnProduccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTotal;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cbxdesde;
    private javax.swing.JComboBox<String> cbxhasta;
    private javax.swing.JComboBox<String> cbxreferencia;
    private javax.swing.JComboBox<String> cbxturno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTable tbfinal;
    private javax.swing.JTable tbinicial;
    private javax.swing.JTable tbplasBaja;
    private javax.swing.JTable tbplasrecibido;
    private javax.swing.JTable tbproduccion;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtfecha1;
    private javax.swing.JTextField txtfecha2;
    private javax.swing.JTextField txtlote;
    private javax.swing.JTextField txtplasticobaja;
    // End of variables declaration//GEN-END:variables
}
