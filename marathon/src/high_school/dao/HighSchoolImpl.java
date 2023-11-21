package high_school.dao;

import high_school.model.Person;

public class HighSchoolImpl implements HighSchool {

    private Person[] people;
    ;
    private int count;

    public HighSchoolImpl() {
        this.people = new Person[50];
        this.count = 0;
    }

    @Override
    public boolean addPerson(Person person) {
        if (person == null || count == people.length || findPerson(person.getId()) != null) {
            return false;
        }
        people[count] = person;
        count++;
        return true;
    }

    @Override
    public Person removePerson(int id) {
        for (int i = 0; i < count; i++) {
            if (people[i].getId() == id) {
                Person res = people[i]; //убрали найденный элемент в переменную
                people[i] = people[count - 1]; //на место найденного поставили последний существующего в массиве
                people[count - 1] = null; //обнулили последнего
                count--;
                return res;
            }
        }
        return null;
    }

    @Override
    public Person findPerson(int id) {
        for (int i = 0; i < count; i++) {
            if (people[i] != null && people[i].getId() == id) {
                return people[i];
            }
        }
        return null;
    }

    @Override
    public int personCount() {
        return count;
    }

    @Override
    public void printPerson() {
        for (int i = 0; i < people.length; i++) {
            if (people[i] != null) {
                System.out.println(people[i]);
            }
        }

    }
}
