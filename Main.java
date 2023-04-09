import javax.swing.JOptionPane;

public class Main {
    static boolean isLogged = false;
    static String welcomeMessageForLoggedUser;
    static String userName;
    static int accountNumber;
    static double accounBalance;
    //AccountBalance do not update when deposit is made

    static void landingPage(){
        String functions = "Welcome!\n\n What do you want to do?\n 1) Login\n 2) Create client\n 3) Create account\n 4) Delete customer\n 5) Delete account\n 0) Exit application";
        String optionString = JOptionPane.showInputDialog(null, functions);
        int option = Integer.parseInt(optionString);

        switch(option){
            case 0:
                System.exit(0);
                break;
            case 1:
                Login.login();
                break;
            case 2:
                CreateAccount.createClientFunction();
                break;
            case 3:
                CreateAccount.createAccountFunction();
                break;
            case 4:
                Delete.delete("customer");
                break;
            case 5:
                Delete.delete("account");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Type a valid option...");
                landingPage();
        }
    }
    public static void main(String[] args) {
        Connect.getConnection();

        if(isLogged == false){
            landingPage();
        } else {
            String welcome = String.format(welcomeMessageForLoggedUser, userName, accountNumber, accounBalance);
            Menu.menu(welcome, accountNumber);
        }
    }
}