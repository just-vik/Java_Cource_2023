package ait.goat.model;

public class Goat {
    public static final int COUNT_MAX=20; // final заданное значение нельзя менять
    private int count;
    private final String name;

    public Goat(String name) {
        this.name = name;
    }



    public int getCount(){
        return count;
    }
    public void increment(){
        count++;
    }

    @Override
    public String toString() {
        return "Goat{" +
                "count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}
