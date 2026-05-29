package student.Student.Management;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    //生徒一覧表示
    @Select("SELECT * FROM students")
    List<Student> findAll();

    //生徒のデータ表示
    @Select("SELECT * FROM students")
    List<Student> search();

    //生徒の授業コース表示
    @Select("SELECT * FROM student_courses")
    List<StudentCourse> searchCourse();





}
