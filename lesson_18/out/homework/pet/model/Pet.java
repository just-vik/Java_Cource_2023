package homework.pet.model;

public class Pet {
    //поля класса
    private int id;
    private String typePet;
    private int age;
    private String nickName;

    //конструктор класса Pet

    public Pet(int id, String typePet, int age, String nickName) {
        this.id = id;
        this.typePet = typePet;
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
    public String getTypePet() {
        return typePet;
    }
    public void setTypePet(String typePet) {
        this.typePet = typePet;
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

    //напишем собственный метод Pet - печать
    public void displayPet() {
        System.out.println("Id: " + id + "| Type : " + typePet + "| Age: "
                + age + "| Nickname: " + nickName);
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
