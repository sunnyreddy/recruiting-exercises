import java.util.*;

// class for warehouse
public class Warehouse {

    private String name;
    // HashMap for this warehouse's inventory distribution
    private HashMap<String, Integer> inventory;

    // Constructor for a warehouse
    public Warehouse(String name, HashMap<String, Integer> inventory) {
        this.name = name;
        this.inventory = new HashMap<>();
        this.inventory = inventory;
    }

    /** Returns the number of a specific item in this warehouse's inventory. */
    public int getItemCount(String item) {
        return inventory.getOrDefault(item, 0);
    }

    /** Sets the number of a specific item in this warehouse's inventory. */
    public void setItemCount(String item, int count) {
        inventory.put(item, count);
    }

    /** Returns the name of this warehouse. */
    public String getName() {
        return name;
    }

    /** Returns the HashMap of this warehouse's inventory. */
    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "{ name: " +  name + ", inventory: " + inventory + " }";
    }
}
