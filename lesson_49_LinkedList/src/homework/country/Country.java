package homework.country;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Country {
    //fields
    private String name;
    private double population;
    private String continent;

    //constructor
    public Country(String name, double population, String continent) {
        this.name = name;
        this.population = population;
        this.continent = continent;
    }

    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    //toString
    @Override
    public String toString() {
        return "Continent: " + continent +
                ", country: " + name +
                ", population: " + population + " millions";
    }

    //comparators
    // сравнивает объекты по их имени (Country::getName) используем метод Comparator.comparing
    public static Comparator<Country> sortByName = Comparator.comparing(Country::getName);
    public static Comparator<Country> sortByPopulationS = Comparator.comparingDouble(Country::getPopulation);
    public static Comparator<Country> sortByPopulationR = sortByPopulationS.reversed();
    public static Comparator<Country> SortByContinentAndPopulation = Comparator.comparing(Country::getContinent).thenComparing(Country.sortByPopulationR);


    //Realization main
    public static void main(String[] args) {
        List<Country> countries = new LinkedList<>();
        countries.add(new Country("Madagascar", 24.8, "Africa"));
        countries.add(new Country("Nigeria", 223.6, "Africa"));
        countries.add(new Country("Vietnam", 100.2, "Asia"));
        countries.add(new Country("China", 1441.7, "Asia"));
        countries.add(new Country("Germany", 84.4, "Europe"));
        countries.add(new Country("Greece", 10.5, "Europe"));
        countries.add(new Country("Argentina", 43.4, "South America"));
        countries.add(new Country("Brazil", 218.7, "South America"));
        countries.add(new Country("USA", 328.2, "North America"));
        countries.add(new Country("Australia", 25.9, "Oceania"));
        countries.add(new Country("New Zeeland", 5.2, "Oceania"));

        System.out.println("------------- Sort by Alphabet --------------");
        countries.sort(Country.sortByName);
        display(countries);

        System.out.println("------------- Sort by population, standard variant--------------");
        countries.sort(Country.sortByPopulationS);
        display(countries);

        System.out.println("------------- Sort by population, reverse variant --------------");
        countries.sort(Country.sortByPopulationR);
        display(countries);

        System.out.println("------------- Sort by continent and population from max to min --------------");
        countries.sort(Country.SortByContinentAndPopulation);
        display(countries);

    }


    private static void display(List<Country> countries) {
        for (Country e : countries) {
            System.out.println(e);
        }
        System.out.println();
    }
}
