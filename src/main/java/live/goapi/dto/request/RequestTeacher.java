package live.goapi.dto.request;

import live.goapi.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
