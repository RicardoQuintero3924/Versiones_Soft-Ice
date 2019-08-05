package VistasCC;

import Utils.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class usuarios extends javax.swing.JFrame {

    public usuarios() {
        initComponents();
        this.setLocation(400, 220);
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
        txtusuarios = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jpcontraseña = new javax.swing.JPasswordField();
        btningresar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INGRESO");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("INGRESO");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("USUARIO");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("CLAVE");

        btningresar.setText("INGRESAR");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btningresar)
                        .addGap(73, 73, 73)
                        .addComponent(btncancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(txtusuarios)
                        .addComponent(jpcontraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btningresar)
                    .addComponent(btncancelar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void usuario1() {
        char passArray[] = jpcontraseña.getPassword();
        for (int i = 0; i < passArray.length; i++) {
            char c = passArray[i];
        }
        String pass = new String(passArray);
        String nom = "";
        String user = txtusuarios.getText();
        String passw = "";
        String consulta = "SELECT nombre,contraseña FROM usuarios WHERE nivus = 1";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                nom = rs.getString("nombre");
                //niv = rs.getInt("nivus");
                passw = rs.getString("contraseña");
                //System.out.println(" "+nom+" "+pass+" ");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (user.equals(nom) && (pass.equals(passw))) {
            JOptionPane.showMessageDialog(null, "BIENVENIDO");
            new menu().setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(null, "ERROR...POR FAVOR VERIFIQUE SUS DATOS");
        }
    }//fin del metodo usuario1

    public void usuario2() {
        char passArray[] = jpcontraseña.getPassword();
        for (int i = 0; i < passArray.length; i++) {
            char c = passArray[i];
        }

        String nom2 = "";
        String user = txtusuarios.getText();
        String consulta1 = "SELECT nombre,contraseña FROM usuarios WHERE nivus = 2";
        String passw2 = "";
        String pass = new String(passArray);
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta1);
            while (rs.next()) {
                nom2 = rs.getString("nombre");
                //niv = rs.getInt("nivus");
                passw2 = rs.getString("contraseña");
                //System.out.println(" "+niv+" "+nom+" "+pass+" ");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        if (user.equals(nom2) && passw2.equals(pass)) {
            JOptionPane.showMessageDialog(null, "BIENVENIDO");
            new menuP().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR...INGRESE LOS DATOS NUEVAMENTE");
        }

    }//fin metodo usuario2

    public void usuario3() {
        char passArray[] = jpcontraseña.getPassword();
        for (int i = 0; i < passArray.length; i++) {
            char c = passArray[i];
        }

        String nom2 = "";
        String user = txtusuarios.getText();
        String consulta1 = "SELECT nombre,contraseña FROM usuarios WHERE nivus = 3";
        String passw2 = "";
        String pass = new String(passArray);
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta1);
            while (rs.next()) {
                nom2 = rs.getString("nombre");
                //niv = rs.getInt("nivus");
                passw2 = rs.getString("contraseña");
                //System.out.println(" "+niv+" "+nom+" "+pass+" ");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        if (user.equals(nom2) && passw2.equals(pass)) {
            JOptionPane.showMessageDialog(null, "BIENVENIDO");
            new menuBP().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR...INGRESE LOS DATOS NUEVAMENTE");
        }
    }//Fin Usuario 3

    public void usuario4() {
        char passArray[] = jpcontraseña.getPassword();
        for (int i = 0; i < passArray.length; i++) {
            char c = passArray[i];
        }

        String nom2 = "";
        String user = txtusuarios.getText();
        String consulta1 = "SELECT nombre,contraseña FROM usuarios WHERE nivus = 4";
        String passw2 = "";
        String pass = new String(passArray);
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta1);
            while (rs.next()) {
                nom2 = rs.getString("nombre");
                //niv = rs.getInt("nivus");
                passw2 = rs.getString("contraseña");
                //System.out.println(" "+niv+" "+nom+" "+pass+" ");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        if (user.equals(nom2) && passw2.equals(pass)) {
            JOptionPane.showMessageDialog(null, "BIENVENIDO");
            new menuProduccion().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR...INGRESE LOS DATOS NUEVAMENTE");
        }
    }

    public void validaUsuario() {
        char passArray[] = jpcontraseña.getPassword();
        for (int i = 0; i < passArray.length; i++) {
            char c = passArray[i];
        }
        String pass = new String(passArray);
        int cont = 0;
        int niv = 0;
        String sql = "SELECT nivus FROM usuarios WHERE nombre = '" + txtusuarios.getText() + "'";
        try {
            Connection con = Conexion.conectar("mysql");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                niv = rs.getInt("nivus");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        while (cont != 1) {
            if (niv == 1) {
                usuario1();
                cont = 1;
            } else {
                if (niv == 2) {
                    usuario2();
                    cont = 1;
                } else {
                    if (niv == 3) {
                        usuario3();
                        cont = 1;
                    } else {
                        if (niv == 4) {
                            usuario4();
                            cont = 1;
                        }
                    }
                }
            }
        }

    }
    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        // TODO add your handling code here:

        if (txtusuarios.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "POR FAVOR INGRESAR EL USUARIO Y LA CLAVE");
        }
        validaUsuario();


    }//GEN-LAST:event_btningresarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btncancelarActionPerformed

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
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btningresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jpcontraseña;
    private javax.swing.JTextField txtusuarios;
    // End of variables declaration//GEN-END:variables
}
