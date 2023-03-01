
public class Program {
    public static void main(String[] args) {

        Toy lot1 = new Toy("Посудка", 3, 15);
        Toy lot2 = new Toy("Пластилин", 5, 25);
        Toy lot3 = new Toy("Раскраска", 10, 30);
        Toy lot4 = new Toy("Наклейки", 11, 30);
        Toy lot5 = new Toy("Кукла", 0, 0);

        Lottery.addToLottery(lot1);
        Lottery.addToLottery(lot2);
        Lottery.addToLottery(lot3);
        Lottery.addToLottery(lot4);
        Lottery.addToLottery(lot5);

        // розыгрыш проходит по типу лото: у нас есть несколько попыток (50) достать номер из мешка (от номера зависит какая игрушка выпадет)
        for (int i = 0; i < 50; i++) {
            Writer.saveToFile(i + 1);
        }

        // при записи некоторые игрушки дублируются (я не смогла решить эту проблему)
    }
}
