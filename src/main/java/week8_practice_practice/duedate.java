import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    String title;
    LibraryItem(String title) { this.title = title; }
    abstract LocalDate dueDate();
}

class Book extends LibraryItem {
    Book(String title) { super(title); }
    LocalDate dueDate() { return LocalDate.of(2023,10,26).plusDays(14); }
}

class DVD extends LibraryItem {
    DVD(String title) { super(title); }
    LocalDate dueDate() { return LocalDate.of(2023,10,26).plusDays(7); }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }
    LocalDate dueDate() { return LocalDate.of(2023,10,26).plusDays(3); }
}

public class duedate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);
            String type = parts[0];
            String title = parts[1].replace("\"", "");
            LibraryItem item = null;

            switch (type) {
                case "BOOK": item = new Book(title); break;
                case "DVD": item = new DVD(title); break;
                case "MAGAZINE": item = new Magazine(title); break;
            }

            System.out.printf("%s: %s%n", item.title, item.dueDate());
        }
    }
}

