package week2_assignment;

public class InventoryCSVParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null || csvLine.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Split by comma
        String[] fields = csvLine.split(",");

        // Validate number of fields
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        // Trim spaces (optional, for cleaner output)
        String product = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();

        // Print formatted record
        System.out.println("Product: " + product +
                " | SKU: " + sku +
                " | Qty: " + qty);
    }

    public static void main(String[] args) {
        // Sample test cases
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
    }
}
