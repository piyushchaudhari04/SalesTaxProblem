import itemstore.Cart;
import itemstore.Item;
import itemstore.ItemCategory;
import itemstore.Receipt;

import java.util.Scanner;

class ShoppingStoreApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = makeCartAvailable();
        addItemsToCart(cart, scanner);
        purchaseItems(cart);
    }

    private static void purchaseItems(Cart cart) {
        Receipt receipt = prepareReceipt(cart);
        receipt.prepare();
        receipt.print();
    }

    private static Receipt prepareReceipt(Cart cart) {
        return new Receipt(cart);
    }

    private static void addItemsToCart(Cart cart, Scanner scanner) {
        int numberOfItems = scanner.nextInt();
        while (numberOfItems-- > 0) {
            Item item = createItem(scanner);
            cart.addItem(item);
        }
    }

    private static Item createItem(Scanner scanner) {
        String name = scanner.next();
        double price = scanner.nextDouble();
        String itemType = scanner.next();
        ItemCategory.ItemType itemCategory = GetItemCategory(itemType);
        return new Item(name, price, itemCategory);
    }

    private static ItemCategory.ItemType GetItemCategory(String itemType) {
        if (itemType.equalsIgnoreCase("book")) {
            return ItemCategory.ItemType.BOOK;
        }
        if (itemType.equalsIgnoreCase("food")) {
            return ItemCategory.ItemType.FOOD;
        }
        if (itemType.equalsIgnoreCase("medical")) {
            return ItemCategory.ItemType.MEDICAL;
        }
        if (itemType.equalsIgnoreCase("imported book")) {
            return ItemCategory.ItemType.IMPORTED_BOOK;
        }
        if (itemType.equalsIgnoreCase("imported food")) {
            return ItemCategory.ItemType.IMPORTED_FOOD;
        }
        if (itemType.equalsIgnoreCase("imported medical")) {
            return ItemCategory.ItemType.IMPORTED_MEDICAL;
        } else {
            return ItemCategory.ItemType.OTHERS;
        }
    }

    private static Cart makeCartAvailable() {
        return new Cart();
    }
}
