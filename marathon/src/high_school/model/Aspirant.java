package high_school.model;

public class Aspirant extends Person{

    private String speciality;

    public Aspirant(int id, String name, String speciality) {
        super(id, name);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Aspirant{");
        sb.append("speciality='").append(speciality).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
