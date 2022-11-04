package live.goapi.service;

import live.goapi.domain.Student;
import live.goapi.domain.repository.StudentRepository;
import live.goapi.dto.response.ResponseStudent;
import live.goapi.util.StudentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentInfoService {
    private final StudentRepository studentRepository;
    private final StudentUtil studentUtil;

    public ResponseStudent getStudentInfoByName(String name) {
        Optional<Student> findStudent = studentRepository.findByName(name);
        return studentUtil.makeResponseStudent(findStudent);
    }

    public ResponseStudent getStudentInfoByNumber(String number) {
        Optional<Student> findStudent = studentRepository.findByNumber(number);
        return studentUtil.makeResponseStudent(findStudent);
    }

    public ArrayList<ResponseStudent> getStudentsInfoByMajor(String major) {
        ArrayList<ResponseStudent> findStudents = studentRepository.findByMajor(major);

        if(findStudents.isEmpty()){
            throw new NullPointerException("해당하는 학생의 정보가 존재하지 않습니다.");
        }

        return findStudents;
    }
}

