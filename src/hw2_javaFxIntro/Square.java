package hw2_javaFxIntro;

public class Square extends Shape{

    private double areaOfSide;
    private double side;

    public Square(double side) {
        super();
        this.side = side;
        areaOfSide = this.side * this.side;
    }

    @Override
    public double getArea() {
        areaOfSide = this.side * this.side;
        return areaOfSide;
    }

    public void setSide(double side) {

        this.side = side;
    }
}
