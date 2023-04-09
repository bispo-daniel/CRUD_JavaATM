import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connect {
    static String dbUrl = "jdbc:mysql://localhost:3306/atmDB";
    static String user = "root";
    static String pass = "1234";
    static Connection connection;

    static void getConnection(){
        try {

            connection = DriverManager.getConnection(dbUrl, user, pass);

            if(connection != null){
                JOptionPane.showMessageDialog(null, "Database has been connected!");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
