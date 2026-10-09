package in.pushpak.crudSpringBootDemo.repository;

import in.pushpak.crudSpringBootDemo.entity.Student;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    /**
     * Student will be injected then its data will be stored and then it will
     * be thrown back to the actual need.
     */

}
