package week7_assignment;

class TrafficLight {
    private String color;       // current color, private
    private final String id;    // final ID, fixed at creation

    // Constructor: starts on RED
    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    // Move to the next color in the cycle
    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else if (color.equals("YELLOW")) {
            color = "RED";
        }
    }

    // Read-only access to current color
    public String getColor() {
        return color;
    }

    // Read-only access to ID
    public String getId() {
        return id;
    }
}

public class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println(t.getId() + " starts at: " + t.getColor()); // RED
        t.next();
        System.out.println("After next(): " + t.getColor()); // GREEN
        t.next();
        System.out.println("After next(): " + t.getColor()); // YELLOW
        t.next();
        System.out.println("After next(): " + t.getColor()); // RED
    }
}

