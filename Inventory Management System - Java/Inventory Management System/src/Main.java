public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to\n\tthe Inventory Management System");
        System.out.println("-----------------------------------");

        User user1 = new User("John", "Doe", "johnD123",
                "johndoe123@email.com", "johnDoe_123");
        System.out.println(user1);
    }
}