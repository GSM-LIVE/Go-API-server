package live.goapi.domain.teacher.presentation;

import live.goapi.domain.teacher.presentation.dto.response.ResponseTeacher;
import live.goapi.domain.teacher.service.TeacherInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/{subject}")
    public List<ResponseTeacher> getTeacherInfoBySubject(@PathVariable String subject) {
        return teacherInfoService.getTeacherInfoBySubject(subject);
    }
}

