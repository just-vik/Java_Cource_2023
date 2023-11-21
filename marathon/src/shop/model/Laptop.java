package shop.model;

public class Laptop extends Computer {
    private String display;
    private int batteryCapacity;
    private double weight;

    public Laptop(String barcode, int ram, int hdd, String brand, boolean hasDiscount, String display, int batteryCapacity, double weight) {
        super(barcode, ram, hdd, brand, hasDiscount);
        this.display = display;
        this.batteryCapacity = batteryCapacity;
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Laptop{");
        sb.append("display='").append(display).append('\'');
        sb.append(", batteryCapacity=").append(batteryCapacity);
        sb.append(", weight=").append(weight);
        sb.append(", discount = ").append(isHasDiscount());
        sb.append('}');
        return sb.toString();
    }
}
