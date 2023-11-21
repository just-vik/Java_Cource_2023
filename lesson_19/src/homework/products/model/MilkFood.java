package homework.products.model;

public class MilkFood extends Food{
    private String milkType; //тип молока
    private double fat; //жирность продукта


    public MilkFood(String name, int barCode, double price, String expDate, String milkType, double fat) {
        super(name, barCode, price, expDate);
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
        return "MilkFood{" +
                "milkType='" + milkType + '\'' +
                ", fat=" + fat +
                '}' + super.toString();
    }
}
