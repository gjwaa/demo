package dao;

import bean.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    UserInfo checkRegis(String acc);

    int regis(UserInfo userInfo);

    UserInfo isLogin(UserInfo userInfo);


    List<UserInfo> selectUserInfo();

    List<UserInfo> getUserByLimit(Map<String,Integer> map);

}
