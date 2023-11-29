package practice.hashset;

public class IHashSetAppl {
    public static void main(String[] args) {
//        ISet<String> mySet = new IHashSet<>();
//        System.out.println("HashSet size is: " + mySet.size());
//
//        mySet.add("Berlin");
//        mySet.add("Leipzig");
//        mySet.add("Hamburg");
//        mySet.add("Munich");
//        System.out.println("HashSet size is: " + mySet.size());
//        mySet.add("Leipzig");
//        System.out.println("HashSet size is: " + mySet.size());
//        System.out.println("============Iterator============");
//        for (String s : mySet) {
//            System.out.println(s);
//        }


//        ISet<Integer> numberSet = new IHashSet<>();
//        for (int i = 0; i < 30; i++) {
//            numberSet.add(i);
//        }
//        System.out.println("============Numbers============");
//        for (Integer n : numberSet) {
//            System.out.print(n + " | ");
//
//        }

        ISet<Integer> integerSet = new IHashSet<>();
        System.out.println("Тестирование с возрастающими целыми числами: ");
        for (int i = 0; i < 100; i++) {
            integerSet.add(i);
        }

        System.out.println("Размер HashSet: " + integerSet.size());

        for (int i = 0; i < 100; i++) {
            if (!integerSet.contains(i)) {
                System.out.println("Число " + i + " отсутствует!");
            }
        }
        ISet<Integer> integerSet2 = new IHashSet<>();

        System.out.println("\nТестирование с случайными целыми числами:");
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 1000); // Генерация случайных чисел от 0 до 999
            integerSet2.add(random);
        }

        System.out.println("Размер HashSet: " + integerSet2.size());

        for (int i = 0; i < 100; i++) {
            if (!integerSet2.contains(i)) {
                System.out.println("отсутствующее число " + i );
            }
        }
    }
}
