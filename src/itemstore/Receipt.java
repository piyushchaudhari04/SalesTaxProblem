package itemstore;

import java.util.ArrayList;

public class Receipt {

    private Cart cart;

    public Receipt(Cart cart) {
        this.cart = cart;
    }

    public void prepare() {
        ArrayList itemList = cart.getItemList();
        for (Object anItemList : itemList) {
            IItem item = (IItem) anItemList;
            item.calculateSalesTax();
            item.updatePrice();
        }
    }

    public void print() {
        ArrayList itemList = cart.getItemList();
        for (Object anItemList : itemList) {
            IItem item = (IItem) anItemList;
            System.out.println(item);
            System.out.println("Sales Tax:" + calculateSalesTax());
            System.out.println("Total Cost" + calculateTotalCost());
        }
    }

    private double calculateTotalCost() {
        ArrayList itemList = cart.getItemList();
        double totalCost = 0;
        for (Object anItemList : itemList) {
            Item item = (Item) anItemList;
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    private double calculateSalesTax() {
        ArrayList itemList = cart.getItemList();
        double salesTax = 0;
        for (Object anItemList : itemList) {
            Item item = (Item) anItemList;
            salesTax += item.getSalesTax();
        }
        return salesTax;
    }
}
