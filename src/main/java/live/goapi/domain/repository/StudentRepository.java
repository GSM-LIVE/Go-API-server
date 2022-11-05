package live.goapi.domain.repository;

import live.goapi.domain.Student;
import live.goapi.dto.response.ResponseStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student , Integer> {
    Optional<Student> findByName(String name);
    Optional<Student> findByNumber(String number);
    ArrayList<ResponseStudent> findByMajor(String major);
}
