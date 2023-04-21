package phdhtl.cntt.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;


// PageInfo : dùng để kiểm soát các forward ( chuyển tiếp ) và các include ( bao gồm ) các page cho layout
public class PageInfo {
	@SuppressWarnings("unchecked")
	public static Map<PageType, PageInfo>  pageRoute = new HashedMap(); // danh sách địa chỉ sẽ include vào trang layout
	
	// kỹ thuật khối tĩnh để thêm các thành phần cho pageRoute
	static {
		// thêm các key và value cho map ( collection ) gồm : key là loại trang , value : kiểu class Page info có hàm khởi tạo gồm các trường (fields) tiêu đề , nội dung , và JS 
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management", "/admin/users/users.jsp", null));
		pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("Report", "/admin/reports/reports.jsp", null));
		pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Video", "/admin/videos/videos.jsp", null));
		
		pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home Page", "/site/home/home.jsp", null));
		pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("Login Page", "/site/users/login.jsp", null));
		pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("Registration Page", "/site/users/registration.jsp", null));
		pageRoute.put(PageType.SITE_CHANGE_PASSWORD_PAGE, new PageInfo("Change Password Page", "/site/users/change_password.jsp", null));
		pageRoute.put(PageType.SITE_FORGOT_PASSWORD_PAGE, new PageInfo("Forgot Password Page", "/site/users/forgot_password.jsp", null));
		pageRoute.put(PageType.SITE_PROFILE_PAGE, new PageInfo("Profile Page", "/site/users/profile.jsp", null));
		pageRoute.put(PageType.SITE_DETAIL_PAGE, new PageInfo("Detail Page", "/site/videos/detail.jsp", null));
		pageRoute.put(PageType.SITE_SHARE_PAGE, new PageInfo("Share Page", "/site/videos/share.jsp", null));
		pageRoute.put(PageType.SITE_FAVORITE_PAGE, new PageInfo("Favorite Page", "/site/videos/favorite.jsp", null));
		
	}
	
	// chuyển nội tới cho trang layout trang admin
	public static void prepareAndForwar(HttpServletRequest request, HttpServletResponse response, PageType pageType) {
		PageInfo page = pageRoute.get(pageType); // biến instance ( đại diện ) PageInfo page gán = với pageRoute.get(pageType) để lấy key trong map pageRoute để lấy value có kiểu là pageInfo 
	
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	// chuyển nội tới cho trang layout trang Site
	public static void prepareAndForwarSite(HttpServletRequest request, HttpServletResponse response, PageType pageType) {
		PageInfo page = pageRoute.get(pageType); // biến instance ( đại diện ) PageInfo page gán = với pageRoute.get(pageType) để lấy key trong map pageRoute để lấy value có kiểu là pageInfo 
	
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("/site/layout.jsp").forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return;
	}
	
	
	// các thuộc tính này là nội dung của page ( layout ) : 
	private String title; //title : tiêu đề
	private String contentUrl; // contentUrl : nội dung
	private String scriptUrl;  // scriptUrl : đường dẫn js
	
	
	
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
	
	
	
}
