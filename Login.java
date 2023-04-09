import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Login {
    static boolean found = false;

    static void login(){
        String accountNumberString = JOptionPane.showInputDialog(null, "Type your account's number");
        int accountNumber = Integer.parseInt(accountNumberString);
        String passwordString = JOptionPane.showInputDialog(null, "Type your password");

        try {

            String sql = "SELECT a.id, a.balance, a.pass, c.name FROM account a JOIN customer c ON a.customer_id_fk = c.id";
            Statement stt = Connect.connection.createStatement();
            ResultSet res = stt.executeQuery(sql);

            while(res.next()){
                int account_number = res.getInt(1);
                double balance = res.getDouble(2);
                String pass = res.getString(3);
                String name = res.getString(4);

                if(accountNumber == account_number && passwordString.equals(pass)){
                    Main.isLogged = true;
                    Main.welcomeMessageForLoggedUser = "Welcome %s!\n\n Account number: %d\n Balance: %.2f\n\n";
                    Main.accountNumber = account_number;
                    Main.accounBalance = balance;
                    Main.userName = name;
                    
                    found = true;
                    break;
                } 
            }

            if(found == false){
                JOptionPane.showMessageDialog(null, "Conta não encontrada");
            }

            //Reseting the variable
            found = false;

        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        Main.main(null);
    }
}