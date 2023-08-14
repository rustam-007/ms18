package az.ingress.demo.service;

import az.ingress.demo.model.Teacher;


public interface TeacherService {

    Teacher getTeacherById(int id);

    void saveTeacher(Teacher teacher);

    void updateTeacher(int id, Teacher teacher);

    void deleteTeacher(int id);
}
