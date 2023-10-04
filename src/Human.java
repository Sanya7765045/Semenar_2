public class Human extends Actor {

    @Override
    public void setMakeOrder() {
        isMakeOrder = true;

    }

    @Override
    public void setTakeOrder() {
        isTakeOrder = true;
    }

    @Override
    public String toString() {
        return "Human{" +
                "Заказ принят=" + isMakeOrder +
                ", Заказ получен=" + isTakeOrder +
                '}';
    }
}
