package ex_4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException, AccountBlockedException, WrongCredentialsException {

        Account user1 = new Account("Панюкова", "Екатерина", "Сергеевна", "23.02.2001",
                "nsu@mail.ru", "123456", true);
        Account user2 = new Account("Торопыжкин", "Владик", "Григорьевич", "26.09.2221",
                "ggg@mail.ru", "000456", true);

        FileAccountManager listOfUsers = new FileAccountManager();
        listOfUsers.register(user1);
        listOfUsers.register(user2);

        //System.out.println(listOfUsers.getAllAccounts());
        listOfUsers.login("nsu@mail.ru", "123456");

        listOfUsers.removeAccount("nsu@mail.ru", "123456");

    }
}
