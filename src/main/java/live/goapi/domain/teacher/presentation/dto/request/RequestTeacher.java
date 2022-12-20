package live.goapi.domain.teacher.presentation.dto.request;

import live.goapi.domain.teacher.entity.Teacher;
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
