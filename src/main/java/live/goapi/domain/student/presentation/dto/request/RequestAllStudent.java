package live.goapi.domain.student.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect
public class RequestAllStudent {
    @NotBlank
    private String randomKey;
}
