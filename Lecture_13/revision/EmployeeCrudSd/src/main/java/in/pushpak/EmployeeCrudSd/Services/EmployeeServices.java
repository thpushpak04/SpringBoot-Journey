package in.pushpak.EmployeeCrudSd.Services;

import in.pushpak.EmployeeCrudSd.Entity.Employee;
import in.pushpak.EmployeeCrudSd.Repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class EmployeeServices {

    private EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    //create method
    public Employee createDetails(Employee employeeReq){
        // setting the soft deleted to default false.
        employeeReq.setDeleted(false);

        Employee empRes = employeeRepository.save(employeeReq);
        return empRes;
    }

    //read method
    public Employee readDetails(Long id){
        Optional<Employee> empRes = employeeRepository.findByIdAndDeleted(id,false);

        if(empRes.isEmpty()){
            return null;
        }

        Employee empResult = empRes.get();

        return empResult;
    };

    //soft delete
    public Boolean softDelete(Long id){

        // we have to follow an analogy like :- get , set and save
        // so first get your required data.


        // step 1 :- get
        Optional<Employee>empRes = employeeRepository.findByIdAndDeleted(id,false);

        //check if is it empty
        if(empRes.isEmpty()){
            return false;
        }
        Employee empExisted = empRes.get();

        // step 2 :- set
        empExisted.setDeleted(true);

        // step 3 :- save

        Employee empResult = employeeRepository.save(empExisted);
        return true;
    }

    //update method
    public Employee updateDetails(Long id, Employee employee){
        Optional<Employee> existEmp = employeeRepository.findById(id);

        Employee empRes = existEmp.get();

        // set the value from request body to the desired object of data.
        empRes.setName(employee.getName());
        empRes.setAge(employee.getAge());
        empRes.setEmail(employee.getEmail());
        empRes.setSalary(employee.getSalary());

        // there is a bug ...and the bug is im not saving the data to db ...im just only returning my data to client as json...before returning
        //i have to save the data too . using save method

        employeeRepository.save(empRes); // saving the edited data to DB.

        return empRes;

    }

    //delete method
    public Optional<Employee> deleteDetails(Long id){
        Optional<Employee> empRes = employeeRepository.findById(id);

        employeeRepository.deleteById(id);

        return empRes;
    }

}
