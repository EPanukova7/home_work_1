package ex_4;

public class Account {
    private String informationAboutPerson;
    private String birthdayDate;
    private String email;
    private String password;
    private boolean blocked;

    public Account(String info, String birth, String mail, String password, boolean blocked) {
        this.informationAboutPerson = info;
        this.birthdayDate = birth;
        this.email = mail;
        this.password = password;
        this.blocked = false;

    }

    public void setInformationAboutPerson(String info) {
        this.informationAboutPerson = info;
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
        this.blocked = status || !this.blocked;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getInformationAboutPerson() {
        return informationAboutPerson;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public boolean getAccountStatus() {
        return blocked;
    }

    public void getInfoAll() {
        System.out.println("    *** Account Information ***   ");
        System.out.println("FCS: " + informationAboutPerson);
        System.out.println("Date of birthday: " + birthdayDate);
        System.out.println("Email address: " + email);

    }
}


