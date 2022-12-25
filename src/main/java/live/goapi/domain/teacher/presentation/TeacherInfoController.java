package live.goapi.domain.teacher.presentation;

import live.goapi.domain.teacher.presentation.dto.request.RequestTeacherMajor;
import live.goapi.domain.teacher.presentation.dto.request.RequestTeacherName;
import live.goapi.domain.teacher.presentation.dto.response.ResponseTeacher;
import live.goapi.domain.teacher.service.TeacherInfoService;
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
@RequestMapping("/teacher")
public class TeacherInfoController {

    private final TeacherInfoService teacherInfoService;

    @GetMapping("/name")
    public ResponseEntity<ResponseTeacher> getTeacherInfoByName(@RequestBody @Valid RequestTeacherName request) {
        ResponseTeacher response = teacherInfoService.getTeacherInfoByName(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/major")
    public ResponseEntity<List<ResponseTeacher>> getTeacherInfoBySubject(@RequestBody @Valid RequestTeacherMajor request) {
        List<ResponseTeacher> response = teacherInfoService.getTeacherInfoByMajor(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

