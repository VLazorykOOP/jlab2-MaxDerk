import java.util.Scanner;

public class Lab22 {
    private double x;
    private double y;
    private double radius;

    public Lab22(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getLength() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public boolean containsPoint(double px, double py) {
        double dx = px - x;
        double dy = py - y;
        return dx * dx + dy * dy <= radius * radius;
    }

    public int intersectionPoints(Lab22 other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > this.radius + other.radius) return 0;
        if (distance < Math.abs(this.radius - other.radius)) return 0;
        if (distance == 0 && this.radius == other.radius) return -1;
        if (distance == this.radius + other.radius || distance == Math.abs(this.radius - other.radius)) return 1;

        return 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coordinates and radius of the first circle:");
        System.out.print("x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("r1: ");
        double r1 = scanner.nextDouble();
        Lab22 c1 = new Lab22(x1, y1, r1);

        System.out.println("Enter coordinates and radius of the second circle:");
        System.out.print("x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("y2: ");
        double y2 = scanner.nextDouble();
        System.out.print("r2: ");
        double r2 = scanner.nextDouble();
        Lab22 c2 = new Lab22(x2, y2, r2);

        System.out.println("Enter coordinates of a point:");
        System.out.print("x3: ");
        double px = scanner.nextDouble();
        System.out.print("y3: ");
        double py = scanner.nextDouble();

        System.out.printf("First circle: Area = %.2f, Circle length = %.2f%n", c1.getArea(), c1.getLength());
        System.out.printf("Second circle: Area = %.2f, Circle length = %.2f%n", c2.getArea(), c2.getLength());
        System.out.println("Intersection points between circles: " + c1.intersectionPoints(c2));
        System.out.println("Is point inside the circle: " + c1.containsPoint(px, py));

        scanner.close();
    }
}