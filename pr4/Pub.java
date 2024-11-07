import java.util.ArrayList;
import java.util.List;

public class Pub {

   private List<Subscriber> subscribers = new ArrayList<>();

   public void subscriber(Subscriber subscriber){

       subscribers.add(subscriber);
   }

    public void unsubscriber(Subscriber subscriber){

        subscribers.remove(subscriber);
    }

    public void publish(String message){
        System.out.println("Publisher :"+message);
        for(Subscriber subscriber : subscribers){

            subscriber.receive(message);
        }
    }
}
