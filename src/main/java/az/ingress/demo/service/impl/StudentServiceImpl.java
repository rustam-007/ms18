package az.ingress.demo.service.impl;

import az.ingress.demo.model.Student;
import az.ingress.demo.repository.StudentRepository;
import az.ingress.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }
}
