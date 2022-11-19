package live.goapi.dto.request;

import live.goapi.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestStudent {
    private String studentName;
    private String studentNumber;
    private String studentMajor;

    public Student toEntity() {
        return Student.builder()
                .studentName(studentName)
                .studentNumber(studentNumber)
                .studentMajor(studentMajor)
                .build();
    }
}
