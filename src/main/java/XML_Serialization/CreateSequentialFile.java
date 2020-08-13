package XML_Serialization;

import javax.xml.bind.JAXB;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateSequentialFile {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\maxim\\IdeaProjects\\Examples_IO\\src\\main\\resources\\subfolder3\\clients.xml");
        //open clients.xml, schrijf objecten ernaartoe, terug sluiten
        try (BufferedWriter output = Files.newBufferedWriter(path)) {
            Scanner input = new Scanner(System.in);

            Accounts accounts = new Accounts(); //stores the accounts before xml serialization

            System.out.printf("%s%n%s%n","Enter account number,first nam, last name and balance",
                    "Enter end-of-file input to end input");

            while(input.hasNext()) { //loop until end of file indicator
                try {
                    //create new record
                    Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());

                    //add to Account list
                    accounts.getAccounts().add(record);
                }

                catch (NoSuchElementException nse) {
                    System.err.println("Invalid input. Please try again");
                    input.nextLine(); //discard input so user can try again
                }
            }
            //Write AccountList's XML to output
            JAXB.marshal(accounts,output);
        }
        catch (IOException e) {
            System.out.println("error opening file");
        }
    }
}
