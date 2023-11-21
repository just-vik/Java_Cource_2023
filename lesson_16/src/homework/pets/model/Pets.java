package homework.pets.model;

public class Pets {
    //поля класса
    private int id;
    private String typePets;
    private int age;
    private String nickName;

    //конструктор класса Pets

    public Pets(int id, String typePets, int age, String nickName) {
        this.id = id;
        this.typePets = typePets;
        this.age = age;
        this.nickName = nickName;
    }

    //геттеры и сеттеры
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTypePets() {
        return typePets;
    }
    public void setTypePets(String typePets) {
        this.typePets = typePets;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    //напишем собственный метод Pets - печать
    public void displayPets() {
        System.out.println("Id: " + id + "\nType : " + typePets + "\nAge: "
                + age + "\nNickname: " + nickName);
    }
    public void sleep(){
        System.out.println("The "+ nickName + " went to sleep.");
    }
    public void eat(){
        System.out.println("The "+ nickName + " eating.");
    }
    public void makeSound(){
        System.out.println("The "+ nickName + " making a sound.");
    }
    public void play(){
        System.out.println("The "+ nickName + " playing.");
    }
    public void walk(){
        System.out.println("The "+ nickName + " walking.");
    }
}
