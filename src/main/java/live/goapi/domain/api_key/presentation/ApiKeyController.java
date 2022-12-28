package live.goapi.domain.api_key.presentation;

import live.goapi.domain.api_key.presentation.dto.response.ApiKeyResponse;
import live.goapi.domain.api_key.service.LookUpApiKeyService;
import live.goapi.domain.api_key.service.RandomApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api-key")
public class ApiKeyController {

    private final RandomApiKeyService randomApiKeyService;
    private final LookUpApiKeyService lookUpApiKeyService;

    @GetMapping("/api-key")
    public ResponseEntity<ApiKeyResponse> getApiKey() {
        ApiKeyResponse response = lookUpApiKeyService.lookUpApiKey();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/api-key/name")
    public ResponseEntity<ApiKeyResponse> getApiKeyByMemberName(@RequestBody String name) {
        ApiKeyResponse response = lookUpApiKeyService.lookUpApiKeyByMemberName(name);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ApiKeyResponse> getNewApiKey() {
        ApiKeyResponse response = randomApiKeyService.execute();
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }
}
