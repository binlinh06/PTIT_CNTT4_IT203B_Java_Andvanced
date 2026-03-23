package session12.hw05.model;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String department;
    private String disease;
    private int days;

    public Patient(int id, String name, int age, String department, String disease, int days) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.disease = disease;
        this.days = days;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public String getDisease() { return disease; }
    public int getDays() { return days; }
}
