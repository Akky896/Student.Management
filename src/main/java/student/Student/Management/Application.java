package student.Student.Management;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private StudentRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//生徒のデータ取得
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return repository.findAll();
	}


	//生徒一人のデータ取得
	@GetMapping("/student")
	public String getStudent(@RequestParam String name){
		Student student = repository.searchByName(name);
		return student.getName() + " " +student.getAge() + "歳";
	}

	//生徒一人のデータ登録
	@PostMapping("/student")
	public void registerStudent(
			String name,
			int age){
		repository.registerStudent(name,age);
	}

	//生徒一人のデータ更新
	@PatchMapping("/student")
	public void updateStudentAge(String name, int age){
		repository.updateStudent(name, age);
	}

	//生徒一人のデータ削除
	@DeleteMapping("/student")
	public void deleteStudent(String name){
		repository.deleteStudent(name);
	}

}
