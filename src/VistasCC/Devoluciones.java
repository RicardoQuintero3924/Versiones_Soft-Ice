package VistasCC;

import Beans.BeansDevoluciones;
import DAO.DAODevoluciones;
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
import javax.swing.table.DefaultTableModel;

public final class Devoluciones extends javax.swing.JFrame {

    int Kcarga = 0;
    
 //hola 
 //hola 
    public Devoluciones() {
        initComponents();
        Cargabd();
        CargarRuta();
        
        this.cbxturno.addItem("Turno 1");
        this.cbxturno.addItem("Turno 2");
        this.cbxturno.addItem("Turno 3");
        this.cbxestado.addItem("BUENO");
        this.cbxestado.addItem("MALO");
    }

    public void sumaKilos() {
        String inserta = "INSERT INTO totalvendido SET cargados = (SELECT SUM(totalkilos) FROM Kilosdespachados WHERE nombre = '" + cbxruta.getSelectedItem() + "'), ruta = '" + cbxruta.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(inserta);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
   
    public void totalVendido() {

        int Kdevueltos = 0;
        int devuelto = 0;
        double libra = 0;
        int Total = 0;
        double Toneladas = 0;
        String devol;
        String referencia;
        String ruta;
        String Kcargado = "SELECT cargados FROM totalvendido WHERE ruta = '" + cbxruta.getSelectedItem() + "'";

        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Kcargado);
            while (rs.next()) {
                Kcarga = rs.getInt("cargados");
            }
        } catch (Exception e) {
        }

