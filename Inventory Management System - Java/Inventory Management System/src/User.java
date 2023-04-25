public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private int userID;

    public User() {}

    public User(String firstName, String lastName, String username, String email,
                String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        setUserID();
    }

    public User(String firstName, String lastName, String username, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        setUserID();
    }

    public User(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        setUserID();
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        setUserID();
    }

    private void setUserID() {
        if (this.firstName != null && this.lastName != null
                && this.email != null) {
            System.out.println("\nUser.setUserID() called...");
            this.userID = Math.abs((this.firstName + " " + this.lastName +
                    " " + this.email).hashCode());
            System.out.println("\tSUCCESS: generating userID (" + this.userID + ").");
        } else {
            System.out.println("\nUser.setUserID() called...");
            System.out.println("\tERROR: invalid user info. Cannot generate userID.");
        }
    }

    public int getUserID() {
        return this.userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        String userOutput = "\n" + this.userID + "\n" + this.firstName + " " + this.lastName +
                "\n" + this.username + "\n" + this.email + "\n" + this.password;
        return userOutput;
    }
}