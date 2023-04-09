import javax.swing.JOptionPane;

public class UserMenu {
    static void menu(String displayMessage, int accountNumber){
        String functionsString = "What do you want to do?\n 1) Transfer\n 2) Withdraw\n 3) Deposit\n 0) Exit account";
        String optionString = JOptionPane.showInputDialog(null, displayMessage.concat(functionsString));
        int option = Integer.parseInt(optionString);

        switch(option){
            case 0:
                Main.logged = false;
                Main.landingPage();
                break;
            case 1:
                Transfer.tranfer(accountNumber);
                break;
            case 2:
                Withdraw.withdraw(accountNumber);
                break;
            case 3:
                Deposit.deposit(accountNumber);
        }
    }
}