package ex_4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class FileService {
    // class-singleton
    private static FileService instance;


    public static synchronized FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    private FileService() {}

    public void cleanFile() throws IOException {
        String csvFilename = "C:\\Users\\Zver\\IdeaProjects\\home_work_1\\src\\ex_4\\DATA.csv";

        try (BufferedWriter fileZero = new BufferedWriter(new FileWriter(csvFilename))) {
            fileZero.write("");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void writeDataOfUsers(HashMap<String, Account> accounts) {
        StringBuilder dataOfUsers = new StringBuilder();
        String csvFilename = "C:\\Users\\Zver\\IdeaProjects\\home_work_1\\src\\ex_4\\DATA.csv";
        try {
            BufferedWriter fileOut = new BufferedWriter(new FileWriter(csvFilename));

            for (Account account: accounts.values()) {
                for (String elem : account.getData()) {
                    dataOfUsers.append(elem);
                    dataOfUsers.append("/");
                }
                dataOfUsers.append("\n");
            }
            //System.out.println(dataOfUsers);
            fileOut.write(String.valueOf(dataOfUsers));
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public ArrayList<Account> readDataOfUsers() throws IOException {
        String csvFilename = "C:\\Users\\Zver\\IdeaProjects\\home_work_1\\src\\ex_4\\DATA.csv";

        ArrayList<Account> userMap = new ArrayList<>();
        BufferedReader fileIn = new BufferedReader(new FileReader(csvFilename));

        Scanner scanner = null;
        String line = null;
        int index = 0;

        try {
            while ((line = fileIn.readLine()) != null) {
                Account account = new Account();
                scanner = new Scanner(line);
                scanner.useDelimiter("/");

                while (scanner.hasNext()) {
                    String user = scanner.next();
                    if (index == 0)
                        account.setLastName(user);
                    else if (index == 1)
                        account.setFirstName(user);
                    else if (index == 2)
                        account.setPatronName(user);
                    else if (index == 3)
                        account.setBirthdayDate(user);
                    else if (index == 4)
                        account.setEmail(user);
                    else if (index == 5)
                        account.setPassword(user);
                    else if (index == 6) {
                        if (Objects.equals(user, "-1")) {
                            account.setBlocked(false);
                        } else {
                            account.setBlocked(true);
                        }
                    }
                    else System.out.println("Uncorrected information!");
                    index ++;
                }
                index = 0;
                userMap.add(account);
            }
            fileIn.close();

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return userMap;
    }
}
