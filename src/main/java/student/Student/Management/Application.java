package student.Student.Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private StudentRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//全生徒のデータ取得
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return repository.findAll();
	}


	//生徒一人のデータ取得
	@GetMapping("/studentList")
	public List<Student> getStudentList(){
		return repository.search();
	}


	//生徒のコース情報の取得
	@GetMapping("/student_courseList")
	public List<StudentCourse> getStudentsCourseList(){
		return repository.searchCourse();
	}




}
