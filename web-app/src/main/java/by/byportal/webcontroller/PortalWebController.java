package by.byportal.webcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;
import workclass.Employee;

@Controller
public class PortalWebController {

    RestTemplate restTemplate;
    final String ROOT_URL = "http://192.168.3.222:8080/";
    @GetMapping("/web/get")
    public String employeeGet (Model model){
        restTemplate=new RestTemplate();
        ResponseEntity<Employee[]> person = restTemplate.getForEntity(ROOT_URL+"employeesall", Employee[].class);
        Employee[] pageList = person.getBody();
        model.addAttribute("pagelistweb", pageList);
        return "HomePage";
    }
    @GetMapping("/web/post")
    public String addEmployeeGet(Model model){
        return "HomePage";
    }

    @PostMapping("/web/post")
    public String addEmployee(Employee postEmploee) throws Exception {
        restTemplate = new RestTemplate();
        restTemplate.postForObject(ROOT_URL + "emploees",postEmploee,Employee.class);
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
    @PostMapping("/web/del/{id}")
    public String delEmploeeOne (@PathVariable(value = "id") long id, Model model){
        restTemplate = new RestTemplate();
        restTemplate.delete(ROOT_URL + "emploees/{id}", Employee.class);
        return "redirect:/web/get";
    }
}
