package itemstore;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Item> itemList;

    public Cart() {
        itemList= new ArrayList<>();
    }

    public void addItem(Item item){
        itemList.add(item);
    }

    ArrayList<Item> getItemList() {
        return itemList;
    }
}
