package Homework;

public class StringPracticum {
    public static void main(String[] args) {

        String str = "I'm proud to learn Java! Java is the most famous programming language!!!";
        System.out.println(str + "\n");

        System.out.println("---------------Print the last symbol of a line-----------------");
        char c = str.charAt(str.length() - 1);
        System.out.println("Last symbol of string: " + c + "\n");

        System.out.println("---------------Find the position of the substring “Java” in a String-----------------");
        int position = str.indexOf("Java");
        System.out.println("Position of substring <Java>: " + position + "\n");

        System.out.println("---------------Check if a given String contains the substring “Java”-----------------");
        boolean contJava = str.contains("Java");
        System.out.println("Contain <Java> string: " + contJava + "\n");

        System.out.println("---------------Replace all “o” symbol with “a”-----------------");
        String replaceSymb = str.replace("o", "a");
        System.out.println("Replaced string: " + replaceSymb + "\n");

        System.out.println("---------------Convert string to uppercase-----------------");
        String upper = str.toUpperCase();
        System.out.println("Uppercase: " + upper + "\n");

        System.out.println("---------------Convert string to lowercase-----------------");
        String lower = str.toLowerCase();
        System.out.println("Lowercase: " + lower + "\n");

        System.out.println("---------------Cut Java substring using method substring()-----------------");
        String cut = str.substring(0, position) + str.substring(position + 4);
        System.out.println("Cut substring <Java>: " + cut + "\n");

        System.out.println("---------------Check if a string ends with the substring “!!!”-----------------");
        boolean checkSymb = str.endsWith("!!!");
        System.out.println("String ends with the symbols <!!!>: " + checkSymb + "\n");

        System.out.println("---------------Check if a string begins with the substring “I'm proud”-----------------");
        boolean checkImProud = str.startsWith("I'm proud");
        System.out.println("String starts with <I'm proud>: " + checkImProud + "\n");
    }
}
