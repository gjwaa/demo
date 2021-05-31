package dao;

import bean.Student;
import bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher();

    Teacher getTeacherById(@Param("tid") int tid);
}
