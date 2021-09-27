package ex_2;

import java.util.*;

public class Group {
    // хранение коллекции студентов
    private String groupNumber;
    private ArrayList<Student> aStudents;

    public Group(String group_Number) {
        groupNumber = group_Number;
        aStudents = new ArrayList<Student>();
    }

    public String getNameGroup() {
        // получение номера группы
        return groupNumber;
    }

    public ArrayList<Student> getAllObjects() {
        // для меня метод!
        if (aStudents == null || aStudents.size() == 0) {
            System.out.println("Список студентов пуст!");
        }
        return aStudents;
    }

    public void addStudent(Student newStudent) {
        // добавление студента в группу
        aStudents.add(newStudent);
        System.out.println("Студент: " + newStudent.lastName + " " + newStudent.name + " добавлен.");
    }

    public Student getByNumber(int numberStud) {
        // получить студента по номеру зачетки книжки
        if (aStudents != null) {
            for (Student student : aStudents) {
                if (student.number == numberStud) {
                    student.printInfo();
                    return student;
                }
            }
        } else {
            System.out.println("Список студентов пуст!");
        }
        return null;
    }

    public void deleteStudent(Student student) {
        // удалить студента из группы
        aStudents.remove(student);

//        try {
//            int count = 0;
//            if (aStudents != null) {
//                for (Student student : aStudents) {
//                    if (student.number == numberStud) {
//                        aStudents.remove(count);
//                        System.out.println("Студент" + student.getNumberStudent() + " удален из списка группы.");
//                    }
//                    count++;
//                }
//            } else {
//                System.out.println("Список студентов пуст!");
//            }
//        } catch (Exception e) {
//            System.out.println("ошибка с удалением!");
//        }
    }

    public ArrayList<Student> getAll() {
        // получить всех студентов группы
        return aStudents;
    }

    public Map<Integer, Integer> getCountByAge() {
        //получить мапу, в которой ключ - возраст, а значение - количество студентов этого возраста
        ArrayList<Integer> ageStud = new ArrayList<>();
        Map<Integer, Integer> mapStudentAge = new HashMap<>();
        int age_;
        for (Student student : aStudents) {
            age_ = student.getAge();
            ageStud.add(age_);

        }
        Collections.sort(ageStud);
        for (Integer i : ageStud) {
            if (mapStudentAge.containsKey(i)) {
                mapStudentAge.put(i, mapStudentAge.get(i) + 1);
                //System.out.println(mapStudentAge.get(i));
            } else {
                mapStudentAge.put(i, 1);
            }
        }
        return mapStudentAge;
    }


    public List<Student> getByMinScore(double score) {
        // получить список студентов, средний балл которых >= заданного
        ArrayList<Student> scoreStuds = new ArrayList<>();

        if (aStudents != null) {
            for (Student student : aStudents) {
                if (student.averageScore >= score) {
                    scoreStuds.add(student);
                }
            }
            System.out.println("Список студентов с средним баллом выше " + score + " :");
            for (Student student : scoreStuds) {
                System.out.println(student.lastName + " " + student.name);
            }

        } else {
            System.out.println("Список студентов пуст!");
        }
        return scoreStuds;
    }

    public void printInfo() {
        //
        if (aStudents != null) {
            System.out.println("Все студенты группы: ");
            for (Student student : aStudents) {
                student.printInfo();
            }
        } else {
            System.out.println("Список студентов пуст!");
        }
    }
}
