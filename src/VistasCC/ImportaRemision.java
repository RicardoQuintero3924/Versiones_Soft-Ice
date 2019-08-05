package VistasCC;

import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ImportaRemision extends javax.swing.JFrame {

    public ImportaRemision() {
        initComponents();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
    }

    public void consultaCarga() {
        //tbremision.setModel(new DefaultTableModel());
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("NIT");
        dtm.addColumn("CLIENTE");
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("NUMERO REMISION");
        dtm.addColumn("FECHA");
        dtm.addColumn("RUTA");  
        dtm.addColumn("CANTIDAD");
        mes = mes + 1;
        tbremision.setModel(dtm);
        String ingre = "SELECT nit,cliente,referencia,numeroR,fecha,ruta,cantidad FROM remisionesmanuales WHERE fechaSistema BETWEEN '"+año+"-"+ mes + "-" + dia + " 00:00:00' AND '"+año+"-"+mes+"-"+dia+" 23:59:59'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(ingre);
            String[] ven = new String[7];
            while (rs.next()) {
                ven[0] = rs.getString(1);
                ven[1] = rs.getString(2);
                ven[2] = rs.getString(3);
                ven[3] = rs.getString(4);
                ven[4] = rs.getString(5);
                ven[5] = rs.getString(6);
                ven[6] = rs.getString(7);
                dtm.addRow(ven);
            }

        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"ERROR CONSULTA "+ e);
        }
    }

    public void carga() {
        String ingre = "LOAD DATA INFILE '" + txtimport.getText()
                + "' INTO TABLE remisionesmanuales "
                + "FIELDS TERMINATED BY ';' "
                + "LINES TERMINATED BY '\r\n' "
                + "IGNORE 7 LINES"
                + "(nit,cliente,referencia,numeroR,fecha,ruta,cantidad)";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(ingre);
            JOptionPane.showMessageDialog(null, "IMPORTADO CON EXITO");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA MIGRACION DE DATOS " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnimport = new javax.swing.JButton();
        txtimport = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbremision = new javax.swing.JTable();
        btnconsul = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("IMPORTAR REMISIONES MANUALES");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("IMPORTAR REMISIONES MANUALES");

        btnimport.setText("IMPORTAR");
        btnimport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimportActionPerformed(evt);
            }
        });

        tbremision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbremision);

        btnconsul.setText("CONSULTAR");
        btnconsul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(192, 192, 192))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnimport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtimport, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnconsul)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnimport)
                    .addComponent(txtimport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnimportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimportActionPerformed

        carga();
        
    }//GEN-LAST:event_btnimportActionPerformed

    private void btnconsulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulActionPerformed
        // TODO add your handling code here:
        consultaCarga();
    }//GEN-LAST:event_btnconsulActionPerformed

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
            java.util.logging.Logger.getLogger(ImportaRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportaRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportaRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportaRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportaRemision().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsul;
    private javax.swing.JButton btnimport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbremision;
    private javax.swing.JTextField txtimport;
    // End of variables declaration//GEN-END:variables
}
