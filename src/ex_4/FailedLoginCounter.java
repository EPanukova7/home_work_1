package ex_4;

import java.util.HashMap;
import java.util.Objects;

public class FailedLoginCounter {
    // class-singleton
    private static FailedLoginCounter instance;
    private HashMap<String, Integer> infoBlockAccounts = new HashMap<String, Integer>();
    private Integer index;
    private Integer counter;

    private FailedLoginCounter(HashMap<String, Account> allAccounts) {
        this.index = 0;
        this.counter = 1;

        if (allAccounts != null) {
           for (Account acc: allAccounts.values()) {
               assert false;
               this.infoBlockAccounts.put(acc.getEmail(), 0);
           }
        }
    }

    private FailedLoginCounter() {}

    public static synchronized FailedLoginCounter getInstance(HashMap<String, Account> allAccounts) {
        if (instance == null) {
            instance = new FailedLoginCounter(allAccounts);

        }
        return instance;
    }

    public boolean checkBlocked(Account account) {
        //System.out.println(infoBlockAccounts);
        Boolean result = true;
        if (!infoBlockAccounts.containsKey(account.getEmail())) {
            if (account.getAccountStatus()) {
                index = 0;
                counter = 1;
                infoBlockAccounts.put(account.getEmail(), counter);
                //System.out.println("STATUS instance: " + index);
            } else {
                System.out.println("Account almost blocked!");
            }
        } else {
            for (String elem : infoBlockAccounts.keySet()) {
                if (Objects.equals(elem, account.getEmail())) {
                    counter++;
                    //System.out.println("OOO " + counter);
                }
            }

            if (counter > 4) {
                account.setBlocked(false);
                //System.out.println("STATUS false: " + account.getAccountStatus());
                infoBlockAccounts.remove(account.getEmail());
                infoBlockAccounts.put(account.getEmail(), counter);
                counter = 0;
                result = false;
            } else {
                Integer now = infoBlockAccounts.get(account.getEmail());
                //System.out.println("STATUS double: " + counter);
                infoBlockAccounts.remove(account.getEmail());
                infoBlockAccounts.put(account.getEmail(), counter);
            }
        }
        return result;
    }
}
