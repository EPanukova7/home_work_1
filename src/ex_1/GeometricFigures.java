package ex_1;

// Построить систему классов для описания плоских геометрических фигур:
// круга, квадрата, прямоугольника. Предусмотреть
// методы для создания объектов, вывода информации о фигуре,
// изменения размеров и вычисления площади, периметра.

public abstract class GeometricFigures {
    // класс для создание объекта геометрическая фигура
    public abstract String getNameFigure();
    public abstract void getInfo();
    public abstract double getAreaFigure();
    public abstract double getPerimeterFigure();
}
