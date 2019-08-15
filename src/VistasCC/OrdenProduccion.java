package VistasCC;

import Utils.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OrdenProduccion extends javax.swing.JFrame {

    public OrdenProduccion() {
        initComponents();
        consultaStock();
        visualizaInventario();
        //extraeProduccion();
        extraeInventario();

    }
    int Iglu500IFC;
    int Iglu3IFC;
    int Iglu7IFC;
    int Iglu20IFC;
    int Parra12IFC;
    int Parra2IFC;
    int Fresca3IFC;
    int Esca20IFC;
    int Blo25IFC;
    int CuarIFC;
    int Pica20IFC;
    int Polar3IFC;
    int Polar2IFC;
    int Polar12IFC;
    int Polar20IFC;
    int Iglu15IFC;
    //extrae las cantidades por referencia del inventario final de la cava
    int Iglu20IC;
    int Escama20IC;
    int Parra12IC;
    int Fres3IC;
    int Iglu3IC;
    int Iglu7IC;
    int Parra2IC;
    int Iglu500IC;
    int Polar2IC;
    int Polar3IC;
    int Polar12IC;
    int Polar20IC;

    public void consultaStock() {
        tbstock.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("STOCK");
        String stock = "SELECT referencia,stock FROM stockminimo";
        String[] arr = new String[2];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(stock);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
                tbstock.setModel(dtm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

    }

    public void conexion(String sql, String variable) {
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                variable = rs.getString("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }

    public int conexion2(String sql, int variable) {
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                variable = rs.getInt("CANTIDAD");
                System.out.println("VALOR DE VARIABLE :  " + variable);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        return variable;
    }

    public void extraeProduccion() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int diaA = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        mes = mes + 1;
        diaA = diaA - 1;
        System.out.println("año: " + año + " mes: " + mes + " dia: " + dia + " hora: " + hora);
        String aux = " ";
        String refe = "IGLU 500 GRAMOS";
        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT (cantidad) AS CANTIDAD FROM produccion WHERE referencia= '" + refe + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";

            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Iglu500IFC = rs.getInt("CANTIDAD");
                    System.out.println("IGLU " + Iglu500IFC);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }

            // Iglu500IFC = Integer.parseInt(aux);
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT (cantidad) AS CANTIDAD FROM produccion WHERE referencia= '" + refe + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Iglu500IFC = rs.getInt("CANTIDAD");
                        System.out.println("IGLU " + Iglu500IFC);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT (cantidad) AS CANTIDAD FROM produccion WHERE referencia= '" + refe + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Iglu500IFC = rs.getInt("CANTIDAD");
                            System.out.println("IGLU " + Iglu500IFC);
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe1 = "IGLU 3 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe1 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Iglu3IFC = rs.getInt("CANTIDAD");
                    System.out.println("IGLU " + Iglu3IFC);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe1 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Iglu3IFC = rs.getInt("CANTIDAD");
                        System.out.println("IGLU 3: " + Iglu3IFC);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe1 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Iglu3IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe2 = "IGLU 7 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe2 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Iglu7IFC = rs.getInt("CANTIDAD");

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe2 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Iglu7IFC = rs.getInt("CANTIDAD");
                        System.out.println("Iglu 7: " + Iglu7IFC);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe2 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Iglu7IFC = rs.getInt("CANTIDAD");

                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe3 = "IGLU 20 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe3 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Iglu20IFC = rs.getInt("CANTIDAD");

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe3 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Iglu20IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe3 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Iglu20IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe4 = "PARRANDA 12 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe4 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Parra12IFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe4 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Parra12IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe4 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Parra12IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe5 = "PARRANDA 2 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe5 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Parra2IFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe5 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Parra2IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe5 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Parra2IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe6 = "FRESCAMPO 3 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe6 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Fresca3IFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe6 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Fresca3IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe6 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Fresca3IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe7 = "ESCAMA 20 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe7 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Esca20IFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe7 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Esca20IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe7 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Esca20IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe8 = "BLOQUE 25 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe8 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Blo25IFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe8 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Blo25IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe8 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Blo25IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe9 = "CUARTO DE BLOQUE";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe9 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    CuarIFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe9 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        CuarIFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe9 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            CuarIFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe10 = "PICADA TRANSP 20 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe10 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Pica20IFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe10 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Pica20IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe10 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Pica20IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe11 = "POLAR 3 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe11 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Polar3IFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe11 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Polar3IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe11 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Polar3IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe12 = "POLAR 2 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe12 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Polar2IFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe12 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Polar2IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe12 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    conexion2(extrae, Polar2IFC);
                    //Polar2IFC = Integer.parseInt(aux);
                }
            }
        }
        String refe13 = "POLAR 12 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe13 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Polar12IFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe13 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Polar12IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe13 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Polar12IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe14 = "POLAR 20 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe14 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Polar20IFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe14 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Polar20IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe14 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:59:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Polar20IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }
        String refe15 = "IGLU 15 KILOS";

        if ((hora > 5) && (hora <= 13)) {
            String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe15 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:59:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(extrae);
                while (rs.next()) {
                    Iglu15IFC = rs.getInt("CANTIDAD");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
            }
        } else {
            if ((hora > 13) && (hora <= 21)) {
                String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe15 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:59:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(extrae);
                    while (rs.next()) {
                        Iglu15IFC = rs.getInt("CANTIDAD");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                }
            } else {
                if ((hora > 21) && (hora <= 5)) {
                    String extrae = "SELECT cantidad FROM produccion WHERE referencia= '" + refe15 + "' AND fecha BETWEEN '" + año + "-" + mes + "-" + diaA + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:29:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(extrae);
                        while (rs.next()) {
                            Iglu15IFC = rs.getInt("CANTIDAD");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
                    }
                }
            }
        }

    }//extrae la produccion de cada turno para sumarla al saldo de la cava.

    public void extraeInventario() {
        String refe = "IGLU 20 KILOS";
        String aux1 = "";
        //se conforma la variable segun la referencia, el peso,la IC que hace referencia al inventario real de la cava. 
        String extra1 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra1);
            while (rs.next()) {
                Iglu20IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        //conexion(extra1, aux1);
        //Iglu20IC = Integer.parseInt(aux1);

        String aux2 = "";
        String refe1 = "ESCAMA 20 KILOS";
        String extra2 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe1 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra2);
            while (rs.next()) {
                Escama20IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

        // conexion(extra2, aux2);
        //Escama20IC = Integer.parseInt(aux1);
        String aux3 = "";
        String refe2 = "PARRANDA 12 KILOS";
        String extra3 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe2 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra3);
            while (rs.next()) {
                Parra12IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

        //conexion(extra3, aux3);
        //Parra12IC = Integer.parseInt(aux1);
        String aux4 = "";
        String refe3 = "FRESCAMPO 3 KILOS";
        String extra4 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe3 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra4);
            while (rs.next()) {
                Fres3IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

        //conexion(extra4, aux4);
        //Fres3IC = Integer.parseInt(aux1);
        String aux5 = "";
        String refe4 = "IGLU 3 KILOS";
        String extra5 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe4 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra5);
            while (rs.next()) {
                Iglu3IC = rs.getInt("saldo");
                System.out.println("Iglu 3:  " + Iglu3IC);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        //conexion(extra5, aux5);
        //Iglu3IC = Integer.parseInt(aux5);

        String aux6 = "";
        String refe5 = "IGLU 7 KILOS";
        String extra6 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe5 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra6);
            while (rs.next()) {
                Iglu7IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        //conexion(extra6, aux6);
        //Iglu7IC = Integer.parseInt(aux6);

        String aux7 = "";
        String refe6 = "PARRANDA 2 KILOS";
        String extra7 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe6 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra7);
            while (rs.next()) {
                Parra2IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        //conexion(extra7, aux7);
        //Parra2IC = Integer.parseInt(aux7);

        String aux8 = "";
        String refe7 = "IGLU 500 GRAMOS";
        String extra8 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe7 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra8);
            while (rs.next()) {
                Iglu500IC = rs.getInt("saldo");
                System.out.println("Iglu 500:  " + Iglu500IC);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

        //conexion(extra8, aux8);
        //Iglu500IC = Integer.parseInt(aux8);
        String aux9 = "";
        String refe8 = "POLAR 2 KILOS";
        String extra9 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe8 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra9);
            while (rs.next()) {
                Polar2IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

        //conexion(extra9, aux9);
        //Polar2IC = Integer.parseInt(aux9);
        String aux10 = "";
        String refe9 = "POLAR 3 KILOS";
        String extra10 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe9 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra10);
            while (rs.next()) {
                Polar3IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        //conexion(extra10, aux10);
        //Polar3IC = Integer.parseInt(aux10);

        String aux11 = "";
        String refe10 = "POLAR 12 KILOS";
        String extra11 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe10 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra11);
            while (rs.next()) {
                Polar12IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        // conexion(extra11, aux11);
        //Polar12IC = Integer.parseInt(aux11);

        String aux12 = "";
        String refe11 = "POLAR 20 KILOS";
        String extra12 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe11 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra12);
            while (rs.next()) {
                Polar20IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        //conexion(extra12, aux12);
        //Polar20IC = Integer.parseInt(aux12);
    }// extrae el inventario actual de la cava para actualizarlo con la produccion

    public void visualizaInventario() {
        tbinventario.setModel(new DefaultTableModel());
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("SALDO");
        String inventario = "SELECT referencia,saldo FROM inventariocava";
        String[] arr = new String[2];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(inventario);
            while (rs.next()) {
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                dtm.addRow(arr);
                tbinventario.setModel(dtm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
    }//muestra el inventario de la cava en la tbinventario.
    
    public int operacionFaltante(int stock, int cntCava){
        int resultado = stock - cntCava;
        return resultado;
    }
    
    public void saveFaltante(){
        String saveF = "INSERT INTO faltantestock SET = referencia ";
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbstock = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbinventario = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbfaltante = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ORDEN DE PRODUCCION");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("ORDEN PRODUCCION");

        tbstock.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbstock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbstock);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("STOCK MINIMO");

        tbinventario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbinventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbinventario);

        tbfaltante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbfaltante);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("INVENTARIO");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("FALTANTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdenProduccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbfaltante;
    private javax.swing.JTable tbinventario;
    private javax.swing.JTable tbstock;
    // End of variables declaration//GEN-END:variables
}
