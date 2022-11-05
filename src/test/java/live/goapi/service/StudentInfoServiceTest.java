package live.goapi.service;

import live.goapi.domain.Student;
import live.goapi.domain.repository.StudentRepository;
import live.goapi.dto.request.RequestStudent;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StudentInfoServiceTest {

    private final StudentInfoService studentInfoService;
    private final StudentRepository studentRepository;

    StudentInfoServiceTest(StudentInfoService studentInfoService, StudentRepository studentRepository) {
        this.studentInfoService = studentInfoService;
        this.studentRepository = studentRepository;
    }

    @Test
    void saveStudentInfo() {
        Student student = new Student("김희망" , "1306" , "Back-End");
        RequestStudent requestStudent = new RequestStudent(student.getName(),student.getNumber(),student.getMajor());
        Integer saveStudentId = studentInfoService.saveStudentInfo(requestStudent);
        Assertions.assertThat(saveStudentId).isEqualTo(1);
    }

}