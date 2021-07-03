package by.byportal.restcontroller;

import by.byportal.repository.EmployeeRepository;
import by.byportal.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PortalRestController {

    @Autowired
    EmployeeRepository employeeRepository;


    //TODO: СаняЛ: очистить Rest - убрать лишнее, оставить только получиние ОДНОГО емплоя, всех емплойв, удаление, обновление и создание
    @GetMapping("/hello")
    public String homePage() {
        System.out.println("hello - проверка вывода в консоль надписи из вкладки /hello");
        String someString = "проверка работоспособности ";
        return someString + " 5";
    }

    // TODO: СаняЛ: Доделать GET эмплоя по id
    @GetMapping("/employee")
    public Employee getEmployee() {
        //Employee employee1 = new Employee("Сергей", "Иванюклвич", 35, "TeamLid");
        Employee exampleEmployee = new Employee("Иванюкович", "Сергей", LocalDate.of(1985,5,25));
        //Employee testEmployee = employeeRepository.????
        return exampleEmployee; //employee1;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        System.out.println("getEmployees() rest-controller");
        List<Employee> employees = employeeRepository.findAll();
        // TODO: СаняЛ: Доделать эмплоёв и тут в соответствии с классом
/*      employees.add(new Employee("Островский", "Руслан", 37, "Developer"));
        employees.add(new Employee("Левченко", "Александр", 36, "Junior"));
        employees.add(new Employee("Рагозинский", "Алексей", 35, "Junior"));
        employees.add(new Employee("Якимчик", "Александр", 34, "Junior"));
        employees.add(new Employee("Савицкий", "Владимир", 38, "Junior"));*/
        return employees;
    }

    // PUT
    @PutMapping(value = "/employees")
    public ResponseEntity<?>  update(@RequestBody Employee updateEmployee) throws Exception {
        Optional<Employee> employee = employeeRepository.findById(updateEmployee.getEmployeeId());
        if(employee.isPresent()) {
            employeeRepository.save(updateEmployee);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    // POST
    // POST: http://localhost:/employees   <- Employee { id: 5, firstName: "Serega" , .... }
    @PostMapping(value = "/employees")
    public ResponseEntity<?> save(@RequestBody Employee saveEmployee) {
        Employee temp = employeeRepository.save(saveEmployee);
        if (temp.getEmployeeId() > 0)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // DELETE -> http://localhost:8090/emploees/55
    @DeleteMapping(value = "/emploees/{personId:\\d+}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long personId) throws Exception {
        //profileService.deleteProfile(personId);
            Optional<Employee> employee = employeeRepository.findById(personId);
            if(employee.isPresent()) {
                employeeRepository.deleteEmployeeByEmployeeId(personId);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
    }

}
