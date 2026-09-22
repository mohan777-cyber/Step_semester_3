package week6_assignment;

class HallTicket {
    String studentName;
    int seatNumber;

    // Constructor
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class ExamHallTicketReferenceManagement {
    public static void main(String[] args) {
        // Create one HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);

        // Assign a second variable to point at the same object
        HallTicket copy = priya;

        // Change seatNumber through the second variable
        copy.seatNumber = 45;

        // Print value through the first variable
        System.out.println("Priya's seat (via priya): " + priya.seatNumber);

        // Check if both variables point to the same object
        System.out.println("priyaa == copy? " + (priya == copy));

        // Create a third, separate HallTicket object with identical field values
        HallTicket separate = new HallTicket("Priya", 45);

        // Check equality with the first object
        System.out.println("priyaa == separate? " + (priya == separate));
    }
}
