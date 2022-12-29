package live.goapi.domain.teacher.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", nullable = false)
    private Integer teacherId;

    @Column(name = "teacher_name" , nullable = false)
    private String teacherName;

    @Column(name = "teacher_major" , nullable = false)
    private String teacherMajor;

}
