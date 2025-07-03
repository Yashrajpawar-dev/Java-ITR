import java.awt.*;
import java.awt.event.*;


public class RegistrationForm {
   public static void main(String[] args) {
    Frame f = new Frame("Regstration Form");



     
    
    Label phoneLabel = new Label("Phone:");
       
     Label nameLabel = new Label("Name:");
        nameLabel.setBounds(50, 50, 80, 20);
        TextField name = new TextField(20);
        name.setBounds(150, 50, 180, 20);
     phoneLabel.setBounds(50, 90, 80, 20);
        TextField phone = new TextField(15);
        phone.setBounds(150, 90, 180, 20);

     
       Label addressLabel = new Label("Address:");
        addressLabel.setBounds(50, 130, 80, 20);
        TextArea address = new TextArea(3, 20);
        address.setBounds(150, 130, 180, 60);
     Label genderLabel = new Label("Gender:");
        genderLabel.setBounds(50, 210, 80, 20);
        CheckboxGroup genderGroup = new CheckboxGroup();
        Checkbox male = new Checkbox("Male", genderGroup, false);
        Checkbox female = new Checkbox("Female", genderGroup, false);
        male.setBounds(150, 210, 60, 20);
        female.setBounds(220, 210, 70, 20);

  Label skillLabel = new Label("Skills:");
        skillLabel.setBounds(50, 250, 80, 20);
        Checkbox java = new Checkbox("Java Fullstack");
        Checkbox web = new Checkbox("Web Dev");
        Checkbox rpa = new Checkbox("Robot Programming");
        Checkbox data = new Checkbox("Data Science");
        java.setBounds(150, 250, 150, 20);
        web.setBounds(150, 280, 150, 20);
        rpa.setBounds(150, 310, 150, 20);
        data.setBounds(150, 340, 150, 20);
        Button submit = new Button("Submit");
        submit.setBounds(150, 380, 80, 30);

 f.add(nameLabel);
        f.add(name);
        f.add(phoneLabel);
        f.add(phone);
        f.add(addressLabel);
        f.add(address);
        f.add(genderLabel);
        f.add(male);
        f.add(female);
        f.add(skillLabel);
        f.add(java);
        f.add(web);
        f.add(rpa);
        f.add(data);
        f.add(submit);
        f.setSize(400,600);
     
        f.setLocationRelativeTo(null); 
        f.setVisible(true);
        f.setVisible(true);


   } 
}
//PunamPawar3720


//PunamPawar3720@