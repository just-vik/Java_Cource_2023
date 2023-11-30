package practice;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapIntroAppl {
    public static void main(String[] args) {
        //Создадим мапу, отражающее кол-во людей (население) в городах США
        Map<String, Integer> usaCities = new TreeMap<>();//создали объект на основе интерфейса MAP
        usaCities.put("Denver", 600_000);
        usaCities.put("Boston", 670_000);
        usaCities.put("Chicago", 2_700_000);
        usaCities.put("Atlanta", 470_000);
        usaCities.put("New York", 8_500_000);
        usaCities.put("Dallas", 1_300_000);
        System.out.println("Map size: " + usaCities.size());
        System.out.println("Is empty: " + usaCities.isEmpty());

        //получение значения по ключу
        Integer num = usaCities.get("Chicago");
        System.out.println(num);
        int pop = usaCities.get("Atlanta");
        System.out.println(pop);

        //проверка ключа на наличие
        System.out.println(usaCities.containsKey("Boston"));
        System.out.println(usaCities.containsKey("Detroit"));

        //вносим изменение(обновим значение в Map по ключу)
        System.out.println(num); //старое значение переменной
        usaCities.put("Chicago", 2_700_001); //меняем значение
        System.out.println(usaCities.get("Chicago")); //вытаскиваем новое значение
        usaCities.replace("Chicago", 2_700_002);
        System.out.println(num);

        Collection<Integer> population = usaCities.values(); //вытащили значения в коллекцию
        int total = 0;
        for (Integer integer : population) {
            total += integer;
        }
        System.out.println("Population: " + total);

        //печатаем содержимое Map'ы
        System.out.println("========Print Map v1========");
        Set<String> keys = usaCities.keySet();
        for (String key : keys) {
            System.out.println(key + " -> " + usaCities.get(key));
        }

        //еще другой способ
        System.out.println("========Print Map v2========");
        Set<Map.Entry<String,Integer>> entries = usaCities.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+" => "+entry.getValue());
        }

        System.out.println("========Print Map v3========");
        System.out.println(usaCities.entrySet());



    }
}
