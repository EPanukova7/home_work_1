package ex_2;

public class Main {
    // Общий класс для добавления студентов
    public static void main(String[] args) {

        Student newStudent0 = new Student(12343, "Екатерина", "Панюкова", 20, 4.7);
        Student newStudent1 = new Student(12345, "Влад", "Киров", 19, 4.8);
        Student newStudent2 = new Student(12346, "Антон", "Попов", 20, 3.6);
        newStudent0.printInfo();

        Group group = new Group("cats");
        group.addStudent(newStudent0);
        group.addStudent(newStudent1);
        group.addStudent(newStudent2);
        System.out.println();
        System.out.println(group.getAllObjects());
        System.out.println(group.getNameGroup());
        group.getByNumber(12343);
        group.deleteStudent(newStudent0);
        System.out.println(group.getAllObjects());
        System.out.println(group.getCountByAge());
        group.getByMinScore(4);
        group.printInfo();
        }
    }


