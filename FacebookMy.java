import java.awt.*;




public class FacebookMy {
public static void main(String[] args) {
     Frame f = new Frame("FaceBook Login");
        f.setSize(400, 500);
        f.setLayout(null);
        f.setBackground(Color.white);
        f.setVisible(true);

        Label logo = new Label("Facebook", Label.CENTER);
        logo.setFont(new Font("Serif", Font.BOLD, 40));

        logo.setBounds(80, 50, 240, 50);
        logo.setForeground(new Color(8, 10, 255,1));
        f.add(logo);
         Label userLabel = new Label("Username:");
        userLabel.setBounds(50, 130, 80, 20);
        TextField username = new TextField();
        username.setBounds(140, 130, 200, 25);
        f.add(userLabel);
        f.add(username);

        Label passLabel = new Label("Password:");
        passLabel.setBounds(50, 180, 80, 20);
        TextField password = new TextField();
        password.setBounds(140, 180, 200, 25);
        password.setEchoChar('*');
        f.add(passLabel);
        f.add(password);

        Button loginButton = new Button("Login");
        loginButton.setBounds(100, 250, 80, 30);
        f.add(loginButton);

        Button clearButton = new Button("Clear");
        clearButton.setBounds(200, 250, 80, 30);
        f.add(clearButton);
          
      f.add(userLabel);  f.add(username);
        f.add(passLabel);  f.add(password);
       
        f.add(logo);
        f.setLocationRelativeTo(null); 
        f.setVisible(true);
        f.setVisible(true);
    }
}
    

