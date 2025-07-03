import java.awt.*;
import java.awt.event.*;

public class InstgramLoginPage {
    public static void main(String[] args) {
           Frame f = new Frame("Instagram Login");
        f.setSize(400, 500);
        f.setLayout(null);
        f.setBackground(Color.white);

        Label logo = new Label("Instagram", Label.CENTER);
        logo.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
        logo.setBounds(80, 50, 240, 50);
        logo.setForeground(new Color(38, 38, 38));
        f.add(logo);

        Label userLabel = new Label("Username:");
        userLabel.setBounds(50, 130, 80, 20);
        TextField username = new TextField();
        username.setBounds(140, 130, 200, 25);
        f.add(userLabel);
        f.add(username);

        Label passLabel = new Label("Password:");
        passLabel.setBounds(50, 170, 80, 20);
        TextField password = new TextField();
        password.setEchoChar('*');
        password.setBounds(140, 170, 200, 25);
        f.add(passLabel);
        f.add(password);

        Checkbox policyCheck = new Checkbox("I accept Privacy Policy");
        policyCheck.setBounds(140, 210, 200, 20);
        f.add(policyCheck);

        Button loginBtn = new Button("Log In");
        loginBtn.setBounds(140, 240, 200, 30);
        loginBtn.setBackground(new Color(56, 151, 240));
        loginBtn.setForeground(Color.white);
        loginBtn.setFont(new Font("Dialog", Font.BOLD, 14));
        f.add(loginBtn);

        Label forgotPass = new Label("Forgot Password?");
        forgotPass.setBounds(140, 280, 150, 20);
        forgotPass.setForeground(Color.BLUE);
        forgotPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
        f.add(forgotPass);
      f.add(userLabel);  f.add(username);
        f.add(passLabel);  f.add(password);
        f.add(policyCheck);
        f.add(loginBtn);
        f.add(forgotPass);
        f.add(logo);
        f.setLocationRelativeTo(null); 
        f.setVisible(true);
        f.setVisible(true);

    }
}
