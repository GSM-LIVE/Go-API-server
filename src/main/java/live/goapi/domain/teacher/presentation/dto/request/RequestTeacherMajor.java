package live.goapi.domain.teacher.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestTeacherMajor {
    @NotBlank
    private String major;

    @NotBlank
    private String randomKey;
}
