package VistasCC;

import Beans.BeansPuntoVenta;
import DAO.DAOPuntoVenta;
import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class puntoVentaDevoluciones extends javax.swing.JFrame {

    public puntoVentaDevoluciones() {
        initComponents();
        CargaRuta();
        Cargabd();
    }

    public void CargaRuta() {
        String sql = "SELECT codigo,nombre FROM rutasm ";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cbxruta.addItem(rs.getString("codigo").concat(". ").concat(rs.getString("nombre")));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
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
            System.out.println(ex);
        }

    }

    public void insertaDevolucion() {
        String ruta = cbxruta.getSelectedItem().toString();
        String referencia = cbxreferencia.getSelectedItem().toString();
        String cantidad = txtcantidad.getText();
        String placa = txtplaca.getText();
        String vendedor = txtvendedor.getText();
        String lote = txtlote.getText();

        BeansPuntoVenta bpv = new BeansPuntoVenta();
        bpv.setReferencia(referencia);
        bpv.setRuta(ruta);
        bpv.setCantidad(cantidad);
        bpv.setPlaca(placa);
        bpv.setVendedor(vendedor);
        bpv.setLote(lote);

        DAOPuntoVenta dpv = new DAOPuntoVenta();
        dpv.insertaDevolucion(bpv);
        JOptionPane.showMessageDialog(null, "DEVOLUCION REALIZADA EXITOSAMENTE");
        cbxruta.setSelectedItem(" ");
        cbxreferencia.setSelectedItem(" ");
        txtcantidad.setText(" ");
        txtplaca.setText(" ");
        txtvendedor.setText(" ");
        txtlote.setText(" ");

    }//metodo que inserta el movimiento en la base de datos

    public void afectaDespachos() {
        Calendar cal = new GregorianCalendar();
        Date fecha = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fec = sdf.format(fecha);
        String up = "UPDATE despachos SET cantidad =cantidad-" + txtcantidad.getText() + " WHERE referencia = '" + cbxreferencia.getSelectedItem().toString() + "' AND nroruta='" + cbxruta.getSelectedItem().toString() + "' AND fecha LIKE '%" + fec + "%'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(up);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
        }

    }//metodo que afecta los despachos de la ruta segun el dia del despacho
    public void afectaCavaPV(){
        Calendar cal = new GregorianCalendar();
        Date fecha = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fec = sdf.format(fecha);
        String up = "UPDATE invinicialcavapv SET cantidad =cantidad+" + txtcantidad.getText() + " WHERE referencia = '" + cbxreferencia.getSelectedItem().toString() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(up);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Soft-Ice: " + e);
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
        cbxruta = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxreferencia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtlote = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtplaca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtvendedor = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnconsulta = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PUNTO DE VENTA DEVOLUCIONES");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("PUNTO DE VENTA DEVOLUCIONES");

        jLabel2.setText("RUTA:");

        cbxruta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel3.setText("REFERENCIA:");

        cbxreferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        jLabel4.setText("CANTIDAD:");

        jLabel5.setText("LOTE:");

        txtlote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloteActionPerformed(evt);
            }
        });

        jLabel6.setText("PLACA:");

        jLabel7.setText("VENDEDOR:");

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnconsulta.setText("CONSULTA");

        btncancelar.setText("CANCELAR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(cbxruta, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(txtcantidad)
                            .addComponent(txtvendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btnguardar)
                        .addGap(32, 32, 32)
                        .addComponent(btnconsulta)
                        .addGap(18, 18, 18)
                        .addComponent(btncancelar)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnconsulta)
                    .addComponent(btncancelar))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtloteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloteActionPerformed

    }//GEN-LAST:event_txtloteActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        System.exit(1);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        afectaDespachos();
        insertaDevolucion();

    }//GEN-LAST:event_btnguardarActionPerformed

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
            java.util.logging.Logger.getLogger(puntoVentaDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(puntoVentaDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(puntoVentaDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(puntoVentaDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new puntoVentaDevoluciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cbxreferencia;
    private javax.swing.JComboBox<String> cbxruta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtlote;
    private javax.swing.JTextField txtplaca;
    private javax.swing.JTextField txtvendedor;
    // End of variables declaration//GEN-END:variables
}
