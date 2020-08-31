import java.util.*;

public class InventoryAllocator {

    private HashMap<String, Integer> order;
    private LinkedList<Warehouse> warehouses;
    private int total;

    public InventoryAllocator(HashMap<String, Integer> order, LinkedList<Warehouse> warehouses) {
        this.order = order;
        this.warehouses = warehouses;
        for (int value : order.values() ) {
            total += value;
        }
    }

    public LinkedList<Warehouse> shipOrders() {
        LinkedList<Warehouse> result = new LinkedList<Warehouse>();
        for (Warehouse wh : warehouses) {
            Warehouse wh_ship = new Warehouse(wh.getName(), new HashMap<String, Integer>());

            for (String item : wh.getInventory().keySet()) {
                if (total == 0) {
                    return result;
                }
                else if (order.getOrDefault(item, 0) == 0 || wh.getItemCount(item) == 0) {
                    continue;
                }
                else {
                    
                    int min_inv = Math.min(order.get(item), wh.getItemCount(item));
                    wh_ship.setItemCount(item, min_inv);
                    total -= min_inv;
                    int fill = order.get(item) - wh.getItemCount(item);
                    int max_inv = Math.max(0, fill);
                    order.put(item, max_inv);
                    if (!result.contains(wh_ship)) {
                        result.add(wh_ship);
                    }
                }
            }
        }
        return result;
    }
}