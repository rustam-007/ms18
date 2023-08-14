package az.ingress.demo.service.impl;

import az.ingress.demo.model.Teacher;
import az.ingress.demo.repository.TeacherRepository;
import az.ingress.demo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id).get();
    }

    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
