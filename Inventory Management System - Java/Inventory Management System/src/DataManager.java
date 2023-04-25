import java.util.ArrayList;

public class DataManager {
    private ArrayList<User> users = new ArrayList<>();

    public DataManager() {}

    public void addUser(User newUser) {
        if (newUser != null) {
            users.add(newUser);
        } else {
            System.out.println("\naddUser() called...");
            System.out.println("\t*** ERROR: user is null/invalid.");
        }
    }
}