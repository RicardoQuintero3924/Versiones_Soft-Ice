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
import javax.swing.table.DefaultTableModel;

public class TotalDespacho extends javax.swing.JFrame {

    public TotalDespacho() {
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
    public void consultadespacho() {//metodo para consultar por turno los despachos de cada turno
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int diaB = fecha.get(Calendar.DAY_OF_MONTH);
        mes = mes + 1;
        String turno = cbxturno.getSelectedItem().toString();
        if (turno.equals("Turno 1")) {
            diaB = diaB - 1;
            String cst = "SELECT referencia,kilos,totalkilos FROM kilosdespachados WHERE fecha BETWEEN '" + año + "-" + mes + "-" + diaB + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:00:00'";
            consulta(cst);
        } else {
            if (turno.equals("Turno 2")) {
                String cst = "SELECT referencia,kilos,totalkilos FROM kilosdespachados WHERE fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 14:00:00'";
                consulta(cst);
            } else {
                if (turno.equals("Turno 3")) {
                    String cst = "SELECT referencia,kilos,totalkilos FROM kilosdespachados WHERE fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 14:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:00:00'";
                    consulta(cst);
                }
            }
        }
    }

    public void consulta(String cst) {//metodo para reflejar informacion en la tabla tbdespacho
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        dtm.addColumn("KILOS");
        String[] dp = new String[3];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(cst);
            while (rs.next()) {
                dp[0] = rs.getString(1);
                dp[1] = rs.getString(2);
                dp[2] = rs.getString(3);
                dtm.addRow(dp);
                tbdespacho.setModel(dtm);
                tbdespacho.getColumnModel().getColumn(0).setPreferredWidth(200);
                tbdespacho.getColumnModel().getColumn(1).setPreferredWidth(50);
                tbdespacho.getColumnModel().getColumn(2).setPreferredWidth(50);

            }
        } catch (Exception e) {
        }
    }

    public void tonelada() {
        Calendar fecha = new GregorianCalendar();
        double tonelada = 0;
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int diaB = fecha.get(Calendar.DAY_OF_MONTH);
        mes = mes + 1;
        String turno = cbxturno.getSelectedItem().toString();
        if (turno.equals("Turno 1")) {
            diaB = diaB - 1;
            String tone = "SELECT SUM(totalkilos) AS TOTAL FROM kilosdespachados WHERE fecha BETWEEN '" + año + "-" + mes + "-" + diaB + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:00:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(tone);
                while (rs.next()) {
                    tonelada = rs.getInt("TOTAL");
                    tonelada = tonelada / 1000; 
                    System.out.println(tonelada);
                }
                String insert = "INSERT INTO toneladadespachada SET cantidad=" + tonelada;
                st.execute(insert);
            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            if (turno.equals("Turno 2")) {
                String tone = "SELECT SUM(totalkilos) AS TOTAL FROM kilosdespachados WHERE fecha BETWEEN '" + año + "-" + mes + "-" + diaB + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 14:00:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(tone);
                    while (rs.next()) {
                        tonelada = rs.getInt("TOTAL");
                        tonelada = tonelada / 1000; 
                    }
                    String insert = "INSERT INTO toneladadespachada SET cantidad=" + tonelada;
                    st.execute(insert);
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else {
                if (turno.equals("Turno 3")) {
                    String tone = "SELECT SUM(totalkilos) AS TOTAL FROM kilosdespachados WHERE fecha BETWEEN '" + año + "-" + mes + "-" + diaB + " 14:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:00:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(tone);
                        while (rs.next()) {
                            tonelada = rs.getInt("TOTAL");
                            tonelada = tonelada / 1000;
                        }
                         String insert = "INSERT INTO toneladadespachada SET cantidad=" + tonelada;
                         st.execute(insert);
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }

    public void consultaTonelada() {
        String insert;
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int diaB = fecha.get(Calendar.DAY_OF_MONTH);
        mes = mes + 1;
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("TONELADAS");
        String[] arr = new String[1];
        String turno = cbxturno.getSelectedItem().toString();
        if (turno.equals("Turno 1")) {
            diaB = diaB - 1;
            insert = "SELECT cantidad FROM toneladadespachada WHERE fecha BETWEEN '" + año + "-" + mes + "-" + diaB + " 21:00:00' AND '" + año + "-" + mes + "-" + dia + " 05:00:00'";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(insert);
                while (rs.next()) {
                    arr[0] = rs.getString(1);
                    dtm.addRow(arr);
                    tbtonelada.setModel(dtm);
                }
            } catch (SQLException e) {
                System.out.println("turno 1" + e);
            }
        } else {
            if (turno.equals("Turno 2")) {
                insert = "SELECT cantidad FROM toneladadespachada WHERE fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 05:00:00' AND '" + año + "-" + mes + "-" + dia + " 14:00:00'";
                try {
                    Connection con = Conexion.conectar("mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(insert);
                    while (rs.next()) {
                        arr[0] = rs.getString(1);
                        dtm.addRow(arr);
                        tbtonelada.setModel(dtm);
                    }
                } catch (SQLException e) {
                    System.out.println("turno 2" + e);
                }
            } else {
                if (turno.equals("Turno 3")) {
                    insert = "SELECT cantidad FROM toneladadespachada WHERE fecha BETWEEN '" + año + "-" + mes + "-" + dia + " 14:00:00' AND '" + año + "-" + mes + "-" + dia + " 21:00:00'";
                    try {
                        Connection con = Conexion.conectar("mysql");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(insert);
                        while (rs.next()) {
                            arr[0] = rs.getString(1);
                            dtm.addRow(arr);
                            tbtonelada.setModel(dtm);
                        }
                    } catch (SQLException e) {
                        System.out.println("turno 3" + e);
                    }
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxturno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdespacho = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnconsulta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbtonelada = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONSOLIDADO DESPACHOS");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("CONSOLIDADO DESPACHOS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("TURNO");

        cbxturno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbxturno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

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
        jScrollPane1.setViewportView(tbdespacho);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("TONELADAS");

        btnconsulta.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        btnconsulta.setText("CONSULTAR");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });

        tbtonelada.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbtonelada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbtonelada);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
        tonelada();
        consultadespacho();
        consultaTonelada();
    }//GEN-LAST:event_btnconsultaActionPerformed

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
            java.util.logging.Logger.getLogger(TotalDespacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TotalDespacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TotalDespacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TotalDespacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TotalDespacho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsulta;
    private javax.swing.JComboBox<String> cbxturno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbdespacho;
    private javax.swing.JTable tbtonelada;
    // End of variables declaration//GEN-END:variables
}
