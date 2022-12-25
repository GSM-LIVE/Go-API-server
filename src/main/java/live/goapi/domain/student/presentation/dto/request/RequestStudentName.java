package live.goapi.domain.student.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class RequestStudentName {

    @NotBlank
    private final String studentName;

    @NotBlank
    private final String randomKey;
}
