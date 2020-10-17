package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.domain.MagazineUsers;
import ua.lviv.lgs.dto.BucketDto;
import ua.lviv.lgs.dto.UserLogin;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.MagazineUsersService;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;
import ua.lviv.lgs.service.impl.MagazineUsersServiceImpl;

@WebServlet(value = "/buckets")
public class BucketsController extends HttpServlet {
	private static final long serialVersionUID = 7L;
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
	private MagazineUsersService magazineUserService = MagazineUsersServiceImpl.getMagazineUsersService();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get buckets");
		
		int userId = UserLogin.userId;

		System.out.println(userId);
		
		List<MagazineUsers> buckets = magazineUserService.readAll();
		
		buckets = buckets.stream().filter(o -> o.getUser().getId() == userId).collect(Collectors.toList());
		
		Map<Integer, Magazine> idToMagazine = magazineService.readAllMap();
		List<BucketDto> listOfBucketDtos = map(buckets, idToMagazine);
		
		String json = new Gson().toJson(listOfBucketDtos);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	private List<BucketDto> map(List<MagazineUsers> buckets, Map<Integer, Magazine> idToMagazine) {
		
		return buckets.stream().map(bucket -> {
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucketId = bucket.getId();			
			bucketDto.purchaseDate = bucket.getPurchaseDate();
			
			Magazine magazine = idToMagazine.get(bucket.getMagazine().getId());
			bucketDto.name = magazine.getName();
			bucketDto.description = magazine.getDescription();
			bucketDto.price = magazine.getPrice();
			bucketDto.isbn = magazine.getIsbn();
			
			return bucketDto;
			
		}).collect(Collectors.toList());
	}

	
}
