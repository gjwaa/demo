package dao;

import bean.ProductInfo;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao implements InterProductDao{
    private ConnectionPool pool = ConnectionPool.getConnectionPool();

    @Override
    public boolean addProduce(ProductInfo productInfo) {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = pool.getCon();
            String sql = "insert into product values(?,?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, null);
            pstm.setString(2, productInfo.getProductName());
            pstm.setInt(3, productInfo.getProductTypeID());
            pstm.setString(4, productInfo.getProductImg());
            pstm.setString(5, productInfo.getIntroduce());
            pstm.setInt(6, productInfo.getStateID());
            pstm.setString(7, productInfo.getStartPrice());
            pstm.setString(8, productInfo.getStrikePrice());
            pstm.setString(9, productInfo.getNewPrice());
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
}
