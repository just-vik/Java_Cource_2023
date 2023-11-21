package high_school.model;

public class Professor extends Person{
    private String department;


    public Professor(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Professor{");
        sb.append("department='").append(department).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
