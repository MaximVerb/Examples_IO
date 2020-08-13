package SequentialFile.OutputtingData;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
    public static void main(String[] args) {
        //will output data, if file already exists, will overwrite it
        Path path = Paths.get("C:\\Users\\maxim\\IdeaProjects\\Examples_IO\\src\\main\\resources\\subfolder3\\clients.txt");
        try (Formatter output = new Formatter(path.toFile())) {
            Scanner input = new Scanner(System.in); //prompt input from user
            System.out.printf("%s%n%s%n","Enter account number, first name, last name and balance.",
                    "Enter the file-ender if you want to terminate the input");

            while(input.hasNext()) { //loop util end of file indicator
                try {
                    output.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
                }
                catch (NoSuchElementException nse) {
                    System.err.println("Invalid input. Please try again");
                    input.nextLine(); //discard input so user can try again
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
