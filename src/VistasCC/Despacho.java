package VistasCC;

import Beans.BeansDespachos;
import DAO.DAODespachos;
import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Despacho extends javax.swing.JFrame {

    int max = 0;
    String fecha;
    String fechasis;
    String ruta;
    String ref;
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
    int Bloque25IC;
    int CBloque;
    int PTrans20IC;
    public Despacho() {
        initComponents();
        InstanciaFecha();
        Cargabd();
        CargaReferencia();
        cargaplanilla();

        this.cbxturno.addItem("Turno 1");
        this.cbxturno.addItem("Turno 2");
        this.cbxturno.addItem("Turno 3");
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        cbxturno = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbxruta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxreferencia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtlote = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdespacho = new javax.swing.JTextField();
        btnconsultar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbconsulta = new javax.swing.JTable();
        txtplanilla = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btdevoluciones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DESPACHOS");
        setIconImage(getIconImage());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("TURNO");

        cbxturno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxturno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("NRO.RUTA");

        cbxruta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxruta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        cbxruta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxrutaItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("REFERENCIA");

        cbxreferencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxreferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CANTIDAD");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("LOTE");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("DESPACHADO POR:");

        btnconsultar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnconsultar.setText("CONSULTAR");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setText("DESPACHAR");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("DESPACHOS");

        tbconsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbconsulta);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nro PLANILLA");

        btdevoluciones.setText("DEVOLUCIONES");
        btdevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdevolucionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btdevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 57, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdespacho, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtplanilla, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(259, 259, 259)
                                                .addComponent(jLabel1))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(85, 85, 85)
                                                        .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(162, 162, 162)
                                                        .addComponent(jLabel4)))))
                                        .addGap(74, 74, 74))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbxruta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtplanilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar)
                    .addComponent(btdevoluciones))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void ConsultaDespacho(String Consult) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("TURNO");
        dtm.addColumn("RUTA");
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        dtm.addColumn("DESPACHADO POR");
        dtm.addColumn("PLANILLA");
        String[] desp = new String[6];
        tbconsulta.setModel(dtm);
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Consult);
            while (rs.next()) {
                desp[0] = rs.getString(1);
                desp[1] = rs.getString(2);
                desp[2] = rs.getString(3);
                desp[3] = rs.getString(4);
                desp[4] = rs.getString(5);
                desp[5] = rs.getString(6);
                dtm.addRow(desp);
                tbconsulta.getColumnModel().getColumn(2).setPreferredWidth(200);
                tbconsulta.getColumnModel().getColumn(1).setPreferredWidth(100);
                tbconsulta.getColumnModel().getColumn(4).setPreferredWidth(150);
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
    }

    public void cargaplanilla() {
        String sql = "SELECT MAX(planilla) AS PLANILLA FROM despachos;";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getInt("PLANILLA");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
    }

    public void descargafecha() {
        String rut = cbxruta.getSelectedItem().toString();
        String referencia = cbxreferencia.getSelectedItem().toString();
        String consul = "SELECT fecha FROM despachos WHERE nroruta ='" + rut + "' AND referencia = '" + referencia + "' AND planilla ='" + txtplanilla.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                fecha = rs.getString("fecha");

             
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERROR SOFT-ICE: " + e);
        }

    }

    public void comparaPlanilla() {
        int planilla = 0;
        int planilla2 = 0;
        String ruta2 = "";
        String re = "";
        String ruta = "";
        String referencia = "";
        String pla = txtplanilla.getText();
        String ref = cbxreferencia.getSelectedItem().toString();
        int plani = Integer.parseInt(pla);
        String tras = cbxruta.getSelectedItem().toString();
        String plan = "SELECT planilla,nroruta,referencia FROM despachos WHERE fecha LIKE '%" + fechasis + "%' AND nroruta='" + cbxruta.getSelectedItem().toString() + "' AND referencia = '"+ref+"'";     
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(plan);
            while (rs.next()) {
                planilla = rs.getInt("planilla");
                ruta = rs.getString("nroruta");
                referencia = rs.getString("referencia");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
        String sql = "SELECT planilla,nroruta,referencia FROM despachos WHERE fecha LIKE '%" + fechasis + "%' AND nroruta='" + cbxruta.getSelectedItem().toString() + "' AND planilla = "+txtplanilla.getText()+"";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                planilla2= rs.getInt("planilla");
                ruta2 = rs.getString("nroruta");
                re = rs.getString("referencia");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: "+e);
        }
       
         if ((planilla == plani) && (tras.equals(ruta)) && (referencia.equals(ref))) {
               sumaDespachos();
        } else {
             if ((tras == null ? ruta2 == null : tras.equals(ruta2)) && (ref == null ? re != null : !ref.equals(re))){
            despachaPlanilla();
           
            } else {
                   menor();         
            }
        }       
    }

    public void consultaRuta() {
        String desc = "SELECT nroruta,referencia FROM despachos WHERE planilla = '" + txtplanilla.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(desc);
            while (rs.next()) {
                ruta = rs.getString("nroruta");
                ref = rs.getString("referencia");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR SOFT-ICE " + e);
        }
    }

    public void InstanciaFecha() {
        Calendar cal = GregorianCalendar.getInstance();
        Date fecha = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fechasis = sdf.format(fecha);

    }

    public void sumaDespachos() {
        String ruta = cbxruta.getSelectedItem().toString();
        String referencia = cbxreferencia.getSelectedItem().toString();
        String suma = "UPDATE despachos SET cantidad = cantidad + '" + txtcantidad.getText() + "' WHERE nroruta='" + ruta + "' AND referencia='" + referencia + "' AND fecha LIKE '%" + fechasis + "%'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(suma);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR SOFT-ICE: " + e);
        }
        JOptionPane.showMessageDialog(null, "DESPACHADO CON EXITO");
        cbxturno.setSelectedItem("");
        cbxruta.setSelectedItem("");
        cbxreferencia.setSelectedItem("");
        txtcantidad.setText("");
        txtlote.setText("");
        txtdespacho.setText("");
        txtplanilla.setText("");
    }
    public void actualizaPantalla(){
        SwingUtilities.updateComponentTreeUI(this);
        this.validate();
    }
    public void menor() {//METODO PARA INGRESAR LOS DESPACHOS
        String valor;
        valor = txtplanilla.getText();
        int vlr = Integer.parseInt(valor);
       
        if (vlr <= max) {
            JOptionPane.showMessageDialog(null, "EL NUMERO DE LA PLANILLA NO PUEDE SER MENOR AL NUMERO DEL DESPACHO ANTERIOR");
         }else{
            String turno = cbxturno.getSelectedItem().toString();
            String ruta = cbxruta.getSelectedItem().toString();
            String referencia = cbxreferencia.getSelectedItem().toString();
            String cantidad = txtcantidad.getText();
            String lote = txtlote.getText();
            String despachado = txtdespacho.getText();
            String planilla = txtplanilla.getText();
            kilosPorRuta();
            BeansDespachos bd = new BeansDespachos();
            bd.setTurno(turno);
            bd.setRuta(ruta);
            bd.setReferencia(referencia);
            bd.setCantidad(cantidad);
            bd.setLote(lote);
            bd.setDespacho(despachado);
            bd.setPlanilla(planilla);
            DAODespachos dd = new DAODespachos();
            dd.InsertarDespachos(bd);
            JOptionPane.showMessageDialog(null, "DESPACHADO CON EXITO");
            cbxturno.setSelectedItem("");
            cbxruta.setSelectedItem("");
            cbxreferencia.setSelectedItem("");
            txtcantidad.setText("");
            txtlote.setText("");
            txtdespacho.setText("");
            txtplanilla.setText("");
            max = vlr;
      } 
    }
    public void despachaPlanilla(){
            String turno = cbxturno.getSelectedItem().toString();
            String ruta = cbxruta.getSelectedItem().toString();
            String referencia = cbxreferencia.getSelectedItem().toString();
            String cantidad = txtcantidad.getText();
            String lote = txtlote.getText();
            String despachado = txtdespacho.getText();
            String planilla = txtplanilla.getText();
            kilosPorRuta();
            BeansDespachos bd = new BeansDespachos();
            bd.setTurno(turno);
            bd.setRuta(ruta);
            bd.setReferencia(referencia);
            bd.setCantidad(cantidad);
            bd.setLote(lote);
            bd.setDespacho(despachado);
            bd.setPlanilla(planilla);
            DAODespachos dd = new DAODespachos();
            dd.InsertarDespachos(bd);
            JOptionPane.showMessageDialog(null, "DESPACHADO CON EXITO");
            cbxturno.setSelectedItem("");
            cbxruta.setSelectedItem("");
            cbxreferencia.setSelectedItem("");
            txtcantidad.setText("");
            txtlote.setText("");
            txtdespacho.setText("");
            txtplanilla.setText("");
         
    } 
    public void turnoConFecha() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int diaB = fecha.get(Calendar.DAY_OF_MONTH);
        mes = mes + 1;
        String turno = cbxturno.getSelectedItem().toString();
        if (turno.equals("Turno 1")) {
            diaB = diaB - 1;
            String Consult = "SELECT turno,nroruta,referencia,cantidad,despachado_por,planilla FROM despachos WHERE  fecha BETWEEN '" + año + "-" + mes + "-" + diaB + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:00:00'";
            ConsultaDespacho(Consult);
        } else {
            if (turno.equals("Turno 2")) {
                String Consult = "SELECT turno,nroruta,referencia,cantidad,despachado_por,planilla FROM despachos WHERE  fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 13:00:00'";
                ConsultaDespacho(Consult);
            } else {
                if (turno.equals("Turno 3")) {
                    String Consult = "SELECT turno,nroruta,referencia,cantidad,despachado_por,planilla FROM despachos WHERE  fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 13"
                            + ":00:00' AND '" + año + "-" + mes + "-" + dia + " 21:00:00'";
                    ConsultaDespacho(Consult);
                }
            }
        }
    }
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
        String refe12 = "BLOQUE 25 KILOS";
        String extra13 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe12 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra13);
            while (rs.next()) {
                Bloque25IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
         String refe13 = "CUARTO DE BLOQUE";
        String extra14 = "SELECT saldo FROM inventariocava WHERE referencia='" + refe13 + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(extra14);
            while (rs.next()) {
                Bloque25IC = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }
        
    }
    public void actualizaOrdenProduccion(){
     //debe capturar la cantidad y la referencia que despachan o se trasladan para modificar los saldos de la cava
       String cant = txtcantidad.getText();
       int cantidad = Integer.parseInt(cant);
       String ref = cbxreferencia.getSelectedItem().toString();
       
     
     
    }
    
    
    private void cbxrutaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxrutaItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxrutaItemStateChanged

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        descargafecha();
        consultaRuta();
        comparaPlanilla();
        actualizaPantalla();
      
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btncancelarActionPerformed


    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        turnoConFecha();
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btdevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdevolucionesActionPerformed
        Devoluciones dv = new Devoluciones();
        dv.setVisible(true);
    }//GEN-LAST:event_btdevolucionesActionPerformed
    public void kilosPorRuta() {
        double produccion = 0;
        double mini = 0;
        double Polar2;
        double Polar3;
        //double Polar4 = 0;
        double Polar12;
        double Polar15;
        double Polar20;
        double Escama20 = 0;
        double Bloque2;
        double Esquimal12;
        double Parranda12;
        double Iglu7;
        double Colsu3;
        double Parra2;
        double Cbloque;
        double Fresca2;
        double Iglucili20;
        double Iglu15;
        double Iglu3;
        double picada;
        double Fresca3;
        String Mini = "IGLU 500 GRAMOS";
        String Pol2 = "POLAR 2 KILOS";
        String Pol3 = "POLAR 3 KILOS";
        String Pol12 = "POLAR 12 KILOS";
        String Pol15 = "POLAR 15 KILOS";
        String Pol20 = "POLAR 20 KILOS";
        String Escama = "ESCAMA 20 KILOS";
        String CBloque = "CUARTO DE BLOQUE";
        String Parranda = "PARRANDA 12 KILOS";
        String Igl7 = "IGLU 7 KILOS";
        String Colsub3 = "COLSUBSIDIO 3 KILOS";
        String Parr2 = "PARRANDA 2 KILOS";
        String Bloque = "BLOQUE 25 KILOS";
        String fresca2 = "FRESCAMPO 2 KILOS";
        String IgluCil20 = "IGLU 20 KILOS";
        String Igl15 = "IGLU 15 KILOS";
        String Igl3 = "IGLU 3 KILOS";
        String Picada = "PICADA TRANSP 20 KILOS";
        String Fres3 = "FRESCAMPO 3 KILOS";
        String cant = txtcantidad.getText();
        String nombre = cbxruta.getSelectedItem().toString();
        String referencia = cbxreferencia.getSelectedItem().toString();
        int cantidad = Integer.parseInt(cant);
        if (referencia.equals(Mini)) {
            mini = cantidad * 0.5;
            String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Mini + "', nombre ='" + nombre + "'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                st.execute(cantidadCargada);

            } catch (SQLException e) {
            }
        } else {
            if (referencia.equals(Pol2)) {
                Polar2 = cantidad * 2.3;
                System.out.println("kilos: " + Polar2);
                String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Polar2 + "', nombre ='" + nombre + "'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    st.execute(cantidadCargada);

                } catch (SQLException e) {
                }

            } else {
                if (referencia.equals(Pol3)) {
                    Polar3 = cantidad * 3.3;
                    //System.out.println("kilos: " + Polar4);
                    String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Polar3 + "', nombre ='" + nombre + "'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        st.execute(cantidadCargada);

                    } catch (SQLException e) {
                    }

                } else {
                    if (referencia.equals(Pol12)) {
                        Polar12 = cantidad * 12.3;
                        
                        String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Polar12 + "', nombre ='" + nombre + "'";
                        try {
                            Connection con = Conexion.conectar("mysql");
                            Statement st = con.createStatement();
                            st.execute(cantidadCargada);

                        } catch (SQLException e) {
                        }

                    } else {
                        if (referencia.equals(Pol15)) {
                            Polar15 = cantidad * 15.3;
                            
                            String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Polar15 + "', nombre ='" + nombre + "'";
                            try {
                                Connection con = Conexion.conectar("mysql");
                                Statement st = con.createStatement();
                                st.execute(cantidadCargada);

                            } catch (SQLException e) {
                            }

                        } else {
                            if (referencia.equals(Pol20)) {
                                Polar20 = cantidad * 20.3;
                               
                                String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Polar20 + "', nombre ='" + nombre + "'";
                                try {
                                    Connection con = Conexion.conectar("mysql");
                                    Statement st = con.createStatement();
                                    st.execute(cantidadCargada);

                                } catch (SQLException e) {
                                }

                            } else {
                                if (referencia.equals(Escama)) {
                                    Escama20 = cantidad * 20.3;
                                  
                                    String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Escama20 + "', nombre ='" + nombre + "'";
                                    try {
                                        Connection con = Conexion.conectar("mysql");
                                        Statement st = con.createStatement();
                                        st.execute(cantidadCargada);

                                    } catch (SQLException e) {
                                    }
                                } else {
                                    if (referencia.equals(CBloque)) {
                                        Cbloque = cantidad * 6.5;
                                        
                                        String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Cbloque + "', nombre ='" + nombre + "'";
                                        try {
                                            Connection con = Conexion.conectar("mysql");
                                            Statement st = con.createStatement();
                                            st.execute(cantidadCargada);

                                        } catch (SQLException e) {
                                        }
                                    } else {
                                        if (referencia.equals(Bloque)) {
                                            Bloque2 = cantidad * 25.3;
                                           
                                            String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Bloque2 + "', nombre ='" + nombre + "'";
                                            try {
                                                Connection con = Conexion.conectar("mysql");
                                                Statement st = con.createStatement();
                                                st.execute(cantidadCargada);

                                            } catch (SQLException e) {
                                            }
                                        } else {
                                            if (referencia.equals(Parranda)) {
                                                Parranda12 = cantidad * 12.3;
                                                
                                                String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Parranda + "', nombre ='" + nombre + "'";
                                                try {
                                                    Connection con = Conexion.conectar("mysql");
                                                    Statement st = con.createStatement();
                                                    st.execute(cantidadCargada);

                                                } catch (SQLException e) {
                                                }
                                            } else {
                                                if (referencia.equals(Igl7)) {
                                                    Iglu7 = cantidad * 7.3;
                                                    
                                                    String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Iglu7 + "', nombre ='" + nombre + "'";
                                                    try {
                                                        Connection con = Conexion.conectar("mysql");
                                                        Statement st = con.createStatement();
                                                        st.execute(cantidadCargada);

                                                    } catch (SQLException e) {
                                                    }
                                                } else {
                                                    if (referencia.equals(Colsub3)) {
                                                        Colsu3 = cantidad * 3.3;
                                                        
                                                        String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Colsu3 + "', nombre ='" + nombre + "'";
                                                        try {
                                                            Connection con = Conexion.conectar("mysql");
                                                            Statement st = con.createStatement();
                                                            st.execute(cantidadCargada);

                                                        } catch (SQLException e) {
                                                        }
                                                    } else {
                                                        if (referencia.equals(Parr2)) {
                                                            Parra2 = cantidad * 2.3;
                                                       
                                                            String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Parra2 + "', nombre ='" + nombre + "'";
                                                            try {
                                                                Connection con = Conexion.conectar("mysql");
                                                                Statement st = con.createStatement();
                                                                st.execute(cantidadCargada);

                                                            } catch (SQLException e) {
                                                            }
                                                        } else {
                                                            if (referencia.equals(fresca2)) {
                                                                Fresca2 = cantidad * 2.3;
                                                                
                                                                String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Fresca2 + "', nombre ='" + nombre + "'";
                                                                try {
                                                                    Connection con = Conexion.conectar("mysql");
                                                                    Statement st = con.createStatement();
                                                                    st.execute(cantidadCargada);

                                                                } catch (SQLException e) {
                                                                }
                                                            } else {
                                                                if (referencia.equals(IgluCil20)) {
                                                                    Iglucili20 = cantidad * 20.3;
                                                                    
                                                                    String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Iglucili20 + "', nombre ='" + nombre + "'";
                                                                    try {
                                                                        Connection con = Conexion.conectar("mysql");
                                                                        Statement st = con.createStatement();
                                                                        st.execute(cantidadCargada);

                                                                    } catch (SQLException e) {
                                                                    }
                                                                } else {
                                                                    if (referencia.equals(Igl15)) {
                                                                        Iglu15 = cantidad * 15.3;
                                                                      
                                                                        String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Iglu15 + "', nombre ='" + nombre + "'";
                                                                        try {
                                                                            Connection con = Conexion.conectar("mysql");
                                                                            Statement st = con.createStatement();
                                                                            st.execute(cantidadCargada);

                                                                        } catch (SQLException e) {
                                                                        }
                                                                    } else {
                                                                        if (referencia.equals(Igl3)) {
                                                                            Iglu3 = cantidad * 3.3;
                                                                           
                                                                            String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Iglu3 + "', nombre ='" + nombre + "'";
                                                                            try {
                                                                                Connection con = Conexion.conectar("mysql");
                                                                                Statement st = con.createStatement();
                                                                                st.execute(cantidadCargada);

                                                                            } catch (SQLException e) {
                                                                            }
                                                                        } else {
                                                                            if (referencia.equals(Picada)) {
                                                                                picada = cantidad * 20.3;
                                                                                
                                                                                String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + picada + "', nombre ='" + nombre + "'";
                                                                                try {
                                                                                    Connection con = Conexion.conectar("mysql");
                                                                                    Statement st = con.createStatement();
                                                                                    st.execute(cantidadCargada);

                                                                                } catch (SQLException e) {
                                                                                }
                                                                            } else {
                                                                                if (referencia.equals(Fres3)) {
                                                                                    Fresca3 = cantidad * 3.3;
                                                                                    
                                                                                    String cantidadCargada = "INSERT INTO kilosdespachados SET referencia = '" + cbxreferencia.getSelectedItem() + "', kilos = '" + txtcantidad.getText() + "', totalkilos = '" + Fresca3 + "', nombre ='" + nombre + "'";
                                                                                    try {
                                                                                        Connection con = Conexion.conectar("mysql");
                                                                                        Statement st = con.createStatement();
                                                                                        st.execute(cantidadCargada);

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
                            }//fin si kilospor2
                        }//fin si bloque
                    }//fin si iglu15
                }//fin si iglu3
            }//fin si iglu20

        }
    }

    public void CargaReferencia() {
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

    }

    public void Cargabd() {
        String sql = "SELECT codigo,nombre FROM rutasm ";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cbxruta.addItem(rs.getString(1).concat(". ").concat(rs.getString(2)));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

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
            java.util.logging.Logger.getLogger(Despacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Despacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Despacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Despacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Despacho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdevoluciones;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cbxreferencia;
    private javax.swing.JComboBox<String> cbxruta;
    private javax.swing.JComboBox<String> cbxturno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbconsulta;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtdespacho;
    private javax.swing.JTextField txtlote;
    private javax.swing.JTextField txtplanilla;
    // End of variables declaration//GEN-END:variables
}
