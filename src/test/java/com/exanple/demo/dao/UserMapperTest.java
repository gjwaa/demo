package com.exanple.demo.dao;

import bean.UserInfo;
import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import util.MybatisUtil;

import java.util.List;

public class UserMapperTest {
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
}
