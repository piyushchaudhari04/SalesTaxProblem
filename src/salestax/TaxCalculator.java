package salestax;

import exception.InvalidPriceException;
import itemstore.IItem;

public class TaxCalculator {

    private static final int IMPORT_TAX = 5;

    public static double calculateTax(double price, int tax, IItem item) {
        if (price < 0) {
            throw new InvalidPriceException("invalid Price: Should be greater than zero");
        }
        if(item.isImported()&&!item.isExempted()){
            int newTax=tax+ IMPORT_TAX;
            return price*(newTax/100);
        }
        else if(item.isExempted()&&item.isImported()){
            int newTax=IMPORT_TAX;
            return price*(newTax/100);
        }
        else{
            return 0;
        }
    }
}
