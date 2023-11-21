package supermarket.model;

public class MilkFood extends Food {
    private String milkType; //тип молока
    private double fat; //жирность продукта

    public MilkFood(int barcode, String name, double price, String expDate, boolean organic, String milkType, double fat) {
        super(barcode, name, price, expDate, organic);
        this.milkType = milkType;
        this.fat = fat;
    }


    public String getMilkType() {
        return milkType;
    }

    public void setMilkType(String milkType) {
        this.milkType = milkType;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MilkFood{");
        sb.append("milkType='").append(milkType).append('\'');
        sb.append(", fat=").append(fat);
        sb.append(", expDate='").append(getExpDate()).append('\'');
        sb.append(", organic=").append(isOrganic());
        sb.append(", food=").append(food);
        sb.append('}');
        return sb.toString();
    }
}
