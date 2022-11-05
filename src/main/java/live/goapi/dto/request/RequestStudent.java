package live.goapi.dto.request;

import live.goapi.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestStudent {
    private String name;
    private String number;
    private String major;

    public Student toEntity() {
        return Student.builder()
                .name(name)
                .number(number)
                .major(major)
                .build();
    }
}
