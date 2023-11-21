package supermarket.model;

public class MeatFood extends Food{
    private String meatType; //хранит тип мяса из которого изготовлен продукт.


    public MeatFood(int barcode, String name, double price, String expDate, boolean organic, String meatType) {
        super(barcode, name, price, expDate, organic);
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
        final StringBuffer sb = new StringBuffer("MeatFood{");
        sb.append("meatType='").append(meatType).append('\'');
        sb.append(", food=").append(food);
        sb.append('}');
        return sb.toString();
    }
}
