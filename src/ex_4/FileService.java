package ex_4;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileService {
    // class-singleton
    private static FileService instance;

    public static synchronized FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    public static void main(String[] args) throws Exception
    {
        //Создаем поток-чтения
        FileInputStream inputStream = new FileInputStream("c:/data.cvs");
        // Создаем поток-записи
        FileOutputStream outputStream = new FileOutputStream("c:/result.cvs");

        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            outputStream.write(data); // и записать его во второй поток
        }

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }

}
