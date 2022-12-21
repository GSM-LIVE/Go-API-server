package live.goapi.domain.teacher.service;

import live.goapi.domain.api_key.service.CheckApiKeyService;
import live.goapi.domain.teacher.entity.Teacher;
import live.goapi.domain.teacher.exception.NotFoundTeacherException;
import live.goapi.domain.teacher.presentation.dto.request.RequestTeacherMajor;
import live.goapi.domain.teacher.presentation.dto.request.RequestTeacherName;
import live.goapi.domain.teacher.presentation.dto.response.ResponseTeacher;
import live.goapi.domain.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherInfoService {
    private final TeacherRepository teacherRepository;

    private CheckApiKeyService checkApiKeyService;


    public ResponseTeacher getTeacherInfoByName (RequestTeacherName request) {
        checkApiKeyService.checkApiKey(request.getRandomKey());

        Teacher teacher = teacherRepository.findByTeacherName(request.getTeacherName())
                .orElseThrow(() -> new NotFoundTeacherException("존재하지 않는 선생님입니다."));
        return makeResponseTeacher(teacher);
    }

    public ResponseTeacher getTeacherInfoByMajor(RequestTeacherMajor request) {
        checkApiKeyService.checkApiKey(request.getRandomKey());

        Teacher teacher = teacherRepository.findByTeacherName(request.getMajor())
                .orElseThrow(() -> new NotFoundTeacherException("존재하지 않는 선생님입니다."));
        return makeResponseTeacher(teacher);
    }

    public ResponseTeacher makeResponseTeacher(Teacher teacher){

        return ResponseTeacher.builder()
                .teacherName(teacher.getTeacherName())
                .major(teacher.getTeacherMajor())
                .build();
    }

}
