package live.goapi.util;

import live.goapi.domain.Teacher;
import live.goapi.dto.response.ResponseTeacher;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TeacherUtil {
    public ResponseTeacher makeResponseTeacher(Optional<Teacher> findTeacher){
        if(findTeacher == null) {
            throw new NullPointerException("존재하지 않는 선생님입니다");
        }
        ResponseTeacher responseTeacher = new ResponseTeacher(
                findTeacher.get().getTeacherName(),
                findTeacher.get().getSubject());

        return responseTeacher;
    }
}
