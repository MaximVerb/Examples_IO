package XML_Serialization;

public class Account {
    private int accNmr;
    private String firstName;
    private String lastName;
    private double balance;

    public Account() { this(0,"","",0.0); }
    //moet een lege constructor hebben om objecten te lezen uit een xml-bestand

    public Account(int accNmr, String firstName, String lastName, double balance) {
        this.accNmr = accNmr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public int getAccNmr() {
        return accNmr;
    }

    public void setAccNmr(int accNmr) {
        this.accNmr = accNmr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
