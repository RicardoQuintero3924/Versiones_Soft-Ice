package VistasCC;

import Beans.BeansDespachos;
import Beans.BeansTrasladoRuta;
import DAO.DAOTrasladosRuta;
import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class TrasladosRuta extends javax.swing.JFrame {

   
    public TrasladosRuta() {
        initComponents();
        CargarRuta();
        CargarRuta2();
        CargaRefe();
    }
     @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
    }
    public void Conecta(String sql){
          try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR SOFT-ICE: "+ e);
        }
    }
    public void CargarRuta() {
        String ruta = "SELECT codigo,nombre FROM rutasm";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(ruta);
            while (rs.next()) {
                cbxorigen.addItem(rs.getString(1).concat(".").concat(rs.getString(2)));
               
            }
        } catch (SQLException e) {
        }

    }
    public void CargarRuta2() {
        String ruta = "SELECT codigo,nombre FROM rutasm";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(ruta);
            while (rs.next()) {
                cbxdestino.addItem(rs.getString(1).concat(".").concat(rs.getString(2)));
               
            }
        } catch (SQLException e) {
        }

    }
    public void CargaRefe() {
        //METODO PARA CARGAR LAS REFERENCIAS DE LA BASE DE DATOS
        String sql = "SELECT nombre FROM referencias ";
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
    public void inserta(){
        // METODO PARA REGISTRAR LOS MOVIMIENTOS DE LOS TRASLADOS
        String origen = cbxorigen.getSelectedItem().toString();
        String destino = cbxdestino.getSelectedItem().toString();
        String referencia = cbxreferencia.getSelectedItem().toString();
        String cantidad = txtcantidad.getText();
        String fecha = txtfecha.getText();
        String observaciones = txtobservaciones.getText();
        
        BeansTrasladoRuta btr = new BeansTrasladoRuta();
        btr.setOrigen(origen);
        btr.setDestino(destino);
        btr.setReferencia(referencia);
        btr.setCantidad(cantidad);
        btr.setFecha(fecha);
        btr.setObservaciones(observaciones);
        
        DAOTrasladosRuta dtr = new DAOTrasladosRuta();
        dtr.inserta(btr);
        JOptionPane.showMessageDialog(null,"TRASLADO GENERADO CON EXITO");
        cbxorigen.setSelectedItem("");
        cbxdestino.setSelectedItem("");
        cbxreferencia.setSelectedItem("");
        txtcantidad.setText("");
        txtfecha.setText("");
        txtobservaciones.setText("");
    }
    public void verificaFecha(){
        String refer = "";
        String referencia= cbxreferencia.getSelectedItem().toString();
        String fech = "SELECT referencia FROM despachos WHERE nroruta= '"+cbxorigen.getSelectedItem()+"' AND fecha LIKE '%"+txtfecha.getText()+"%'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(fech);
            while(rs.next()){
                refer = rs.getString("referencia");
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
       
        if(refer.equals(referencia)){
            afectaOrigenDespacho();
            afectaDestinoDespacho();
            inserta();
        }else{
            JOptionPane.showMessageDialog(null,"LA REFERENCIA HA TRASLADAR NO COINCIDE");
        }
    
    }
    public void afectaOrigenDespacho(){
        String can = txtcantidad.getText();
        int cantidad = Integer.parseInt(can);
        String sql = "UPDATE despachos SET cantidad = cantidad - '"+cantidad+"', fecha = fecha WHERE referencia = '"+cbxreferencia.getSelectedItem()+"' AND nroruta LIKE '%"+cbxorigen.getSelectedItem()+"' AND fecha LIKE '%"+txtfecha.getText()+"%'";
        Conecta(sql);
           }
    public void ConsultaRutaCargo(){
        //este metodo consulta si la ruta cargo el dia en que se hizo el traslado entre rutas
        String ruta ="SELECT cantidad FROM despachos WHERE nroruta= '"+cbxdestino.getSelectedItem()+"' AND fecha LIKE '%"+txtfecha.getText()+"%'";
       int cant = 0;
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(ruta);
            while(rs.next()){
                 cant = rs.getInt("cantidad");
    
            }
            if(cant == 0){
                insertaTraslado();   
            }
        } catch (SQLException e) {
             System.out.println(e);
        }

    
    }
    public void insertaTraslado(){
        String can = txtcantidad.getText();
        int cantidad = Integer.parseInt(can);
        String Insert = "INSERT INTO despachos SET"
                      + " turno = 'TRASLADO',"
                      + " nroruta='"+cbxdestino.getSelectedItem()+"',"
                      + " referencia='"+cbxreferencia.getSelectedItem()+"',"
                      + " despachado_por='"+cbxorigen.getSelectedItem()+"',"
                      + " cantidad ='"+cantidad+"',"
                      + " lote= 'N/A',"
                      + " fecha= '"+txtfecha.getText()+"',"
                      + " planilla = '1'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(Insert);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void afectaDestinoDespacho(){
        String can = txtcantidad.getText();
        int cantidad = Integer.parseInt(can);
        String cand ="UPDATE despachos SET cantidad = cantidad + '"+cantidad+"', fecha = fecha WHERE referencia = '"+cbxreferencia.getSelectedItem()+"' AND nroruta LIKE '%"+cbxdestino.getSelectedItem()+"' AND fecha LIKE '%"+txtfecha.getText()+"%'";
        Conecta(cand);
        ConsultaRutaCargo();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtobservaciones = new javax.swing.JTextArea();
        cbxorigen = new javax.swing.JComboBox<>();
        cbxdestino = new javax.swing.JComboBox<>();
        cbxreferencia = new javax.swing.JComboBox<>();
        txtcantidad = new javax.swing.JTextField();
        btngenerar = new javax.swing.JButton();
        btnconsulta = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TRASLADOS RUTAS");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("TRASLADOS RUTAS");

        jLabel2.setText("ORIGEN:");

        jLabel3.setText("DESTINO:");

        jLabel4.setText("REFERENCIA:");

        jLabel5.setText("CANTIDAD:");

        jLabel6.setText("OBSERVACIONES:");

        txtobservaciones.setColumns(20);
        txtobservaciones.setRows(5);
        jScrollPane1.setViewportView(txtobservaciones);

        cbxorigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        cbxdestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        cbxreferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        btngenerar.setText("GENERAR");
        btngenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenerarActionPerformed(evt);
            }
        });

        btnconsulta.setText("CONSULTAR");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });

        btncancelar.setText("CANCELAR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel7.setText("FECHA: (yyyy-MM-dd)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(163, 163, 163))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(217, 217, 217))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxorigen, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(147, 147, 147)
                                .addComponent(cbxdestino, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(147, 147, 147)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtfecha)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(txtcantidad)))))
                        .addContainerGap(72, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(btngenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnconsulta)
                .addGap(64, 64, 64)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxorigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxdestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngenerar)
                    .addComponent(btnconsulta)
                    .addComponent(btncancelar))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
        // TODO add your handling code here:
        new ConsultaTraslado().setVisible(true);
    }//GEN-LAST:event_btnconsultaActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btngenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenerarActionPerformed
          
        verificaFecha();
        ConsultaRutaCargo();
    }//GEN-LAST:event_btngenerarActionPerformed

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
            java.util.logging.Logger.getLogger(TrasladosRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrasladosRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrasladosRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrasladosRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrasladosRuta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btngenerar;
    private javax.swing.JComboBox<String> cbxdestino;
    private javax.swing.JComboBox<String> cbxorigen;
    private javax.swing.JComboBox<String> cbxreferencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextArea txtobservaciones;
    // End of variables declaration//GEN-END:variables
}
