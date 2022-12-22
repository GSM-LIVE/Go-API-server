package live.goapi.domain.teacher.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ResponseTeacher {
    private String teacherName;
    private String major;
}
