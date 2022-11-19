package live.goapi.util;

import live.goapi.domain.Student;
import live.goapi.dto.response.ResponseStudent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentUtil {

    public ResponseStudent makeResponseStudent(Student findStudent) {
        return ResponseStudent.builder()
                .studentName(findStudent.getStudentName())
                .studentNumber(findStudent.getStudentNumber())
                .studentMajor(findStudent.getStudentMajor())
                .build();
    }

}
