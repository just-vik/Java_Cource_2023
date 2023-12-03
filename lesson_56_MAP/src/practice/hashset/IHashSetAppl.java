package practice.hashset;

public class IHashSetAppl {
    public static void main(String[] args) {
        ISet<String> mySet = new IHashSet<>();
        System.out.println("HashSet size is: " + mySet.size());

        mySet.add("Berlin");
        mySet.add("Leipzig");
        mySet.add("Hamburg");
        mySet.add("Munich");
        System.out.println("HashSet size is: " + mySet.size());
        mySet.add("Leipzig");
        System.out.println("HashSet size is: " + mySet.size());
        System.out.println("============Iterator============");
        for (String s : mySet) {
            System.out.println(s);
        }


//        ISet<Integer> numberSet = new IHashSet<>();
//        for (int i = 0; i < 30; i++) {
//            numberSet.add(i);
//        }
//        System.out.println("============Numbers============");
//        for (Integer n : numberSet) {
//            System.out.print(n + " | ");
//
//        }

        System.out.println("\n===========Number from 1 to 100===========");
        ISet<Integer> integerSet = new IHashSet<>();
        for (int i = 0; i < 100; i++) {
            integerSet.add(i);
        }
        printSetInteger(integerSet);

        System.out.println("\n===========Random numbers===========");
        ISet<Integer> integerSet2 = new IHashSet<>();
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 100); // Генерация случайных чисел от 0 до 999
            integerSet2.add(random);
        }
        printSetInteger(integerSet2);


    }

    private static void printSetInteger(ISet<Integer> set) {
        for (Integer n:set) {
            System.out.print(n+" | ");
        }
    }
}
