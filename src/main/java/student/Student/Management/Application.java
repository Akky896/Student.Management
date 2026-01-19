package student.Student.Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {


	private Map<String,Map<String,String>> studentInformation = new HashMap<>();

	public Application(){
		Map<String,String> student1 = new HashMap<>();
		student1.put("name","Enami Kouji");
		student1.put("age","37");

		Map<String,String> student2 = new HashMap<>();
		student2.put("name","Yamada Akira");
		student2.put("age","25");

		studentInformation.put("No.1",student1);
		studentInformation.put("No.2",student2);

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/studentInformation")
	public String getStudentInformation(){
		String result = "";

		for (Map<String,String> student : studentInformation.values()){
			result += student.get("name") + " " + student.get("age") + "歳\n";
		}
		return result;

	}

	@PostMapping("/studentInformation")
	public String addStudent(
			@RequestParam String id,
			@RequestParam String name,
			@RequestParam String age
	){
		Map<String, String> student = new HashMap<>();
		student.put("name",name);
		student.put("age",age);

		studentInformation.put(id,student);

		return "追加しました: " + name + " " + age + "歳";
	}

}
