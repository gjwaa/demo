package servlet;

import bean.AdminInfo;
import dao.AdminDao;
import dao.AdminMapper;
import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String acc = req.getParameter("acc");
        String pwd = req.getParameter("pwd");
        String verify = req.getParameter("verify");
        System.out.println(acc + ",,," + pwd);
        System.out.println("");
        String adminVerify = (String) req.getSession().getAttribute("adminVerify");

        AdminDao adminDao = new AdminDao();

        if (verify.equals(adminVerify)) {
            System.out.println("验证码正确");

            AdminInfo login = adminDao.adminLogin(new AdminInfo(acc, pwd));
            System.out.println(login + "++++++");
            if (login != null) {
                if (acc.equals(login.getAcc()) && pwd.equals(login.getPwd())) {
                    System.out.println("登陆成功");
                    req.getRequestDispatcher("view/adminManage.jsp").forward(req, resp);
                } else {
                    System.out.println("登录失败");
                    resp.sendRedirect("view/admin.jsp?admin=false");

                }
            } else {
                resp.sendRedirect("view/admin.jsp?admin=false");
            }

        } else {
            resp.sendRedirect("view/admin.jsp?admin=false");
        }


    }
}
