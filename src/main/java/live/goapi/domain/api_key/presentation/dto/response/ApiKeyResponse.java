package live.goapi.domain.api_key.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class ApiKeyResponse {
    private final String randomKey;
}
