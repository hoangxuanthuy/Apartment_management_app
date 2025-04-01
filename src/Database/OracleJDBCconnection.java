      package Database;
        import java.sql.Connection;
        import java.sql.DatabaseMetaData;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.logging.Level;
        import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class OracleJDBCconnection {
	public static Connection getJDBCconnection() {
		try {
			// Dang ky MySQL Driver voi DriverManager
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Cac thong so
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String userName = "QLCHUNGCU";
			String password = "password";
			//Tao ket noi 
			return DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu !","Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
                            c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void printInfo(Connection c) {
		try {
			if (c != null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        }
     public static void main(String[] args) {
         
         Connection c = OracleJDBCconnection.getJDBCconnection();
          // Tắt auto-commit
      
            try {
               Statement statement = c.createStatement();
               if (statement != null){
                   System.out.print(1);}
            } catch (SQLException ex) {
                Logger.getLogger(OracleJDBCconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
         
   
         }
   }
