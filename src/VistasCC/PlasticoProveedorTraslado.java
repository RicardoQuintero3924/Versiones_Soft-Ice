package VistasCC;

import Beans.BeansPlasticoProveedorTraslados;
import Bussines.BussinesLogic;
import DAO.DAOPlasticoProveedorTraslado;
import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class PlasticoProveedorTraslado extends javax.swing.JFrame {
    
    String opc;
    int entrada = 0;
    int salida = 0;
    int saldo;
    int entra;
    int resta;
    int aux;
    int promedio;
    int saldodias;
    String color = "";

    public PlasticoProveedorTraslado() {
        initComponents();
        Cargabd();

        this.TipoMovimiento.addItem("ENTRADA");
        this.TipoMovimiento.addItem("SALIDA");

//implementar hora...
        Calendar cal = Calendar.getInstance();
        String fecha, hora;
        fecha = cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR);
        hora = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
        this.fecha.setText(fecha);
        this.hora.setText(hora);
    }

    public void DAO() {
        String tipomoviemiento = TipoMovimiento.getSelectedItem().toString();
        String salid = Salida.getSelectedItem().toString();
        String referencia = Referencia.getSelectedItem().toString();
        String cantidad = txtCantidad.getText();
        String Nroremision = txtremision.getText();
        String lote = txtlote.getText();

        BeansPlasticoProveedorTraslados bp = new BeansPlasticoProveedorTraslados();
        bp.setTipoMovimiento(tipomoviemiento);
        bp.setSalida(salid);
        bp.setReferencia(referencia);
        bp.setCantidad(cantidad);
        bp.setNroremision(Nroremision);
        bp.setLote(lote);
        bp.getTurno();

        DAOPlasticoProveedorTraslado dao = new DAOPlasticoProveedorTraslado();
        dao.InsertarPlasticoproveedorTraslado(bp);
        JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
        TipoMovimiento.setSelectedItem("");
        Salida.setSelectedItem("");
        Referencia.setSelectedItem("");
        txtCantidad.setText("");
        txtremision.setText("");
        txtlote.setText("");
    }

    public void sumaEntrada() {
        String Polar2 = "POLAR 2 KILOS";
        String Polar3 = "POLAR 3 KILOS";
        String Polar12 = "POLAR 12 KILOS";
        String Mini = "IGLU 500 GRAMOS";
        String Polar20 = "POLAR 20 KILOS";
        String Escama = "ESCAMA 20 KILOS";
        String Bloque = "BLOQUE 25 KILOS";
        String Parranda = "PARRANDA 12 KILOS";
        String Iglu7 = "IGLU 7 KILOS";
        String CBloque = "CUARTO DE BLOQUE";
        String Parra2 = "PARRANDA 2 KILOS";
        String Picada = "PICADA TRANSP 20 KILOS";
        String fresca2 = "FRESCAMPO 2 KILOS";
        String IgluCil20 = "IGLU CILINDRO 20 KILOS";
        String Iglu15 = "IGLU 15 KILOS";
        String Iglu3 = "IGLU 3 KILOS";
        String Iglu2 = "IGLU 2 KILOS";
        String Fresca3 = "FRESCAMPO 3 KILOS";
        String refe = Referencia.getSelectedItem().toString();
        if (refe.equals(Polar2)) {
            String entr = "SELECT SUM(cantidad) AS TOTALCANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Polar2 + "'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(entr);
                while (rs.next()) {
                    entrada = rs.getInt("TOTALCANTIDAD");
                    
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            if (refe.equals(Polar3)) {
                String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Polar3 + "'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(entr);
                    while (rs.next()) {
                        entrada = rs.getInt("CANTIDAD");
                        //System.out.println("entrada 3" +entrada);
                    }
                } catch (SQLException e) {
                }

            } else {
                if (refe.equals(Polar12)) {
                    String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Polar12 + "'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(entr);
                        while (rs.next()) {
                            entrada = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                    }
                } else {
                    if (refe.equals(Mini)) {
                        String entr = "SELECT SUM(cantidad)AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Mini + "'";
                        try {
                            Connection con = Conexion.conectar("mysql");
                            Statement st = con.createStatement();
                            ResultSet rs = st.executeQuery(entr);
                            while (rs.next()) {
                                entrada = rs.getInt("CANTIDAD");
                            }
                        } catch (SQLException e) {
                        }
                    } else {
                        if (refe.equals(Polar20)) {
                            String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Polar20 + "'";
                            try {
                                Connection con = Conexion.conectar("mysql");
                                Statement st = con.createStatement();
                                ResultSet rs = st.executeQuery(entr);
                                while (rs.next()) {
                                    entrada = rs.getInt("CANTIDAD");
                                }
                            } catch (SQLException e) {
                            }
                        } else {
                            if (refe.equals(Escama)) {
                                String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Escama + "'";
                                try {
                                    Connection con = Conexion.conectar("mysql");
                                    Statement st = con.createStatement();
                                    ResultSet rs = st.executeQuery(entr);
                                    while (rs.next()) {
                                        entrada = rs.getInt("CANTIDAD");
                                    }
                                } catch (SQLException e) {
                                }
                            } else {
                                if (refe.equals(Bloque)) {
                                    String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Bloque + "'";
                                    try {
                                        Connection con = Conexion.conectar("mysql");
                                        Statement st = con.createStatement();
                                        ResultSet rs = st.executeQuery(entr);
                                        while (rs.next()) {
                                            entrada = rs.getInt("CANTIDAD");
                                        }
                                    } catch (SQLException e) {
                                    }
                                } else {
                                    if (refe.equals(Parranda)) {
                                        String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Parranda + "'";
                                        try {
                                            Connection con = Conexion.conectar("mysql");
                                            Statement st = con.createStatement();
                                            ResultSet rs = st.executeQuery(entr);
                                            while (rs.next()) {
                                                entrada = rs.getInt("CANTIDAD");
                                            }
                                        } catch (SQLException e) {
                                        }
                                    } else {
                                        if (refe.equals(Iglu7)) {
                                            String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Iglu7 + "'";
                                            try {
                                                Connection con = Conexion.conectar("mysql");
                                                Statement st = con.createStatement();
                                                ResultSet rs = st.executeQuery(entr);
                                                while (rs.next()) {
                                                    entrada = rs.getInt("CANTIDAD");
                                                }
                                            } catch (SQLException e) {
                                            }
                                        } else {
                                            if (refe.equals(CBloque)) {
                                                String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + CBloque + "'";
                                                try {
                                                    Connection con = Conexion.conectar("mysql");
                                                    Statement st = con.createStatement();
                                                    ResultSet rs = st.executeQuery(entr);
                                                    while (rs.next()) {
                                                        entrada = rs.getInt("CANTIDAD");
                                                    }
                                                } catch (SQLException e) {
                                                }
                                            } else {
                                                if (refe.equals(Parra2)) {
                                                    String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Parra2 + "'";
                                                    try {
                                                        Connection con = Conexion.conectar("mysql");
                                                        Statement st = con.createStatement();
                                                        ResultSet rs = st.executeQuery(entr);
                                                        while (rs.next()) {
                                                            entrada = rs.getInt("CANTIDAD");
                                                        }
                                                    } catch (SQLException e) {
                                                    }
                                                } else {
                                                    if (refe.equals(Picada)) {
                                                        String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Picada + "'";
                                                        try {
                                                            Connection con = Conexion.conectar("mysql");
                                                            Statement st = con.createStatement();
                                                            ResultSet rs = st.executeQuery(entr);
                                                            while (rs.next()) {
                                                                entrada = rs.getInt("CANTIDAD");
                                                            }
                                                        } catch (SQLException e) {
                                                        }
                                                    } else {
                                                        if (refe.equals(fresca2)) {
                                                            String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + fresca2 + "'";
                                                            try {
                                                                Connection con = Conexion.conectar("mysql");
                                                                Statement st = con.createStatement();
                                                                ResultSet rs = st.executeQuery(entr);
                                                                while (rs.next()) {
                                                                    entrada = rs.getInt("CANTIDAD");
                                                                }
                                                            } catch (SQLException e) {
                                                            }

                                                        } else {
                                                            if (refe.equals(IgluCil20)) {
                                                                String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + IgluCil20 + "'";
                                                                try {
                                                                    Connection con = Conexion.conectar("mysql");
                                                                    Statement st = con.createStatement();
                                                                    ResultSet rs = st.executeQuery(entr);
                                                                    while (rs.next()) {
                                                                        entrada = rs.getInt("CANTIDAD");
                                                                    }
                                                                } catch (SQLException e) {
                                                                }
                                                            } else {
                                                                if (refe.equals(Iglu15)) {
                                                                    String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Iglu15 + "'";
                                                                    try {
                                                                        Connection con = Conexion.conectar("mysql");
                                                                        Statement st = con.createStatement();
                                                                        ResultSet rs = st.executeQuery(entr);
                                                                        while (rs.next()) {
                                                                            entrada = rs.getInt("CANTIDAD");
                                                                        }
                                                                    } catch (SQLException e) {
                                                                    }

                                                                } else {
                                                                    if (refe.equals(Iglu3)) {
                                                                        String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Iglu3 + "'";
                                                                        try {
                                                                            Connection con = Conexion.conectar("mysql");
                                                                            Statement st = con.createStatement();
                                                                            ResultSet rs = st.executeQuery(entr);
                                                                            while (rs.next()) {
                                                                                entrada = rs.getInt("CANTIDAD");
                                                                            }
                                                                        } catch (SQLException e) {
                                                                        }
                                                                    } else {
                                                                        if (refe.equals(Iglu2)) {
                                                                            String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Iglu2 + "'";
                                                                            try {
                                                                                Connection con = Conexion.conectar("mysql");
                                                                                Statement st = con.createStatement();
                                                                                ResultSet rs = st.executeQuery(entr);
                                                                                while (rs.next()) {
                                                                                    entrada = rs.getInt("CANTIDAD");
                                                                                }
                                                                            } catch (SQLException e) {
                                                                            }
                                                                        } else {
                                                                            if (refe.equals(Fresca3)) {
                                                                                String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'ENTRADA' AND referenciaP ='" + Fresca3 + "'";
                                                                                try {
                                                                                    Connection con = Conexion.conectar("mysql");
                                                                                    Statement st = con.createStatement();
                                                                                    ResultSet rs = st.executeQuery(entr);
                                                                                    while (rs.next()) {
                                                                                        entrada = rs.getInt("CANTIDAD");
                                                                                    }
                                                                                } catch (SQLException e) {
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
    }//REGISTRA LAS ENTRADAS DE PLASTICO A LA BODEGA DE PLASTICO

    public void restaEntrada() {
         String Polar2 = "POLAR 2 KILOS";
        String Polar3 = "POLAR 3 KILOS";
        String Polar12 = "POLAR 12 KILOS";
        String Mini = "IGLU 500 GRAMOS";
        String Polar20 = "POLAR 20 KILOS";
        String Escama = "ESCAMA 20 KILOS";
        String Bloque = "BLOQUE 25 KILOS";
        String Parranda = "PARRANDA 12 KILOS";
        String Iglu7 = "IGLU 7 KILOS";
        String CBloque = "CUARTO DE BLOQUE";
        String Parra2 = "PARRANDA 2 KILOS";
        String Picada = "PICADA TRANSP 20 KILOS";
        String fresca2 = "FRESCAMPO 2 KILOS";
        String IgluCil20 = "IGLU CILINDRO 20 KILOS";
        String Iglu15 = "IGLU 15 KILOS";
        String Iglu3 = "IGLU 3 KILOS";
        String Iglu2 = "IGLU 2 KILOS";
        String Fresca3 = "FRESCAMPO 3 KILOS";
        String refe = Referencia.getSelectedItem().toString();
        if (refe.equals(Polar2)) {
            String entr = "SELECT SUM(cantidad) AS TOTALCANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Polar2 + "'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(entr);
                while (rs.next()) {
                    resta = rs.getInt("TOTALCANTIDAD");
                    System.out.println("entrada " + resta);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            if (refe.equals(Polar3)) {
                String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Polar3 + "'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(entr);
                    while (rs.next()) {
                        resta = rs.getInt("CANTIDAD");
                        //System.out.println("entrada 3" +entrada);
                    }
                } catch (SQLException e) {
                }

            } else {
                if (refe.equals(Polar12)) {
                    String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Polar12 + "'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(entr);
                        while (rs.next()) {
                            resta = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                    }
                } else {
                    if (refe.equals(Mini)) {
                        String entr = "SELECT SUM(cantidad)AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Mini + "'";
                        try {
                            Connection con = Conexion.conectar("mysql");
                            Statement st = con.createStatement();
                            ResultSet rs = st.executeQuery(entr);
                            while (rs.next()) {
                                resta = rs.getInt("CANTIDAD");
                            }
                        } catch (SQLException e) {
                        }
                    } else {
                        if (refe.equals(Polar20)) {
                            String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Polar20 + "'";
                            try {
                                Connection con = Conexion.conectar("mysql");
                                Statement st = con.createStatement();
                                ResultSet rs = st.executeQuery(entr);
                                while (rs.next()) {
                                    resta = rs.getInt("CANTIDAD");
                                }
                            } catch (SQLException e) {
                            }
                        } else {
                            if (refe.equals(Escama)) {
                                String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Escama + "'";
                                try {
                                    Connection con = Conexion.conectar("mysql");
                                    Statement st = con.createStatement();
                                    ResultSet rs = st.executeQuery(entr);
                                    while (rs.next()) {
                                        resta = rs.getInt("CANTIDAD");
                                    }
                                } catch (SQLException e) {
                                }
                            } else {
                                if (refe.equals(Bloque)) {
                                    String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Bloque + "'";
                                    try {
                                        Connection con = Conexion.conectar("mysql");
                                        Statement st = con.createStatement();
                                        ResultSet rs = st.executeQuery(entr);
                                        while (rs.next()) {
                                            resta = rs.getInt("CANTIDAD");
                                        }
                                    } catch (SQLException e) {
                                    }
                                } else {
                                    if (refe.equals(Parranda)) {
                                        String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Parranda + "'";
                                        try {
                                            Connection con = Conexion.conectar("mysql");
                                            Statement st = con.createStatement();
                                            ResultSet rs = st.executeQuery(entr);
                                            while (rs.next()) {
                                                resta = rs.getInt("CANTIDAD");
                                            }
                                        } catch (SQLException e) {
                                        }
                                    } else {
                                        if (refe.equals(Iglu7)) {
                                            String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Iglu7 + "'";
                                            try {
                                                Connection con = Conexion.conectar("mysql");
                                                Statement st = con.createStatement();
                                                ResultSet rs = st.executeQuery(entr);
                                                while (rs.next()) {
                                                    resta = rs.getInt("CANTIDAD");
                                                }
                                            } catch (SQLException e) {
                                            }
                                        } else {
                                            if (refe.equals(CBloque)) {
                                                String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + CBloque + "'";
                                                try {
                                                    Connection con = Conexion.conectar("mysql");
                                                    Statement st = con.createStatement();
                                                    ResultSet rs = st.executeQuery(entr);
                                                    while (rs.next()) {
                                                        resta = rs.getInt("CANTIDAD");
                                                    }
                                                } catch (SQLException e) {
                                                }
                                            } else {
                                                if (refe.equals(Parra2)) {
                                                    String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Parra2 + "'";
                                                    try {
                                                        Connection con = Conexion.conectar("mysql");
                                                        Statement st = con.createStatement();
                                                        ResultSet rs = st.executeQuery(entr);
                                                        while (rs.next()) {
                                                            resta = rs.getInt("CANTIDAD");
                                                        }
                                                    } catch (SQLException e) {
                                                    }
                                                } else {
                                                    if (refe.equals(Picada)) {
                                                        String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Picada + "'";
                                                        try {
                                                            Connection con = Conexion.conectar("mysql");
                                                            Statement st = con.createStatement();
                                                            ResultSet rs = st.executeQuery(entr);
                                                            while (rs.next()) {
                                                                resta = rs.getInt("CANTIDAD");
                                                            }
                                                        } catch (SQLException e) {
                                                        }
                                                    } else {
                                                        if (refe.equals(fresca2)) {
                                                            String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + fresca2 + "'";
                                                            try {
                                                                Connection con = Conexion.conectar("mysql");
                                                                Statement st = con.createStatement();
                                                                ResultSet rs = st.executeQuery(entr);
                                                                while (rs.next()) {
                                                                    resta = rs.getInt("CANTIDAD");
                                                                }
                                                            } catch (SQLException e) {
                                                            }

                                                        } else {
                                                            if (refe.equals(IgluCil20)) {
                                                                String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + IgluCil20 + "'";
                                                                try {
                                                                    Connection con = Conexion.conectar("mysql");
                                                                    Statement st = con.createStatement();
                                                                    ResultSet rs = st.executeQuery(entr);
                                                                    while (rs.next()) {
                                                                        resta = rs.getInt("CANTIDAD");
                                                                    }
                                                                } catch (SQLException e) {
                                                                }
                                                            } else {
                                                                if (refe.equals(Iglu15)) {
                                                                    String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Iglu15 + "'";
                                                                    try {
                                                                        Connection con = Conexion.conectar("mysql");
                                                                        Statement st = con.createStatement();
                                                                        ResultSet rs = st.executeQuery(entr);
                                                                        while (rs.next()) {
                                                                            resta = rs.getInt("CANTIDAD");
                                                                        }
                                                                    } catch (SQLException e) {
                                                                    }

                                                                } else {
                                                                    if (refe.equals(Iglu3)) {
                                                                        String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Iglu3 + "'";
                                                                        try {
                                                                            Connection con = Conexion.conectar("mysql");
                                                                            Statement st = con.createStatement();
                                                                            ResultSet rs = st.executeQuery(entr);
                                                                            while (rs.next()) {
                                                                                resta = rs.getInt("CANTIDAD");
                                                                            }
                                                                        } catch (SQLException e) {
                                                                        }
                                                                    } else {
                                                                        if (refe.equals(Iglu2)) {
                                                                            String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Iglu2 + "'";
                                                                            try {
                                                                                Connection con = Conexion.conectar("mysql");
                                                                                Statement st = con.createStatement();
                                                                                ResultSet rs = st.executeQuery(entr);
                                                                                while (rs.next()) {
                                                                                    resta = rs.getInt("CANTIDAD");
                                                                                }
                                                                            } catch (SQLException e) {
                                                                            }
                                                                        } else {
                                                                            if (refe.equals(Fresca3)) {
                                                                                String entr = "SELECT SUM(cantidad) AS CANTIDAD FROM plasticobodegapt WHERE tipomovimiento = 'SALIDA' AND referenciaP ='" + Fresca3 + "'";
                                                                                try {
                                                                                    Connection con = Conexion.conectar("mysql");
                                                                                    Statement st = con.createStatement();
                                                                                    ResultSet rs = st.executeQuery(entr);
                                                                                    while (rs.next()) {
                                                                                        resta = rs.getInt("CANTIDAD");
                                                                                    }
                                                                                } catch (SQLException e) {
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
    }//REGISTRA LAS SALIDAS DEL PLASTICO DE LA BODEGA

    public void actualizarEntrada() {

        String refe = Referencia.getSelectedItem().toString();
        String movi = TipoMovimiento.getSelectedItem().toString();

        if (movi.equals("ENTRADA")) {
            entra = Integer.parseInt(txtCantidad.getText());
            int operacion = entrada - resta;
            int entradas = operacion + entra;
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                st.execute("INSERT INTO entraplas SET cantidad =" + entradas + ", referencia='" + refe + "'");
            } catch (SQLException e) {
            }
            // System.out.println("suma " + entra + " referencia " + refe + " entrada " + entrada +" total "+ entradas + " restas "+ resta );
        }
    }//ACTUALIZA LAS ENTRADAS DE PLASTICO REFLEJANDOLAS EN ENTRAPLAS

    public void conexion(String prome) {

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(prome);
            while (rs.next()) {
                aux = rs.getInt("TOTAL");
                System.out.println(aux);
            }
        } catch (Exception e) {
        }
    }

    public void saldosMenores() {
        Calendar fech = new GregorianCalendar();
        int año = fech.get(Calendar.YEAR);
        int mes = fech.get(Calendar.MONTH);
        int dia = fech.get(Calendar.DAY_OF_MONTH);
        int diaB = fech.get(Calendar.DAY_OF_MONTH);
        diaB = diaB + 1;
        mes = mes + 1;
        String sal = txtCantidad.getText();
        salida = Integer.parseInt(sal);
        saldo = 0;
        String tm = TipoMovimiento.getSelectedItem().toString();
        String con = "SELECT cantidad FROM entraplas WHERE referencia ='" + Referencia.getSelectedItem() + "'";
        try {
            Connection co = Conexion.conectar("mysql");
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(con);
            while (rs.next()) {
                saldo = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (tm.equals("ENTRADA")) {
            DAO();
        } else {
            if (saldo >= salida) {
                DAO();
                //System.out.println("saldo " + saldo + " salida " + salida);
            } else {
                // System.out.println("saldo "+saldo+" salida "+salida+"");
                JOptionPane.showMessageDialog(null, "EL SALDO DE SALIDA ES MAYOR QUE EL DE BODEGA");
            }
        }
    }

    public void promedioEmpaque() {
         String Polar2 = "POLAR 2 KILOS";
        String Polar3 = "POLAR 3 KILOS";
        String Polar12 = "POLAR 12 KILOS";
        String Mini = "IGLU 500 GRAMOS";
        String Polar20 = "POLAR 20 KILOS";
        String Escama = "ESCAMA 20 KILOS";
        String Bloque = "BLOQUE 25 KILOS";
        String Parranda = "PARRANDA 12 KILOS";
        String Iglu7 = "IGLU 7 KILOS";
        String CBloque = "CUARTO DE BLOQUE";
        String Parra2 = "PARRANDA 2 KILOS";
        String Picada = "PICADA TRANSP 20 KILOS";
        String fresca2 = "FRESCAMPO 2 KILOS";
        String IgluCil20 = "IGLU CILINDRO 20 KILOS";
        String Iglu15 = "IGLU 15 KILOS";
        String Iglu3 = "IGLU 3 KILOS";
        String Iglu2 = "IGLU 2 KILOS";
        String Fresca3 = "FRESCAMPO 3 KILOS";
        String Reempaque = "REEMPAQUE";
        String refe = Referencia.getSelectedItem().toString();
        String prome = "SELECT SUM(cantidad) AS TOTAL FROM proyeccionplastico WHERE referencia = '" + refe + "'";
        int cd, cm, cad, cam, pcam;
        int alerta;
        if (refe.equals(Polar2)) {
            conexion(prome);
            cm = aux / 12;
            cd = cm / 30;
            cad = (int) (cd * 0.30);
            pcam = (int) (cm * 0.30);
            cam = cm + pcam;
            promedio = cd + cad;
            alerta = promedio * 30;
            alertaEmpaque(alerta);
            saldos(promedio);
            insertaAlerta(refe, cd, cm, cad, cam);
            System.out.println("cm = " + cm + " cd " + cd + " cam " + cam + " promedio " + promedio + " cad " + cad);
        } else {
            if (refe.equals(Polar3)) {
                conexion(prome);
                cm = aux / 12;
                cd = cm / 30;
                cad = (int) (cd * 0.30);
                pcam = (int) (cm * 0.30);
                cam = cm + pcam;
                promedio = cd + cad;
                alerta = promedio * 30;
                alertaEmpaque(alerta);
                saldos(promedio);
                insertaAlerta(refe, cd, cm, cad, cam);

            } else {
                if (refe.equals(Polar12)) {
                    conexion(prome);
                    cm = aux / 12;
                    cd = cm / 30;
                    cad = (int) (cd * 0.30);
                    pcam = (int) (cm * 0.30);
                    cam = cm + pcam;
                    promedio = cd + cad;
                    alerta = promedio * 30;
                    alertaEmpaque(alerta);
                    saldos(promedio);
                    insertaAlerta(refe, cd, cm, cad, cam);
                } else {
                    if (refe.equals(Mini)) {
                        conexion(prome);
                        cm = aux / 12;
                        cd = cm / 30;
                        cad = (int) (cd * 0.30);
                        pcam = (int) (cm * 0.30);
                        cam = cm + pcam;
                        promedio = cd + cad;
                        alerta = promedio * 30;
                        alertaEmpaque(alerta);
                        saldos(promedio);
                        insertaAlerta(refe, cd, cm, cad, cam);

                    } else {
                        if (refe.equals(Polar20)) {
                            conexion(prome);
                            cm = aux / 12;
                            cd = cm / 30;
                            cad = (int) (cd * 0.30);
                            pcam = (int) (cm * 0.30);
                            cam = cm + pcam;
                            promedio = cd + cad;
                            alerta = promedio * 30;
                            alertaEmpaque(alerta);
                            saldos(promedio);
                            insertaAlerta(refe, cd, cm, cad, cam);

                        } else {
                            if (refe.equals(Escama)) {
                                conexion(prome);
                                cm = aux / 12;
                                cd = cm / 30;
                                cad = (int) (cd * 0.30);
                                pcam = (int) (cm * 0.30);
                                cam = cm + pcam;
                                promedio = cd + cad;
                                alerta = promedio * 30;
                                alertaEmpaque(alerta);
                                saldos(promedio);
                                insertaAlerta(refe, cd, cm, cad, cam);
                            } else {
                                if (refe.equals(Bloque)) {
                                    conexion(prome);
                                    cm = aux / 12;
                                    cd = cm / 30;
                                    cad = (int) (cd * 0.30);
                                    pcam = (int) (cm * 0.30);
                                    cam = cm + pcam;
                                    promedio = cd + cad;
                                    alerta = promedio * 30;
                                    alertaEmpaque(alerta);
                                    saldos(promedio);
                                    insertaAlerta(refe, cd, cm, cad, cam);

                                } else {
                                    if (refe.equals(Parranda)) {
                                        conexion(prome);
                                        cm = aux / 12;
                                        cd = cm / 30;
                                        cad = (int) (cd * 0.30);
                                        pcam = (int) (cm * 0.30);
                                        cam = cm + pcam;
                                        promedio = cd + cad;
                                        alerta = promedio * 30;
                                        alertaEmpaque(alerta);
                                        saldos(promedio);
                                        insertaAlerta(refe, cd, cm, cad, cam);

                                    } else {
                                        if (refe.equals(Iglu7)) {
                                            conexion(prome);
                                            cm = aux / 12;
                                            cd = cm / 30;
                                            cad = (int) (cd * 0.30);
                                            pcam = (int) (cm * 0.30);
                                            cam = cm + pcam;
                                            promedio = cd + cad;
                                            alerta = promedio * 30;
                                            alertaEmpaque(alerta);
                                            saldos(promedio);
                                            insertaAlerta(refe, cd, cm, cad, cam);

                                        } else {
                                            if (refe.equals(CBloque)) {
                                                conexion(prome);
                                                cm = aux / 12;
                                                cd = cm / 30;
                                                cad = (int) (cd * 0.30);
                                                pcam = (int) (cm * 0.30);
                                                cam = cm + pcam;
                                                promedio = cd + cad;
                                                alerta = promedio * 30;
                                                alertaEmpaque(alerta);
                                                saldos(promedio);
                                                insertaAlerta(refe, cd, cm, cad, cam);

                                            } else {
                                                if (refe.equals(Parra2)) {
                                                    conexion(prome);
                                                    cm = aux / 12;
                                                    cd = cm / 30;
                                                    cad = (int) (cd * 0.30);
                                                    pcam = (int) (cm * 0.30);
                                                    cam = cm + pcam;
                                                    promedio = cd + cad;
                                                    alerta = promedio * 30;
                                                    alertaEmpaque(alerta);
                                                    saldos(promedio);
                                                    insertaAlerta(refe, cd, cm, cad, cam);

                                                } else {
                                                    if (refe.equals(Picada)) {
                                                        conexion(prome);
                                                        cm = aux / 12;
                                                        cd = cm / 30;
                                                        cad = (int) (cd * 0.30);
                                                        pcam = (int) (cm * 0.30);
                                                        cam = cm + pcam;
                                                        promedio = cd + cad;
                                                        alerta = promedio * 30;
                                                        alertaEmpaque(alerta);
                                                        saldos(promedio);
                                                        insertaAlerta(refe, cd, cm, cad, cam);
                                                    } else {
                                                        if (refe.equals(fresca2)) {
                                                            conexion(prome);
                                                            cm = aux / 12;
                                                            cd = cm / 30;
                                                            cad = (int) (cd * 0.30);
                                                            pcam = (int) (cm * 0.30);
                                                            cam = cm + pcam;
                                                            promedio = cd + cad;
                                                            alerta = promedio * 30;
                                                            alertaEmpaque(alerta);
                                                            saldos(promedio);
                                                            insertaAlerta(refe, cd, cm, cad, cam);

                                                        } else {
                                                            if (refe.equals(IgluCil20)) {
                                                                conexion(prome);
                                                                cm = aux / 12;
                                                                cd = cm / 30;
                                                                cad = (int) (cd * 0.30);
                                                                pcam = (int) (cm * 0.30);
                                                                cam = cm + pcam;
                                                                promedio = cd + cad;
                                                                alerta = promedio * 30;
                                                                alertaEmpaque(alerta);
                                                                saldos(promedio);
                                                                insertaAlerta(refe, cd, cm, cad, cam);

                                                            } else {
                                                                if (refe.equals(Iglu15)) {
                                                                    conexion(prome);
                                                                    cm = aux / 12;
                                                                    cd = cm / 30;
                                                                    cad = (int) (cd * 0.30);
                                                                    pcam = (int) (cm * 0.30);
                                                                    cam = cm + pcam;
                                                                    promedio = cd + cad;
                                                                    alerta = promedio * 30;
                                                                    alertaEmpaque(alerta);
                                                                    saldos(promedio);
                                                                    insertaAlerta(refe, cd, cm, cad, cam);

                                                                } else {
                                                                    if (refe.equals(Iglu3)) {
                                                                        conexion(prome);
                                                                        cm = aux / 12;
                                                                        cd = cm / 30;
                                                                        cad = (int) (cd * 0.30);
                                                                        pcam = (int) (cm * 0.30);
                                                                        cam = cm + pcam;
                                                                        promedio = cd + cad;
                                                                        alerta = promedio * 30;
                                                                        alertaEmpaque(alerta);
                                                                        saldos(promedio);
                                                                        insertaAlerta(refe, cd, cm, cad, cam);

                                                                    } else {
                                                                        if (refe.equals(Iglu2)) {
                                                                            conexion(prome);
                                                                            cm = aux / 12;
                                                                            cd = cm / 30;
                                                                            cad = (int) (cd * 0.30);
                                                                            pcam = (int) (cm * 0.30);
                                                                            cam = cm + pcam;
                                                                            promedio = cd + cad;
                                                                            alerta = promedio * 30;
                                                                            alertaEmpaque(alerta);
                                                                            saldos(promedio);
                                                                            insertaAlerta(refe, cd, cm, cad, cam);

                                                                        } else {
                                                                            if (refe.equals(Fresca3)) {
                                                                                conexion(prome);
                                                                                cm = aux / 12;
                                                                                cd = cm / 30;
                                                                                cad = (int) (cd * 0.30);
                                                                                pcam = (int) (cm * 0.30);
                                                                                cam = cm + pcam;
                                                                                promedio = cd + cad;
                                                                                alerta = promedio * 30;
                                                                                alertaEmpaque(alerta);
                                                                                saldos(promedio);
                                                                                insertaAlerta(refe, cd, cm, cad, cam);

                                                                            }else{
                                                                                if (refe.equals(Reempaque)) {
                                                                                conexion(prome);
                                                                                cm = aux / 12;
                                                                                cd = cm / 30;
                                                                                cad = (int) (cd * 0.30);
                                                                                pcam = (int) (cm * 0.30);
                                                                                cam = cm + pcam;
                                                                                promedio = cd + cad;
                                                                                alerta = promedio * 30;
                                                                                alertaEmpaque(alerta);
                                                                                saldos(promedio);
                                                                                insertaAlerta(refe, cd, cm, cad, cam);

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

    }

    public void alertaEmpaque(int alerta) {
        String refe = Referencia.getSelectedItem().toString();
        String est = "SELECT cantidad FROM entraplas WHERE referencia= '" + refe + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(est);
            while (rs.next()) {
                double cant = rs.getInt("cantidad");
                if (cant <= alerta) {
                    JOptionPane.showMessageDialog(this, "EL SALDO DE " + refe + " ESTA LLEGANDO A SU PORCENTAJE MINIMO, POR FAVOR COMUNIQUESE CON SU PROVEEDOR");
                }
            }
        } catch (Exception e) {
        }
    }

    public void saldos(int promedio) {
        String refe = Referencia.getSelectedItem().toString();
        String est = "SELECT cantidad FROM entraplas WHERE referencia= '" + refe + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(est);
            while (rs.next()) {
                int cant = rs.getInt("cantidad");
                System.out.println("cantidad real " + cant);
                saldodias = cant / promedio;
                System.out.println("saldo dias  " + saldodias);
                if (saldodias > 30.0) {
                    color = "VERDE";
                    System.out.println(color);
                } else {
                    if (saldodias <= 15.0) {
                        color = "ROJO";
                        System.out.println(color);
                    } else {
                        if (saldodias <= 25.0) {
                            color = "AMARILLO";
                            System.out.println(color);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice"+ e);
        }

    }
    
    public void insertaAlerta(String refe, int cd, int cm, int cad, int cam) {
        String scrip = "INSERT INTO alertasplas SET referencia = '" + refe + "', mes = " + cm + ", dia =" + cd + ","
                + "prodia =" + promedio + ", promes =" + cam + ", diadu=" + saldodias + ", color='" + color + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(scrip);

        } catch (SQLException e) {
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

        btnConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TipoMovimiento = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        Salida = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Referencia = new javax.swing.JComboBox<>();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtremision = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtlote = new javax.swing.JTextField();
        btnconsultar = new javax.swing.JButton();

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultar.setText("CONSULTAR");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BODEGA PLASTICO");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("FECHA");

        fecha.setText("00/00/00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("HORA");

        hora.setText("00:00:00");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setText("BODEGA PLASTICO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TIPO DE MOVIMIENTO");

        TipoMovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        TipoMovimiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TipoMovimientoItemStateChanged(evt);
            }
        });
        TipoMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoMovimientoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("PROVIENE DE ");

        Salida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        Salida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SalidaItemStateChanged(evt);
            }
        });
        Salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalidaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("REFERENCIA");

        Referencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        Referencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ReferenciaItemStateChanged(evt);
            }
        });
        Referencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReferenciaActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("CANTIDAD");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("NRO.REMISION");

        txtremision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtremisionActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("LOTE");

        btnconsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnconsultar.setText("CONSULTAR");
        btnconsultar.setName("BODEGA PLASTICO"); // NOI18N
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hora))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnguardar)
                        .addGap(79, 79, 79)
                        .addComponent(btnconsultar)
                        .addGap(57, 57, 57)
                        .addComponent(btncancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Salida, 0, 212, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Referencia, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(txtCantidad)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(txtremision)
                    .addComponent(jLabel11)
                    .addComponent(txtlote))
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fecha)
                    .addComponent(jLabel3)
                    .addComponent(hora))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtremision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar)
                    .addComponent(btnconsultar))
                .addGap(76, 76, 76))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtremisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtremisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtremisionActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        restaEntrada();
        sumaEntrada();
        actualizarEntrada();
        saldosMenores();
        //promedioEmpaque();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        // TODO add your handling code here:
       new ConsultaPlastico().setVisible(true);
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_btncancelarActionPerformed

    private void TipoMovimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TipoMovimientoItemStateChanged
        // TODO add your handling code here:}
        //metodo para enlazar dos combobox
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String Seleccion = (String) TipoMovimiento.getSelectedItem();
            if (this.TipoMovimiento.getSelectedIndex() > 0) {
                //this.jComboBox1.setModel(new DefaultComboBoxModel(this.getEntrada(this.jComboBox1.getSelectedItem().toString())));
                this.Salida.setModel(new DefaultComboBoxModel(this.getEntrada(this.TipoMovimiento.getSelectedItem().toString())));
            }
        }

    }//GEN-LAST:event_TipoMovimientoItemStateChanged

    public String[] getEntrada(String Salida) {
        String[] EntraSal = new String[5];

        if (Salida.equalsIgnoreCase("Entrada")) {
            EntraSal[0] = "TUBOPLAST";
            EntraSal[1] = "POLIEMPAK";
            EntraSal[2] = "PLASTICOS UNION";
            EntraSal[3] = "CARTAGENA";
            EntraSal[4] = "BOGOTA";
           
        }
        if (Salida.equalsIgnoreCase("Salida")) {
            EntraSal[0] = "PLANTA SUR";
            EntraSal[1] = "PRODUCCION";
            EntraSal[2] = "BOGOTA";
            EntraSal[3] = "CARTAGENA";
            
        }
        return EntraSal;
    }


    private void SalidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SalidaItemStateChanged

        String[] turno = {"Turno 1", "Turno 2", "Turno 3"};
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (this.TipoMovimiento.getSelectedIndex() == 2) {
                String Seleccion = (String) Salida.getSelectedItem();
                if (this.Salida.getSelectedIndex() == 1) {

                    opc = (String) JOptionPane.showInputDialog(this, "SELECCIONE EL TURNO", "TURNO ENTREGA", JOptionPane.INFORMATION_MESSAGE, null, turno, null);

                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        st.executeUpdate("INSERT INTO turno SET descripcion = '" + opc + "', referencia = '" + Referencia.getSelectedItem().toString() + "'");
                        // AND referencia = '" + Referencia.getSelectedItem().toString() + "'");

                    } catch (SQLException ex) {
                        System.out.println(ex);

                    }

                }
            }
        }
    }//GEN-LAST:event_SalidaItemStateChanged
    //METODO PARA LLEVAR EL TURNO AL DAO 

    public void Cargabd() {
        //METODO PARA CARGAR LAS REFERENCIAS DE LA BASE DE DATOS
        String sql = "SELECT nombre FROM referenciasmedellin ";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Referencia.addItem(rs.getString(1));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    private void ReferenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ReferenciaItemStateChanged

        /*if (evt.getStateChange() == ItemEvent.SELECTED){ 
           String Seleccion = (String)Referencia.getSelectedItem();
           if (this.Referencia.getSelectedIndex()>0)
           {
               
            //this.jComboBox1.setModel(new DefaultComboBoxModel(this.getEntrada(this.jComboBox1.getSelectedItem().toString())));
              this.Referencia.setModel(new DefaultComboBoxModel(this.getReferencia(this.Referencia.getSelectedItem().toString())));
           }
    }//GEN-LAST:event_ReferenciaItemStateChanged
  */    }

    public String[] getReferencia(String Refe) {
        /* String[] EntraSal = new String [5];
       
       if(Refe.equalsIgnoreCase("REFERENCIA")){
           EntraSal[0]= "BOLSA HIELO IGLU 20 KILOS";
           EntraSal[1]= "BOLSA HIELO IGLU 3 KILOS";
           EntraSal[2]= "BOLSA HIELO IGLU EN BLOQUE 25 KILOS";
           EntraSal[3]= "BOLSA HIELO MINIGLU 500 GR";
           EntraSal[4]= "BOLSA HIELO IGLU 15 KILOS";
       }
         */ return null;
    }
    private void ReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReferenciaActionPerformed

    private void SalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalidaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_SalidaActionPerformed

    private void TipoMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoMovimientoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TipoMovimientoActionPerformed

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
            java.util.logging.Logger.getLogger(PlasticoProveedorTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlasticoProveedorTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlasticoProveedorTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlasticoProveedorTraslado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlasticoProveedorTraslado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Referencia;
    private javax.swing.JComboBox<String> Salida;
    private javax.swing.JComboBox<String> TipoMovimiento;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtlote;
    private javax.swing.JTextField txtremision;
    // End of variables declaration//GEN-END:variables
}
