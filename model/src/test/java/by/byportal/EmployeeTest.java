package by.byportal;

import by.byportal.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.util.Assert;

import java.time.LocalDate;

public class EmployeeTest {

    @Test
    public void testSetGetFirstName() {
        Employee testEmployee = new Employee();
        String name = "Alex";
        testEmployee.setFirstName(name);

        Assert.isTrue(testEmployee.getFirstName() == name,
                "Employee firstName setter/getter is not working: Name is not Alex");
    }

    @Test
    public void testSetGetLastName() {
        Employee testEmployee = new Employee();
        String lastName = "Rabinovich";
        testEmployee.setLastName(lastName);

        // Этот тест недостоверно проверяет lastName еттер/геттер
        Assert.notNull(testEmployee.getLastName(),
                "Employee lastName setter/getter is not working: NULL");
    }

    @Test
    public void testEmployeeThreeConstructor() {
        LocalDate insertedDate = LocalDate.now();
        String name = "John";
        String last = "Markovich";
        Employee testEmployee = new Employee(name, last, insertedDate);

        Assert.isTrue(
                testEmployee.getFirstName() == name
                        && testEmployee.getLastName() == last
                        && testEmployee.getBirthDate() == insertedDate
                ,"Employee Employee(String, String, LocalDate) constructor is not properly working"
        );
    }
}
