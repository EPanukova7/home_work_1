package ex_3_1;

public class MyExceptionClass extends Exception {
    // test
    public  MyExceptionClass(String message){
        super(message);
    }
}

class PhoneNumberAlreadyExists extends MyExceptionClass {

    public PhoneNumberAlreadyExists (String message) {
        super(message);
        String a = "";
    }
}

class RecordNotFound extends Error {

    public RecordNotFound (String message) {
        super(message);
    }
}

class RecordNotValid extends MyExceptionClass {

    public RecordNotValid (String message) {
        super(message);
    }
}

