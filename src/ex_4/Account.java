package ex_4;

import java.util.ArrayList;
import java.util.Objects;

public class Account {
    private String lastName;
    private String firstName;
    private String patronName;
    private String birthdayDate;
    private String email;
    private String password;
    private boolean blocked;


    public Account(String lastName, String firstName, String patronName,
                   String birth, String email, String password, boolean blocked) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronName = patronName;
        this.birthdayDate = birth;
        this.email = email;
        this.password = password;
        this.blocked = false;
    }

    public Account() {
    }


    public void setLastName(String name) {
        this.lastName = name;

    }

    public void setFirstName(String firstName1) {
        this.firstName = firstName1;

    }

    public void setPatronName(String patronName1) {
        this.patronName = patronName1;

    }

    public void setBirthdayDate(String birth) {
        this.birthdayDate = birth;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public void setBlocked(boolean status) {
        this.blocked = status;

    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronName() {
        return patronName;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public boolean getAccountStatus() {
        return blocked;
    }

    public ArrayList<String> getData() {

        ArrayList<String> data = new ArrayList<String>();

        data.add(getLastName());
        data.add(getFirstName());
        data.add(getPatronName());
        data.add(getBirthdayDate());
        data.add(getEmail());
        data.add(getPassword());
        data.add("0");

        return data;
    }


    public void getInfoAll() {
        System.out.println("*** Account Information ***   ");
        System.out.println("FCS: " + lastName + " " + firstName + " " + patronName);
        System.out.println("Date of birthday: " + birthdayDate);
        System.out.println("Email address: " + email);
        System.out.println("***************************\n");

    }

}


