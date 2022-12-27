package live.goapi.domain.club.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RequestClubName {
    private final String clubName;
    private final String apiKey;
}
