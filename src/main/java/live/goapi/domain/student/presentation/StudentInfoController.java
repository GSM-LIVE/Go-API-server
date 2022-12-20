package live.goapi.domain.student.presentation;

import live.goapi.domain.student.presentation.dto.response.ResponseStudent;
import live.goapi.domain.student.service.StudentInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentInfoController {

    private final StudentInfoService studentInfoService;

    /**
     * @param name
     * @return ResponseStudent
     * name = 김희망
     * {
     * "name" : "김희망"
     * "number" : "1306"
     * "major" : "Back-End"
     * }
     */
    @PostMapping("/info{name")
    public ResponseStudent getStudentInfoByName(@RequestBody String name) {
        return studentInfoService.getStudentInfoByStudentName(name);
    }

    @PostMapping("/info/number")
    public ResponseStudent getStudentInfoByNumber(@RequestBody  String number) {
        return studentInfoService.getStudentInfoByStudentNumber(number);
    }

    @PostMapping("/info/major")
    public ResponseEntity<List<ResponseStudent>> getStudentInfoByMajor(@RequestBody String major) {
        List<ResponseStudent> response = studentInfoService.getStudentsInfoByMajor(major);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/info/club")
    public ResponseEntity<List<ResponseStudent>> getStudentInfoByClub(@RequestBody String clubName) {
        List<ResponseStudent> response = studentInfoService.getStudentsByClub(clubName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
