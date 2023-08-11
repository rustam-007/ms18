package az.ingress.demo.service;

import az.ingress.demo.model.Student;
import az.ingress.demo.repository.StudentRepository;


public interface StudentService {

    Student getStudentById(int id);

    void save(Student student);
}
