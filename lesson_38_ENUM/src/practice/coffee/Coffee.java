package practice.coffee;

import practice.month.Month;

public enum Coffee {
    // set constants
    ESP("Espresso", 3.25), AMR("Americano", 3.85),
    CAP("Cappuccino", 4.50), LAT("Latte", 4.85);

    //class fields
    private String type;
    double price;

    // constructor
    Coffee(String type, double price) {
        this.type = type;
        this.price = price;
    }

    //getters
    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    //setter
    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
