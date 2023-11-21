package homework.products.model;

public class Food extends Product{
    private String expDate;// хранит дату истечения срока годности.

    public Food(String name, int barCode, double price, String expDate) {
        super(name, barCode, price);
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "Food{" +
                "expDate='" + expDate + '\'' +
                '}' + super.toString();
    }
}
