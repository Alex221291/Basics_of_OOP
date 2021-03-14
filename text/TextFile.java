package Basic_of_OOP.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

//Задача 1.
//Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//вывести на консоль содержимое, дополнить, удалить.
public class TextFile extends File {

    public TextFile(String name, String extension, Directory directory) {
        super(name, extension, directory);
    }

    public void readText() throws IOException {
        Path pathTextFile = Paths.get(getDirectory().getRootDirectory() + "\\" + getDirectory().getNameDirectory() + "\\" + getName() + "." + getExtension());
        if (Files.exists(pathTextFile)) {
            System.out.println(getName() + "." + getExtension() + ":");
            List<String> textLines = Files.readAllLines(pathTextFile);
            for (String s: textLines) {
                System.out.println(s);
            }
        }
        else {
            System.out.println("file " + getName() + "." + getExtension() + " not found");
        }
    }

    public void writeText(String text) throws IOException {
        List<String> textLines = Collections.singletonList(text);
        Path pathTextFile = Paths.get(getDirectory().getRootDirectory() + "\\" + getDirectory().getNameDirectory() + "\\" + getName() + "." + getExtension());
        if (Files.exists(pathTextFile)) {
            Files.write(pathTextFile, textLines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            System.out.println("line is added to the file");
        }
        else {
            System.out.println("file " + getName() + "." + getExtension() + " not found");
        }
    }
}
