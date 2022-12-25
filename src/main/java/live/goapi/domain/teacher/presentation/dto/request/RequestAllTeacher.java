package live.goapi.domain.teacher.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class RequestAllTeacher {
    @NotBlank
    private final String randomKey;
}
