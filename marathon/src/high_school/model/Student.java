package high_school.model;

public class Student extends Person{
    private int course;

    public Student(int id, String name, int course) {
        super(id, name);
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("course=").append(course);
        sb.append('}');
        return sb.toString();
    }
}
