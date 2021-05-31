package com.exanple.demo.dao;

import bean.Student;
import bean.Teacher;
import bean.UserInfo;
import dao.StudentMapper;
import dao.TeacherMapper;
import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import util.MybatisUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void selectUserInfo(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserInfo> userInfos = mapper.selectUserInfo();
        for(UserInfo userInfo:userInfos){
            System.out.println(userInfo);
        }
        sqlSession.close();
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",2);
        map.put("pageSize",2);
        List<UserInfo> infos = mapper.getUserByLimit(map);
        for (UserInfo info : infos) {
            System.out.println(info);
        }
        sqlSession.close();

    }

    @Test
    public void getStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void getStudent2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void getTeacher(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Test
    public void getTeacherById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherById = mapper.getTeacherById(1);
        System.out.println(teacherById);
        sqlSession.close();
    }

    @Test
    public void getIf(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("sname","玖玖");
        List<Student> list = mapper.getIf(map);
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void getChose(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, String> map = new HashMap<String, String>();

        List<Student> list = mapper.getChose(map);
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void getUpd(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("sname","玖玖");
        map.put("tid","1");
        int upd = mapper.getUpd(map);

        sqlSession.close();
    }

    @Test
    public void getForEach(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String,List<Integer>> map = new HashMap<String,List<Integer>>();
        List<Integer> lis = new ArrayList<Integer>();
//        lis.add(1);
//        lis.add(2);
        map.put("sids",lis);
        List<Student> list = mapper.getForEach(map);
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
    }


}
