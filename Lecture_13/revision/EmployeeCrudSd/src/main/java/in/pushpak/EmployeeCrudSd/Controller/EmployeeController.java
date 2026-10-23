package in.pushpak.EmployeeCrudSd.Controller;

import in.pushpak.EmployeeCrudSd.Entity.Employee;
import in.pushpak.EmployeeCrudSd.Services.EmployeeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    //implement DI

    private EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices){
        this.employeeServices = employeeServices;
    }

    //create method
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee empRes = employeeServices.createDetails(employee);

        if(empRes == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(empRes);

    }


    //read method
    @GetMapping("/get")
    public ResponseEntity<Employee> readEmployee(@RequestParam Long id){

        Employee empRes = employeeServices.readDetails(id);

        if(empRes == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity.ok(empRes);

    }


    // soft - delete
    @PatchMapping("/soft-delete")
    public ResponseEntity<Boolean> softDeleteEmployee(@RequestParam Long id){
        Boolean empRes = employeeServices.softDelete(id);

        if(empRes == false){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(false);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(true);
    }

    // update method
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestParam Long id,
                                                   @RequestBody Employee employee){

        Employee empRes = employeeServices.updateDetails(id,employee);

        if(empRes == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(empRes);
    }

    // delete method
    @DeleteMapping("/delete")
    public ResponseEntity<Optional<Employee>> deleteEmployee(@RequestParam Long id){

        Optional<Employee> empRes = employeeServices.deleteDetails(id);

        if(empRes.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empRes);


    }
}
