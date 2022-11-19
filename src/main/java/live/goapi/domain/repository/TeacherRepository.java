package live.goapi.domain.repository;

import live.goapi.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Optional<Teacher> findByTeacherName(String name);

    Optional<Teacher> findBySubject(String subject);
}
