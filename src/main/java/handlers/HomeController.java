package handlers;
//To add tomcat - add configuration - tomcat - local -Deployment - add artifact
import DAO.UserDAO;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

@WebServlet(value = {"/","/home","/servlet_war_exploded"}) // link variables
public class HomeController extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override//override method doGet
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET");
//        resp.setHeader("contentType", "text/html");
//        PrintWriter writer = resp.getWriter();
//        writer.println("<h1>HELLO</h1>");
//        writer.close();
        String sex = req.getParameter("sex");
        String name = req.getParameter("name");

        //req.setAttribute("sex", "girls");//указали атрибут прописанный в файле INDEX
        req.setAttribute("sex", sex);
        req.setAttribute("name", name);

        requestPage(req, resp);

    }

    private void fillInUserList(HttpServletRequest req) {
        List<User> users = userDAO.findAll();
        StringBuilder b = new StringBuilder();
        for (User u : users){
            b.append(String.format("<li> %s, %s </li>",u.getName(), u.getSex()));
        }
       req.setAttribute("list", b.toString());
    }

    @Override
    protected void doPost(   //разобраться как работает POST
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("POST");


        String sex = req.getParameter("sex");
        String name = req.getParameter("name");

        //save user into database
        userDAO.save(new User(name,sex));

        requestPage(req, resp);
    }

    private void requestPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        fillInUserList(req);
        req
                .getRequestDispatcher("/templates/index.jsp")
                .forward(req, resp);
    }
}
