package lab4;

import jakarta.persistence.*;

@Entity
@Table(name = "triangles")
public class Triangle extends Shape {
    private double width;
    private double height;
    private double sideA;
    private double sideB;
    private double sideC;
    private String name;

    public Triangle() {}

    public Triangle(double width, double height, double sideA, double sideB, double sideC, String name, Color color) {
        super(color);
        this.width = width;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.name = name;
    }

    @Override
    public double getArea() {
        return 0.5 * height * width;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getName() {
        return name;
    }

    // Dodaj metodę setName
    public void setName(String name) {
        this.name = name;
    }

    public double getA() {
        return sideA;
    }

    public void setA(double sideA) {
        this.sideA = sideA;
    }

    public double getB() {
        return sideB;
    }

    public void setB(double sideB) {
        this.sideB = sideB;
    }

    public double getC() {
        return sideC;
    }

    public void setC(double sideC) {
        this.sideC = sideC;
    }
}
