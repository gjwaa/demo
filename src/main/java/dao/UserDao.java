package dao;

import bean.UserInfo;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements InterUserDao {
    private ConnectionPool pool = ConnectionPool.getConnectionPool();

    @Override
    public boolean checkRegis(String acc) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            con = pool.getCon();
            String sql = "select acc from user where acc = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, acc);
            res = pstm.executeQuery();
            if (res.next()) {
                return true;
            } else
                return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("con null");
        }
        finally {
            pool.closeCon(res, pstm);
        }
        return false;
    }

    @Override
    public boolean regis(UserInfo userInfo) {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = pool.getCon();
            String sql = "insert into user values(?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, null);
            pstm.setString(2, userInfo.getAcc());
            pstm.setString(3, userInfo.getPwd());
            pstm.setString(4, userInfo.getPhone());
            pstm.setString(5, userInfo.getEmail());
            int i = pstm.executeUpdate();
            if(i>0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            pool.closeCon(null, pstm);
        }
        return false;
    }

    @Override
    public boolean isLogin(String acc, String pwd) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            con = pool.getCon();
            String sql = "select * from user where acc = ? and pwd = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, acc);
            pstm.setString(2, pwd);
            res = pstm.executeQuery();
            if (res.next()) {
                return true;
            } else
                return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            pool.closeCon(res, pstm);
        }
        return false;
    }

    @Override
    public List<UserInfo> selectUserInfo() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<UserInfo> list = new ArrayList<UserInfo>();
        try {
            con = pool.getCon();
            String sql = "select * from user";
            pstm = con.prepareStatement(sql);
            res = pstm.executeQuery();
            while (res.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setAcc(res.getString("acc"));
                userInfo.setPwd(res.getString("pwd"));
                list.add(userInfo);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            pool.closeCon(res, pstm);
        }
        return null;
    }

    @Override
    public boolean adminLogin(String acc, String pwd) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            con = pool.getCon();
            String sql = "select * from admin where acc = ? and pwd = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, acc);
            pstm.setString(2, pwd);
            res = pstm.executeQuery();
            if (res.next()) {
                return true;
            } else
                return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            pool.closeCon(res, pstm);
        }
        return false;
    }


}
