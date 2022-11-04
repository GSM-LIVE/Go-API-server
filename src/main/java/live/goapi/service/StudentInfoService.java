package live.goapi.service;

import live.goapi.domain.Student;
import live.goapi.domain.repository.StudentRepository;
import live.goapi.dto.response.ResponseStudent;
import live.goapi.util.StudentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StudentInfoService {
    private final StudentRepository studentRepository;
    private final StudentUtil studentUtil;

    ResponseStudent getStudentInfoByName(String name) {
        Student findStudent = studentRepository.findByName(name);
        return studentUtil.makeResponseStudent(findStudent);
    }

    ResponseStudent getStudentInfoByNumber(String number) {
        Student findStudent = studentRepository.findByNumber(number);
        return studentUtil.makeResponseStudent(findStudent);
    }

    ArrayList<Student> getStudentsInfoByMajor(String major) {
        ArrayList<Student> findStudents = studentRepository.findByMajor(major);

        if(findStudents.isEmpty()){
            throw new NullPointerException("존재하지 않는 학생입니다.");
        }
        return findStudents;
    }


}

