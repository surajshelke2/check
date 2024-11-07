public class SubB implements Subscriber{
    @Override
    public void receive(String message) {
        System.out.println("Sub B"+message);
    }
}
