package itemstore;

import salestax.TaxCalculator;

public class Item implements IItem {

    private String name;
    private double price;
    private double salesTax;
    private ItemCategory.ItemType itemType;

    public Item(String name, double price, ItemCategory.ItemType itemType) {
        this.name = name;
        this.price = price;
        this.itemType = itemType;
        this.salesTax = 0;
    }

    @Override
    public void calculateSalesTax() {
        salesTax = TaxCalculator.calculateTax(price, percentSalesTax,this);
    }

    public void updatePrice() {
        price += salesTax;
    }

    @Override
    public boolean isImported() {
        return itemType.isImported();
    }

    @Override
    public boolean isExempted() {
        return itemType.isExempted();
    }

    public double getPrice() {
        return price;
    }

    public double getSalesTax() {
        return salesTax;
    }

    @Override
    public String toString() {
        return "name='" + name + ":" + " price=" + price;
    }
}
