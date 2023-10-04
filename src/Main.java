import java.util.List;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Human human1 = new Human();
        human1.setName("Alexandr");
        human1.setMakeOrder();
        market.acceptToMarket(human1);

        Human human2 = new Human();
        human2.setName("Elena");
        human2.setMakeOrder();
        market.acceptToMarket(human2);

        Human human3 = new Human();
        human3.setName("Ivan");
        market.takeInQueue(human3);

        Human human4 = new Human();
        human4.setName("Maria");
        market.takeInQueue(human4);

        market.update();

        Human human5 = new Human();
        human5.setName("Olga");
        human5.setMakeOrder();
        market.acceptToMarket(human5);

        market.releaseFromMarket(List.of(human1, human2));

        market.update();
        market.update();
        market.update();

        market.releaseFromQueue();

        market.update();
    }
}