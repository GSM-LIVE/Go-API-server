package live.goapi.domain.student.service;

import live.goapi.domain.api_key.service.CheckApiKeyService;
import live.goapi.domain.club.entity.Club;
import live.goapi.domain.club.repository.ClubRepository;
import live.goapi.domain.student.entity.Student;
import live.goapi.domain.student.exception.NotFoundStudentException;
import live.goapi.domain.student.presentation.dto.request.*;
import live.goapi.domain.student.presentation.dto.response.ResponseStudent;
import live.goapi.domain.student.repository.StudentRepository;
import live.goapi.domain.teacher.exception.NotFoundTeacherException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentInfoService {

    private final StudentRepository studentRepository;
    private final ClubRepository clubRepository;
    private final CheckApiKeyService checkApiKeyService;



    public ResponseStudent getStudentInfoByStudentName (RequestStudentName request) {

        checkApiKeyService.checkApiKey(request.getRandomKey());

        Student findStudent = studentRepository.findByStudentName(request.getStudentName()).orElseThrow(
                () -> new NotFoundStudentException("존재하지 않는 학생입니다"));
        return makeResponseStudent(findStudent);
    }

    public ResponseStudent getStudentInfoByStudentNumber(RequestStudentNumber request) {

        checkApiKeyService.checkApiKey(request.getRandomKey());

        Student findStudent = studentRepository.findByStudentNumber(request.getStudentNumber())
                .orElseThrow( ()-> new NotFoundTeacherException("존재하지 않는 학생입니다"));

        return makeResponseStudent(findStudent);
    }

    public List<ResponseStudent> getStudentsInfoByMajor(RequestStudentMajor request) {

        checkApiKeyService.checkApiKey(request.getRandomKey());

        List<Student> students = studentRepository.findByStudentMajor(request.getMajor());
        
        
        if(students.isEmpty()){
            throw new NotFoundStudentException("존재하지 않는 학생들입니다.");
        }

        List<ResponseStudent> responseList = makeResponseStudentList(students);

        return responseList;
    }
    
    public List<ResponseStudent> getStudentsByClub(RequestStudentClub request) {

        checkApiKeyService.checkApiKey(request.getRandomKey());

        Optional<Club> club = clubRepository.findByClubName(request.getClubName());
        List<Student> clubStudents = studentRepository.findByClub(club.get());
        
        
        if(clubStudents.isEmpty()) {
            throw new NotFoundStudentException("존재하지 않는 학생들입니다.");
        }

        List<ResponseStudent> responseList = makeResponseStudentList(clubStudents);

        return responseList;
    }

    public List<ResponseStudent> getAllStudents(RequestAllStudent request) {
        checkApiKeyService.checkApiKey(request.getRandomKey());
        List<Student> students = studentRepository.findAll();

        if(students.isEmpty()) {
            throw new NotFoundStudentException("존재하지 않는 학생들입니다.");
        }

        List<ResponseStudent> response = makeResponseStudentList(students);
        return response;
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
        List<ResponseStudent> responseList = students.stream()
                .map(s -> new ResponseStudent(s.getStudentName() ,s.getStudentNumber()
                        , s.getStudentMajor(), s.getClub().getClubName()))
                .collect(Collectors.toList());

        return responseList;
    }
}
