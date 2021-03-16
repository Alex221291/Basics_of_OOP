package Basic_of_OOP.calendar;

import java.time.LocalDate;

//Задача 3.
//Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
//выходных и праздничных днях.
public class Main {
    public static void main(String []args){
        Calendar calendar = new Calendar();

        calendar.addDate(new Calendar().new Weekend(LocalDate.of(2021, 3, 20), HolidayType.WEEKEND));
        calendar.addDate(new Calendar().new Weekend(LocalDate.of(2021, 3, 21), HolidayType.WEEKEND));
        calendar.addDate(new Calendar().new Weekend(LocalDate.of(2021, 5, 9), HolidayType.FESTIVE));
        calendar.addDate(new Calendar().new Weekend(LocalDate.of(2021, 7, 3), HolidayType.FESTIVE));
        calendar.addDate(new Calendar().new Weekend(LocalDate.of(2021, 4, 4), HolidayType.FESTIVE));
        calendar.addDate(new Calendar().new Weekend(LocalDate.of(2021, 5, 9), HolidayType.FESTIVE));
        calendar.addDate(new Calendar().new Weekend(LocalDate.of(2021, 5, 2), HolidayType.FESTIVE));

        calendar.showHolidays();
    }
}
