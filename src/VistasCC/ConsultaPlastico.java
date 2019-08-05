package VistasCC;

import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class ConsultaPlastico extends javax.swing.JFrame {

    int cantidadT = 0;
    int total = 0;
    int entrasale = 0;
    int entrada = 0;
    int salida = 0;
    int contCon = 0;
    int contTot = 0;
    public ConsultaPlastico() {
        initComponents();
        activarBoton();
        Cargabd();
    }
    @Override
   public Image getIconImage(){
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
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

    public void ConsultaTotal() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CANTIDAD TOTAL");

        tbcantidad.setModel(model);

        String[] suma = new String[1];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet sr = st.executeQuery("SELECT cantidad FROM consolidadoplas WHERE  referencia = '" + cbxreferencia.getSelectedItem().toString() + "' AND fecha BETWEEN '" + Desde.getText() + "' AND '" + Hasta.getText() + "'");
            while (sr.next()) {

                suma[0] = sr.getString(1);
                model.addRow(suma);
                tbcantidad.setModel(model);
            }

        } catch (Exception e) {
        }

    }

    public void Consulta(String Text) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("FECHA");
        modelo.addColumn("TIPO MOVIMIENTO");
        modelo.addColumn("PROVIENE DE");
        modelo.addColumn("CANTIDAD");
        
        tbconsulta.setModel(modelo);
        String[] datos = new String[4];
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT fecha,tipomovimiento,provienede,cantidad FROM plasticobodegapt WHERE  referenciaP = '" + cbxreferencia.getSelectedItem().toString() + "' AND fecha BETWEEN  '" + Desde.getText() + "' AND '" + Hasta.getText() + "'");

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                //datos[4] =rs.getString(5);
                //datos[5] =rs.getString(6);
                modelo.addRow(datos);

            }

            tbconsulta.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +ex);

        }

    }

    public void ConsultaSobra() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("MOTIVO");
        dtm.addColumn("CANTIDAD");
        String[] cant = new String[3];
        String consul = "SELECT referencia,motivo,faltante FROM sobrantes_faltantes WHERE fechasf BETWEEN '" + Desde.getText() + "' AND '" + Hasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cant[0] = rs.getString(1);
                cant[1] = rs.getString(2);
                cant[2] = rs.getString(3);
                dtm.addRow(cant);
                tbsobrafalta.setModel(dtm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
    }

    public void ConsultaNotas() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("CANTIDAD");
        String[] can = new String[2];
        String consul = "SELECT referencia,cantidad FROM notascredito WHERE fecha BETWEEN '" + Desde.getText() + "' AND '" + Hasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                can[0] = rs.getString(1);
                can[1] = rs.getString(2);
                dtm.addRow(can);
                tbnotac.setModel(dtm);
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
    }

    public void Operaciones() {

        int sobrante = 0;
        int faltante = 0;
        int notaCAbierta = 0;

        String entra = "SELECT cantidad FROM entraplas WHERE referencia = '" + cbxreferencia.getSelectedItem() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(entra);
            while (rs.next()) {
                entrada = rs.getInt("cantidad");
                System.out.println("entrada " + entrada);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        
        
        String Sale = "SELECT cantidad  FROM plasticobodegapt WHERE referenciaP = '" + cbxreferencia.getSelectedItem() + "' AND tipomovimiento = 'SALIDA' AND fecha BETWEEN '" + Desde.getText() + "' AND '" + Hasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Sale);
            while (rs.next()) {
                salida = rs.getInt("cantidad");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        
        String sobra = "SELECT faltante FROM sobrantes_faltantes WHERE motivo = 'SOBRANTE' AND referencia= '" + cbxreferencia.getSelectedItem() + "' AND fechasf BETWEEN '" + Desde.getText() + "' AND '" + Hasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sobra);
            while (rs.next()) {
                sobrante = rs.getInt("faltante");
            }
        } catch (SQLException e) {
        }
        String falta = "SELECT faltante FROM sobrantes_faltantes WHERE motivo = 'FALTANTE' AND referencia= '" + cbxreferencia.getSelectedItem() + "' AND fechasf BETWEEN '" + Desde.getText() + "' AND '" + Hasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(falta);
            while (rs.next()) {
                faltante = rs.getInt("faltante");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        String notacre = "SELECT cantidad FROM notascredito WHERE referencia= '" + cbxreferencia.getSelectedItem() + "' AND abierta_cerrada= 'ACTIVA' AND fecha BETWEEN '" + Desde.getText() + "' AND '" + Hasta.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(notacre);
            while (rs.next()) {
                notaCAbierta = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }

        entrasale = entrada - salida;
        System.out.println("entrada " + entrada + " entrasale " + entrasale + " salida " + salida);
        if (sobrante > 0) {
            entrasale = entrasale + sobrante;
        } else {
            if (faltante > 0) {
                entrasale = entrasale - faltante;
            }
        }
        if (notaCAbierta > 0) {
            entrasale = entrasale - notaCAbierta;

        }
        if (entrasale > 0) {
            String InsertarTotal = "INSERT INTO consolidadoplas SET referencia = '" + cbxreferencia.getSelectedItem() + "', cantidad = " + entrasale;
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                st.executeUpdate(InsertarTotal);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
            }
        } else {
            JOptionPane.showMessageDialog(null,"POR FAVOR INGRESE VALORES ANTES DE TOTALIZAR");
        }

    }//fin del metodo operaciones

    public void actualizarEntraplas() {
        int entraplas;
        String refe = cbxreferencia.getSelectedItem().toString();
        entraplas = entrada - salida;
        String actua = "UPDATE entraplas SET cantidad = " + entraplas + " WHERE referencia = '" + refe + "'";
       
        
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            st.execute(actua);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxreferencia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbconsulta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnconsulta = new javax.swing.JButton();
        Desde = new javax.swing.JTextField();
        Hasta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbcantidad = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbsobrafalta = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbnotac = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btntotal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSOLIDADO PLASTICO");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("CONSOLIDADO PLASTICO");

        cbxreferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        cbxreferencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxreferenciaItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("REFERENCIA");

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("DESDE");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("HASTA");

        btnconsulta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnconsulta.setText("CONSULTAR");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });

        Desde.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Desde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesdeActionPerformed(evt);
            }
        });

        Hasta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Hasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HastaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("aaaa-mm-dd");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("aaaa-mm-dd");

        tbcantidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbcantidad);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("BODEGA PLASTICO");

        tbsobrafalta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbsobrafalta);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("SOBRANTES & FALTANTES");

        tbnotac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbnotac);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("NOTAS CREDITO");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setText("TOTAL");

        btntotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btntotal.setText("TOTAL");
        btntotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(374, 374, 374))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(Desde, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(602, 602, 602))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(btntotal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(48, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntotal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Desde, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void activarBoton() {
        
       
    }

    public void menoresCero() {//editar con porcentaje, para que salga con un JOptionPane el mensaje de alerta
        Calendar fecha = new GregorianCalendar();
        int saldo = 0;
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int diaB = fecha.get(Calendar.DAY_OF_MONTH);
        String refe = cbxreferencia.getSelectedItem().toString();
        diaB = diaB - 1;
        mes = mes + 1;
        String cero = "SELECT cantidad FROM entraplas WHERE referencia = '" + cbxreferencia.getSelectedItem() + "' AND  fecha BETWEEN '" + año + "-" + mes + "-" + diaB + "' AND '" + año + "-" + mes + "-" + dia + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(cero);
            while (rs.next()) {
                saldo = rs.getInt("cantidad");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR Soft-Ice: " +e);
        }
        if (saldo <= 15000) {
            JOptionPane.showMessageDialog(null, "DE LA REFERENCIA " + refe + " LE QUEDAN POCAS UNIDADES");
        } else {

            if (saldo <= 10000) {
               
                JOptionPane.showMessageDialog(null, "DE LA REFERENCIA " + refe + "  LE QUEDAN POCAS UNIDADES");
            } else {
                if (saldo <= 5000) {
                   
                    JOptionPane.showMessageDialog(null, "DE LA REFERENCIA " + refe + " POR FAVOR COMUNIQUESE CON SU PROVEEDOR");
                }
            }
        }
    }
    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
        
        this.Consulta(Desde.getText());
        this.Consulta(Hasta.getText());
        this.Consulta(cbxreferencia.getSelectedItem().toString());

        ConsultaSobra();
        ConsultaNotas();

        
         contCon = cbxreferencia.getSelectedIndex();
       
        if(contCon != contCon){
            JOptionPane.showMessageDialog(null,"POR FAVOR CAMBIE DE REFERENCIA PARA TOTALIZAR");
        }else{
           btntotal.setEnabled(true); 
        }
    }//GEN-LAST:event_btnconsultaActionPerformed

    private void cbxreferenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxreferenciaItemStateChanged

    }//GEN-LAST:event_cbxreferenciaItemStateChanged

    private void HastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HastaActionPerformed

    private void DesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DesdeActionPerformed

    private void btntotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalActionPerformed

         contTot= cbxreferencia.getSelectedIndex();
        if(contCon == contTot){ 
            Operaciones();
            actualizarEntraplas();
            ConsultaTotal();
            btntotal.setEnabled(false);
        }else{   
                btntotal.setEnabled(true);
                   
        }
        
        //Operaciones();
        //actualizarEntraplas();
        //ConsultaTotal();
        //btntotal.setEnabled(false);
        

    }//GEN-LAST:event_btntotalActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaPlastico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaPlastico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaPlastico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaPlastico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaPlastico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Desde;
    private javax.swing.JTextField Hasta;
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btntotal;
    private javax.swing.JComboBox<String> cbxreferencia;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbcantidad;
    private javax.swing.JTable tbconsulta;
    private javax.swing.JTable tbnotac;
    private javax.swing.JTable tbsobrafalta;
    // End of variables declaration//GEN-END:variables
}
