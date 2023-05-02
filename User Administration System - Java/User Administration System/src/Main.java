import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame main_frame = new JFrame();
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setLayout(null);
        main_frame.setSize(650, 400);
        main_frame.setVisible(true);
        String welcomeMssg = "Welcome to the User Administration System\n\tPlease login below:\n";
        System.out.println(welcomeMssg);
    }
}