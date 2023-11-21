package supermarket.model;


public class Food extends Product{
    private String expDate;
    private boolean organic;


    public Food(int barcode, String name, double price, String expDate, boolean organic) {
        super(barcode, name, price, null);
        this.expDate = expDate;
        this.organic = organic;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public boolean isOrganic() {
        return organic;
    }

    public void setOrganic(boolean organic) {
        this.organic = organic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Food ");
        sb.append(", expDate = ").append(expDate).append('\'');
        sb.append(", organic = ").append(organic);
        return sb.toString();

      // + super.toString();
    }
}
