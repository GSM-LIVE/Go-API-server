package live.goapi.controller;

import live.goapi.domain.Student;
import live.goapi.dto.response.ResponseStudent;
import live.goapi.service.StudentInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
    @PostMapping("/info/name")
    public ResponseStudent getStudentInfoByName(String name) {
        return studentInfoService.getStudentInfoByName(name);
    }

    @PostMapping("/info/number")
    public ResponseStudent getStudentInfoByNumber(String number) {
        return studentInfoService.getStudentInfoByNumber(number);
    }

    @PostMapping("/info/major")
    public ArrayList<ResponseStudent> getStudentInfoByMajor(String major) {
        return studentInfoService.getStudentsInfoByMajor(major);
    }
}
