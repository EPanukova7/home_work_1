package ex_2;

public class Student {
    public String name;
    public int number;
    public String lastName;
    public int age;
    public double averageScore;

    public Student(int number_, String name_, String lastName_, int age_, double averageScore_) {
        // создаем студента
        this.number = number_;
        this.name = name_;
        this.lastName = lastName_;
        this.age = age_;
        this.averageScore = averageScore_;
    }
    public int getNumberStudent() {

        return number;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("_________________________");
        System.out.println("Номер зачетки: " + number);
        System.out.println("Ф.И.: " + lastName + " " + name);
        System.out.println("Возраст: " + age + " лет");
        System.out.println("Средний балл: " + averageScore);
        System.out.println("");
        System.out.println("_________________________");
    }
}
