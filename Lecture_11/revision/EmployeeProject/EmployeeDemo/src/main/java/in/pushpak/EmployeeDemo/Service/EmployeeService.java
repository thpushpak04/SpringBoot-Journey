package in.pushpak.EmployeeDemo.Service;

import in.pushpak.EmployeeDemo.Employee;
import in.pushpak.EmployeeDemo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    //DI
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    //****** the business logic **********


    //create method
    public Employee createDetails(Employee employeeReq){
        Employee employeeResp= employeeRepository.save(employeeReq);

        return employeeResp;
    }

    // read one - method
    public Optional<Employee> readDetails(Long id){
        Optional<Employee> readEmpRes = employeeRepository.findById(id);
        // as there can be null value if data do not exist for this id.

        return readEmpRes;
    }

    // read all - method
    public List<Employee> readAllDetails(){
        List<Employee> empRes = employeeRepository.findAll(); //send data in list datatype

        return empRes;
    }

    //update - method
    public Employee updateDetails(Long id, Employee employeeReq){
        if(employeeRepository.existsById(id)){
            Employee empRes = employeeRepository.save(employeeReq);
            return empRes;
        }
        return null;
    }

    // delete - method
    public Employee deleteDetails(Long id){
        Optional<Employee> empRes = employeeRepository.findById(id);
        employeeRepository.deleteById(id);
        System.out.println("the deleted details are: ");

        if(empRes.isPresent()){
            return empRes.get();
        }

        return null;
    }

}
