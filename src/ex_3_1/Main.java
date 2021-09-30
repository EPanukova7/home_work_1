package ex_3_1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws PhoneNumberAlreadyExists, RecordNotValid {

        Record firstRecord = new Record("89130912500", "Екатерина Панюкова");
        Record secondRecord = new Record("89607864277", "Анастасия Архипова");
        Record thirdRecord = new Record(null, "Людмила Степанова");
        Record forthRecord = new Record("12345", "dwaefraerf");

        PhoneBook book = new PhoneBook();

        // проверка для создания новой записи
        book.createRecord(firstRecord);
        try {
            book.createRecord(firstRecord);
        } catch (PhoneNumberAlreadyExists ex) {
            System.out.println(ex);
        }

        // проверка на обновление списка контактов
        book.createRecord(thirdRecord);
        try {
            book.updateRecord(thirdRecord);
        } catch (RecordNotValid e) {
            System.out.println(e);
        }
        // проверка на обновление несуществующей записи
        //book.updateRecord(secondRecord);

        ArrayList<Record> bookNew = book.getAllRecords();
        System.out.println(bookNew);

        // проверка на удаление записи
        long idParam = secondRecord.id;
        book.deleteRecord(idParam);

        ArrayList<Record> bookNew0 = book.getAllRecords();
        System.out.println(bookNew0);

        book.deleteRecord(forthRecord.id);


    }
}
