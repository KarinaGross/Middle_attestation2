
public class Toy {
    private int id;
    private String name;
    private int amount;
    private int weight; 

    public Toy(String name, int amount, int weight) {
        this.name = name;
        this.amount = amount;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("(%d, %s, %d, %d)", id, name, amount, weight);
    }

    public int getAmount() {
        return amount;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setId(int id) {
        this.id = id;
    }
   
}
