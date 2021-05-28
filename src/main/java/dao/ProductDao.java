package dao;

import bean.ProductInfo;
import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

public class ProductDao implements ProductMapper{
    @Override
    public int addProduce(ProductInfo productInfo) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        int i = mapper.addProduce(productInfo);
        sqlSession.close();
        return i;
    }
}
