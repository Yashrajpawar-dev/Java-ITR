import java.util.*;


class Direction extends Thread{
 
    String names;

   String Vehicles[];

   void Direction(String n , String[] v){
   this.names = n;
    this.Vehicles = v;

   }
    
   @Override
  public void run() {
    try{
       String[] signal = {"Red","Yellow","Green"};

   while (true){
        for(int i =0; i<= signal.length;i++){
            switch (i) {
                case 1:
                System.out.println("Red : Stop");
                Thread.sleep(10000);
                    




                    break;
                    case 2:
                     System.out.println("Yellow : Ready");
                Thread.sleep(10000);
                    break;
                    case 3:
                     System.out.println("Green: Go");
                Thread.sleep(10000);
                    break;
            
                default:
                    break;
            }
        }
    }
}

       super.run();
  }}
public class TrafficLights extends Thread{

    public static void main(String[] args) {
     

        String CommonVehicles[] = {"Bus", "car", "trusj"};

        String emergency[] = {"Ambulance"};

        Thread north = new Direction("north", CommonVehicles);
        Thread south = new Direction("suth", CommonVehicles);
        Thread east = new Direction("east", CommonVehicles);
        Thread west = new Direction("west", CommonVehicles);
Thread emer = new Direction("Emergency" emergency);

        north.start();
        south.start();
        east.start();
        west.start();
    }}
}
   