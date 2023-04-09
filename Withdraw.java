import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Withdraw {
    static void withdraw(int accountNumber){
        String withdrawValueString = JOptionPane.showInputDialog(null, "Type the withdraw's value");
        int withdrawValue = Integer.parseInt(withdrawValueString);

        try {
            String sql = "SELECT * from account";
            Statement stt = Connect.connection.createStatement();
            ResultSet res = stt.executeQuery(sql);

            while (res.next()) {
                int id = res.getInt(1);
                double currentBalance = res.getDouble("balance");

                if(accountNumber == id){
                    if(withdrawValue <= currentBalance){
                        double newBalanceValue = currentBalance - withdrawValue;
                        String updateBalance = "UPDATE account SET balance = ? WHERE id = ?";
                        PreparedStatement preparedStatement = Connect.connection.prepareStatement(updateBalance);
                        preparedStatement.setDouble(1, newBalanceValue);
                        preparedStatement.setInt(2, id);
                        int response = preparedStatement.executeUpdate();
                        if(response > 0){
                            Main.accounBalance = newBalanceValue;
                            JOptionPane.showMessageDialog(null, "Withdraw successfully made!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Withdraw value greater than balance :(");
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Main.main(null);
    }
}