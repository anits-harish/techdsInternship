
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class postgreIN {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://database-1.ch1h6wz99vww.ap-south-1.rds.amazonaws.com:5432/test_1";
        String user = "postgres";
        String password = "vYRJZuo65qe01ogHcHwz";

        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Student")) {

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(postgreIN.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}