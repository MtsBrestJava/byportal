package by.byportal.webcontroller;

import by.byportal.model.Employee;
import by.byportal.webcontroller.filessaweready.ReadFileExcel;
import by.byportal.webcontroller.filessaweready.SaveFileExcel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
        Employee putEmplpoyee = new Employee();
        model.addAttribute("putemployee", putEmplpoyee);
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
        restTemplate.postForObject(ROOT_URL + "emploees", newemployee, Employee.class);
        return "redirect:/web/get";
    }

    @PutMapping("/web/put}")
    public String putEmployeeOne (@RequestBody Employee putemployee) throws Exception {
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
    @GetMapping("/save")
    public String saveMyFile (Model model) {
        restTemplate=new RestTemplate();
        ResponseEntity<Employee[]> person = restTemplate.getForEntity(ROOT_URL+"employees", Employee[].class);
        Employee[] pageList = person.getBody();
        SaveFileExcel.saveFile(pageList);
    return "HomePage";
    }
    @GetMapping("/read")
    public String readMyFile(Model model){
        List readlist = ReadFileExcel.readFile();
        model.addAttribute("readlist", readlist);
        return "HomePage";
    }
}
