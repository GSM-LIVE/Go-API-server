package live.goapi.controller;

import live.goapi.dto.response.ResponseTeacher;
import live.goapi.service.TeacherInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherInfoController {

    private TeacherInfoService teacherInfoService;

    @GetMapping("/info/{teacherName}")
    public ResponseTeacher getTeacherInfoByName(@PathVariable String teacherName) {
        return teacherInfoService.getTeacherInfoByName(teacherName);
    }

    @GetMapping("/info/{subject}")
    public ResponseTeacher getTeacherInfoBySubject(@PathVariable String subject) {
        return teacherInfoService.getTeacherInfBySubject(subject);
    }
}

