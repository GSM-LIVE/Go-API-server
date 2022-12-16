package live.goapi.domain.gsmapi.teacher.presentation.dto.request;

import live.goapi.domain.gsmapi.teacher.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestTeacher {

    private String teacherName;
    private String subject;

    public Teacher toEntity() {
        return Teacher.builder().
                teacherName(teacherName).
                subject(subject).
                build();
    }


}
