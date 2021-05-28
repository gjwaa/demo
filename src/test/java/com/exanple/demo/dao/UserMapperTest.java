package com.exanple.demo.dao;

import bean.UserInfo;
import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import util.MybatisUtil;

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



}
