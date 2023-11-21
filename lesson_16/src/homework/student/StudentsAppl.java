package homework.student;

import homework.student.model.Students;

public class StudentsAppl {
    public static void main(String[] args) {
        Students stud1=new Students(228896,"Igor","Spielberg",2001,"director");
        Students stud2=new Students(228550,"Jessica","Martin",2004,"lawyer");
        Students stud3=new Students(228375,"Nick","Brown",2003,"engineer");

        stud1.displayInfo();
        stud1.skip();
        stud1.vacation();
        System.out.println("________________________");
        stud2.displayInfo();
        stud2.study();
        stud2.course();
        stud2.exam();
        System.out.println("________________________");
        stud3.displayInfo();
        stud3.study();
        stud3.vacation();
        stud3.study();
        stud3.exam();
    }
}
