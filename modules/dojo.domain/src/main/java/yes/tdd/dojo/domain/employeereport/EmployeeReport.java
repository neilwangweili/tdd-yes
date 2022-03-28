package yes.tdd.dojo.domain.employeereport;

import java.util.*;
import java.util.stream.*;

public final class EmployeeReport {
    private final List<Employee> employees;

    private EmployeeReport(Employee... employees) {
        this.employees = Stream.of(employees)
            .filter(Employee::isAdult)
            .sorted(Comparator.comparing(Employee::name).reversed())
            .collect(Collectors.toList());
    }

    public static EmployeeReport generate(Employee... employees) {
        return new EmployeeReport(employees);
    }

    public String report() {
        return employees.stream().map(Employee::report).collect(Collectors.joining(" "));
    }
}
