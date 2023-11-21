package homework;

import java.util.Collections;
import java.util.LinkedList;

public class GermanyAppl {
    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Berlin");
        linkedList.add("Hannover");
        linkedList.add("Magdeburg");
        linkedList.add("Düsseldorf");
        linkedList.add("Saarbrücken");
        linkedList.add("Kiel");
        linkedList.add("Stuttgart");
        linkedList.add("Dresden");
        linkedList.add("Potsdam");
        linkedList.add("Wiesbaden");
        linkedList.add("Munich");
        linkedList.add("Bremen");
        linkedList.add("Erfurt");
        linkedList.add("Schwerin");
        linkedList.add("Mainz");
        System.out.println(linkedList);

        System.out.println("\n=====State Capitals of Germany=======");
        Collections.sort(linkedList);
        display(linkedList);

        System.out.println("\n=====Adding Hamburg on middle of the list=======");
        linkedList.add(8, "Hamburg");
        display(linkedList);

        System.out.println("\n=====Adding Hamburg on top of the list=======");
        linkedList.addFirst("Hamburg");
        display(linkedList);

        System.out.println("\n=====Remove by object=======");
        linkedList.remove("Mainz");
        display(linkedList);

        System.out.println("\n=====Remove by index=======");
        linkedList.remove(9); //remove Hamburg duplicate
        display(linkedList);

        System.out.println("\n=====Adding Hamburg on top of the list v2=======");
        linkedList.push("Mainz");
        display(linkedList);

        System.out.println("\n=====Printing a non-existent object=======");
        System.out.println(linkedList.indexOf("Frankfurt"));

        System.out.println("\n=====Get by index=======");
        System.out.println(linkedList.get(2)); //result - Berlin

        System.out.println("\n=====Printing first and last array object=======");
        System.out.println("First element is: "+ linkedList.peekFirst());
        System.out.println("Last element is: "+ linkedList.peekLast());

        System.out.println("\n=====Clearing an array=======");
        linkedList.clear();
        display(linkedList);




    }

    private static void display(LinkedList<String> cities) {
        for (String city : cities) {
            System.out.println(city);
        }
        System.out.println();
    }
}
