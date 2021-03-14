package Basic_of_OOP.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

//Задача 1.
//Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//вывести на консоль содержимое, дополнить, удалить.
public class Directory {
    private String rootDirectory;
    private String nameDirectory;
    ArrayList<File> files;

    public Directory(String rootDirectory, String nameDirectory, ArrayList<File> files) {
        this.rootDirectory = rootDirectory;
        this.nameDirectory = nameDirectory;
        this.files = files;
    }

    public void createDirectory() throws IOException {
        Path pathDirectory = Paths.get(rootDirectory + "\\" + nameDirectory);
        if (!Files.exists(pathDirectory)) {
            Files.createDirectory(pathDirectory);
            System.out.println("directory " + nameDirectory + " created");
        }
        else {
            System.out.println("directory " + nameDirectory + " is already there");
        }
    }

    public String getRootDirectory() {
        return rootDirectory;
    }

    public void setRootDirectory(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public String getNameDirectory() {
        return nameDirectory;
    }

    public void setNameDirectory(String nameDirectory) {
        this.nameDirectory = nameDirectory;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }
}
