import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JPanel header_panel = new JPanel();
        header_panel.setBackground(Color.DARK_GRAY);
        header_panel.setForeground(Color.WHITE);
        header_panel.setSize(300, 50);
        header_panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        header_panel.setAlignmentY(Component.TOP_ALIGNMENT);
        header_panel.setVisible(true);

        JLabel main_label = new JLabel("Welcome to the User Administration System");
        main_label.setSize(300, 50);
        main_label.setLayout(null);
        main_label.setForeground(Color.WHITE);
        main_label.setVisible(true);
        header_panel.add(main_label);

        /*
            login_panel
            - username_label/input
            - password_label/input
         */
        JPanel login_panel = new JPanel();
        login_panel.setBackground(Color.DARK_GRAY);
        login_panel.setForeground(Color.WHITE);
        login_panel.setSize(300, 50);
        login_panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        login_panel.setVisible(true);

        JLabel username_label = new JLabel("Username: ");
        username_label.setSize(300, 50);
        username_label.setLayout(null);
        username_label.setForeground(Color.WHITE);
        username_label.setVisible(true);
        JLabel password_label = new JLabel("Password: ");
        password_label.setSize(300, 50);
        password_label.setLayout(null);
        password_label.setForeground(Color.WHITE);
        password_label.setVisible(true);
        login_panel.add(username_label);
        login_panel.add(password_label);

        JFrame main_frame = new JFrame();
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setLayout(null);
        main_frame.setSize(650, 400);
        main_frame.setBackground(Color.DARK_GRAY);
        main_frame.setForeground(Color.WHITE);
        main_frame.add(header_panel);
        main_frame.add(login_panel);
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