package itemstore;

public class ItemCategory {

    public enum ItemType {

        BOOK(true, false),
        MEDICAL(true, false),
        FOOD(true, false),
        OTHERS(false, false),
        IMPORTED_BOOK(true, true),
        IMPORTED_MEDICAL(true, true),
        IMPORTED_FOOD(true, true),
        IMPORTED_OTHERS(false, true);

        private boolean isExempted;
        private boolean isImported;

        ItemType(boolean exempted, boolean imported) {
            isExempted = exempted;
            isImported = imported;
        }

        public boolean isImported() {
            return isImported;
        }

        public boolean isExempted() {
            return isExempted;
        }
    }
}
