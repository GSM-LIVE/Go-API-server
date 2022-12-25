package live.goapi.domain.teacher.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class RequestTeacherMajor {
    @NotBlank
    private final String major;

    @NotBlank
    private final String randomKey;
}
