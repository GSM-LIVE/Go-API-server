package live.goapi.domain.student.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class RequestStudentClub {
    @NotBlank
    private final String clubName;
    @NotBlank
    private final String randomKey;
}
