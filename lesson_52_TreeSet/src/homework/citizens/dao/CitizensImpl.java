package homework.citizens.dao;

import java.util.Comparator;

public class CitizensImpl {

    public static Comparator<Citizens> nameComparator = Comparator.comparing(Citizens::getName);
    public static Comparator<Citizens> ageComparator = Comparator.comparingInt(Citizens::getAge);
}
