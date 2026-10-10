public class FileExtensionValidator {

    // Method to validate file extension
    public static String validateFileExtension(String filename) {
        if (filename == null || filename.isEmpty()) {
            return "Rejected — invalid file type";
        }

        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);

        // Accepted extensions: pdf, docx, zip
        if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        // Example inputs
        System.out.println("Assignment1.PDF → " + validateFileExtension("Assignment1.PDF"));
        System.out.println("notes.txt → " + validateFileExtension("notes.txt"));
        System.out.println("project.zip → " + validateFileExtension("project.zip"));
        System.out.println("report.docx → " + validateFileExtension("report.docx"));
        System.out.println("invalidfile → " + validateFileExtension("invalidfile"));
    }
}
