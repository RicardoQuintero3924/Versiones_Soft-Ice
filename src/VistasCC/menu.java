package VistasCC;

import java.awt.Image;
import java.awt.Toolkit;


public class menu extends javax.swing.JFrame {

  
    public menu() {
        initComponents();
        this.setLocation(400,220);
    }
    @Override
     public Image getIconImage(){
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnnotascredito = new javax.swing.JMenuItem();
        mnsobrantes = new javax.swing.JMenuItem();
        mnplasticobodega = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnplasticoproduccion = new javax.swing.JMenuItem();
        mnproduccion = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mndespachos = new javax.swing.JMenuItem();
        mndevoluciones = new javax.swing.JMenuItem();
        mntotaldespacho = new javax.swing.JMenuItem();
        mntotalruta = new javax.swing.JMenuItem();
        jbcremisiones = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jdcalertas = new javax.swing.JMenuItem();
        jdcventas = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jdccavas = new javax.swing.JMenuItem();
        JDCMV = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        JMtraslados = new javax.swing.JMenuItem();
        JmtrasladaRuta = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu9.setText("File");
        jMenuBar3.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar3.add(jMenu10);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MENÚ");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1050, 752));
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/logo-Iglu-transparente.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 0, 900, 710);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenu1.setText("PLASTICO");

