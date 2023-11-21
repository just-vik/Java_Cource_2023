package shop.model;

public class Computer {

    private String barcode;
    private int ram;
    private int hdd;
    private String brand;
    private boolean hasDiscount; // Поле, указывающее на наличие скидки


    public Computer(String barcode, int ram, int hdd, String brand, boolean hasDiscount) {
        this.barcode = barcode;
        this.ram = ram;
        this.hdd = hdd;
        this.brand = brand;
        this.hasDiscount = hasDiscount;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Computer{");
        sb.append("barcode='").append(barcode).append('\'');
        sb.append(", ram=").append(ram);
        sb.append(", hdd=").append(hdd);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", hasDiscount=").append(hasDiscount);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Computer computer = (Computer) object;

        return barcode.equals(computer.barcode);
    }

    @Override
    public int hashCode() {
        return barcode.hashCode();
    }

}
