package live.goapi.domain.survey.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class WriteSurveyRequest {

    @NotBlank
    private final String groupName;

    @NotBlank
    private final String projectName;

    @NotBlank
    private final String purpose;

    @NotBlank
    private final String position;

    @NotBlank
    private final String description;

}