        devol = txtdevolucion.getText();
        devuelto = Integer.parseInt(devol);
        referencia = cbxreferencia.getSelectedItem().toString();
        ruta = cbxruta.getSelectedItem().toString();
        String iglu20 = "BOLSA DE HIELO IGLU 20 KILOS";
        String iglu3 = "BOLSA DE HIELO IGLU 3 KILOS";
        String iglu15 = "BOLSA DE HIELO IGLU 15 KG";
        String bloque = "BOLSA DE HIELO EN BLOQUE IGLU ";
        String iglu2 = "BOLSA DE HIELO IGLU 2 KG";
        String iglu500 = "BOLSA DE HIELO IGLU 500 GR";
        if (referencia.equals(iglu20)) {
            Kdevueltos = devuelto * 20;
            Total = Kcarga - Kdevueltos;
            Toneladas = Total / 1000;
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                st.execute("INSERT INTO kilos_toneladas SET kilos = '" + Total + "', toneladas = '" + Toneladas + "', ruta='" + ruta + "'");
            } catch (Exception e) {
            }
            System.out.println("devuelto por 20: " + Kdevueltos);

        } else {
            if (referencia.equals(iglu3)) {
                Kdevueltos = devuelto * 3;
                Total = Kcarga - Kdevueltos;
                Toneladas = Total / 1000;
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    st.execute("INSERT INTO kilos_toneladas SET kilos = '" + Total + "', toneladas = '" + Toneladas + "', ruta='" + ruta + "'");
                } catch (Exception e) {
                }
                System.out.println("devuelto por 3: " + Kdevueltos + " kilos es:" + Total);
            } else {
                if (referencia.equals(iglu15)) {
                    Kdevueltos = devuelto * 15;
                    Total = Kcarga - Kdevueltos;
                    Toneladas = Total / 1000;
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        st.execute("INSERT INTO kilos_toneladas SET kilos = '" + Total + "', toneladas = '" + Toneladas + "', ruta='" + ruta + "'");
                    } catch (Exception e) {
                    }
                    System.out.println("kilos despachados " + Kcarga);
                    System.out.println("devuelto por 15: " + Kdevueltos + " quedan: " + Total);
                } else {
                    if (referencia.equals(bloque)) {
                        Kdevueltos = devuelto * 25;
                        Total = Kcarga - Kdevueltos;
                        Toneladas = Total / 1000;
                        try {
                            Connection con = Conexion.conectar("mysql");
                            Statement st = con.createStatement();
                            st.execute("INSERT INTO kilos_toneladas SET kilos = '" + Total + "', toneladas = '" + Toneladas + "', ruta='" + ruta + "'");
                        } catch (Exception e) {
                        }
                        System.out.println("devuelto por bloque: " + Kdevueltos + " total: " + Total);

                    } else {
                        if (referencia.equals(iglu2)) {
                            Kdevueltos = devuelto * 2;
                            Total = Kcarga - Kdevueltos;
                            Toneladas = Total / 1000;
                            try {
                                Connection con = Conexion.conectar("mysql");
                                Statement st = con.createStatement();
                                st.execute("INSERT INTO kilos_toneladas SET kilos = '" + Total + "', toneladas = '" + Toneladas + "', ruta='" + ruta + "'");
                            } catch (Exception e) {
                            }
                            System.out.println("devuelto por 2: " + Kdevueltos + " total: " + Total);

                        } else {
                            if (referencia.equals(iglu500)) {
                                libra = devuelto * 0.5;
                                Total = Kcarga - Kdevueltos;
                                Toneladas = Total / 1000;
                                try {
                                    Connection con = Conexion.conectar("mysql");
                                    Statement st = con.createStatement();
                                    st.execute("INSERT INTO kilos_toneladas SET kilos = '" + Total + "', toneladas = '" + Toneladas + "', ruta='" + ruta + "'");
                                } catch (Exception e) {
                                }
                                System.out.println("devuelto de 500: " + libra + " kilos total es: " + Total);
                            }
                        }
                    }
                }
            }
        }

    }
    public void actualizaDespacho(){
       
        int total;
        int despachado = 0;
        String devo = txtdevolucion.getText();
        int devolucion = Integer.parseInt(devo);
        String update ="SELECT cantidad,fecha FROM despachos WHERE referencia = '"+cbxreferencia.getSelectedItem()+"' AND nroruta= '"+cbxruta.getSelectedItem().toString()+"' AND fecha LIKE '%"+txtfecha.getText()+"%'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(update);
            while(rs.next()){
                 despachado = rs.getInt("cantidad");
                 
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        total = despachado - devolucion;
        System.out.println("total "+total);
    String actua = "UPDATE despachos SET cantidad = '"+total+"' WHERE referencia='"+cbxreferencia.getSelectedItem()+"' AND nroruta= '"+cbxruta.getSelectedItem().toString()+"'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(actua);
        } catch (SQLException e) {
            System.out.println(e);
        }
    
    }
    public void mostrarconsulta(String Text) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("RUTA");
        modelo.addColumn("REFERENCIA");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("FECHA");
        //modelo.addColumn("MARCA");
        tbConsulta.setModel(modelo);
        String[] datos = new String[4];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nroruta,referencia,cantidad,fecha FROM despachos  WHERE nroruta= '" + cbxruta.getSelectedItem() + "' AND  fecha like '%" + txtfecha.getText() + "%'");
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                modelo.addRow(datos);
            }
            tbConsulta.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }

    }

 
    @Override
    public Image getIconImage(){
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    public void CargarRuta() {
        String ruta = "SELECT codigo,nombre FROM rutasm";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(ruta);
            while (rs.next()) {
                cbxruta.addItem(rs.getString(1).concat(". ").concat(rs.getString(2)));
            }
        } catch (Exception e) {
        }

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

        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnconsultar = new javax.swing.JButton();
        txtdevolucion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtobservacion = new javax.swing.JTextArea();
        btnguardar = new javax.swing.JButton();
        cbxreferencia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbConsulta = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxturno = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtdespachador = new javax.swing.JTextField();
        btncancelar = new javax.swing.JButton();
        cbxruta = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxestado = new javax.swing.JComboBox<>();
        cbxdescribe = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEVOLUCIONES");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("DEVOLUCIONES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("RUTA");

        btnconsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnconsultar.setText("NUEVA CONSULTA");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("CANTIDAD DEVOLUCION");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("OBSERVACIONES");

        txtobservacion.setColumns(20);
        txtobservacion.setRows(5);
        jScrollPane2.setViewportView(txtobservacion);

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        cbxreferencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxreferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("REFERENCIA");

        tbConsulta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbConsulta);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("FECHA");

        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("TURNO");

        cbxturno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxturno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("DESPACHADOR");

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setText("SALIR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        cbxruta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("ESTADO DEVOLUCION:");

        cbxestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        cbxestado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxestadoItemStateChanged(evt);
            }
        });

        cbxdescribe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        cbxdescribe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxdescribeItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxruta, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(119, 119, 119)
                                .addComponent(btnconsultar)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxreferencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtdespachador, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxdescribe, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(69, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addComponent(btnguardar)
                .addGap(27, 27, 27)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(cbxruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxdescribe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdespachador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        // TODO add your handling code here:
        Devoluciones dv = new Devoluciones();
        dv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        String fecha = txtfecha.getText();
        String ruta = cbxruta.getSelectedItem().toString();
        String referencia = cbxreferencia.getSelectedItem().toString();
        String devolucion = txtdevolucion.getText();
        String turno = cbxturno.getSelectedItem().toString();
        String despacha = txtdespachador.getText();
        String observacion = txtobservacion.getText();
        String estado = cbxestado.getSelectedItem().toString();
        String descripcion = cbxdescribe.getSelectedItem().toString();
        actualizaDespacho();
        //sumaKilos();
        //totalVendido();

        BeansDevoluciones bd = new BeansDevoluciones();
        bd.setFecha(fecha);
        bd.setRuta(ruta);
        bd.setReferencia(referencia);
        bd.setDevolucion(devolucion);
        bd.setTurno(turno);
        bd.setDespacha(despacha);
        bd.setObservaciones(observacion);
        bd.setEstado(estado);
        bd.setDescripcion(descripcion);

        DAODevoluciones dd = new DAODevoluciones();
        dd.InsertarDevoluciones(bd);
        //dd.Devoluciones(bd);
        JOptionPane.showMessageDialog(null, "DEVOLUCION REALIZADA");
        txtfecha.setText("");
        cbxruta.setSelectedItem("");
        cbxreferencia.setSelectedItem("");
        txtdevolucion.setText("");
        cbxturno.setSelectedItem("");
        txtdespachador.setText("");
        txtobservacion.setText("");
        cbxestado.setSelectedItem("");
        cbxdescribe.setSelectedItem("");
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
        // TODO add your handling code here:
        this.mostrarconsulta(txtfecha.getText());
    }//GEN-LAST:event_txtfechaActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void cbxdescribeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxdescribeItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxdescribeItemStateChanged

    private void cbxestadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxestadoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String Seleccion = (String) cbxestado.getSelectedItem();
            if (this.cbxestado.getSelectedIndex() > 0) {
               
                this.cbxdescribe.setModel(new DefaultComboBoxModel(this.getDevolucion(Seleccion)));
            }
        }
    }//GEN-LAST:event_cbxestadoItemStateChanged

     public String[] getDevolucion(String estado){
       String [] devuelve = new String[3];
       if(estado.equalsIgnoreCase("BUENO")){
           devuelve[0] = "CAVA";
           JOptionPane.showMessageDialog(null,"SU DEVOLUCION SE SUMO A LA CAVA");
       }
       
       if(estado.equalsIgnoreCase("MALO")){
           devuelve[0] = "CALIDAD";
           devuelve[1] = "DAÑO CONGELADOR";
           devuelve[2] = "DAÑO TERMOCUPLA";
       }

        return devuelve;
    }
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
            java.util.logging.Logger.getLogger(Devoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Devoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Devoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Devoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Devoluciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btnguardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxdescribe;
    private javax.swing.JComboBox<String> cbxestado;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbConsulta;
    private javax.swing.JTextField txtdespachador;
    private javax.swing.JTextField txtdevolucion;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextArea txtobservacion;
    // End of variables declaration//GEN-END:variables

}
