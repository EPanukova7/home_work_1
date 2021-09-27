package ex_1;

public class Circle extends GeometricFigures {
    private static final String name = "Circle";
    private double radius;


    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getNameFigure() {
        return name;
    }

    @Override
    public void getInfo() {
        System.out.println("-----------------------");
        System.out.println(name);
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getAreaFigure());
        System.out.println("Perimeter: " + getPerimeterFigure() + "\n");
    }

    @Override
    public double getAreaFigure() {
        return Math.floor(Math.PI*Math.pow(radius, 2));
    }

    @Override
    public double getPerimeterFigure() {
        return Math.floor(2*radius*Math.PI);
    }

    public void setRadiusFigure(double newRadius) {
        this.radius = newRadius;
    }
}


