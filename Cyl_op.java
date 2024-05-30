import java.util.Scanner;

interface Operations {
    double PI = 3.14;
    double area();
    double volume();
}

class Cylinder implements Operations {
    double height;
    double radius;

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }
    public double area() {
        // Area of cylinder = 2πrh + 2πr^2
        return 2 * PI * radius * height + 2 * PI * radius * radius;
    }
    public double volume() {
        // Volume of cylinder = πr^2h
        return PI * radius * radius * height;
    }
}

public class Cyl_op {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the height of the cylinder: ");
        double height = scanner.nextDouble();

        System.out.print("Enter the radius of the cylinder: ");
        double radius = scanner.nextDouble();

        scanner.close();

        Cylinder cylinder = new Cylinder(height, radius);
        System.out.println("Cylinder Area: " + cylinder.area());
        System.out.println("Cylinder Volume: " + cylinder.volume());
    }
}
