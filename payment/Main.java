package Basic_of_OOP.payment;

import java.math.BigDecimal;

//Задача 2.
//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.
public class Main {
    public static void main(String []args) {
        Payment payment = new Payment();
        payment.addProduct(new Payment().new Product("TV", new BigDecimal(999.00)));
        payment.addProduct(new Payment().new Product("Fridge", new BigDecimal(1199.00)));
        payment.addProduct(new Payment().new Product("Washing machine", new BigDecimal(799.00)));
        payment.addProduct(new Payment().new Product("Gas stove", new BigDecimal(999.00)));
        payment.fullPrise();
    }
}
