package dao;

import bean.UserInfo;

import java.util.List;

public interface UserMapper {

    UserInfo checkRegis(String acc);

    int regis(UserInfo userInfo);

    UserInfo isLogin(UserInfo userInfo);

    List<UserInfo> selectUserInfo();


}
