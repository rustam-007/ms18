package az.ingress.demo.controller;

import az.ingress.demo.model.Teacher;
import az.ingress.demo.service.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
//@RequiredArgsConstructor only final variables
@AllArgsConstructor
public class TeacherController {

    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final TeacherService teacherServiceImpl2;

//    public StudentController(ModelMapper modelMapper, StudentService studentService) {
//        this.modelMapper = modelMapper;
//        this.studentService = studentService;
//    }


    @GetMapping("{id}")
    public Teacher getStudentById(@PathVariable int id) {
        System.out.println(teacherServiceImpl2);
        return teacherServiceImpl2.getTeacherById(id);
    }

    @PostMapping
    public String saveStudent(@RequestBody Teacher teacher) {
        teacherServiceImpl2.save(teacher);
        return "Student inserted to db with name: " + teacher.getName();
    }

    @PutMapping
    public Integer updateStudent (@RequestBody Teacher teacher) {
        teacher.setName("Kamil");
        System.out.println(teacher);
        return teacher.getId();
    }

    @DeleteMapping
    public String deleteStudent (@RequestParam(value = "id") int id) {
        return "Student with id: " + id + " was deleted";
    }
}
