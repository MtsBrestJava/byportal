package by.byportal.webcontroller;

import by.byportal.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class PortalWebController {

    RestTemplate restTemplate;
    final String ROOT_URL = "http://localhost:8090/";

    @GetMapping("/web/get")
    public String employeeGet (Model model){
        restTemplate=new RestTemplate();
        ResponseEntity<Employee[]> person = restTemplate.getForEntity(ROOT_URL+"employees", Employee[].class);
        Employee[] pageList = person.getBody();
        model.addAttribute("pagelistweb", pageList);
        Employee newEmployee = new Employee();
        model.addAttribute("newemployee", newEmployee);
        return "HomePage";
    }

    @GetMapping("/web/post")
    public String addEmployeeGet(Model model){
        return "HomePage";
    }

    @PostMapping("/web/post")
    public String addEmployee(Employee newemployee) throws Exception {
        restTemplate = new RestTemplate();
        restTemplate.postForObject(ROOT_URL + "emploees",newemployee,Employee.class);
        return "redirect:/web/get";
    }
   /* @GetMapping("/web/put/{id}")
    public String addEmployeePut(Model model){
        return "HomePage";
    }*/
    @PutMapping("/web/put")
    public String putEmploeeOne (@PathVariable(value = "id") long id, Employee putEmploee) throws Exception {
        restTemplate = new RestTemplate();
        restTemplate.put(ROOT_URL + "emploees/{id}", putEmploee, Employee.class);
        return "redirect:/web/get";
    }

    // my PUT

    @PutMapping(value = "/{personId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProfile(
            @Valid @RequestBody ProfileRequest request,
            @PathVariable int personId
    ) {
        Employee.updateProfile(
                request.getFirstName(),
                request.getLastName(),
                request.getAge(),
                portalId
        );
    }

    /*@PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
      @Valid @RequestBody Employee employeeDetails) throws Exception {
        Employee employee = EmployeeRepository.findById(employeeId)
        .orElseThrow(() -> new Exception("Employee not found for this id :: " + employeeId));
        employee.setPortalId(employeeDetails.getPortalId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = Employee.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }*/

    @PostMapping("/web/del/{id}")
    public String delEmploeeOne (@PathVariable(value = "id") long id, Model model){
        restTemplate = new RestTemplate();
        restTemplate.delete(ROOT_URL + "emploees/{id}", Employee.class);
        return "redirect:/web/get";
    }
}
