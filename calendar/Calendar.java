package Basic_of_OOP.calendar;

import java.time.LocalDate;
import java.util.ArrayList;

//Задача 3.
//Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
//выходных и праздничных днях.
public class Calendar {
    ArrayList<Weekend> holidays = new ArrayList<>();

    public Calendar(ArrayList<Weekend> holidays) {
        this.holidays = holidays;
    }

    public Calendar(){

    }

    public void addDate(Weekend weekend){
        holidays.add(weekend);
    }

    public void showHolidays() {
        System.out.println("Holidays:");
        for (Weekend w : holidays) {
            System.out.println(w.toString());
        }
    }

    public ArrayList<Weekend> getHolidays() {
        return holidays;
    }

    public void setHolidays(ArrayList<Weekend> holidays) {
        this.holidays = holidays;
    }

    class Weekend{
        private LocalDate date;
        private HolidayType typeDay;

        public Weekend(LocalDate date, HolidayType typeDay) {
            this.date = date;
            this.typeDay = typeDay;
        }

        @Override
        public String toString() {
            return "date: " + date.toString() +
                    "\ttypeDay: " + typeDay;
        }

        public LocalDate getDate() {
            return date;
        }

        public HolidayType getTypeDay() {
            return typeDay;
        }
    }
}
enum HolidayType {
   WORKING , WEEKEND, FESTIVE
}
