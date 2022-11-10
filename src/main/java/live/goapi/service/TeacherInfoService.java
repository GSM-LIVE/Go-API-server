package live.goapi.service;

import live.goapi.domain.Teacher;
import live.goapi.domain.repository.TeacherRepository;
import live.goapi.dto.request.RequestTeacher;
import live.goapi.dto.response.ResponseTeacher;
import live.goapi.util.TeacherUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherInfoService {
    private final TeacherRepository teacherRepository;
    private final TeacherUtil teacherUtil;

    public Integer saveTeacherInfo(RequestTeacher requestTeacher) {
        Teacher teacher = requestTeacher.toEntity();
        teacherRepository.save(teacher);
        return teacher.getTeacherId();
    }

    public ResponseTeacher getTeacherInfoByName (String teacherName) {
        Optional<Teacher> findTeacher = teacherRepository.findByTeacherName(teacherName);
        return teacherUtil.makeResponseTeacher(findTeacher);
    }

    public  ResponseTeacher getTeacherInfBySubject (String subject) {
        Optional<Teacher> findTeacher = teacherRepository.findBySubject(subject);
        return teacherUtil.makeResponseTeacher(findTeacher);
    }

}
