package ex_1;

public class Quadrant extends GeometricFigures {
    private static final String name = "Quadrant";
    private double sideQuad;

    public Quadrant(double side_) {

        this.sideQuad = side_;
    }

    @Override
    public String getNameFigure() {

        return name;
    }

    @Override
    public void getInfo() {
        System.out.println("-----------------------");
        System.out.println(name);
        System.out.println("Side: " + sideQuad);
        System.out.println("Area: " + getAreaFigure());
        System.out.println("Perimeter: " + getPerimeterFigure() + "\n");
    }

    @Override
    public double getAreaFigure() {
        return Math.floor(Math.pow(sideQuad, 2));
    }

    @Override
    public double getPerimeterFigure() {
        return Math.floor(4*sideQuad);
    }

    public void setSizeFigure(double size) {
        this.sideQuad = size;
    }
}