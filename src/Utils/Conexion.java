package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
     public static Connection conectar(String db) {
    Connection con = null;
    try {
      /*  if ( db.compareTo("oracle") == 0)
          {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@alfa10:1521:Oracle", "corozal", "finca");
            con.setAutoCommit(true);
          }
        else{
             if (db.compareTo("db2") == 0)
               {
                 Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
                 con = DriverManager.getConnection("jdbc:db2:PORCINOS"); //remplazar ips por el nombre de la db
                 con.setAutoCommit(true);
              }
              else
              {*/
      if (db.compareTo("mysql") == 0) {
        String conexion = "";
        /*  try{
            File archivoConexion = new File("D:/conexion.txt");
            RandomAccessFile ff = new RandomAccessFile(archivoConexion, "r");
            if(archivoConexion.exists())
            {
              conexion = ff.readLine();
            }
            ff.close();
            System.out.print(conexion);
          }ca tch(Exception e){
            System.out.println(e);
          }*/
        
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost/iglu","root","");
                // con = DriverManager.getConnection("jdbc:mysql://192.168.1.20/visionsoft","root","");
          //                      "jdbc:mysql://192.168.77.108/test","192.168.77.112","");
          con.setAutoCommit(true);
        }

      //  }
      // } 
    }
    catch (ClassNotFoundException cnfe) {
        System.out.println(
                cnfe.getMessage() + "Error En El Controlador, No Se Ha Podido Establecer La Conexi�n con la Base De Datos. Clase Conexion");
    }
    catch (SQLException sqle) {
     
        sqle.printStackTrace();
        //System.out.println(
          //sqle.getMessage() + "  ErrorSQL Problemas en la Ejecucion de Alguna Cla�sula SQL. . Clase Conexion");
    }
    catch (Exception e) {
        System.out.println(
                e.getMessage() + "Ha Ocurrido Una Excepci�n. Clase Conexi�n");
    }
    return con;
  }

  public void desconectar(Connection con) {
    try {
      con.close();
    }
    catch (SQLException ex) {}
  }

    
}
