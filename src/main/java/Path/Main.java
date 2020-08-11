package Path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main{
    public static void main(String[] args) {
        //om de huidige map aan te duiden .
        //de bovenliggende map ..
        //een object van de interface Path stelt een pad voor in het bestandssysteem
        Path p1 = Paths.get("C:\\Users\\maxim\\IdeaProjects");
        System.out.println(p1.getRoot());   //geeft de basismap

        Path p2 = p1.resolve("Examples_IO")
                .resolve("src")
                .resolve("main")
                .resolve("resources")
                .resolve("subfolder1/File1");
        System.out.println(p2);

        Path p3 = Paths.get("subfolder1/File1");
        System.out.println(p3.toAbsolutePath());

        Path p4 = Paths.get("src/main/resources/subfolder1/File1");
        System.out.println(p4.getParent()); //geeft het pad voorafgaand aan het laatste
        System.out.println(p4.getFileName());//geeft laatste bestandsnaam

        Path p5 = Paths.get("C:\\Users\\maxim\\IdeaProjects\\Examples_IO\\src\\main\\resources\\subfolder2\\File2");
        for(Path p : p5) {
            System.out.print(p+"\\");
        }
        System.out.println();

        Path p6 = p5.relativize(p2);                    //het relatieve path van het ene bestand tegenover het andere
                                                        //met andere woorden, vanaf welke map verschillen ze
        System.out.println(p6);
    }
}
