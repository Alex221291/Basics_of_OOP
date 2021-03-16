package Basic_of_OOP.dragon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

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
public class Cave {

    private ArrayList<Treasure> treasures = new ArrayList<>();

    public Cave() {
        for (int i = 0; i < 100; i++){
            treasures.add(new Treasure(TreasureType.values()[new Random().nextInt(TreasureType.values().length)]));
        }
    }

    public Cave(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    public void allTreasures() {
        System.out.println("Treasures:");
        for (Treasure t : treasures) {
            System.out.println(t.toString());
        }
    }

    public void mostPreciousTreasure() {
        treasures.sort(Comparator.comparing(obj -> obj.treasureType.getCost()));
        System.out.println("\nThe most precious treasure in the cave:\n"+ treasures.get(treasures.size() - 1).toString() + "\n");
    }

    public void treasuresInAmount(BigDecimal sum) {
        BigDecimal remainingSum = sum;
        treasures.sort(Comparator.comparing(obj -> obj.treasureType.getCost()));
        Collections.reverse(treasures);
        System.out.println("Collect treasures for the amount of " + sum);
        for (Treasure t : treasures) {
            if(remainingSum.compareTo(t.treasureType.getCost()) >= 0)
            System.out.println(t.toString());
            remainingSum = remainingSum.subtract(t.treasureType.getCost());
        }
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    class Treasure {
        private TreasureType treasureType;

        public Treasure(TreasureType treasureType) {
            this.treasureType = treasureType;
        }

        @Override
        public String toString() {
            return treasureType.toString();
        }

        public TreasureType getTreasureType() {
            return treasureType;
        }

        public void setTreasureType(TreasureType treasureType) {
            this.treasureType = treasureType;
        }
    }
}

enum TreasureType {
    GOLD_COIN(BigDecimal.valueOf(72)),
    SILVER_COIN(BigDecimal.valueOf(12)),
    DIAMOND(BigDecimal.valueOf(500)),
    PEARL(BigDecimal.valueOf(30)),
    INCREDIBLE_DIAMOND(BigDecimal.valueOf(3000));
    BigDecimal cost;
    TreasureType() {
    }

    TreasureType(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.name() + "\tcost:" + cost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
