package live.goapi.util;

import live.goapi.domain.Student;
import live.goapi.dto.response.ResponseStudent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentUtil {
    public ResponseStudent makeResponseStudent(Optional<Student> findStudent) {
        if(findStudent == null){
            throw new NullPointerException("존재하지 않는 학생입니다.");
        }
        ResponseStudent response = new ResponseStudent(
                findStudent.get().getName(), findStudent.get().getNumber(), findStudent.get().getMajor());
        return response;
    }
}