        jMenuItem1.setText("PLASTICO BODEGA");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        mnnotascredito.setText("NOTAS CREDITO");
        mnnotascredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnnotascreditoActionPerformed(evt);
            }
        });
        jMenu1.add(mnnotascredito);

        mnsobrantes.setText("SOBRANTES & FALTANTES");
        mnsobrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnsobrantesActionPerformed(evt);
            }
        });
        jMenu1.add(mnsobrantes);

        mnplasticobodega.setText("CONSOLIDADO PLASTICO");
        mnplasticobodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnplasticobodegaActionPerformed(evt);
            }
        });
        jMenu1.add(mnplasticobodega);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("PRODUCCION");

        mnplasticoproduccion.setText("PLASTICO PRODUCCION");
        mnplasticoproduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnplasticoproduccionActionPerformed(evt);
            }
        });
        jMenu2.add(mnplasticoproduccion);

        mnproduccion.setText("PRODUCCION");
        mnproduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnproduccionActionPerformed(evt);
            }
        });
        jMenu2.add(mnproduccion);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("DESPACHOS");

        mndespachos.setText("DESPACHOS");
        mndespachos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mndespachosActionPerformed(evt);
            }
        });
        jMenu3.add(mndespachos);

        mndevoluciones.setText("DEVOLUCIONES");
        mndevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mndevolucionesActionPerformed(evt);
            }
        });
        jMenu3.add(mndevoluciones);

        mntotaldespacho.setText("TOTAL DESPACHOS");
        mntotaldespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntotaldespachoActionPerformed(evt);
            }
        });
        jMenu3.add(mntotaldespacho);

        mntotalruta.setText("TOTAL POR RUTA");
        mntotalruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntotalrutaActionPerformed(evt);
            }
        });
        jMenu3.add(mntotalruta);

        jMenuBar1.add(jMenu3);

        jbcremisiones.setText("INFORMES");
        jbcremisiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcremisionesActionPerformed(evt);
            }
        });

        jMenuItem2.setText("REMISIONES");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jbcremisiones.add(jMenuItem2);

        jdcalertas.setText("ALERTAS");
        jdcalertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdcalertasActionPerformed(evt);
            }
        });
        jbcremisiones.add(jdcalertas);

        jdcventas.setText("VENTAS");
        jdcventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdcventasActionPerformed(evt);
            }
        });
        jbcremisiones.add(jdcventas);

        jMenuItem3.setText("RESUMEN FACTURACION");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jbcremisiones.add(jMenuItem3);

        jdccavas.setText("CAVAS");
        jdccavas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdccavasActionPerformed(evt);
            }
        });
        jbcremisiones.add(jdccavas);

        JDCMV.setText("CMV");
        JDCMV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDCMVActionPerformed(evt);
            }
        });
        jbcremisiones.add(JDCMV);

        jMenuBar1.add(jbcremisiones);

        jMenu6.setText("TRASLADOS");

        JMtraslados.setText("TRASLADOS");
        JMtraslados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMtrasladosActionPerformed(evt);
            }
        });
        jMenu6.add(JMtraslados);

        JmtrasladaRuta.setText("TRASLADOS  A RUTAS");
        JmtrasladaRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmtrasladaRutaActionPerformed(evt);
            }
        });
        jMenu6.add(JmtrasladaRuta);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        new PlasticoProveedorTraslado().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnplasticobodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnplasticobodegaActionPerformed
        
       new ConsultaPlastico().setVisible(true);
    }//GEN-LAST:event_mnplasticobodegaActionPerformed

    private void mnsobrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnsobrantesActionPerformed
        
        new SobrantesFaltantes().setVisible(true);
    }//GEN-LAST:event_mnsobrantesActionPerformed

    private void mnnotascreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnnotascreditoActionPerformed
        
         new NotaCredito().setVisible(true);
    }//GEN-LAST:event_mnnotascreditoActionPerformed

    private void mnplasticoproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnplasticoproduccionActionPerformed
        
        new PlasticoEnProduccion().setVisible(true);
    }//GEN-LAST:event_mnplasticoproduccionActionPerformed

    private void mnproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnproduccionActionPerformed
        
        new Produccion().setVisible(true);
    }//GEN-LAST:event_mnproduccionActionPerformed

    private void mndespachosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mndespachosActionPerformed
        
        new Despacho().setVisible(true);
    }//GEN-LAST:event_mndespachosActionPerformed

    private void mndevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mndevolucionesActionPerformed
        
        new Devoluciones().setVisible(true);
    }//GEN-LAST:event_mndevolucionesActionPerformed

    private void mntotaldespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntotaldespachoActionPerformed
        
        new TotalDespacho().setVisible(true);
    }//GEN-LAST:event_mntotaldespachoActionPerformed

    private void mntotalrutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntotalrutaActionPerformed
        
        new TotalPorRuta().setVisible(true);
    }//GEN-LAST:event_mntotalrutaActionPerformed

    private void jbcremisionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcremisionesActionPerformed
        
        new remisiones().setVisible(true);
    }//GEN-LAST:event_jbcremisionesActionPerformed

    private void jdcalertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdcalertasActionPerformed
        
        new alertas().setVisible(true);
    }//GEN-LAST:event_jdcalertasActionPerformed

    private void jdcventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdcventasActionPerformed
        
        new Ventas().setVisible(true);
    }//GEN-LAST:event_jdcventasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        new ResumenFacturacion().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jdccavasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdccavasActionPerformed
        
        new Cavas().setVisible(true);
    }//GEN-LAST:event_jdccavasActionPerformed

    private void JDCMVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDCMVActionPerformed
                new CMV().setVisible(true);
    }//GEN-LAST:event_JDCMVActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        new remisiones().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void JMtrasladosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMtrasladosActionPerformed
        // TODO add your handling code here:
        new Traslados().setVisible(true);
    }//GEN-LAST:event_JMtrasladosActionPerformed

    private void JmtrasladaRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmtrasladaRutaActionPerformed
        // TODO add your handling code here:
        new TrasladosRuta().setVisible(true);
    }//GEN-LAST:event_JmtrasladaRutaActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JDCMV;
    private javax.swing.JMenuItem JMtraslados;
    private javax.swing.JMenuItem JmtrasladaRuta;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu jbcremisiones;
    private javax.swing.JMenuItem jdcalertas;
    private javax.swing.JMenuItem jdccavas;
    private javax.swing.JMenuItem jdcventas;
    private javax.swing.JMenuItem mndespachos;
    private javax.swing.JMenuItem mndevoluciones;
    private javax.swing.JMenuItem mnnotascredito;
    private javax.swing.JMenuItem mnplasticobodega;
    private javax.swing.JMenuItem mnplasticoproduccion;
    private javax.swing.JMenuItem mnproduccion;
    private javax.swing.JMenuItem mnsobrantes;
    private javax.swing.JMenuItem mntotaldespacho;
    private javax.swing.JMenuItem mntotalruta;
    // End of variables declaration//GEN-END:variables
}
