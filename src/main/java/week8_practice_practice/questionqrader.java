import java.util.*;

    abstract class Question {
        String correct, student;
        int points;
        Question(String correct, String student, int points) {
            this.correct = correct; this.student = student; this.points = points;
        }
        abstract double grade();
    }

    class MCQ extends Question {
        MCQ(String correct, String student, int points) { super(correct, student, points); }
        double grade() { return student.equals(correct) ? points : 0; }
    }

    class TF extends Question {
        TF(String correct, String student, int points) { super(correct, student, points); }
        double grade() { return student.equals(correct) ? points : 0; }
    }

    class Essay extends Question {
        Essay(String correct, String student, int points) { super(correct, student, points); }
        double grade() {
            String[] keywords = correct.toLowerCase().split(",");
            String ans = student.toLowerCase();
            int count = 0;
            for (String k : keywords) if (ans.contains(k.trim())) count++;
            if (count >= 2) return points * 0.75;
            else if (count == 1) return points * 0.5;
            else return 0;
        }
    }

    public class questionqrader {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            sc.nextLine();
            double total = 0;

            for (int i = 0; i < N; i++) {
                String line = sc.nextLine();
                String[] parts = line.split("\"");
                String type = parts[0].trim();
                String correct = parts[3];
                String student = parts[5];
                int points = Integer.parseInt(parts[6].trim());
                Question q = null;
                if (type.startsWith("MCQ")) q = new MCQ(correct, student, points);
                else if (type.startsWith("TF")) q = new TF(correct, student, points);
                else q = new Essay(correct, student, points);

                double score = q.grade();
                System.out.printf("%s: %.2f%n", type, score);
                total += score;
            }
            System.out.printf("Total Score: %.2f%n", total);
        }
    }


