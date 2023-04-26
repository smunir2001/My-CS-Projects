public class Employee extends User {
    /*
        Employee capabilities/functionality
        - View all products (product specs, product price, product SKU, etc.)
        - Update/reset password
        - Update/reset email
        - Update/reset product information
        - Add products
        - Remove products
     */
    public Employee(String firstName, String lastName, String username, String email, String password, int userType) {
        super(firstName, lastName, username, email, password, userType);
    }
}
