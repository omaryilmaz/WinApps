 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBCon {
    private Connection koneksi;

    public Connection connect(){
     
       try{
           Class.forName("org.sqlite.JDBC");
           JOptionPane.showMessageDialog(null, "Successfully load driver");
       }catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null, "Error Driver!\n" + ex);
       }

       //for connection to database
       try{
           //String url="jdbc:sqlite:db/muhammed";
           String url="jdbc:sqlite:OmarDB.db";
         
           koneksi=DriverManager.getConnection(url);
           System.out.println("Connection successful");
       }catch(SQLException se){
           System.out.println("Connection failure "+se);
           JOptionPane.showMessageDialog(null,"Database Connection Failed "," Warning",JOptionPane.WARNING_MESSAGE);
       }
       return koneksi;
    }
}
//           String url="jdbc:sqlite:C:\\IraqJavaWorkSpace\\OmarDBExam\\OmarDB";
      