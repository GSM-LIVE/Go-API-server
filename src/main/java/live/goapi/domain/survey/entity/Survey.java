package live.goapi.domain.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id", nullable = false)
    private Long surveyId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "position")
    private String position;

    @Column(name = "description")
    private String description;

}
