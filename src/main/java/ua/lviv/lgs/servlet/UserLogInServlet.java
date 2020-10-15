package ua.lviv.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.dto.UserLogin;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;

@WebServlet(value = "/login")
public class UserLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = Logger.getLogger(UserRegistrationServlet.class);
	
	private UserService userService = UserServiceImpl.getUserService();

	public void init() {
		System.out.println("init servlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doget");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		String email = request.getParameter("email");
		String password = request.getParameter("password");	
		//String userId = request.getParameter("id");
		
		 
				
		User user = userService.readByEmail(email);
		if (user == null) {
			try {				
				
				response.sendRedirect("index.jsp");		
				
//				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
		
		if(user != null && user.getPassword().equals(password)) {
			
			try {
				
				HttpSession session = request.getSession(true);
				session.setAttribute("userId", user.getId());
				session.setAttribute("userEmail", user.getEmail());
				session.setAttribute("role", user.getRole().toString());
				
				UserLogin userLogin = new UserLogin();
				userLogin.destinationUrl = "cabinet.jsp";
				userLogin.userEmail = user.getEmail();
				UserLogin.userId = user.getId();
				
				System.out.println(UserLogin.userId);
				
				String json = new Gson().toJson(userLogin);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json);
			    
			    System.out.println("dispatcher ok");
				
//			    RequestDispatcher rd = getServletContext().getRequestDispatcher("/buckets?userId="+ userId);
//				rd.forward(request, response);
				
			} catch (IOException e) {
				System.out.println("seach mistake");
				LOGGER.error(e);
			}
		} 

	}

	
}
// maven repository gson
//servlet json response
//admin sidebar bootstrap  https://www.creative-tim.com/product/light-bootstrap-dashboard
// header exemple bootsnipp https://bootsnipp.com/snippets/kl5rW
//css set footer always button
//bootstrap form css template
//https://colorlib.com/wp/bootstrap-form-templates/

//filter search table
