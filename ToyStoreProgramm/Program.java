
public class Program {
    public static void main(String[] args) {

        ToyNew lot1 = new ToyNew("Посудка", 3, 15);
        ToyNew lot2 = new ToyNew("Пластилин", 5, 25);
        ToyNew lot3 = new ToyNew("Раскраска", 10, 30);
        ToyNew lot4 = new ToyNew("Наклейки", 11, 30);
        ToyNew lot5 = new ToyNew("Кукла", 0, 0);

        LotteryNew.addToLottery(lot1);
        LotteryNew.addToLottery(lot2);
        LotteryNew.addToLottery(lot3);
        LotteryNew.addToLottery(lot4);
        LotteryNew.addToLottery(lot5);

        // розыгрыш проходит по типу лото: у нас есть несколько попыток (50) достать номер из мешка (от номера зависит какая игрушка выпадет)
        for (int i = 0; i < 50; i++) {
            Writer.saveToFile(i + 1);
        }

        // при записи некоторые игрушки дублируются (я не смогла решить эту проблему)
    }
}
