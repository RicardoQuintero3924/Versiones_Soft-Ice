package VistasCC;

import Beans.BeansTraslados;
import DAO.DAOTraslados;
import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
//FALTA ORGANIZAR LAS AFECTACIONES EN LOS TRASLADOS DE LAS CAVAS DE CARTAGENA Y BOGOTA.
public class Traslados extends javax.swing.JFrame {

    public Traslados() {
        initComponents();
        Cargabd();
        CargaRuta();
        this.cbxorigen.addItem("PLANTA PRINCIPAL");
        this.cbxorigen.addItem("PLANTA SUR");
        this.cbxorigen.addItem("PUNTO VENTA LOS COLORES");
        this.cbxorigen.addItem("PUNTO VENTA RIONEGRO");

        // this.cbxorigen.addItem("RUTA");
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

    public void inserta() {
        String origen = cbxorigen.getSelectedItem().toString();
        String destino = cbxdestino.getSelectedItem().toString();
        String transporte = cbxtransporte.getSelectedItem().toString();
        String referencia = cbxreferencia.getSelectedItem().toString();
        String cantidad = txtcantidad.getText();
        int cant = Integer.parseInt(cantidad);
        String despechado = txtdespachado.getText();
        String lote = txtlote.getText();
        String observa = txtobservaciones.getText();
        String remision = txtremision.getText();

        BeansTraslados bt = new BeansTraslados();
        bt.setOrigen(origen);
        bt.setDestino(destino);
        bt.setTransporte(transporte);
        bt.setReferencia(referencia);
        bt.setCantidad(cant);
        bt.setDespachado_por(despechado);
        bt.setLote(lote);
        bt.setObserva(observa);
        bt.setRemision(remision);

        DAOTraslados dao = new DAOTraslados();
        dao.InsertaTraslados(bt);
        JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
        cbxorigen.setSelectedItem(0);
        cbxdestino.setSelectedItem(0);
        cbxtransporte.setSelectedItem(0);
        cbxreferencia.setSelectedItem(0);
        txtcantidad.setText("");
        txtdespachado.setText("");
        txtlote.setText("");
        txtobservaciones.setText("");
        txtremision.setText("");

    }

    public void CargaRuta() {
        String sql = "SELECT codigo,nombre FROM rutasm ";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cbxtransporte.addItem(rs.getString("codigo").concat(".").concat(rs.getString("nombre")));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void conecta(String sql) {
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
    }

    public void afectaTraslado() {
        Calendar cal = GregorianCalendar.getInstance();
        Date fecha = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechasis = sdf.format(fecha);
        String origen;
        String destino;
        origen = cbxorigen.getSelectedItem().toString();
        destino = cbxdestino.getSelectedItem().toString();
        String can = txtcantidad.getText();
        String refe = cbxreferencia.getSelectedItem().toString();
        int cantidad = Integer.parseInt(can);
        if (origen.equalsIgnoreCase("PLANTA PRINCIPAL") && (destino.equalsIgnoreCase("PUNTO VENTA LOS COLORES"))) {
            String update = "UPDATE invfinalcava SET cantidad = cantidad - " + cantidad + " WHERE referencia = '" + refe + "'";
            conecta(update);
           // String afectaPV = "UPDATE invfinalcavapv SET cantidad = cantidad + "+cantidad+" WHERE referencia = '"+refe+"'";
           // conecta(afectaPV);
        } else {
            if (origen.equalsIgnoreCase("PLANTA PRINCIPAL") && (destino.equalsIgnoreCase("PUNTO VENTA RIONEGRO"))) {
                String update = "UPDATE invfinalcava SET cantidad = cantidad - " + cantidad + " WHERE referencia = '" + refe + "'";
                conecta(update);
                String afectaPVR = "UPDATE invfinalcavapvr SET cantidad = cantidad + "+cantidad+" WHERE referencia = '"+refe+"' AND fecha LIKE '%"+fechasis+"%'";
                conecta(afectaPVR);
            } else {
                if (origen.equalsIgnoreCase("PLANTA PRINCIPAL") && (destino.equalsIgnoreCase("BOGOTA"))) {
                    String update = "UPDATE invenincava SET cantidad = cantidad - " + cantidad + " WHERE referencia = '" + refe + "'";
                    conecta(update);
                } else {
                    if (origen.equalsIgnoreCase("PLANTA PRINCIPAL") && (destino.equalsIgnoreCase("CARTAGENA"))) {
                        String update = "UPDATE invenincava SET cantidad = cantidad - " + cantidad + " WHERE referencia = '" + refe + "'";
                        conecta(update);
                    } else {
                        if (origen.equalsIgnoreCase("PLANTA PRINCIPAL") && (destino.equalsIgnoreCase("PLANTA SUR"))) {
                            String update = "UPDATE invenincava SET cantidad = cantidad - " + cantidad + " WHERE referencia = '" + refe + "'";
                            conecta(update);
                        }
                    }
                }
            }
        }

        System.out.println("se descontaron de la cava " + cantidad + " de la referencia " + refe);
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
        cbxorigen = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxdestino = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxtransporte = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxreferencia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdespachado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtobservaciones = new javax.swing.JTextArea();
        btnrealizar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtlote = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtremision = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TRASLADOS");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("TRASLADOS");

        jLabel2.setText("ORIGEN:");

        cbxorigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        cbxorigen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxorigenItemStateChanged(evt);
            }
        });
        cbxorigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxorigenActionPerformed(evt);
            }
        });

        jLabel3.setText("DESTINO");

        cbxdestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel4.setText("TRANSPORTE");

        cbxtransporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        cbxtransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxtransporteActionPerformed(evt);
            }
        });

        jLabel5.setText("REFERENCIA");

        cbxreferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel6.setText("CANTIDAD");

        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });

        jLabel7.setText("DESPACHADO POR:");

        jLabel8.setText("OBSERVACIONES:");

        txtobservaciones.setColumns(20);
        txtobservaciones.setRows(5);
        jScrollPane1.setViewportView(txtobservaciones);

        btnrealizar.setText("REALIZAR");
        btnrealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrealizarActionPerformed(evt);
            }
        });

        btnconsultar.setText("CONSULTAR");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        jButton1.setText("CANCELAR");

        jLabel9.setText("LOTE:");

        txtlote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloteActionPerformed(evt);
            }
        });

        jLabel10.setText("REMISION:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(cbxreferencia, 0, 175, Short.MAX_VALUE)
                                    .addComponent(cbxorigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(cbxdestino, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel4)
                                                    .addComponent(cbxtransporte, 0, 184, Short.MAX_VALUE)
                                                    .addComponent(txtdespachado)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel10)
                                                        .addGap(121, 121, 121))
                                                    .addComponent(txtremision)))))
                                    .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnrealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnconsultar)
                        .addGap(77, 77, 77)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(249, 249, 249))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxorigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxdestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxtransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdespachado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtremision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnrealizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxorigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxorigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxorigenActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void cbxtransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxtransporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxtransporteActionPerformed

    private void txtloteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloteActionPerformed

    private void cbxorigenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxorigenItemStateChanged
        //Enlasa los combobox origen y destino.

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String tras = (String) cbxorigen.getSelectedItem();
            if (this.cbxorigen.getSelectedIndex() > 0) {
                this.cbxdestino.setModel(new DefaultComboBoxModel(this.getEntrada(tras)));
            }
        }

    }//GEN-LAST:event_cbxorigenItemStateChanged

    private void btnrealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrealizarActionPerformed
        // TODO add your handling code here:
        afectaTraslado();
        inserta();
    }//GEN-LAST:event_btnrealizarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        // TODO add your handling code here:
        new ConsultaTraslado().setVisible(true);
    }//GEN-LAST:event_btnconsultarActionPerformed

    public String[] getEntrada(String salida) {
        String[] traslada = new String[7];
        if (salida.equalsIgnoreCase("PLANTA PRINCIPAL")) {
            traslada[0] = "PUNTO VENTA LOS COLORES";
            traslada[1] = "PLANTA SUR";
            traslada[2] = "PUNTO VENTA RIONEGRO";
            traslada[3] = "BOGOTA";
            traslada[4] = "CARTAGENA";
        }
        if (salida.equalsIgnoreCase("PLANTA SUR")) {
            traslada[0] = "PLANTA PRINCIPAL";
            traslada[1] = "PUNTO VENTA RIONEGRO";
            traslada[2] = "PUNTO VENTA LOS COLORES";
            traslada[3] = "BOGOTA";
            traslada[4] = "CARTAGENA";
        }
        if (salida.equalsIgnoreCase("PUNTO VENTA RIONEGRO")) {
            traslada[0] = "PLANTA PRINCIPAL";
            traslada[1] = "PLANTA SUR";
            traslada[2] = "PUNTO VENTA LOS COLORES";
        }
        if (salida.equalsIgnoreCase("PUNTO VENTA LOS COLORES")) {
            traslada[0] = "PLANTA PRINCIPAL";
            traslada[1] = "PLANTA SUR";
            traslada[2] = "PUNTO VENTA RIONEGRO";

        }

        return traslada;
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
            java.util.logging.Logger.getLogger(Traslados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Traslados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Traslados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Traslados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Traslados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btnrealizar;
    private javax.swing.JComboBox<String> cbxdestino;
    private javax.swing.JComboBox<String> cbxorigen;
    private javax.swing.JComboBox<String> cbxreferencia;
    private javax.swing.JComboBox<String> cbxtransporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtdespachado;
    private javax.swing.JTextField txtlote;
    private javax.swing.JTextArea txtobservaciones;
    private javax.swing.JTextField txtremision;
    // End of variables declaration//GEN-END:variables
}
