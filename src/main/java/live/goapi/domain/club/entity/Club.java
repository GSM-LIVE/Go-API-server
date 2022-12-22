package live.goapi.domain.club.entity;

import live.goapi.domain.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "club_name")
    private String clubName;

    @OneToMany
    private List<Student> students;
}
