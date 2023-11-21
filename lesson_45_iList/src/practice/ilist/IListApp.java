package practice.ilist;


public class IListApp {
    public static void main(String[] args) {

       IList<Integer> list =new IListImpl<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("------------------- Add ---------------------");
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("------------------- List size ---------------------");
        System.out.println(list.size());
        System.out.println("------------------- isEmpty ---------------------");
        System.out.println(list.isEmpty());
        System.out.println("-------------------- indexOf --------------------");
        System.out.println(list.indexOf(30));

        System.out.println("-------------------Add String---------------------");
        IList<String> listOfCities = new IListImpl<>();
        listOfCities.add("Berlin");
        listOfCities.add("NY");
        listOfCities.add("London");
        listOfCities.add("Paris");
        listOfCities.add("India");
        System.out.println(listOfCities.size());
        System.out.println(listOfCities.isEmpty());
        printList(listOfCities);
        System.out.println("------------------- Remove by object ---------------------");
        listOfCities.remove("NY");
        printList(listOfCities);
        System.out.println("------------------- Add (index,element) ---------------------");
        listOfCities.add(0,"NY");
        printList(listOfCities);
        System.out.println("-------------------- Last index --------------------");
        System.out.println(listOfCities.lastIndex("London"));
        System.out.println("------------------- Get by index ---------------------");
        System.out.println(listOfCities.get(1));
        System.out.println("------------------- Set by index ---------------------");
        listOfCities.set(1,"Germany");
        printList(listOfCities);
        System.out.println("------------------- Contains ---------------------");
        System.out.println(listOfCities.contains("India"));
        System.out.println(listOfCities.contains("Japan"));
        System.out.println("------------------- Clean ---------------------");
        listOfCities.clean();
        printList(listOfCities);

        IList<String> city = new IListImpl<>();
        System.out.println("==============================");
        city.add("London");
        city.add("Amsterdam");
        city.add("Berlin");
        city.add("Paris");
        city.add("Madrid");
        city.add("Istanbul");
        city.add("Moscow");

        for (String s:city) {
            System.out.print(s+" | ");
        }

        city.forEach(s -> System.out.println(" "+s));

        for (int i = 0; i < city.size(); i++) {
            System.out.println(city.get(i));
        }

    }
    //================================================================================================
    // Метод для распечатки списка
    private static <E> void printList(IList<E> list) {
        for (E element : list) {
            System.out.println(element);
        }
    }
}
