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

    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacher(int id, Teacher teacher) {
        Teacher teacher1 = teacherRepository.findById(id).get();
        teacher1.setAge(teacher.getAge());
        teacher1.setName(teacher.getName());
        teacher1.setSurname(teacher.getSurname());
        teacher1.setSubject(teacher.getSubject());
        teacher1.setSalary(teacher.getSalary());
    }

    @Override
    public void deleteTeacher(int id) {
        teacherRepository.deleteById(id);
    }
}
