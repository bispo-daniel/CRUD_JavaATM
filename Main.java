import javax.swing.JOptionPane;

public class Main {
    static boolean logged = false;
    static String welcomeMessageForLoggedUser;
    static String userName;
    static int accountNumber;
    static double accounBalance;

    static void landingPage(){
        String functions = "Welcome!\n\n What do you want to do?\n 1) Login\n 2) Create client\n 3) Create account\n 0) Exit application";
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
                CreateClient.createClientFunction();
                break;
            case 3:
                CreateAccount.createAccountFunction();
                break;
            // case 4:
            //     Delete.delete("customer");
            //     break;
            // case 5:
            //     Delete.delete("account");
            //     break;
            default:
                JOptionPane.showMessageDialog(null, "Type a valid option...");
                landingPage();
        }
    }

    static void isLogged(){
        if(logged == false){
            landingPage();
        } else {
            String welcome = String.format(welcomeMessageForLoggedUser, userName, accountNumber, accounBalance);
            UserMenu.menu(welcome, accountNumber);
        }
    }
    public static void main(String[] args) {
        try {
            Connect.getConnection();
            isLogged();
        } catch(NumberFormatException e){
            logged = false;
            JOptionPane.showMessageDialog(null, "You probably typed a letter where a number is expected.\nTry again...");
            main(args);
        }
    }
}