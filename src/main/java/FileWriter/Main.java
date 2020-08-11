package FileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path aPath = Paths.get("C:\\Users\\maxim\\IdeaProjects\\Examples_IO\\src\\main\\resources\\subfolder2\\File");
        try (FileWriter file = new FileWriter(aPath.toFile()))  //de string erin kopiëren werkt niet, tenzij je
                                                                //String.valueOf() gebruikt
        {
            file.write("Hello");
            file.write(" There Champ");
        }

        catch (IOException e) {
            System.out.println("Oops, something went wrong");
            System.out.println(e.getMessage());
        }
    }
}
