package practice;

import java.util.HashMap;
import java.util.Map;

// подсчитать количество M и Ж
public class ManAndWomen {
    public static void main(String[] args) {
        System.out.println("Group list with gender (sex)");
        Map<String,String> groupMapGender = new HashMap<>();
        groupMapGender.put("Leonid", "Male");
        groupMapGender.put("Kirill", "Male");
        groupMapGender.put("Olesia", "Female");
        groupMapGender.put("Galina", "Female");
        groupMapGender.put("Andreas", "Male");
        groupMapGender.put("Sergei", "Male");
        groupMapGender.put("Elena", "Female");
        groupMapGender.put("Viktor", "Male");
        groupMapGender.put("Tatyana", "Female");
        groupMapGender.put("Vladislava", "Female");
        groupMapGender.put("Iryna", "Female");
        groupMapGender.put("Sasha", "Male");
        groupMapGender.put("Olga", "Female");
        groupMapGender.put("Olga", "Female");

        int women = 0;
        int men = 0;
//        for (String gender : groupMapGender.keySet()) {
//            if (groupMapGender.get(gender).equals("Female")) {
//                women++;
//            } else if (groupMapGender.get(gender).equals("Male")) {
//                men++;
//            }
            for (String gender : groupMapGender.values()) {
            if (gender.equals("Female")) {
                women++;
            } else if (gender.equals("Male")) {
                men++;
            }
        }
        System.out.println("Women: " + women);
        System.out.println("Men: " + men);
    }
}
