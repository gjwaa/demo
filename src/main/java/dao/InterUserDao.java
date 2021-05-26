package dao;

import bean.UserInfo;

import java.util.List;

public interface InterUserDao {

    boolean checkRegis(String acc);

    boolean regis(UserInfo userInfo);

    boolean isLogin(String acc,String pwd);

    List<UserInfo> selectUserInfo();

    boolean adminLogin(String acc,String pwd);
}
