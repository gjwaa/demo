package dao;

public class DaoFactroy {
    public static InterUserDao getUserDao(){
        return new UserDao();
    }
    public static InterProductDao getProductDao(){
        return new ProductDao();
    }
}
