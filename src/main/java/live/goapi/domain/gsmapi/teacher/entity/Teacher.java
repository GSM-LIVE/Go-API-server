package live.goapi.domain.gsmapi.teacher.entity;


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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id", nullable = false)
    private Integer teacherId;

    @Column(name = "teacher_name" , nullable = false , unique = true)
    private String teacherName;

    @Column(name = "subject" , nullable = false, unique = true)
    private String subject;

}
