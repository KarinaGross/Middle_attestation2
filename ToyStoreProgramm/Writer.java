import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Writer {

    public static void saveToFile(int id) {
        try {
            File f = new File("Prizes.txt");
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);

            Toy toy = Lottery.getPrize();
            if (toy.getAmount() != 0) {
                toy.setId(id);
                String s = toy.toString();
                pw.println(s);
            }
            
            pw.close();
        } catch (Exception e) {
            System.out.println("Ошибка в сохранении файла");
        }
    }
}
