package practice.seasons;

public enum Season {
    // set constants
    WIN(1, "Winter"), SPR(2, "Spring"),
    SUM(3, "Summer"), AUT(4, "Autumn");

    //class fields
    private int number;
    private String name;

    // constructor
    Season(int number, String name) {
        this.number = number;
        this.name = name;
    }

    //getters
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
