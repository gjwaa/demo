package servlet;

import bean.UserInfo;
import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/login")
public class Login extends HttpServlet {

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

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        try {
            List<UserInfo> list = mapper.selectUserInfo();
            req.getSession().setAttribute("userList", list);
            String serverVerify = (String) req.getSession().getAttribute("verify");
            if (verify.equals(serverVerify)) {
                System.out.println("验证码正确");
                UserInfo login = mapper.isLogin(new UserInfo(acc, pwd));
                if (login!=null){
                    if (acc.equals(login.getAcc())&&pwd.equals(login.getPwd())) {
                        System.out.println("登陆成功");
                        req.getRequestDispatcher("view/table.jsp").forward(req, resp);
                    } else {
                        System.out.println("账号密码错误");
                        resp.sendRedirect("view/login.jsp?login=false");
                    }
                }else {
                    resp.sendRedirect("view/login.jsp?login=false");
                }

            } else {
                resp.sendRedirect("view/login.jsp?login=false");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }

}
