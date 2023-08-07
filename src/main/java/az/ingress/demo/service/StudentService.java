package az.ingress.demo.service;

import az.ingress.demo.model.Student;
import az.ingress.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudentByid(int id) {
        return studentRepository.findById(id).get();
    }
}
