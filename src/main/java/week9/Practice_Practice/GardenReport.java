package week9.Practice_Practice;

import java.util.*;
import java.text.DecimalFormat;

// Abstract base class
abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public abstract double area();
    public abstract String getShape();
}

// Circle plot
class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getShape() {
        return "CIRCLE";
    }
}

// Rectangle plot
class RectanglePlot extends Plot {
    private double length, width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public String getShape() {
        return "RECTANGLE";
    }
}

// Triangle plot
class TrianglePlot extends Plot {
    private double base, height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    @Override
    public String getShape() {
        return "TRIANGLE";
    }
}

public class GardenReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String shape = parts[0];
            String owner = parts[1];

            switch (shape) {
                case "CIRCLE":
                    plots.add(new CirclePlot(owner, Double.parseDouble(parts[2])));
                    break;
                case "RECTANGLE":
                    plots.add(new RectanglePlot(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                    break;
                case "TRIANGLE":
                    plots.add(new TrianglePlot(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                    break;
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double total = 0;

        for (Plot plot : plots) {
            double area = plot.area();
            System.out.println(plot.owner + " (" + plot.getShape() + "): " + df.format(area));
            total += area;
        }

        System.out.println("Total Area: " + df.format(total));
    }
}

