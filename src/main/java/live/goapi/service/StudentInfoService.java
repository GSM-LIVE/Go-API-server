package live.goapi.service;

import live.goapi.domain.Student;
import live.goapi.domain.Teacher;
import live.goapi.domain.repository.StudentRepository;
import live.goapi.dto.request.RequestStudent;
import live.goapi.dto.request.RequestTeacher;
import live.goapi.dto.response.ResponseStudent;
import live.goapi.dto.response.ResponseTeacher;
import live.goapi.exception.exceptions.NotFoundStudentException;
import live.goapi.exception.exceptions.NotFoundTeacherException;
import live.goapi.util.StudentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentInfoService {

    private final StudentRepository studentRepository;
    private final StudentUtil studentUtil;

    public Integer saveStudentInfo(RequestStudent requestStudent) {
        Student student = requestStudent.toEntity();
        studentRepository.save(student);
        return student.getStudentId();
    }

    public ResponseStudent getStudentInfoByStudentName (String studentName) {
        Student findStudent = studentRepository.findByStudentName(studentName).orElseThrow(
                () -> new NotFoundStudentException("존재하지 않는 학생입니다"));
        return studentUtil.makeResponseStudent(findStudent);
    }

    public ResponseStudent getStudentInfoByStudentNumber(String studentNumber) {
        Student findStudent = studentRepository.findByStudentNumber(studentNumber).orElseThrow(
                ()-> new NotFoundTeacherException("존재하지 않는 학생입니다"));
        return studentUtil.makeResponseStudent(findStudent);
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
}
