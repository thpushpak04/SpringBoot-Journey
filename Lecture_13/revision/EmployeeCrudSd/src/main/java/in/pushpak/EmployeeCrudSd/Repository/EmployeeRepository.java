package in.pushpak.EmployeeCrudSd.Repository;

import in.pushpak.EmployeeCrudSd.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Optional<Employee> findByIdAndDeleted(Long id, boolean deleted);

}
