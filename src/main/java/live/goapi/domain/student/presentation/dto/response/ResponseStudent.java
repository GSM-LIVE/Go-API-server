package live.goapi.domain.student.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStudent {
    private String studentName;
    private String studentNumber;
    private String studentMajor;
}
