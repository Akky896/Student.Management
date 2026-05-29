package student.Student.Management;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class StudentCourse {
    private String id;
    private String studentId;
    private String courseName;
    private LocalDate startDate;
    private LocalDate endDate;


}
