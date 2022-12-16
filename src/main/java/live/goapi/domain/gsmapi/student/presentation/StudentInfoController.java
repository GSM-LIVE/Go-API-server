package live.goapi.domain.gsmapi.student.presentation;

import live.goapi.domain.gsmapi.student.presentation.dto.response.ResponseStudent;
import live.goapi.domain.gsmapi.student.service.StudentInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    @GetMapping("/info/{name}")
    public ResponseStudent getStudentInfoByName(@PathVariable String name) {
        return studentInfoService.getStudentInfoByStudentName(name);
    }

    @GetMapping("/info/{number}")
    public ResponseStudent getStudentInfoByNumber(@PathVariable String number) {
        return studentInfoService.getStudentInfoByStudentNumber(number);
    }

    @GetMapping("/info/{major}")
    public List<ResponseStudent> getStudentInfoByMajor(@PathVariable String major) {
        return studentInfoService.getStudentsInfoByMajor(major);
    }
}
