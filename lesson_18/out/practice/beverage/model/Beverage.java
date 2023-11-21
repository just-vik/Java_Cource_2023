package practice.beverage.model;

public class Beverage {
    //fields
    private String title;   //наименование
    private String packing; //вид упаковки
    private int quantity;   //кол-во упаковок

    //Constructor
    public Beverage(String title, String packing, int quantity) {
        this.title = title;
        this.packing = packing;
        this.quantity = quantity;
    }
    //пустой конструктор
    public Beverage() {
    }


    //Getter & Setter

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Methods for purchase
    public void toBuy(String title, String packing, int quantity) { //static - don't write
        System.out.println("Go to market and buy: " + title + " " + packing + " " + quantity + ".");

    }

    //Methods for checking what's left in stock
    public void displayStock() {
        System.out.println("We have: " + title + " " + packing + " " + quantity + ".");
    }
}
