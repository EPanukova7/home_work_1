package ex_4;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException, AccountBlockedException, WrongCredentialsException {

        Account user1 = new Account("Панюкова", "Екатерина", "Сергеевна", "23.02.2001",
                "nsu@mail.ru", "123456", true);
        Account user2 = new Account("Торопыжкин", "Владик", "Григорьевич", "26.09.2221",
                "ggg@mail.ru", "000456", true);

        FileAccountManager listOfUsers = new FileAccountManager();
        listOfUsers.register(user1);
        listOfUsers.register(user2);

        try {
            listOfUsers.login("nsu@mail.ru", "120456");
        } catch (WrongCredentialsException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listOfUsers.login("nsu@mail.ru", "120456");
        } catch (WrongCredentialsException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listOfUsers.login("nsu@mail.ru", "120456");
        } catch (WrongCredentialsException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listOfUsers.login("nsu@mail.ru", "120456");
        } catch (WrongCredentialsException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listOfUsers.login("nsu@mail.ru", "120456");
        } catch (WrongCredentialsException | AccountBlockedException ex) {
            System.out.println(ex.getMessage());
        }

        listOfUsers.removeAccount("ertyui", "fghj");
        //try {
        //    listOfUsers.login("nsu@mail.ru", "120456");
        //} catch (WrongCredentialsException | AccountBlockedException ex) {
        //    System.out.println(ex.getMessage());
        //}

        listOfUsers.removeAccount("nsu@mail.ru", "123456");

    }
}
