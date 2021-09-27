package ex_1;

public class Main {

    public static void main(String[] args) {
        GeometricFigures[] figures = {
                new Rectangle(10, 5),
                new Quadrant(10),
                new Circle(3)
        };

        for(GeometricFigures i : figures) {
            i.getInfo();
        }
        Circle circle = new Circle(2);
        circle.setRadiusFigure(5);
        circle.getInfo();

    }
}