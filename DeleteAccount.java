import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DeleteAccount {

    static boolean confirmation(){
        boolean bool = false;
		String confirmationString = JOptionPane.showInputDialog(null, "Type 1 to confirm\nType 0 to cancel");
		int confirmation = Integer.parseInt(confirmationString);

		if (confirmation == 1) {
			bool = true;
		}

		return bool;
    }
    
    static void delete(int accountNumber){
        try {
            String sql = "DELETE FROM account WHERE id = ?";
            PreparedStatement stt = Connect.connection.prepareStatement(sql);

            stt.setInt(1, accountNumber);

            if (confirmation()) {
                int response = stt.executeUpdate();
                if (response > 0) {
                    String dialog = "Account %d successfully removed!";
                    JOptionPane.showMessageDialog(null, String.format(dialog, accountNumber));
                }
                Main.logged = false;
            } 

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Main.isLogged();
    }
}
