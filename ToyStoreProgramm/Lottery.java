import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Lottery {
    private static ArrayList<Toy> toys = new ArrayList<>();
    private static Map<ArrayList<Integer>, Toy> d;
    private static Toy prize;

    public static void addToLottery(Toy toy) {
        toys.add(toy);
    }

    public static ArrayList<Toy> getToys() {
        return toys;
    }


    public static Toy getPrize() {
        try {
            getToy();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return prize;
    }

    private static void makeIntervalsAndToys() {
        d = new HashMap<ArrayList<Integer>, Toy>();

        ArrayList<Integer> w = new ArrayList<>(); // создаем список всех весов
        for (Toy toyNew : toys) {
            w.add(toyNew.getWeight());
        }

        ArrayList<Integer> segment = new ArrayList<>();

        for (Toy toyNew : toys) {
            if (toyNew.getAmount() != 0) {
                if (d.isEmpty()) {
                    segment.add(0);
                    segment.add(w.get(0));
                } else {
                    int num = segment.get(1);
                    segment.set(0, num + 1);
                    segment.set(1, num + w.get(toys.indexOf(toyNew)));
                }

                ArrayList<Integer> listInt = new ArrayList<>();
                listInt.add(segment.get(0));
                listInt.add(segment.get(1));
                d.put(listInt, toyNew);
            }
        }
    }

    public static void getToy() throws Exception {
        makeIntervalsAndToys(); // наполняем мапу парами интервал : игрушка

        int randNum = ThreadLocalRandom.current().nextInt(1, 101);

        if (d.isEmpty()) {
            throw new Exception("Игрушки закончились ");
        } else {
            for (ArrayList<Integer> interval : d.keySet()) {
                Toy toyNew = d.get(interval);

                if (randNum > interval.get(0) && randNum < interval.get(1)) {
                    Toy lot = toys.get(toys.indexOf(toyNew));
                    if (toyNew.getAmount() != 0) {
                        lot.setAmount(lot.getAmount() - 1);
                        prize = lot;
                    } else {
                        toys.remove(toys.indexOf(toyNew));
                        
                    }
                } 
            }
        }
    }

}
