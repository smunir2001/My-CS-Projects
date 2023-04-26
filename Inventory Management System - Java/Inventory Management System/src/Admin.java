public class Admin extends Employee {
    /*
        Administrator capabilities/functionality
        - Add/remove/edit users/employees
        - View all products (product specs, product price, product SKU, etc.)
        - Update/reset password
        - Update/reset email
        - Update/reset product information
        - Add products
        - Remove products
     */
    DataManager dm;
    public Admin(String firstName, String lastName, String username, String email, String password, int userType) {
        super(firstName, lastName, username, email, password, userType);
        dm = new DataManager();
    }
}
