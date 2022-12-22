package live.goapi.domain.teacher.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestTeacherName {
    @NotBlank
    private String teacherName;

    @NotBlank
    private String randomKey;
}
