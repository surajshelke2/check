public class PubSub {

    public static void main(String[] args) {
        Pub publisher = new Pub();

        SubList subA = new SubList();
        SubB subB = new SubB();

        publisher.subscriber(subA);
        publisher.subscriber(subB);

        publisher.publish("Hello");
        publisher.publish("Another message");

        publisher.unsubscriber(subA);
        publisher.publish("Final");

    }
}
