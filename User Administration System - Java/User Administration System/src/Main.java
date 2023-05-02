import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JFrame main_frame = new JFrame();
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setLayout(null);
        main_frame.setSize(650, 400);
        main_frame.setBackground(Color.DARK_GRAY);
        main_frame.setForeground(Color.DARK_GRAY);
        main_frame.setVisible(true);
        String welcomeMssg = "Welcome to the User Administration System\n\tPlease login below";
        System.out.println(welcomeMssg);

        String adminUsername = "root_admin";
        String adminPassword = "root_admin_123";

        String inputUsername;
        String inputPassword;
        Scanner input_scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        while (isLoggedIn == false) {
            System.out.print("------------------\nUsername: ");
            inputUsername = input_scanner.nextLine();
            System.out.print("Password: ");
            inputPassword = input_scanner.nextLine();
            if (inputUsername.equals(adminUsername) && inputPassword.equals(adminPassword)) {
                System.out.println("SUCCESS: logged in as administrator.");
                isLoggedIn = true;
                break;
            } else {
                System.out.println("ERROR: invalid credentials.");
            }
        }

    }
}