package Basic_of_OOP.text;

import java.io.IOException;
import java.util.ArrayList;

//Задача 1.
//Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//вывести на консоль содержимое, дополнить, удалить.
public class Main {
    public static void main(String []args) throws IOException {
        TextFile tFile = new TextFile("test", "txt", new Directory("C:\\", "temp", new ArrayList<File>()));
        tFile.createFile();
        tFile.writeText("Hello world!");
        tFile.readText();
        tFile.renameFile("Java", "txt");
        tFile.deleteFile();
    }
}
