package practice.wardrobe.model;

public class Wardrobe implements Comparable<Wardrobe> {
    double height;
    double wight;
    double depth;

    public Wardrobe(double height, double wight, double depth) {
        this.height = height;
        this.wight = wight;
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public double getWight() {
        return wight;
    }

    public double getDepth() {
        return depth;
    }

    public double area() { //площадь его основания высоту на глубину
        return wight * depth;
    }

    public double volume() {
        return area() * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wardrobe wardrobe = (Wardrobe) o;

        if (Double.compare(height, wardrobe.height) != 0) return false;
        if (Double.compare(wight, wardrobe.wight) != 0) return false;
        return Double.compare(depth, wardrobe.depth) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(height);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(wight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(depth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Wardrobe {" +
                "height = " + height +
                ", wight = " + wight +
                ", depth = " + depth +
                ", area = " + area() +
                ", volume = " + volume() +
                '}';
    }

    @Override
    public int compareTo(Wardrobe o) {
        return Double.compare(height, o.height);
    }


}
