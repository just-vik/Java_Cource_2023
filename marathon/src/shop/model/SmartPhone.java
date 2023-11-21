package shop.model;

public class SmartPhone extends Laptop {
    private String camera;
    private String color;

    public SmartPhone(String barcode, int ram, int hdd, String brand, boolean hasDiscount, String display, int batteryCapacity, double weight, String camera, String color) {
        super(barcode, ram, hdd, brand, hasDiscount, display, batteryCapacity, weight);
        this.camera = camera;
        this.color = color;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SmartPhone{");
        sb.append("camera='").append(camera).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", discount = ").append(isHasDiscount());
        sb.append('}');
        return sb.toString();
    }
}
