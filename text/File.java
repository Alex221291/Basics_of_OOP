package Basic_of_OOP.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Задача 1.
//Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//вывести на консоль содержимое, дополнить, удалить.
public class File {
    private String name;
    private String extension;
    Directory directory;

    public File(String name, String extension, Directory directory) {
        this.name = name;
        this.extension = extension;
        this.directory = directory;
    }

    public void createFile() throws IOException {
        Path pathFile = Paths.get(directory.getRootDirectory() + "\\" + directory.getNameDirectory() + "\\" + name + "." + extension);
        directory.createDirectory();
        if(!Files.exists(pathFile)) {
            Files.createFile(pathFile);
            System.out.println("file " + name + "." + extension +" created");
        }
        else {
            System.out.println("file " + name + "." + extension +" not created");
        }
    }

    public void deleteFile () throws IOException {
        Path pathFile = Paths.get(directory.getRootDirectory() + "\\" + directory.getNameDirectory() + "\\" + name + "." + extension);
        if (Files.exists(pathFile)) {
            Files.delete(pathFile);
            System.out.println("file " + name + "." + extension +" deleted");
        }
        else {
            System.out.println("file " + name + "." + extension +" not deleted");
        }
    }

    public void renameFile(String newName, String newExtension) {
        Path pathFile = Paths.get(directory.getRootDirectory() + "\\" + directory.getNameDirectory() + "\\" + name + "." + extension);
        Path pathRenameFile = Paths.get(directory.getRootDirectory() + "\\" + directory.getNameDirectory() + "\\" + newName + "." + newExtension);
        if (Files.exists(pathFile) && !Files.exists(pathRenameFile)) {
            if (new java.io.File(pathFile.toString()).renameTo(new java.io.File(pathRenameFile.toString()))) {
                setName(newName);
                setExtension(newExtension);
                System.out.println("file " + name + "." + extension +"renamed to " + newName + "." + newExtension);
            }
            else {
                System.out.println("file not renamed");
            }
        }
        else {
            System.out.println("file " + name + "." + extension + " does not exist or file " + newName + "." + newExtension + " exists");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }
}
