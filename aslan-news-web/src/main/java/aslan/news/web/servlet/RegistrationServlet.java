package aslan.news.web.servlet;

import com.chahan.domain.exception.LoginException;
import com.chahan.domain.service.AuthService;
import com.chahan.domain.service.AuthServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private AuthService authService = AuthServiceImpl.getLoginServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");
        try {
            authService.signUp(username, password, repeatPassword);
        } catch (LoginException e) {
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("repeatPassword", repeatPassword);
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}