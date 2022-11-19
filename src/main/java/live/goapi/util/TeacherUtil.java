package live.goapi.util;

import live.goapi.domain.Teacher;
import live.goapi.dto.response.ResponseTeacher;
import org.springframework.stereotype.Component;


@Component
public class TeacherUtil {
    public ResponseTeacher makeResponseTeacher(Teacher findTeacher){

        ResponseTeacher responseTeacher = new ResponseTeacher(
                findTeacher.getTeacherName(),
                findTeacher.getSubject());
        return responseTeacher;
    }
}
