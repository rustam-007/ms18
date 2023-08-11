package az.ingress.demo;

import az.ingress.demo.controller.StudentController;
import az.ingress.demo.dto.StudentDto;
import az.ingress.demo.model.Student;
import az.ingress.demo.service.StudentService;
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
	StudentService studentServiceImpl;
	@Autowired
	StudentController studentController;
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

		studentServiceImpl.save(new Student(1, "Senan", "Senanov", 27));

		try {
			Student student = studentServiceImpl.getStudentById(1);
			StudentDto studentDto = StudentDto.builder()
					.age(student.getAge())
					.name(student.getName())
					.surname(student.getSurname())
					.build();
//			StudentDto studentDto = modelMapper.map(student, StudentDto.class);
			System.out.println(studentDto);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
		}

		System.out.println(studentServiceImpl);
		System.out.println("------");
		System.out.println(studentController.getStudentById(1));
	}
}
