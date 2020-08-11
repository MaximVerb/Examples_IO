package Files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Files is een utility klasse, we kunnen er geen objecten van maken
        Path aPath = Paths.get("C:\\Users\\maxim\\IdeaProjects\\Examples_IO\\src\\main\\resources\\subfolder3\\File4.txt");
        try {
            Files.createDirectories(aPath.getParent()); //maakt eventuele ontbrekende directories
            if (Files.notExists(aPath)) {
                Files.createFile(aPath); //maakt een bestand aan in die locatie
                System.out.println("You created a file");
            }

            //Write a few lines of text to the file (for huge amounts of text, use BufferedWriter)
            List<String> lines = new ArrayList<>();
            lines.add("Hello ");
            lines.add("World");
            Files.write(aPath, lines, Charset.defaultCharset(), StandardOpenOption.APPEND); //3de en 4de parameter?
            System.out.println(Files.readAllLines(aPath,Charset.defaultCharset()));

            //retrieve attributes of file
            DosFileAttributes attrs = Files.readAttributes(aPath,DosFileAttributes.class);

            System.out.println(attrs.isArchive());
            System.out.println(attrs.isHidden());
            System.out.println(attrs.creationTime());
            System.out.println(attrs.lastAccessTime());
            System.out.println(attrs.lastModifiedTime());
            System.out.println(attrs.isReadOnly());
            System.out.println(attrs.isDirectory());
            System.out.println(attrs.isRegularFile());

            //copy a file
            Path aPath2 = Paths.get("C:\\Users\\maxim\\IdeaProjects\\Examples_IO\\src\\main\\resources\\subfolder2\\File2");
            Files.copy(aPath,aPath2, StandardCopyOption.REPLACE_EXISTING);

            //delete a file
            Files.deleteIfExists(aPath);

            //de file-naam veranderen
            Path aPath3 = Paths.get("C:\\Users\\maxim\\IdeaProjects\\Examples_IO\\src\\main\\resources\\subfolder2\\File");
            Files.move(aPath2,aPath3);

            //wie eigenaar is van de file
            FileOwnerAttributeView fileOwnerAttributeView = Files.getFileAttributeView(aPath3, FileOwnerAttributeView.class);
            UserPrincipal userPrincipal = fileOwnerAttributeView.getOwner();
            System.out.println("File Owner: " + userPrincipal.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
