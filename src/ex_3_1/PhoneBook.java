package ex_3_1;

import java.util.ArrayList;

public class PhoneBook {

    private ArrayList<Record> phoneBook;

    public PhoneBook() {
        phoneBook = new ArrayList<>();
    }
    public ArrayList<Record> getAllRecords() {
        // возвращает список из всех записей справочника
        return phoneBook;
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
        // сохраняет в справочнике новую запись, если уже есть,
        // то проверяемое исключение PhoneNumberAlreadyExists
        if (phoneBook.contains(record)) {
            throw new PhoneNumberAlreadyExists("Запись уже есть!");
        } else {
            phoneBook.add(record);
            //System.out.println(phoneBook);
        }
    }

    public void updateRecord(Record record) throws RecordNotValid{
        // обновляет запись в справочнике, если нет, то RecordNotFound
        if (phoneBook.contains(record)) {
            if ((record.name == null || record.name.length() == 0) ||
                    (record.phoneNumber == null || record.phoneNumber.length() == 0)) {
                throw new RecordNotValid("Запись некорректна!");
            } else {
                phoneBook.set(phoneBook.indexOf(record), record);
            }
        } else {
            throw new RecordNotFound("Запись не найдена!");
        }
        }

    public void deleteRecord(long idFind) {
        // удаляет запись из справочника по идентификатору,
        // если нет, то RecordNotFound
        for (Record record : phoneBook) {
            if (record.id == idFind) {
                phoneBook.remove(record);
                return;
            }
        }

        throw new RecordNotFound("Запись не найдена!");
    }
}


