package itemstore;

public interface IItem {
    int percentSalesTax=10;
    void calculateSalesTax();
    void updatePrice();
    boolean isImported();
    boolean isExempted();
}
