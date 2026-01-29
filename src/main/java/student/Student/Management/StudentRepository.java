package student.Student.Management;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    //生徒一覧表示
    @Select("SELECT * FROM student")
    List<Student> findAll();

    //生徒一人のデータ表示
    @Select("SELECT * FROM student WHERE name = #{name}")
    Student searchByName (String name);

    //生徒一人のデータ登録
    @Insert("INSERT student values(#{name}, #{age})")
    void registerStudent(String name, int age);

    //生徒一人のデータ更新
    @Update("UPDATE student SET age = #{age} WHERE name = #{name}")
    void updateStudent(String name, int age);

    //生徒一人のデータ削除
    @Delete("DELETE FROM student WHERE name = #{name}")
    void deleteStudent(String name);


}
