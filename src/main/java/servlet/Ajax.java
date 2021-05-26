package servlet;

import dao.DaoFactroy;
import dao.InterUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajax")
public class Ajax extends HttpServlet {
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
        InterUserDao iud = DaoFactroy.getUserDao();
        PrintWriter out = resp.getWriter();
        String acc = req.getParameter("acc");
        boolean isRegis = iud.checkIsRegis(acc);
        if(isRegis){
            System.out.println("该账号已被注册");
            out.write("true");
        }else {
            System.out.println("该账号可使用");
            out.write("false");
        }
    }
}
