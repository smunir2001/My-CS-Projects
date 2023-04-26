import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println("Welcome to\n\tthe Inventory Management System");
//        System.out.println("-----------------------------------");

//        DataManager dm = new DataManager();
        // Testing DataManager.createNewUser() method & DataManager.addUser() method
        /*
            Creating new user type admin.
         */
//        dm.createNewUser("John", "Doe", "johnD123", "johndoe123@email.com", "johnDoe_123", 3);
//        dm.createNewUser("Mary", "Smith", "maryS_456", "marysmith456@email.com", "MaryS_456", 2);
//        dm.createNewUser("Jane", "Mary", "janem.293", "janemary293@email.com", "janemary293", 1);
//        dm.printCurrentUsers();
        // Testing DataManager.removeUser() method
//        dm.removeUser(429437534);
//        dm.removeUser(31753217);
//        dm.removeUser(475544499);
//        dm.printCurrentUsers();
        runProgram();
    }

    private static String[] getAdminCreds() throws IOException {
        File inputFile = new File("data/AdminCreds.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        String[] adminCreds = new String[2];
        String line;
        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            adminCreds[i] = line.substring(10, line.length());
            i++;
        }
        return adminCreds;
    }

    public static void runProgram() throws IOException {
        System.out.println("Welcome to\n\tthe Inventory Management System");
        System.out.println("-----------------------------------");
        System.out.println("\tPlease login...");

        String[] adminCreds = getAdminCreds();
//        System.out.println("adminCreds[]: " + Arrays.toString(adminCreds));

        Scanner scannerObj = new Scanner(System.in);
        String username = "";
        String password = "";
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("\nUsername: ");
            username = scannerObj.nextLine();
            System.out.print("Password: ");
            password = scannerObj.nextLine();
            if (username.equals(adminCreds[0]) && password.equals(adminCreds[1])) {
                System.out.println("\nSUCCESS:\n\tLogged in as administrator.");
                System.out.println("-----------------------------------");
                loggedIn = true;
                adminController();
            } else {
                System.out.println("ERROR: invalid credentials. Please try again.");
            }
        }
    }

    public static void adminController() {
        Admin adminObj = new Admin("John", "Doe", "root_admin", "johndoe@email.com", "admin_root_739", 3);
        adminObj.dm.createNewUser("John", "Doe", "root_admin", "johndoe@email.com", "admin_root_739", 3);
        adminObj.dm.createNewUser("Mary", "Smith", "maryS194", "marysmith@email.com", "mary.smith98", 2);
        adminObj.dm.printCurrentUsers();

    }
}