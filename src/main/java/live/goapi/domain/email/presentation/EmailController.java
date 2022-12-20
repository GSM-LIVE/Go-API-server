package live.goapi.domain.email.presentation;

import live.goapi.domain.email.presentation.dto.request.EmailSentDto;
import live.goapi.domain.email.service.EmailSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailSendService emailSendService;

    @PostMapping(value = "/send" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody EmailSentDto emailSentDto) {
        emailSendService.sendEmail(emailSentDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
