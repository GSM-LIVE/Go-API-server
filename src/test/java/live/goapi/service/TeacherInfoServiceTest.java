package live.goapi.service;

import live.goapi.domain.Teacher;
import live.goapi.domain.repository.TeacherRepository;
import live.goapi.dto.request.RequestTeacher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherInfoServiceTest {
    private final TeacherInfoService teacherInfoService;
    private final TeacherRepository teacherRepository;

    public TeacherInfoServiceTest(TeacherInfoService teacherInfoService, TeacherRepository teacherRepository) {
        this.teacherInfoService = teacherInfoService;
        this.teacherRepository = teacherRepository;
    }

    @Test
    void saveTeacherInfo() {
        Teacher teacher = new Teacher("윤민화", "과학");
            RequestTeacher requestTeacher = new RequestTeacher(teacher.getTeacherName(), teacher.getSubject());
            Integer saveTeacherId = teacherInfoService.saveTeacherInfo(requestTeacher);
            Assertions.assertThat(saveTeacherId).isEqualTo(1);
        }
    }
