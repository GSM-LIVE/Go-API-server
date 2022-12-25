package live.goapi.domain.student.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class RequestAllStudent {
    @NotBlank
    private String randomKey;
}
