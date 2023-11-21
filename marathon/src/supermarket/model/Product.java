package supermarket.model;

public abstract class Product{
    private final int barcode;
    private String name;
    private double price;
    Food food;

    public Product(int barcode, String name, double price, Food food) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.food = food;
    }

    public int getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("barcode=").append(barcode);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", food=").append(food);
        sb.append('}');
        return sb.toString();
    }

    //    сравнение и поиск задвоенных значений (equals и hashcode)


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return barcode == product.barcode;
    }

    @Override
    public int hashCode() {
        return barcode;
    }


}
