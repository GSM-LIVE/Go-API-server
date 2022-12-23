package live.goapi.domain.survey.presentation;

import live.goapi.domain.survey.presentation.dto.WriteSurveyRequest;
import live.goapi.domain.survey.service.WriteSurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
public class SurveyController {

    private final WriteSurveyService writeSurveyService;

    @PostMapping
    public ResponseEntity<Void> writeSurvey(@Valid @RequestBody WriteSurveyRequest request) {
        writeSurveyService.writeSurvey(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
