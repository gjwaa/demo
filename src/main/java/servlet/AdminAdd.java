package servlet;

import bean.ProductInfo;
import dao.DaoFactroy;
import dao.InterProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "AdminAdd",urlPatterns = "/adminAdd")
@MultipartConfig(location = "D://")
public class AdminAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        InterProductDao ipd = DaoFactroy.getProductDao();
        String name = req.getParameter("name");
        String startPrice = req.getParameter("startPrice");
        String type = req.getParameter("type");
        String introduce = req.getParameter("introduce");

        Part loadFile = req.getPart("loadFile");
        String fileName = loadFile.getSubmittedFileName();
        loadFile.write("D://load//"+fileName);
        System.out.println("loadFile:"+fileName);

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName(name);
        productInfo.setStartPrice(startPrice);
        productInfo.setProductTypeID(Integer.valueOf(type));
        productInfo.setProductImg(fileName);
        productInfo.setIntroduce(introduce);
        ipd.addProduce(productInfo);


    }
}
