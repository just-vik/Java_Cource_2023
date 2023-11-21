package ait.string;

public class StringEqualsAppl {
    public static void main(String[] args) {
        String str0 = "Hello";
        String str1 = "Hello";//указывает на уже созданный в константе "Hello"(str0)
        String str2 = new String("Hello"); //создается новый объект String
        System.out.println(str0);
        System.out.println(str1);
        System.out.println(str2);

        //!!! объекты сравниваются через метод Equals

        boolean checker1 = str0 == str2;
        System.out.println(checker1);
        boolean checker = str0.equals(str2);
        System.out.println(checker);
    }
}
