package dao;

public class DaoFactroy {
    public static InterUserDao getUserDao(){
        return new UserDao();
    }
}
