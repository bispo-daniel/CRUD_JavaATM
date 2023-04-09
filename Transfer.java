import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Transfer {
    static void tranfer(int accountNumber){
        String transferValueString = JOptionPane.showInputDialog(null, "Type the transfer value");
        double transferValue = Double.parseDouble(transferValueString);

        String destinationAccountString = JOptionPane.showInputDialog(null, "Type the destination account number");
        int destinationAccount = Integer.parseInt(destinationAccountString);

        if(accountNumber == destinationAccount){
            JOptionPane.showMessageDialog(null, "You cannot transfer to your own account");
            Main.isLogged();
        } else {
            try {
                String findAccountSQL = "SELECT * FROM account";
                Statement stt = Connect.connection.createStatement();
                ResultSet res = stt.executeQuery(findAccountSQL);

                while (res.next()) {
                    int account_number = res.getInt("id");
                    double balance = res.getDouble("balance");

                    if(accountNumber == account_number){
                        if(transferValue <= balance){
                            double newBalanceValue = balance - transferValue;

                            String sql = "UPDATE account SET balance = ? WHERE id = ?";
                            PreparedStatement preparedStatement = Connect.connection.prepareStatement(sql);

                            preparedStatement.setDouble(1, newBalanceValue);
                            preparedStatement.setInt(2, account_number);
                            int response = preparedStatement.executeUpdate();

                            Main.accounBalance = newBalanceValue;

                            if(response > 0){
                                JOptionPane.showMessageDialog(null, "Transfer successfully made!");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Transfer value greater than balance :(");
                            Main.main(null);
                        }
                    }

                    if(destinationAccount == account_number){
                        double newBalanceValue = balance + transferValue;

                        String sql = "UPDATE account SET balance = ? WHERE id = ?";
                        PreparedStatement preparedStatement = Connect.connection.prepareStatement(sql);

                        preparedStatement.setDouble(1, newBalanceValue);
                        preparedStatement.setInt(2, account_number);
                        preparedStatement.executeUpdate();

                    } 
                }

            } catch(SQLException e){
                e.printStackTrace();
            }
        }

        Main.isLogged();
    }
}