package servlet;

import bean.UserInfo;
import dao.DaoFactroy;
import dao.InterUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regis")
public class Regis extends HttpServlet {
    private InterUserDao iud = DaoFactroy.getUserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String acc = req.getParameter("acc");
        String pwd = req.getParameter("pwd");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        boolean checkRegis = iud.checkRegis(acc);
        if (!checkRegis) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAcc(acc);
            userInfo.setPwd(pwd);
            userInfo.setPhone(phone);
            userInfo.setEmail(email);
            boolean regis = iud.regis(userInfo);
            if (regis) {
                req.getRequestDispatcher("view/login.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("view/regis.jsp?error=yes");
            }
        } else {
            resp.sendRedirect("view/regis.jsp?error=yes");
        }


    }
}
