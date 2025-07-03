import java.awt.*;




public class FaceBook extends Frame  {
   Label title,textEmail,textPassword; 
   TextField emailField,password;
   Button loginButton,clearButton;

   FaceBook(){
    setSize(300,400);
    setVisible(true);

   }
   public static void main(String[] args) {
FaceBook fb = new FaceBook();
   }
}
