package SequentialFile.ReadingData;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\maxim\\IdeaProjects\\Examples_IO\\src\\main\\resources\\subfolder3\\clients.txt");
        try(Scanner input = new Scanner(path.toFile())) {
            //het Scanner object start vanaf het begin van de file, teruggaan in dezelfde file gaat dus niet, tenzij
            //je de file sluit en opnieuw heropent en terug vanaf opnieuw de data begint door te nemen
            System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First name", "Last name", "Balance");
            while (input.hasNext()) { //while there is more to read
                System.out.printf("%-10s%-12s%-12s%10s%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
            }
        }
        catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
