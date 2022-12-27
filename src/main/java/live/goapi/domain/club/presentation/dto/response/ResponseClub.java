package live.goapi.domain.club.presentation.dto.response;

import live.goapi.domain.student.presentation.dto.response.ResponseStudent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClub {
    private String clubName;
    private List<String> clubStudentName;
}
