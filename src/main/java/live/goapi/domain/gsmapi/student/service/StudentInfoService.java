package live.goapi.domain.gsmapi.student.service;

import live.goapi.domain.gsmapi.student.entity.Student;
import live.goapi.domain.gsmapi.student.exception.NotFoundStudentException;
import live.goapi.domain.gsmapi.student.presentation.dto.response.ResponseStudent;
import live.goapi.domain.gsmapi.student.repository.StudentRepository;
import live.goapi.domain.gsmapi.student.presentation.dto.request.RequestStudent;
import live.goapi.domain.gsmapi.teacher.exception.NotFoundTeacherException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentInfoService {

    private final StudentRepository studentRepository;

    public void saveStudentInfo(RequestStudent requestStudent) {
        Student student = requestStudent.toEntity();
        studentRepository.save(student);
    }

    public ResponseStudent getStudentInfoByStudentName (String studentName) {
        Student findStudent = studentRepository.findByStudentName(studentName).orElseThrow(
                () -> new NotFoundStudentException("존재하지 않는 학생입니다"));
        return makeResponseStudent(findStudent);
    }

    public ResponseStudent getStudentInfoByStudentNumber(String studentNumber) {
        Student findStudent = studentRepository.findByStudentNumber(studentNumber).orElseThrow(
                ()-> new NotFoundTeacherException("존재하지 않는 학생입니다"));
        return makeResponseStudent(findStudent);
    }

    public List<ResponseStudent> getStudentsInfoByMajor(String major) {
        List<Student> students = studentRepository.findByStudentMajor(major);
        List<ResponseStudent> responseList = new ArrayList<>();
        if(students.isEmpty()){
            throw new NotFoundStudentException("존재하지 않는 학생들입니다.");
        }

        for (Student student : students) {
            responseList.add(new ResponseStudent(
                    student.getStudentName(),
                    student.getStudentNumber(),
                    student.getStudentMajor()));
        }

        return responseList;
    }

    public ResponseStudent makeResponseStudent(Student findStudent) {
        return ResponseStudent.builder()
                .studentName(findStudent.getStudentName())
                .studentNumber(findStudent.getStudentNumber())
                .studentMajor(findStudent.getStudentMajor())
                .build();
    }
}
