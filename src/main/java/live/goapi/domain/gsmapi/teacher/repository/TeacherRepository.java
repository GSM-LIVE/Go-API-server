package live.goapi.domain.gsmapi.teacher.repository;

import live.goapi.domain.gsmapi.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Optional<Teacher> findByTeacherName(String name);

    List<Teacher> findBySubject(String subject);
}
