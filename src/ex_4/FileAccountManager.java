package ex_4;

import java.io.IOException;
import java.util.*;

public class FileAccountManager extends Throwable implements AccountManager {

    private Map<String, Account> allAccounts;
    private final FileService fileService = FileService.getInstance();
    private final FailedLoginCounter failedLoginCounter = FailedLoginCounter.getInstance((HashMap<String, Account>) allAccounts);

    public FileAccountManager() {
        allAccounts = new HashMap<>();
    }

    public void setAllAccounts(HashMap<String, Account> allAccounts) {
        this.allAccounts = allAccounts;
    }

    @Override
    public void register(Account account) throws IOException {
        if (allAccounts.containsKey(account.getEmail())) {
            throw new AccountAlreadyExistsException("Account " + account.getEmail()+ " already exists!");
        }
        account.setBlocked(true);
        allAccounts.put(account.getEmail(), account);
        fileService.writeDataOfUsers((HashMap<String, Account>) allAccounts);
        System.out.println("Account " + account.getEmail()+" created!");
    }

    @Override
    public Account login(String email, String password) throws WrongCredentialsException,
            AccountBlockedException, IOException {

        if (email.endsWith("@mail.ru") || email.endsWith("@gmail.ru")) {
            ArrayList<Account> arrayListAccounts = fileService.readDataOfUsers();
            HashMap<String, Account> newAccounts = new HashMap<>();

            for (Account account: arrayListAccounts) {newAccounts.put(account.getEmail(), account);}

            if (newAccounts.containsKey(email)) {
                Account user = newAccounts.get(email);
                user.setBlocked(failedLoginCounter.checkBlocked(user));

                if (Objects.equals(user.getPassword(), password) && user.getAccountStatus()) {
                    if (!newAccounts.isEmpty()) {
                        fileService.writeDataOfUsers(newAccounts);
                    } else {
                        fileService.cleanFile();}
                    user.getInfoAll();
                    return user;}

                else if (Objects.equals(user.getPassword(), password) && !user.getAccountStatus()) {
                    if (!newAccounts.isEmpty()) {
                        fileService.writeDataOfUsers(newAccounts);
                    } else {
                        fileService.cleanFile();}
                    throw new AccountBlockedException("Account "+user.getEmail()+" is blocked!");
                } else if (!Objects.equals(user.getPassword(), password) && user.getAccountStatus()) {

                    if (!newAccounts.isEmpty()) {
                        fileService.writeDataOfUsers(newAccounts);
                    } else {
                        fileService.cleanFile();
                    }
                    throw new WrongCredentialsException("Wrong password! (0)");

                } else if (!Objects.equals(user.getPassword(), password) && !user.getAccountStatus()) {
                    if (!newAccounts.isEmpty()) {
                        fileService.writeDataOfUsers(newAccounts);
                    } else {
                        fileService.cleanFile();
                    }
                    throw new AccountBlockedException("Account "+user.getEmail()+" is blocked!");
                }
            } else {
                throw new WrongCredentialsException("Wrong login (1)!");
            }
        } else {
            throw new WrongCredentialsException("Wrong login (2)!");
        }
        return null;
    }

    @Override
    public void removeAccount(String email, String password) throws WrongCredentialsException, IOException {
        ArrayList<Account> arrayListAccounts = fileService.readDataOfUsers();
        HashMap<String, Account> newAccounts = new HashMap<>();

        if (arrayListAccounts == null) {
            System.out.println("List is empty!");
            return;}

        for (Account account: arrayListAccounts) {
            newAccounts.put(account.getEmail(), account);
        }

        Account user = newAccounts.get(email);

        if ((Objects.equals(user.getEmail(), email) & Objects.equals(user.getPassword(), password))
                & newAccounts.containsKey(email)) {
            newAccounts.remove(email, user);
            System.out.println("Account " + user.getEmail() + " is invalid!");

            if (!newAccounts.isEmpty()) {
                fileService.writeDataOfUsers(newAccounts);
            } else {
                fileService.cleanFile();
            }
        } else {
            throw new WrongCredentialsException("Wrong login or password! Try again!");
        }

    }
}
