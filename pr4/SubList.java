public class SubList implements  Subscriber{
    @Override
    public void receive(String message) {

        System.out.println("Sub A : "+message);
    }
}
