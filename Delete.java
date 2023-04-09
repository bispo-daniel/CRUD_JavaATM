import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Delete {
    static void delete(String tableName){
        String text = "Type your %s's number";
        String numberString = JOptionPane.showInputDialog(null, String.format(text, tableName));
        int number = Integer.parseInt(numberString);

        try {
            String sql = "DELETE FROM %s WHERE id = ?";
            String formatedSql = String.format(sql, tableName);

            //Create a confirm deletion with your account's password
            PreparedStatement stt = Connect.connection.prepareStatement(formatedSql);
            stt.setInt(1, number);
            int response = stt.executeUpdate();
            
            if(response > 0){
                String dialog = "%s %d successfully deleted!";
                JOptionPane.showMessageDialog(null, String.format(dialog, tableName, number));
            }
        } catch (SQLException e){
            if(e.getErrorCode() == 1451){
                JOptionPane.showMessageDialog(null, "You must delete this customer's accounts first");
            } else {
                e.printStackTrace();
            }
        }

        Main.landingPage();
    }
}