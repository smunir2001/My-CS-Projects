public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to\n\tthe Inventory Management System");
        System.out.println("-----------------------------------");

        DataManager dm = new DataManager();
        dm.createNewUser("John", "Doe", "johnD123", "johndoe123@email.com", "johnDoe_123");
        dm.createNewUser("Mary", "Smith", "maryS_456", "marysmith456@email.com", "MaryS_456");
        dm.createNewUser("Jane", "Mary", "janem.293", "janemary293@email.com", "janemary293");
        dm.getCurrentUsers();

    }
}