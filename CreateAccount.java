import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CreateAccount {
    static void createAccountFunction(){
        String accountNumberString = JOptionPane.showInputDialog(null, "Type your preferred account number");
        int accountNumber = Integer.parseInt(accountNumberString);
        
        String balanceString = JOptionPane.showInputDialog(null, "Type your initial balance");
        double balance = Double.parseDouble(balanceString);
        
        String password = JOptionPane.showInputDialog(null, "Type your new account's password");
        
        String customerIdString = JOptionPane.showInputDialog(null, "Type your client id");
        int customerId = Integer.parseInt(customerIdString);
        
        try {
            String sql = "INSERT INTO account (id, balance, pass, customer_id_fk) VALUES (?, ?, ?, ?)";  
            PreparedStatement stt = Connect.connection.prepareStatement(sql);  

            stt.setInt(1, accountNumber);
            stt.setDouble(2, balance);
            stt.setString(3, password);
            stt.setInt(4, customerId);

            int response = stt.executeUpdate();
            if(response > 0){
                JOptionPane.showMessageDialog(null, String.format("Account %d successfully created!", accountNumber));
            }

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "This account number has already been taken...");                
            } else if(e.getErrorCode() == 1452){
                JOptionPane.showMessageDialog(null, "This customer does not exist");
            } else {
                e.printStackTrace();
                System.out.println(e.getErrorCode());
            }
        }

        Main.landingPage();
    }
}