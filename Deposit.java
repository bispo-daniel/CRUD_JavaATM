import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Deposit {
    static void deposit(int accountNumber){
        String depositValueString = JOptionPane.showInputDialog(null, "Type the deposit's value");
        int depositValue = Integer.parseInt(depositValueString);

        try {
            String sql = "SELECT * from account";
            Statement stt = Connect.connection.createStatement();
            ResultSet res = stt.executeQuery(sql);

            while(res.next()){
                int account_number = res.getInt(1);
                double currentBalance = res.getDouble("balance");

                if(account_number == accountNumber){
                    double newBalance = currentBalance + depositValue;
                    String setNewBalance = "UPDATE account SET balance = ? WHERE id = %d";
                    String formattedString = String.format(setNewBalance, accountNumber);
                    PreparedStatement preparedStatement = Connect.connection.prepareStatement(formattedString);
                    preparedStatement.setDouble(1, newBalance);
                    int response = preparedStatement.executeUpdate();

                    if(response > 0){
                        Main.accounBalance = newBalance;
                        
                        String dialog = "%d balance updated!";
                        JOptionPane.showMessageDialog(null, String.format(dialog, accountNumber));
                    }
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Main.isLogged();
    }
}