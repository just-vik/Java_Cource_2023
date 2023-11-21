package practice.supermarket.dao;

import practice.supermarket.model.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class SupermarketImpl implements Supermarket {
    private Collection<Product> productsList = new ArrayList<>(); //поле со списком продуктов
// Так тоже можно
//    private ArrayList<Product> products = new ArrayList<>();
//    private List<Product> products = new ArrayList<>();

    @Override
    public boolean addProduct(Product product) {
        if (product == null || productsList.contains(product)) { //проверяем не null и содержит product
            return false;
        }
        return productsList.add(product);
    }

    @Override
    public Product removeProduct(long barCode) {
        Product removed = findByBarCode(barCode);//нашли продукт по barcode
        productsList.remove(removed); //удалили из списка
        return removed;//вернули из метода тот, который удалили
    }

    @Override
    public Product findByBarCode(long barCode) {
        for (Product p : productsList) {
            if (p.getBarCode() == barCode) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Iterable<Product> findByCategory(String category) {
        return findByPredicate(p -> category.equalsIgnoreCase(p.getCategory())); // использует лямбда-выражение для поиска элемента в коллекции по определенному предикату, который определяется через p->category.equalsIgnoreCase(category).
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        return findByPredicate(p -> brand.equalsIgnoreCase(p.getBrand()));

    }

    @Override
    public Iterable<Product> findByProductsWithExpiredDate() {
        //создаем объект для текущей даты
        LocalDate currentDay = LocalDate.now();
        //создаем объект, который указывает дату просрочки > 5 дней (определяем порог просрочки)
        LocalDate expMoreThenPeriod = currentDay.minusDays(5); // просрочки > 5 дней от текущей даты
        //возвращаем продукт из листа с датой просрочки более 5 дней
        return findByPredicate(p -> p.getDate().isBefore(expMoreThenPeriod));

        // return findByPredicate(p -> currentDay.isAfter(p.getDate()));
    }

    private Iterable<Product> findByPredicate(Predicate<Product> predicate) {
        List<Product> res = new ArrayList<>();
        //перебираем все список продуктов, находим те которые удовлетворяют условию предиката
        for (Product p : productsList) {
            if (predicate.test(p)) {
                res.add(p);
            }
        }
        return res;
    }

    @Override
    public int skuQuantity() {
        return productsList.size();
    }

    @Override
    public Iterator<Product> iterator() {
        return productsList.iterator(); //берем iterator от arrayList
    }
}
