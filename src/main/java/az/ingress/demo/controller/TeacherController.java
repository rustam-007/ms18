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

//    public TeacherController(ModelMapper modelMapper, TeacherService teacherService) {
//        this.modelMapper = modelMapper;
//        this.teacherService = teacherService;
//    }


    @GetMapping("{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        System.out.println(teacherServiceImpl2);
        return teacherServiceImpl2.getTeacherById(id);
    }

    @PostMapping
    public String saveTeacher(@RequestBody Teacher teacher) {
        teacherServiceImpl2.saveTeacher(teacher);
        return "Teacher inserted to db with name: " + teacher.getName();
    }

    @PutMapping
    public String updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        teacherServiceImpl2.updateTeacher(id, teacher);
        return "Teacher with id:" + id + " was updated";
    }

    @DeleteMapping
    public String deleteTeacher(@RequestParam(value = "id") int id) {
        return "Teacher with id: " + id + " was deleted";
    }
}
