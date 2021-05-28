package dao;

import bean.AdminInfo;
import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

public class AdminDao implements AdminMapper{

    @Override
    public AdminInfo adminLogin(AdminInfo adminInfo) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        AdminInfo login = mapper.adminLogin(adminInfo);
        sqlSession.close();
        return login;
    }
}
