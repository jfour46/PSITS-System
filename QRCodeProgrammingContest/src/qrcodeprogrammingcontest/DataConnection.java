
package qrcodeprogrammingcontest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataConnection {
    static Connection con = null;
    

    public static Connection connectDb(){
       try {
            String drive = "com.mysql.cj.jdbc.Driver";
            Class.forName(drive);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jeffdb?useSSL=false","root","jefferson12345");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       return con;
      
    }
    public static Connection getConnection(){
        try
        {
            if(con == null || con.isClosed()){
                con = connectDb();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return con;
    }
    
}
