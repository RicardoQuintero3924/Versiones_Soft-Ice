package VistasCC;

import java.awt.Image;
import java.awt.Toolkit;


public class menuProduccion extends javax.swing.JFrame {

   
    public menuProduccion() {
        initComponents();
    }
    
    @Override
     public Image getIconImage(){
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jmDespacho = new javax.swing.JMenuItem();
        jmDevoluciones = new javax.swing.JMenuItem();
        jmTraslados = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmProduccion = new javax.swing.JMenuItem();
        jmCavas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MENU DESPACHOS");
        setIconImage(getIconImage());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/logo-Iglu-transparente.png"))); // NOI18N

        jMenu2.setText("DESPACHOS");

        jmDespacho.setText("DESPACHOS");
        jmDespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDespachoActionPerformed(evt);
            }
        });
        jMenu2.add(jmDespacho);

        jmDevoluciones.setText("DEVOLUCIONES");
        jmDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDevolucionesActionPerformed(evt);
            }
        });
        jMenu2.add(jmDevoluciones);

        jmTraslados.setText("TRASLADOS");
        jmTraslados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTrasladosActionPerformed(evt);
            }
        });
        jMenu2.add(jmTraslados);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("PRODUCCION");

        jmProduccion.setText("PRODUCCION ");
        jmProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProduccionActionPerformed(evt);
            }
        });
        jMenu1.add(jmProduccion);

        jmCavas.setText("CAVAS");
        jmCavas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCavasActionPerformed(evt);
            }
        });
        jMenu1.add(jmCavas);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDespachoActionPerformed
        // TODO add your handling code here:
        new Despacho().setVisible(true);
    }//GEN-LAST:event_jmDespachoActionPerformed

    private void jmDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDevolucionesActionPerformed
        // TODO add your handling code here:
        new Devoluciones().setVisible(true);
    }//GEN-LAST:event_jmDevolucionesActionPerformed

    private void jmTrasladosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTrasladosActionPerformed
        // TODO add your handling code here:
        new Traslados().setVisible(true);
    }//GEN-LAST:event_jmTrasladosActionPerformed

    private void jmProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProduccionActionPerformed
        // TODO add your handling code here:
        new PlasticoEnProduccion().setVisible(true);
    }//GEN-LAST:event_jmProduccionActionPerformed

    private void jmCavasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCavasActionPerformed
        // TODO add your handling code here:
        new Cavas().setVisible(true);
    }//GEN-LAST:event_jmCavasActionPerformed
        
  
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
            java.util.logging.Logger.getLogger(menuProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuProduccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmCavas;
    private javax.swing.JMenuItem jmDespacho;
    private javax.swing.JMenuItem jmDevoluciones;
    private javax.swing.JMenuItem jmProduccion;
    private javax.swing.JMenuItem jmTraslados;
    // End of variables declaration//GEN-END:variables
}
