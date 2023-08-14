package az.ingress.demo.service;

import az.ingress.demo.model.Teacher;


public interface TeacherService {

    Teacher getTeacherById(int id);

    void save(Teacher teacher);
}
