package pro.pushpak.crudDtoDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.pushpak.crudDtoDemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
