package hw2_javaFxIntro;

import java.util.ArrayList;
import java.util.Random;

public class TestShape {

    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<>();

        Cube c1 = new Cube(5.0);
        Cube c2 = new Cube(658.25);
        Square s1 = new Square(154.2);
        Square s2 = new Square(12.3);
        Pyramid p1 = new Pyramid(3.2);
        Pyramid p2 = new Pyramid(.025);
        Triangle t1 = new Triangle(51.2);
        Triangle t2 = new Triangle(3.36);

        shapes.add(c1);
        shapes.add(c2);
        shapes.add(s1);
        shapes.add(s2);
        shapes.add(t1);
        shapes.add(t2);
        shapes.add(p1);
        shapes.add(p2);

        for (Shape s : shapes) {
            System.out.println(s.getClass() + " " + s.getArea());
        }
    }
}
