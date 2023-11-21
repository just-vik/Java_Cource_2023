package homework.products.model;

public class MeatFood extends Food{
    private String meatType; //хранит тип мяса из которого изготовлен продукт.


    public MeatFood(String name, int barCode, double price, String expDate, String meatType) {
        super(name, barCode, price, expDate);
        this.meatType = meatType;
    }

    public String getMeatType() {
        return meatType;
    }
    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }


    @Override
    public String toString() {
        return "MeatFood{" +
                "meatType='" + meatType + '\'' +
                '}' + super.toString();
    }
}
