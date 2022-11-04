package live.goapi.domain.repository;

import live.goapi.domain.Student;
import live.goapi.dto.response.ResponseStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentRepository extends JpaRepository<Integer , Student> {
    Student findByName(String name);
    Student findByNumber(String number);
    ArrayList<ResponseStudent> findByMajor(String major);
}
