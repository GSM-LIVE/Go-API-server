package live.goapi.domain.gsmapi.student.repository;

import live.goapi.domain.gsmapi.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByStudentName(String studentName);
    Optional<Student> findByStudentNumber(String studentNumber);
    List<Student> findByStudentMajor(String studentMajor);
}
