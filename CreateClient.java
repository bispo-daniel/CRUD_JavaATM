import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CreateClient {
    static void createClientFunction(){
        String idString = JOptionPane.showInputDialog(null, "Type your preferred client id");
            int id = Integer.parseInt(idString);
        String name = JOptionPane.showInputDialog(null, "Type your name");

        try {
            String sql = "INSERT INTO customer (id, name) VALUES (?, ?)";
            PreparedStatement stt = Connect.connection.prepareStatement(sql);

            stt.setInt(1, id);
            stt.setString(2, name);
            int res = stt.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null, String.format("Customer [%d] %s successfully created!", id, name));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Main.landingPage();
    }
}
