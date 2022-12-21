package live.goapi.domain.api_key.presentation;

import live.goapi.domain.api_key.presentation.dto.response.ApiKeyResponse;
import live.goapi.domain.api_key.service.RandomApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api-key")
@Slf4j
public class ApiKeyController {

    private final RandomApiKeyService randomApiKeyService;

    @PostMapping
    public ResponseEntity<ApiKeyResponse> getNewApiKey() {
        ApiKeyResponse response = randomApiKeyService.execute();
        log.info("response ={}" , response);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }
}
