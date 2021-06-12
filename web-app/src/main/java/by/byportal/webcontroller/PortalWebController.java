package by.byportal.webcontroller;

import by.byportal.model.Employee;
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
   /* @GetMapping("/")
    public String startPage (Model model){
        return "StartPage";
    }*/

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

    @PutMapping("/web/put/{id}")
    public String putEmployeeOne (@PathVariable(value = "id") long id, Employee putemployee) throws Exception {
        restTemplate = new RestTemplate();
        restTemplate.put(ROOT_URL + "employees/{id}", putemployee, Employee.class);
        return "redirect:/web/get";
    }

    @DeleteMapping("/web/{id}")
    public String delEmploeeOne (@PathVariable(value = "id") long id, Model model){
        restTemplate = new RestTemplate();
        restTemplate.delete(ROOT_URL + "employees/{id}", Employee.class);
        // TO REST: DELETE -> http://localhost:8090/emploees/55
        return "redirect:/web/get";
    }
}
