package hw2_javaFxIntro;

public class Cube extends Shape{

    private double areaOfSide;
    private double side;

    public Cube(double side) {
        super();
        this.side = side;
        areaOfSide = side * side;
    }

    @Override
    public double getArea() {
        areaOfSide = side * side;
        return areaOfSide * 6;
    }

    public void setSide(double side) {

        this.side = side;
    }
}
