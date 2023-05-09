import javax.swing.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UpdateAccount {

    static void update(int accountNumber, String column, String newValue) {
        try {
            String sql = "UPDATE account SET %s = ? WHERE id = %d";
            String formatedSQL = String.format(sql, column, accountNumber);

            PreparedStatement stt = Connect.connection.prepareStatement(formatedSQL);
            
            if(column == "id"){
                int newValueInt = Integer.parseInt(newValue);
                stt.setInt(1, newValueInt);
                Main.accountNumber = newValueInt;
            } else {
                stt.setString(1, newValue);
            }

            int response = stt.executeUpdate();
            if(response > 0){
                String dialog = "%s successfully updated!";
                JOptionPane.showMessageDialog(null, String.format(dialog, column));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    static void options(int accountNumber) {
        String dialog = "What do you want to update? \n\n 1) Account number \n 2) Password";
        String menuOptionString = JOptionPane.showInputDialog(null, dialog);

        String newValue = JOptionPane.showInputDialog(null, "Type the new value");

        int option = Integer.parseInt(menuOptionString);
        switch(option){
            case 1 -> {
                update(accountNumber, "id", newValue);
            }
            case 2 -> {
                update(accountNumber, "pass", newValue);
            }
        }

        Main.isLogged();
    }
}