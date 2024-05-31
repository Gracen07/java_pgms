import java.util.Scanner;

interface Area {
    double calculateArea();
}

interface Volume {
    double calculateVolume();
}

class Shape {
    String name;

    public Shape() {
        this.name = "Undefined";
    }

    public String getName() {
        return this.name;
    }
}

class Circle extends Shape implements Area {
    double radius;

    public Circle(double r, String n) {
        super();
        this.radius = r;
        this.name = n;
    }
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape implements Area {
    double side;

    public Square(double s, String n) {
        super();
        this.side = s;
        this.name = n;
    }
    public double calculateArea() {
        return side * side;
    }
}

class Cylinder extends Circle implements Volume {
    double height;

    public Cylinder(double h, double r, String n) {
        super(r, n);
        this.height = h;
    }
    public double calculateVolume() {
        return super.calculateArea() * height;
    }
}

class Sphere extends Circle implements Volume {
    public Sphere(double r, String n) {
        super(r, n);
    }
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}

class Cube extends Square implements Volume {
    public Cube(double s, String n) {
        super(s, n);
    }
    public double calculateVolume() {
        return Math.pow(side, 3);
    }
}

class Glome extends Sphere implements Volume {
    public Glome(double r, String n) {
        super(r, n);
    }
    public double calculateVolume() {
        return 0.5 * Math.PI * Math.PI * Math.pow(radius, 4);
    }
}

public class Geo_Shap{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double circleRadius = scanner.nextDouble();

        System.out.print("Enter the side length of the square: ");
        double squareSide = scanner.nextDouble();

        System.out.print("Enter the height of the cylinder: ");
        double cylinderHeight = scanner.nextDouble();

        System.out.print("Enter the radius of the sphere: ");
        double sphereRadius = scanner.nextDouble();

        System.out.print("Enter the side length of the cube: ");
        double cubeSide = scanner.nextDouble();

        System.out.print("Enter the radius of the glome: ");
        double glomeRadius = scanner.nextDouble();

        scanner.close();

        Circle circle = new Circle(circleRadius, "Circle");
        Square square = new Square(squareSide, "Square");
        Cylinder cylinder = new Cylinder(cylinderHeight, circleRadius, "Cylinder");
        Sphere sphere = new Sphere(sphereRadius, "Sphere");
        Cube cube = new Cube(cubeSide, "Cube");
        Glome glome = new Glome(glomeRadius, "Glome");

        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Square Area: " + square.calculateArea());
        System.out.println("Cylinder Volume: " + cylinder.calculateVolume());
        System.out.println("Sphere Volume: " + sphere.calculateVolume());
        System.out.println("Cube Volume: " + cube.calculateVolume());
        System.out.println("Glome Volume: " + glome.calculateVolume());
    }
}
