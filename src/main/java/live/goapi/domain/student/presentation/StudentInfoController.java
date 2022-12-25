package live.goapi.domain.student.presentation;

import live.goapi.domain.student.presentation.dto.request.*;
import live.goapi.domain.student.presentation.dto.response.ResponseStudent;
import live.goapi.domain.student.service.StudentInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentInfoController {

    private final StudentInfoService studentInfoService;

    @PostMapping
    public ResponseEntity<List<ResponseStudent>> getAllStudents(@RequestBody @Valid RequestAllStudent request) {
        List<ResponseStudent> response = studentInfoService.getAllStudents(request);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @PostMapping("/name")
    public ResponseEntity<ResponseStudent> getStudentInfoByName(@RequestBody @Valid RequestStudentName request) {
        ResponseStudent response = studentInfoService.getStudentInfoByStudentName(request);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @PostMapping("/number")
    public ResponseEntity<ResponseStudent> getStudentInfoByNumber(@RequestBody @Valid RequestStudentNumber request) {
        ResponseStudent response = studentInfoService.getStudentInfoByStudentNumber(request);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @PostMapping("/major")
    public ResponseEntity<List<ResponseStudent>> getStudentInfoByMajor(@RequestBody @Valid RequestStudentMajor request) {
        List<ResponseStudent> response = studentInfoService.getStudentsInfoByMajor(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/club")
    public ResponseEntity<List<ResponseStudent>> getStudentInfoByClub(@RequestBody RequestStudentClub request) {
        List<ResponseStudent> response = studentInfoService.getStudentsByClub(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
