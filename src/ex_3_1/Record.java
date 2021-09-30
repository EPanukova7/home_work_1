package ex_3_1;

public class Record {

    protected long id ;
    protected String phoneNumber = null;
    protected String name = null;

    protected long count = 1111;

    public Record(String phoneNumber , String name) {
        //Random random = new Random();

        //this.id = random.nextLong();
        this.id = count +1;
        this.phoneNumber = phoneNumber ;
        this.name = name;
    }

    public Record() {
    }

    public void printInfo() {
        System.out.println(id);
        System.out.println(phoneNumber);
        System.out.println(name);
    }

}
