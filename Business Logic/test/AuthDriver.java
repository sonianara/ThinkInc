import java.util.Scanner;

public class AuthDriver {
    public static void main(String[] args){
        String userID = "";
        String password = "";
        User user = null;
        int i = 0;

        Scanner ui = new Scanner(System.in);
        do {
            System.out.println("Enter Username:");
            userID = ui.nextLine();
            System.out.println("Enter Password:");
            password = ui.nextLine();
            if (checkCreds(userID, password) = true) {
                directUser(userID, password);
                i = 4;
            }
            i++;
            System.out.println("Invalid Password\nYou have %d more attempts", 3-i);
        }while(i < 3);

    }
}
