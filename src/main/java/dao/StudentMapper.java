package dao;

import bean.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    List<Student> getStudent();

    List<Student> getStudent2();

    List<Student> getIf(Map<String,String> map);

    List<Student> getChose(Map<String,String> map);

    int getUpd(Map<String,String> map);

    List<Student> getForEach(Map<String,List<Integer>> map);

}
