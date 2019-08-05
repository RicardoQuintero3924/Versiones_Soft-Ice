package VistasCC;

import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Produccion extends javax.swing.JFrame {

    public Produccion() {
        initComponents();
        this.cbxturno.addItem("Turno 1");
        this.cbxturno.addItem("Turno 2");
        this.cbxturno.addItem("Turno 3");
        
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
    }

    public void operacionInicial() {
        double Polar2 = 0;
        double Polar3 = 0;
        double Polar4 = 0;
        double Polar12 = 0;
        double Polar15 = 0;
        double Polar20 = 0;
        double Escama20 = 0;
        double Esquimal20 = 0;
        double Esquimal12 = 0;
        double Artico12 = 0;
        double Iglu7 = 0;
        double Colsu3 = 0;
        double Parra2 = 0;
        double Esqui2 = 0;
        double Fresca2 = 0;
        double Iglucili20 = 0;
        double Iglu15 = 0;
        double Iglu3 = 0;
        double Iglu2 = 0;
        double Fresca3 = 0;
        //metodo que recupera la cantidad recibida de plastico
        String extraeCantidad = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL  FROM produccion WHERE referencia = 'POLAR 2 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extraeCantidad);
            while (rs.next()) {
                Polar2 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Polar2);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        String extrae1 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'POLAR 4 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae1);
            while (rs.next()) {
                Polar4 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Polar4);
            }
        } catch (SQLException e) {
        }
        String extrae2 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'POLAR 12 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae2);
            while (rs.next()) {
                Polar12 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Polar12);
            }
        } catch (SQLException e) {
        }
        String extrae3 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'POLAR 15 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae3);
            while (rs.next()) {
                Polar15 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Polar15);
            }
        } catch (SQLException e) {
        }
        String extrae4 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'POLAR 20 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae4);
            while (rs.next()) {
                Polar20 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Polar20);
            }
        } catch (SQLException e) {
        }
        String extrae5 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'ESCAMA 20 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae5);
            while (rs.next()) {
                Escama20 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Escama20);
            }
        } catch (SQLException e) {
        }
        String extrae6 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'ESQUIMAL 12 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae6);
            while (rs.next()) {
                Esquimal12 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Esquimal12);
            }
        } catch (SQLException e) {
        }
        String extrae7 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'ARTICO 12 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae7);
            while (rs.next()) {
                Artico12 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Artico12);
            }
        } catch (SQLException e) {
        }
        String extrae8 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'IGLU 7 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae8);
            while (rs.next()) {
                Iglu7 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Iglu7);
            }
        } catch (SQLException e) {
        }
        String extrae9 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'COLSUBSIDIO 3 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae9
            );
            while (rs.next()) {
                Colsu3 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Colsu3);
            }
        } catch (SQLException e) {
        }
        String extrae10 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'PARRANDA 2 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae10);
            while (rs.next()) {
                Parra2 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Parra2);
            }
        } catch (SQLException e) {
        }
        String extrae11 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'ESQUIMAL 2 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae11);
            while (rs.next()) {
                Esqui2 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Esqui2);
            }
        } catch (SQLException e) {
        }
        String extrae12 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'FRESCAMPO 2 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae12);
            while (rs.next()) {
                Fresca2 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Fresca2);
            }
        } catch (SQLException e) {
        }
        String extrae13 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'IGLU CILINDRO 20 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae13);
            while (rs.next()) {
                Iglucili20 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Iglucili20);
            }
        } catch (SQLException e) {
        }
        String extrae14 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'IGLU 15 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae14);
            while (rs.next()) {
                Iglu15 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Iglu15);
            }
        } catch (SQLException e) {
        }
        String extrae15 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'IGLU 3 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae15);
            while (rs.next()) {
                Iglu3 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Iglu3);
            }
        } catch (SQLException e) {
        }
        String extrae16 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'IGLU 2 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae16);
            while (rs.next()) {
                Iglu2 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Iglu2);
            }
        } catch (SQLException e) {
        }
        String extrae17 = "SELECT SUM(cantidad) AS CANTIDAD_TOTAL FROM plasticobodegapt WHERE referenciaP = 'FRESCAMPO 3 KILOS' AND provienede = 'PRODUCCION'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extrae17);
            while (rs.next()) {
                Fresca3 = rs.getInt("CANTIDAD_TOTAL");
                System.out.println(Fresca3);
            }
        } catch (SQLException e) {
        }
    }

    public void extraeEscama() {
        Calendar fec = new GregorianCalendar();
        int Año = fec.get(Calendar.YEAR);
        int Mes = fec.get(Calendar.MONTH);
        int Dia = fec.get(Calendar.DAY_OF_MONTH);
        Mes = Mes + 1;
        int DiaA = fec.get(Calendar.DAY_OF_MONTH);
        DiaA = DiaA - 1;
        Date fecha = fec.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String FechaSis = sdf.format(fecha);
        String Turno = cbxturno.getSelectedItem().toString();
        if (Turno.equals("Turno 1")) {
            String extrae17 = "SELECT kilosproducidos.referencia,produccion.cantidad,kilosproducidos.kilosp,kilosproducidos.toneladas FROM kilosproducidos,produccion WHERE fechak BETWEEN '" + Año + "-" + Mes + "-" + DiaA + " 21:00:00' AND '" + Año + "-" + Mes + "-" + Dia + " 05:00:00' AND kilosproducidos.referencia = produccion.referencia AND kilosproducidos.referencia= 'ESCAMA 20 KILOS' AND produccion.referencia = 'ESCAMA 20 KILOS' AND fecha BETWEEN '"+ Año + "-" + Mes + "-" + DiaA +" 21:00:00' AND '"+ Año + "-" + Mes + "-" + Dia +" 05:00:00'";
            consulta(extrae17);
        } else {
            if (Turno.equals("Turno 2")) {
                String extrae18 = "SELECT kilosproducidos.referencia,produccion.cantidad,kilosproducidos.kilosp,kilosproducidos.toneladas  FROM kilosproducidos,produccion WHERE fechak BETWEEN '" + Año + "-" + Mes + "-" + Dia + " 05:00:00' AND '" + Año + "-" + Mes + "-" + Dia + " 13:00:00' AND kilosproducidos.referencia = produccion.referencia AND kilosproducidos.referencia= 'ESCAMA 20 KILOS' AND produccion.referencia = 'ESCAMA 20 KILOS' AND fecha BETWEEN '"+ Año + "-" + Mes + "-" + Dia +" 05:00:00' AND '"+ Año + "-" + Mes + "-" + Dia +" 13:00:00'";
                consulta(extrae18);
            }else{
                if(Turno.equals("Turno 3")){
                  String extrae19 = "SELECT kilosproducidos.referencia,produccion.cantidad,kilosproducidos.kilosp,kilosproducidos.toneladas FROM kilosproducidos,produccion WHERE fechak BETWEEN '" + Año + "-" + Mes + "-" + Dia + " 13:00:00' AND '" + Año + "-" + Mes + "-" + Dia + " 21:00:00' AND kilosproducidos.referencia = produccion.referencia AND kilosproducidos.referencia= 'ESCAMA 20 KILOS' AND produccion.referencia = 'ESCAMA 20 KILOS' AND fecha BETWEEN '"+ Año + "-" + Mes + "-" + Dia +" 13:00:00' AND '"+ Año + "-" + Mes + "-" + Dia +" 21:00:00'";
                  consulta(extrae19);
                }
            }
        }
    }
    
    public void extraeBloque(){
         Calendar fec = new GregorianCalendar();
        int Año = fec.get(Calendar.YEAR);
        int Mes = fec.get(Calendar.MONTH);
        int Dia = fec.get(Calendar.DAY_OF_MONTH);
        Mes = Mes + 1;
        int DiaA = fec.get(Calendar.DAY_OF_MONTH);
        DiaA = DiaA - 1;
        Date fecha = fec.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String FechaSis = sdf.format(fecha);
        String Turno = cbxturno.getSelectedItem().toString();
        if (Turno.equals("Turno 1")) {
            String extrae17 = "SELECT kilosproducidos.referencia,produccion.cantidad,Kilosproducidos.kilosp,kilosproducidos.toneladas FROM kilosproducidos,produccion WHERE fechak BETWEEN '" + Año + "-" + Mes + "-" + DiaA + " 21:00:00' AND '" + Año + "-" + Mes + "-" + Dia + " 05:00:00' AND kilosproducidos.referencia = produccion.referencia AND kilosproducidos.referencia LIKE '%BLOQUE%' AND produccion.referencia LIKE '%BLOQUE%' AND kilosproducidos.fechak = produccion.fecha";
            consultaBlo(extrae17);
        } else {
            if (Turno.equals("Turno 2")) {
                String extrae18 = "SELECT kilosproducidos.referencia,produccion.cantidad,kilosproducidos.kilosp,kilosproducidos.toneladas  FROM kilosproducidos,produccion WHERE fechak BETWEEN '" + Año + "-" + Mes + "-" + Dia + " 05:00:00' AND '" + Año + "-" + Mes + "-" + Dia + " 13:00:00' AND kilosproducidos.referencia = produccion.referencia AND kilosproducidos.referencia LIKE '%BLOQUE%' AND produccion.referencia LIKE '%BLOQUE%'  AND kilosproducidos.fechak = produccion.fecha";
                consultaBlo(extrae18);
            }else{ 
                if(Turno.equals("Turno 3")){
                  String extrae19 = "SELECT kilosproducidos.referencia,produccion.cantidad,kilosproducidos.kilosp,kilosproducidos.toneladas FROM kilosproducidos,produccion WHERE fechak BETWEEN '" + Año + "-" + Mes + "-" + Dia + " 13:00:00' AND '" + Año + "-" + Mes + "-" + Dia + " 21:00:00' AND kilosproducidos.referencia = produccion.referencia AND kilosproducidos.referencia LIKE '%BLOQUE%' AND produccion.referencia LIKE '%BLOQUE%'  AND kilosproducidos.fechak = produccion.fecha";
                  consultaBlo(extrae19);
                }
            }
        }
    }

    public void toneladasT() {
        Calendar fech = new GregorianCalendar();
        int año = fech.get(Calendar.YEAR);
        int mes = fech.get(Calendar.MONTH);
        int dia = fech.get(Calendar.DAY_OF_MONTH);
        int diaB = fech.get(Calendar.DAY_OF_MONTH);
        mes = mes + 1;
        String turno = cbxturno.getSelectedItem().toString();
        if (turno.equals("Turno 1")) {
            diaB = diaB - 1;
            String Tone = "SELECT SUM(toneladas) FROM kilosproducidos WHERE fechak BETWEEN '" + año + "-" + mes + "-" + diaB + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 06:00:00'";
            consulta3(Tone);
        } else {
            if (turno.equals("Turno 2")) {
                String Tone = "SELECT SUM(toneladas) FROM kilosproducidos WHERE fechak BETWEEN '" + año + "-" + mes + "-" + dia + " 06:00:00' AND '" + año + "-" + mes + "-" + dia + " 14:00:00'";
                consulta3(Tone);
            } else {
                if (turno.equals("Turno 3")) {
                    String Tone = "SELECT SUM(toneladas) FROM kilosproducidos WHERE fechak BETWEEN '" + año + "-" + mes + "-" + dia + " 14:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:00:00'";
                    consulta3(Tone);
                }
            }
        }
    }

    public void consulta(String consul) {
        tbescama.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        dtm.addColumn("KILOS PRO");
        dtm.addColumn("TONELADAS");
        String[] cant = new String[4];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cant[0] = rs.getString(1);
                cant[1] = rs.getString(2);
                cant[2] = rs.getString(3);
                cant[3] = rs.getString(4);
                dtm.addRow(cant);
                tbescama.setModel(dtm);
                
            }
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "ERROR Soft-Ice :" + e);
        }
    }

    public void consulta2(String kilPro) {
        tbcilindro.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        dtm.addColumn("KILOS PRO");
        dtm.addColumn("TONELADAS");
       
        String[] kil = new String[4];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(kilPro);
            while (rs.next()) {
                kil[0] = rs.getString(1);
                kil[1] = rs.getString(2);
                kil[2] = rs.getString(3);
                kil[3] = rs.getString(4);
                dtm.addRow(kil);
                tbcilindro.setModel(dtm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: JTABLE CILINDRO: " + e);
        }
    }
    
    public void consultaBlo(String bloq){
        tbbloque.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        dtm.addColumn("KILOS PRO");
        dtm.addColumn("TONELADAS"); 
        String[] kil = new String[4];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(bloq);
            while (rs.next()) {
                kil[0] = rs.getString(1);
                kil[1] = rs.getString(2);
                kil[2] = rs.getString(3);
                kil[3] = rs.getString(4);
                dtm.addRow(kil);
                tbbloque.setModel(dtm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: JTABLE BLOQUE " + e);
        }
        
    }
    public void consulta3(String Tone) {
        tbton.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("TONELADAS");
        String[] kil = new String[1];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Tone);
            while (rs.next()) {
                kil[0] = rs.getString(1);
                dtm.addRow(kil);
                tbton.setModel(dtm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

    }

    public void kilosProducidos() {//crear tabla para realizar la consulta de kilosproducidos.
        Calendar cal = new GregorianCalendar();
        int Año = cal.get(Calendar.YEAR);
        int Mes = cal.get(Calendar.MONTH);
        int Dia = cal.get(Calendar.DAY_OF_MONTH);
        Mes = Mes + 1;
        String Turno = cbxturno.getSelectedItem().toString();
        if (Turno.equals("Turno 1")) {
            int diaA = cal.get(Calendar.DAY_OF_MONTH);
            diaA = diaA - 1;
            String kilPro = "SELECT kilosproducidos.referencia,produccion.cantidad,kilosproducidos.kilosp,kilosproducidos.toneladas FROM kilosproducidos,produccion WHERE fechak BETWEEN '" + Año + "-" + Mes + "-" + diaA + " 21:00:00' AND '" + Año + "-" + Mes + "-" + Dia + " 05:00:00' AND kilosproducidos.referencia = produccion.referencia AND fecha BETWEEN '"+Año+"-"+Mes+"-"+diaA+" 21:00:00' AND '"+Año+"-"+Mes+"-"+Dia +" 05:00:00'";
            consulta2(kilPro);
        } else {
            if (Turno.equals("Turno 2")) {
                String kilPro = "SELECT kilosproducidos.referencia,produccion.cantidad,kilosproducidos.kilosp,kilosproducidos.toneladas FROM kilosproducidos,produccion WHERE fechak BETWEEN '" + Año + "-" + Mes + "-" + Dia + " 05:00:00' AND '" + Año + "-" + Mes + "-" + Dia + " 13:00:00' AND kilosproducidos.referencia = produccion.referencia AND fecha BETWEEN '"+Año+"-"+Mes+"-"+Dia+" 05:00:00' AND '"+Año+"-"+Mes+"-"+Dia +" 13:00:00'";
                consulta2(kilPro);
            } else {
                if (Turno.equals("Turno 3")) {
                String kilPro = "SELECT kilosproducidos.referencia,produccion.cantidad,kilosproducidos.kilosp,kilosproducidos.toneladas FROM kilosproducidos,produccion WHERE fechak BETWEEN '" + Año + "-" + Mes + "-" + Dia + " 13:00:00' AND '" + Año + "-" + Mes + "-" + Dia + " 21:00:00' AND kilosproducidos.referencia = produccion.referencia AND fecha BETWEEN '"+Año+"-"+Mes+"-"+Dia+" 13:00:00' AND '"+Año+"-"+Mes+"-"+Dia +" 21:00:00'";
                    consulta2(kilPro);
                }
            }
        }
    }

    public void clasificaReferencias() {
        //se debe crear un metodo que separe las referencias entre escama,cilindro y bloque. se debe extraer de produccion
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
        Calendar cal = new GregorianCalendar();
        Date fecha = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String fech = sdf.format(fecha);
        System.out.println("fecha sistema " + fech);
        String f = "2019-04-24";
        String trae = "SELECT referencia from produccion WHERE fecha LIKE '%" + f + "%'";
        String[] ref = new String[30];
        String refe = "";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(trae);

            while (rs.next()) {
                refe = rs.getString("referencia");
                System.out.println(refe);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice " + e);
        }
        if (Escama.equals(refe)) {
            String Esca = "SELECT referencia";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxturno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbcilindro = new javax.swing.JTable();
        btnconsulta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbescama = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbton = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbbloque = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUCCION");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("PRODUCCION");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("TURNO");

        cbxturno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxturno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        tbcilindro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbcilindro);

        btnconsulta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnconsulta.setText("CONSULTAR");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TONELADAS PRODUCIDAS");

        tbescama.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbescama);

        tbton.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbton);

        tbbloque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbbloque);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("CILINDRO:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("ESCAMA:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("BLOQUE:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnconsulta))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(437, 437, 437)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(jLabel5))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
        kilosProducidos();
        toneladasT();
        extraeEscama();
        extraeBloque();
           
    }//GEN-LAST:event_btnconsultaActionPerformed

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
            java.util.logging.Logger.getLogger(Produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsulta;
    private javax.swing.JComboBox<String> cbxturno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbbloque;
    private javax.swing.JTable tbcilindro;
    private javax.swing.JTable tbescama;
    private javax.swing.JTable tbton;
    // End of variables declaration//GEN-END:variables
}
