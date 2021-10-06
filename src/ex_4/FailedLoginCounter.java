package ex_4;

public class FailedLoginCounter {
    // class-singleton
    private static FailedLoginCounter instance;

    public static synchronized FailedLoginCounter getInstance(Account account) {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }
}
