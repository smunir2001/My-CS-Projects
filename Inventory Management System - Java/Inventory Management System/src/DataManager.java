import java.util.ArrayList;

public class DataManager {
    private ArrayList<User> users = new ArrayList<>();

    public DataManager() {}

    private void addUser(User newUser) {
        if (newUser != null) {
            System.out.println("\nDataManager.addUser() called...");
            System.out.println("\tSUCCESS: adding user {" + newUser.getUserID() + "} to the database.");
            this.users.add(newUser);
        } else {
            System.out.println("\nDataManager.addUser() called...");
            System.out.println("\tERROR: user is null/invalid.");
        }
    }

    public void createNewUser(String firstName, String lastName, String username,
                              String email, String password) {
        if (firstName != "" && lastName != "" && username != "" && email != "" &&
            password != "") {
            System.out.println("\nDataManager.createNewUser() called...");
            System.out.println("\tSUCCESS: creating new user {" + lastName + ", " + firstName + "}");
            User newUser = new User(firstName, lastName, username, email, password);
            addUser(newUser);
        } else {
            System.out.println("\nDataManager.createNewUser() called...");
            System.out.println("\tERROR: failed to create new user. Invalid parameters.");
        }
    }

    public void removeUser(int userID) {
        System.out.println("\nDataManager.removeUser() called...");
        if (this.users == null || this.users.size() == 0) {
            System.out.println("\tERROR: failed to remove specified user. No current users found in the database.");
            return;
        }
        int i = 0;
        while (i < this.users.size()) {
            if (this.users.get(i).getUserID() == userID) {
                break;
            }
            i++;
        }
        System.out.println("\tSUCCESS: removing user {" + this.users.get(i).getUserID() + "} from the database.");
        this.users.remove(i);
    }

    public void getCurrentUsers() {
        System.out.println("\nDataManager.getCurrentUsers() called...");
        if (this.users.size() != 0) {
            String currentUsersOutput = "\tno. of current users: " + this.users.size() + "\n\tcurrentUsers: [";
            for (int i = 0; i < this.users.size(); i++) {
                currentUsersOutput += this.users.get(i).getUserID() + ", ";
            }
            currentUsersOutput += "\b\b]";
            System.out.println(currentUsersOutput);
        } else {
            System.out.println("\tno. of current users: " + this.users.size() + "\n\tcurrentUsers: []");
        }
    }
}