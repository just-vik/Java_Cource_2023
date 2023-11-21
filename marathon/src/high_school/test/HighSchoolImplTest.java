package high_school.test;

import high_school.dao.HighSchool;
import high_school.dao.HighSchoolImpl;
import high_school.model.Aspirant;
import high_school.model.Person;
import high_school.model.Professor;
import high_school.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class HighSchoolImplTest {

    HighSchool highSchool;
    Person[] people;

    @BeforeEach
    void setUp() {
        highSchool = new HighSchoolImpl(); // Создаем экземпляр HighSchoolImpl
        people = new Person[4];

        people[0] = new Student(1021, "John", 2);
        people[1] = new Student(1022, "Mary", 3);
        people[2] = new Aspirant(1120, "Maks", "jurist");
        people[3] = new Professor(2020, "Jacob", "Jurisprudence");


        //добавим элементы массива в company
        for (int i = 0; i < people.length; i++) {
            highSchool.addPerson(people[i]);
        }
    }
        @Test
        void addPerson () {
            assertFalse(highSchool.addPerson(null));
            assertFalse(highSchool.addPerson(people[1]));
            Person person = new Aspirant(1121, "Oscar", "Notary");
            assertTrue(highSchool.addPerson(person));
            assertEquals(5, highSchool.personCount());
        }

        @Test
        void removePerson () {
            Person removedPerson = highSchool.removePerson(1022);
            assertNotNull(removedPerson);
            assertEquals(3,highSchool.personCount());
            Person notFindPerson = highSchool.removePerson(5555);
            assertNull(notFindPerson);
            assertEquals(3, highSchool.personCount());
        }

        @Test
        void findPerson () {
            Person findPerson = highSchool.findPerson(1120);
            assertNotNull(findPerson);
            assertEquals("Maks", findPerson.getName());
            Person notFindPerson = highSchool.findPerson(1234);
            assertNull(notFindPerson);
        }

        @Test
        void personCount () {
            assertEquals(4, highSchool.personCount());
        }
    }
