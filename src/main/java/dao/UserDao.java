package dao;

import bean.UserInfo;
import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

import java.util.List;

public class UserDao implements UserMapper{
    @Override
    public UserInfo checkRegis(String acc) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserInfo userInfo = mapper.checkRegis(acc);
        sqlSession.close();
        return userInfo;
    }

    @Override
    public int regis(UserInfo userInfo) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int regis = mapper.regis(userInfo);
        sqlSession.commit();
        sqlSession.close();
        return regis;
    }

    @Override
    public UserInfo isLogin(UserInfo userInfo) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserInfo login = mapper.isLogin(userInfo);
        sqlSession.close();
        return login;
    }

    @Override
    public List<UserInfo> selectUserInfo() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserInfo> userInfos = mapper.selectUserInfo();
        sqlSession.close();
        return userInfos;
    }
}
