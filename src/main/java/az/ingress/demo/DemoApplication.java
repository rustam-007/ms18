package az.ingress.demo;

import az.ingress.demo.controller.TeacherController;
import az.ingress.demo.dto.TeacherDto;
import az.ingress.demo.model.Teacher;
import az.ingress.demo.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	TeacherService teacherServiceImpl;
	@Autowired
	TeacherController teacherController;
	@Autowired
	ModelMapper modelMapper;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//		for (String s : beanDefinitionNames) {
//			System.out.println(s);
//		}

		teacherServiceImpl.save(new Teacher(1, "Senan", "Senanov", 27));

		try {
			Teacher teacher = teacherServiceImpl.getTeacherById(1);
			TeacherDto teacherDto = TeacherDto.builder()
					.age(teacher.getAge())
					.name(teacher.getName())
					.surname(teacher.getSurname())
					.build();
//			StudentDto studentDto = modelMapper.map(student, StudentDto.class);
			System.out.println(teacherDto);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
		}

		System.out.println(teacherServiceImpl);
		System.out.println("------");
		System.out.println(teacherController.getStudentById(1));
	}
}
