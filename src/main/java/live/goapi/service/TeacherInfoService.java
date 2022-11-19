package live.goapi.service;

import live.goapi.domain.Teacher;
import live.goapi.domain.repository.TeacherRepository;
import live.goapi.dto.request.RequestTeacher;
import live.goapi.dto.response.ResponseTeacher;
import live.goapi.exception.collection.NotFoundTeacherException;
import live.goapi.util.TeacherUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        Teacher findTeacher = teacherRepository.findByTeacherName(teacherName).orElseThrow(() ->new NotFoundTeacherException("존재하지 않는 선생님입니다"));
        return teacherUtil.makeResponseTeacher(findTeacher);
    }

    public  ResponseTeacher getTeacherInfoBySubject(String subject) {
        Teacher findTeacher = teacherRepository.findBySubject(subject).orElseThrow(()-> new NotFoundTeacherException("존재하지 않는 선생님입니다"));
        return teacherUtil.makeResponseTeacher(findTeacher);
    }

}
