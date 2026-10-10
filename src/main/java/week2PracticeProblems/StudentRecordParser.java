public class StudentRecordParser {

    // Method to parse and print student record
    public static void parseStudentRecord(String csvLine) {
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

        // Trim spaces for cleaner output
        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        // Print formatted record
        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    public static void main(String[] args) {
        // Example inputs
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Rahul,RA2211003010456,IT");
        parseStudentRecord("InvalidLineWithoutEnoughFields");
    }
}
