package in.pushpak.EmployeeDemo.Controller;


import in.pushpak.EmployeeDemo.Employee;
import in.pushpak.EmployeeDemo.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    //create method
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee createdEmployee = employeeService.createDetails(employee);

        if(createdEmployee == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdEmployee);
    }

    //read one
    @GetMapping("/get")
    public ResponseEntity<Optional<Employee>> readEmployee(@RequestParam Long id){
        //using @RequestParam we can fetch data

        Optional<Employee> readEmp = employeeService.readDetails(id);

        if(readEmp.isEmpty()){ // as readEmp is optional object
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(readEmp);
    }

    //readAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> readAllEmployee(){
        List<Employee> employeeRes = employeeService.readAllDetails();

        if(employeeRes == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity.ok(employeeRes);

    }

    //update
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestParam Long id,
                                                   @RequestBody Employee employee){
        Employee empRes = employeeService.updateDetails(id,employee);

        if(empRes == null){
            ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(empRes);
    }

    // delete

    @DeleteMapping("/delete")
    public ResponseEntity<Employee> deleteEmployee(@RequestParam Long id){
        Employee empRes = employeeService.deleteDetails(id);

        if(empRes == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity.ok(empRes);
    }
}
