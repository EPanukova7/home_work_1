package ex_1;

public class Rectangle extends GeometricFigures {
    private static final String name = "Rectangle";
    private double width;
    private double height;

    public Rectangle(double width_, double height_) {
        this.width = width_;
        this.height = height_;
    }

    @Override
    public String getNameFigure() {
        return name;
    }

    @Override
    public void getInfo() {
        System.out.println("-----------------------");
        System.out.println(name);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + getAreaFigure());
        System.out.println("Perimeter: " + getPerimeterFigure() + "\n");
    }

    @Override
    public double getAreaFigure() {
        return Math.floor(width*height);
    }

    @Override
    public double getPerimeterFigure() {
        return Math.floor(2*(width+height));
    }

    public void setWidthFigure(double width_) {
        this.width = width_;
    }

    public void setHeightFigure(double height_) {
        this.height = height_;
    }
}
