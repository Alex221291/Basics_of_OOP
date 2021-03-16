package Basic_of_OOP.dragon;

import java.math.BigDecimal;
import java.util.Scanner;

//Задача 4.
//Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Приложение должно быть объектно-, а не процедурно-ориентированным.
//• Каждый класс должен иметь отражающее смысл название и информативный состав.
//• Наследование должно применяться только тогда, когда это имеет смысл.
//• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//• Классы должны быть грамотно разложены по пакетам.
//• Консольное меню должно быть минимальным.
//• Для хранения данных можно использовать файлы.
//Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
//дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
//выбора сокровищ на заданную сумму.
public class Researcher {
    private Cave cave;

    public Researcher(Cave cave) {
        this.cave = cave;
    }

    public void research() {
       boolean exit = true;
        while(exit) {
            System.out.println("\nMenu:\n" +
                    "1-View treasures\n" +
                    "2-The most precious treasure\n" +
                    "3-Collect treasures for the amount of\n" +
                    "4-exit\n");
            System.out.print("Enter the command:\t");
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    cave.allTreasures();
                    break;
                case 2:
                    cave.mostPreciousTreasure();
                    break;
                case 3:
                    System.out.print("Enter sum:\t");
                    cave.treasuresInAmount(BigDecimal.valueOf(new Scanner(System.in).nextDouble()));
                    break;
                case 4:
                    exit  = false;
                    System.out.println("The end.");
                    break;
                default:
                    System.out.println("Invalid command. Repeat.");
                    break;
            }

        }
    }

    public Cave getCave() {
        return cave;
    }

    public void setCave(Cave cave) {
        this.cave = cave;
    }
}
