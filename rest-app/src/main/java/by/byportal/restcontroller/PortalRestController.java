package by.byportal.restcontroller;

import by.byportal.repository.EmployeeRepository;
import by.byportal.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PortalRestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/hello")
    public String homePage() {
        System.out.println("hello - проверка вывода в консоль надписи из вкладки /hello");
        String someString = "проверка работоспособности ";
        return someString + " 5";
    }
    @GetMapping("/employee")
    public Employee getEmployee() {
        //Employee employee1 = new Employee("Сергей", "Иванюклвич", 35, "TeamLid");
        Employee exampleEmployee = new Employee("Иванюкович", "Сергей", new Date(82, 5, 22));
        //Employee testEmployee = employeeRepository.????
        return exampleEmployee; //employee1;
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        // TODO: Доделать эмплоёв и тут в соответствии с классом
/*        employees.add(new Employee("Островский", "Руслан", 37, "Developer"));
        employees.add(new Employee("Левченко", "Александр", 36, "Junior"));
        employees.add(new Employee("Рагозинский", "Алексей", 35, "Junior"));
        employees.add(new Employee("Якимчик", "Александр", 34, "Junior"));
        employees.add(new Employee("Савицкий", "Владимир", 38, "Junior"));*/
        return employees;
    }
//ORN
}
