package ua.lviv.lgs.shared;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.domain.UserRole;

public class FilterServise {
	
	private static FilterServise filterServise;
	
	private FilterServise() {};
	
	public static FilterServise getFilterServise() {
		
		if(filterServise == null) {
			filterServise = new FilterServise();
		}		
		return filterServise;		
	}
	
	public void doFilterValidation(ServletRequest request, ServletResponse response, 
			FilterChain chain, List<UserRole> userRole) throws IOException, ServletException {
		
		try {
			
			HttpSession session = ((HttpServletRequest) request).getSession();
			UserRole role = UserRole.valueOf((String) session.getAttribute("role"));
			
			if(role != null && userRole.contains(role)) {
				chain.doFilter(request, response);
			} else {
				((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}
	

}
