package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.domain.MagazineUsers;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.dto.UserLogin;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.MagazineUsersService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;
import ua.lviv.lgs.service.impl.MagazineUsersServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;

@WebServlet(value = "/bucketContr")
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 6L;
	private MagazineUsersService magazineUsersService = MagazineUsersServiceImpl.getMagazineUsersService();   
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
	private UserService userService = UserServiceImpl.getUserService();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("bucket post");		
		String magazineId = request.getParameter("magazineId");	
		
		Magazine magazine = magazineService.read(Integer.parseInt(magazineId));
		
		System.out.println("magazine id" + magazineId);		
		HttpSession session = request.getSession();
		Integer userId = UserLogin.userId;
		User user = userService.read(userId);
		
		MagazineUsers magazineUsers = new MagazineUsers();
		magazineUsers.setId(UUID.randomUUID().toString());
		magazineUsers.setMagazine(magazine);
		magazineUsers.setUser(user);
		magazineUsers.setPurchaseDate(new Date());
		
			magazineUsersService.create(magazineUsers);
				
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("do delete bucket");
		
		String bucketId = request.getParameter("bucketId");
		System.out.println(bucketId);
		
		magazineUsersService.delete(bucketId);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
