package hw2_javaFxIntro;

public class Triangle extends Shape{

    private double areaOfSide;
    private double side;

    public Triangle(double side) {
        super();
        this.side = side;
        areaOfSide = this.side * this.side  / 2;
    }

    @Override
    public double getArea() {
        areaOfSide = this.side * this.side  / 2;
        return areaOfSide;
    }

    public void setSide(double side) {

        this.side = side;
    }
}
