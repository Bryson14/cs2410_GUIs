package hw2_javaFxIntro;

public class Pyramid extends Shape{

    private double areaOfSide;
    private double side;

    public Pyramid(double side) {
        super();
        this.side = side;
        areaOfSide = side * side / 2;
    }

    @Override
    public double getArea() {
        areaOfSide = this.side * this.side / 2;
        return areaOfSide * 4;
    }

    public void setSide(double side) {

        this.side = side;
    }
}
