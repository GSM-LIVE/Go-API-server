package live.goapi.domain.student.service;

import live.goapi.domain.club.entity.Club;
import live.goapi.domain.club.repository.ClubRepository;
import live.goapi.domain.student.entity.Student;
import live.goapi.domain.student.exception.NotFoundStudentException;
import live.goapi.domain.student.presentation.dto.response.ResponseStudent;
import live.goapi.domain.student.repository.StudentRepository;
import live.goapi.domain.student.presentation.dto.request.RequestStudent;
import live.goapi.domain.teacher.exception.NotFoundTeacherException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentInfoService {

    private final StudentRepository studentRepository;
    private final ClubRepository clubRepository;
    
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
        
        
        if(students.isEmpty()){
            throw new NotFoundStudentException("존재하지 않는 학생들입니다.");
        }

        List<ResponseStudent> responseList = makeResponseStudentList(students);

        return responseList;
    }
    
    public List<ResponseStudent> getStudentsByClub(String clubName) {
        Optional<Club> club = clubRepository.findByClubName(clubName);
        List<Student> clubStudents = studentRepository.findByClub(club.get());
        
        
        if(clubStudents.isEmpty()) {
            throw new NotFoundStudentException("존재하지 않는 학생들입니다.");
        }

        List<ResponseStudent> responseList = makeResponseStudentList(clubStudents);

        return responseList;
    }

    private ResponseStudent makeResponseStudent(Student findStudent) {
        return ResponseStudent.builder()
                .studentName(findStudent.getStudentName())
                .studentNumber(findStudent.getStudentNumber())
                .studentMajor(findStudent.getStudentMajor())
                .club(findStudent.getClub().getClubName())
                .build();
    }
    
    private List<ResponseStudent> makeResponseStudentList(List<Student> students) {
        List<ResponseStudent> responseList = new ArrayList<>();
        for (Student clubStudent : students) {
            responseList.add(makeResponseStudent(clubStudent));
        }
        return responseList;
    }
}
