package yes.tdd.dojo.domain.employeereport;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeReportTest {

    private EmployeeReport employeeReport;

    @BeforeEach
    void setUp() {
        employeeReport = EmployeeReport.generate(
            new Employee("Max", 17),
            new Employee("Sepp", 18),
            new Employee("Nina", 15),
            new Employee("Mike", 51)
        );
    }

    @Test
    void should_be_able_to_report_employee_who_is_greater_than_18_years_old() {
        assertFalse(employeeReport.report().contains("Max".toUpperCase()));
        assertTrue(employeeReport.report().contains("Sepp".toUpperCase()));
        assertFalse(employeeReport.report().contains("Nina".toUpperCase()));
        assertTrue(employeeReport.report().contains("Mike".toUpperCase()));
    }

    @Test
    void should_be_able_to_report_employee_by_name_sort_desc() {
        assertEquals(employeeReport.report(), "Sepp".toUpperCase() + ", 18; " + "Mike".toUpperCase() + ", 51;");
    }

    @Test
    void should_be_able_to_report_employee_and_name_capture() {
        assertEquals(employeeReport.report(), "SEPP, 18; MIKE, 51;");
    }
}
