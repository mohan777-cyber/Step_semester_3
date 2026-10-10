package week10practice;

public class StudentGradeAssignment {

    public static void main(String[] args) {
        int marks1 = 72; // Sample input 1
        int marks2 = 95; // Sample input 2
        int marks3 = 35; // Sample input 3

        printGrade(marks1);
        printGrade(marks2);
        printGrade(marks3);
    }

    public static void printGrade(int marks) {
        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 75) {
            System.out.println("Grade B");
        } else if (marks >= 60) {
            System.out.println("Grade C");
        } else if (marks >= 40) {
            System.out.println("Grade D");
        } else {
            System.out.println("Grade F");
        }
    }
}

