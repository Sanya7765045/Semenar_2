import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Market implements QueueBehavior, MarketBehavior {

    private List<Actor> orders;
    private Queue<Actor> queue;

    public Market() {
        orders = new ArrayList<>();
        queue = new LinkedList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        queue.offer(actor);
        System.out.println(actor.getName() + " принят в магазин.");
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            orders.remove(actor);
            System.out.println("Покупатель " + actor.getName() + " покинул магазин.");
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
    }

    @Override
    public void takeInQueue(Actor actor) {
        queue.offer(actor);
        System.out.println(actor.getName() + " встал в очередь.");
    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                orders.add(actor);
                System.out.println(actor.getName() + " сделал заказ.");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : orders) {
            if (actor.isTakeOrder()) {
                orders.remove(actor);
                System.out.println(actor.getName() + " получил заказ.");
                break;
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        Actor actor = queue.poll();
        System.out.println(actor.getName() + " покинул очередь.");
    }
}