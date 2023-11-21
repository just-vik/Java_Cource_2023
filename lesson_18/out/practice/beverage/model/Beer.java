package practice.beverage.model;

public class Beer extends Beverage {

    private String type; // type beer

    //Constructor
    public Beer(String title, String packing, int quantity, String type) {
        super(title, packing, quantity);
        this.type = type;
    }
    //пустой конструктор
    public Beer() {
    }



    public void toBuy(String title, String packing, int quantity, String type) {
        super.toBuy(title, packing, quantity);
        this.type = type;
    }

    public void displayStock() {
        super.displayStock(); //метод из родительского класса
        System.out.println("This is " + type + " beer");
    }
    //getter and setter

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

