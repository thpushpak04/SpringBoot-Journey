package in.pushpak.crudSpringBootDemo.repository;

import in.pushpak.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByDeletedIsFalse();

    Optional<Student> findByIdAndDeletedIsFalse(Long id);
    /**
     * Student will be injected then its data will be stored and then it will
     * be thrown back to the actual need.
     */


    //findBy+fieldName+condition
}
