package Basic_of_OOP.payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


//Задача 2.
//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.
public class Payment {

    private List<Product> products = new ArrayList<>();


    public void addProduct(Product product) {
        products.add(product);
    }

    public void fullPrise() {
        System.out.println("Final shopping list:");
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Product product : products) {
            System.out.println(product.toString());
            totalAmount = totalAmount.add(product.cost);
        }
        System.out.println("Total amount: " + totalAmount);
    }

    class Product {
        private String name;
        private BigDecimal cost;

        public Product(String name, BigDecimal cost) {
            this.name = name;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "name: " + name + "\tcost: " + cost;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getCost() {
            return cost;
        }

        public void setCost(BigDecimal cost) {
            this.cost = cost;
        }
    }
}
