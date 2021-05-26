package util;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ConnectionPool {
    private static ConnectionPool pool;
    private static ArrayList<Connection> conList = new ArrayList<Connection>();
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    private ConnectionPool() {
    }

    public static ConnectionPool getConnectionPool() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    static {
        try {
            Properties properties = new Properties();
            properties.load(ConnectionPool.class.getClassLoader().getResourceAsStream("db.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driver);
            for (int i = 0; i < 10; i++) {
                Connection con = DriverManager.getConnection(url, user, password);
                conList.add(con);

            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        if (conList.size() > 0) {
            return conList.remove(0);
        }
        return null;
    }

    public void setCon(Connection con) {
        if (conList.size() < 10) {
            conList.add(con);
        }
    }

    public void closeCon(ResultSet res, PreparedStatement pstm) {
        if (res != null) {
            try {
                res.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static ConnectionPool getPool() {
        return pool;
    }

    public static void setPool(ConnectionPool pool) {
        ConnectionPool.pool = pool;
    }

    public ArrayList<Connection> getConList() {
        return conList;
    }

    public void setConList(ArrayList<Connection> conList) {
        this.conList = conList;
    }
}
