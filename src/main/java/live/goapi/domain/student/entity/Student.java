package live.goapi.domain.student.entity;

import live.goapi.domain.api_key.entity.ApiKey;
import live.goapi.domain.club.entity.Club;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "studnet_name")
    private String studentName;

    @Column(name = "student_number")
    private String studentNumber;

    @Column(name = "major")
    private String studentMajor;

    @ManyToOne
    @Column(name = "club_id")
    private Club club;

}
