package XML_Serialization;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Accounts {

    //specifieert de element naam voor ieder object van de klasse Account (zie: xml-file)
    //annotatie is hier verplicht want accounts is privé + heeft geen read-write eigenschappen (setters&getters)
    @XmlElement(name="account")
    private List<Account> accounts = new ArrayList<>();
    //to serialize a list, it must be declared as an instance of the class


    public List<Account> getAccounts() {
        return accounts;
    }
}
