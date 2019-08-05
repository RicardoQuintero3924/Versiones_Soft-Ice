package VistasCC;

import Utils.Conexion;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class Ventas extends javax.swing.JFrame {

   
    public Ventas() {
        initComponents();
    }
    public void comparaVenta(){
        
    }
    @Override
     public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagen/iglu.png"));
        return retValue;
    }
    public void carga1(){
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("RUTA");
        dtm.addColumn("FECHA VENTA");
        dtm.addColumn("CANTIDAD");
        dtm.addColumn("REFERENCIA");
        dtm.addColumn("IDENTIFICACION");
        dtm.addColumn("RAZON SOCIAL");
        dtm.addColumn("TIPO DOCUMENTO");
        mes = mes + 1;
        tbventa.setModel(dtm);
        String ingre= "SELECT Ruta,Fecha,Cantidad,Producto,Identificacion,Razon_social,Tipo_Documento FROM venta WHERE fecha LIKE '%"+mes+"-"+dia+"%'";
        try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(ingre);
                String [] ven = new String[7];
                while(rs.next()){
                   ven[0]= rs.getString(1);
                   ven[1]= rs.getString(2);
                   ven[2]= rs.getString(3);
                   ven[3]= rs.getString(4);
                   ven[4]= rs.getString(5);
                   ven[5]= rs.getString(6);
                   ven[6]= rs.getString(7);
                   dtm.addRow(ven);
                }
                
            } catch (SQLException e) {
                System.out.println(e);
            }
    }
    public void carga(){
        String ingre = "LOAD DATA INFILE '"+ texto.getText() 
                + "' INTO TABLE venta "
                + "FIELDS TERMINATED BY ';' "
                + "LINES TERMINATED BY '\r\n' "
                + "IGNORE 7 LINES"
                + "(Ruta,Identificacion,Razon_social,Fecha,Tipo_Documento,Cantidad,Producto)";
            try {
                Connection con = Conexion.conectar("mysql");
                Statement st = con.createStatement();
                st.execute(ingre);
                JOptionPane.showMessageDialog(null, "IMPORTADO CON EXITO");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR AL CARGAR"+e);
            }
    }
    public String cargarDatos() throws FileNotFoundException, IOException{
        String aux = "";
        String texto = "";
        try {
        JFileChooser carga = new JFileChooser();
        carga.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.xlsx","xlsx");
        carga.setFileFilter(filtro);
        int retorna = carga.showOpenDialog(Ventas.this);
     
            File guarda = carga.getSelectedFile();
            if(guarda != null){
               FileReader archivo = new FileReader(guarda); 
               BufferedReader lee = new BufferedReader(archivo);
               while((aux=lee.readLine())!= null){
                   
                   texto = aux + "/n";
                  System.out.println("ruta "+ texto);
                  //carga1(texto);
               }
               lee.close();
            }
        
        } catch (HeadlessException | FileNotFoundException e) {
        
          
    }
        return texto;
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnimportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbventa = new javax.swing.JTable();
        texto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VENTAS");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("VENTAS");

        btnimportar.setText("IMPORTAR");
        btnimportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimportarActionPerformed(evt);
            }
        });

        tbventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbventa);

        texto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnimportar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(423, 423, 423))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnimportar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnimportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimportarActionPerformed
       carga();
       carga1();
    }//GEN-LAST:event_btnimportarActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbventa;
    private javax.swing.JTextField texto;
    // End of variables declaration//GEN-END:variables
}
