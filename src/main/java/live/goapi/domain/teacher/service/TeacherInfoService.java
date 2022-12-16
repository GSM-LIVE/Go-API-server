package live.goapi.domain.teacher.service;

import live.goapi.domain.teacher.entity.Teacher;
import live.goapi.domain.teacher.repository.TeacherRepository;
import live.goapi.domain.teacher.presentation.dto.request.RequestTeacher;
import live.goapi.domain.teacher.presentation.dto.response.ResponseTeacher;
import live.goapi.global.exception.collection.NotFoundTeacherException;
import live.goapi.global.util.TeacherUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherInfoService {
    private final TeacherRepository teacherRepository;

    public void saveTeacherInfo(RequestTeacher requestTeacher) {
        Teacher teacher = requestTeacher.toEntity();
        teacherRepository.save(teacher);
    }

    public ResponseTeacher getTeacherInfoByName (String teacherName) {
        Teacher findTeacher = teacherRepository.findByTeacherName(teacherName).orElseThrow(
                () -> new NotFoundTeacherException("존재하지 않는 선생님입니다"));
        return makeResponseTeacher(findTeacher);
    }

    public List<ResponseTeacher> getTeacherInfoBySubject(String subject) {
        List<Teacher> teachers = teacherRepository.findBySubject(subject);
        List<ResponseTeacher> responseList = new ArrayList<>();
        if(teachers.isEmpty()){
            throw new NotFoundTeacherException("존재하지 않는 선생님입니다.");
        }

        for (Teacher teacher : teachers) {
            responseList.add(new ResponseTeacher(teacher.getTeacherName(), teacher.getSubject()));
        }

        return responseList;
    }

    public ResponseTeacher makeResponseTeacher(Teacher findTeacher){

        ResponseTeacher responseTeacher = new ResponseTeacher(
                findTeacher.getTeacherName(),
                findTeacher.getSubject());
        return responseTeacher;
    }

}
