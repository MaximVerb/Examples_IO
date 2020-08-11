package Filereader.BufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main1 {
    public static void main(String[] args) throws FileNotFoundException {
        Path aPath = Paths.get("C:\\Users\\maxim\\IdeaProjects\\Examples_IO\\src\\main\\resources\\subfolder2\\File");
        try (FileReader file = new FileReader(aPath.toFile());
             BufferedReader reader = new BufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
