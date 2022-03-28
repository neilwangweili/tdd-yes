package yes.tdd.dojo.domain.employeereport;

public class Employee {
    private final Name name;
    private final Age age;

    public Employee(String name, int age) {
        this.name = new Name(name);
        this.age = new Age(age);
    }

    public String name() {
        return name.name();
    }

    public boolean isAdult() {
        return age.isAdult();
    }

    public String report() {
        return name.report() + ", " + age.report() + ";";
    }
}
