package live.goapi.domain.club.service;

import live.goapi.domain.club.entity.Club;
import live.goapi.domain.club.exception.ClubNotFoundException;
import live.goapi.domain.auth.presentation.dto.dto.ClubMemberRequest;
import live.goapi.domain.club.repository.ClubRepository;
import live.goapi.domain.student.entity.Student;
import live.goapi.domain.student.presentation.dto.response.ResponseStudent;
import live.goapi.domain.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClubMemberService {

    private final ClubRepository clubRepository;
    private final StudentRepository studentRepository;

    public List<ResponseStudent> getClubStudents(ClubMemberRequest request) {
        Optional<Club> findClub = clubRepository.findByClubName(request.getClubName());
        List<Student> clubStudents = studentRepository.findByClub(findClub.get());

        if(clubStudents.isEmpty()) {
            throw new ClubNotFoundException("존재하지 않는 전공동아리 입니다.");
        }

        List<ResponseStudent> responseStudents = new ArrayList<>();


        for (Student clubStudent : clubStudents) {
            responseStudents.add(ResponseStudent.builder()
                    .studentName(clubStudent.getStudentName())
                    .studentNumber(clubStudent.getStudentNumber())
                    .studentMajor(clubStudent.getStudentMajor())
                    .build());
        }

        return responseStudents;
    }
}
