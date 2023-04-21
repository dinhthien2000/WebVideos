package phdhtl.cntt.common;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	// get : lấy giá  trị của cookie tên name
	public static String get(String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				// nếu tên cookie = name truyền vào thì trả về giá trị của cookie
				if (cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	// add : lưu cookies
	public static Cookie add(String name , String value, int hours, HttpServletResponse response) {
		Cookie cookie = new Cookie(name, value); // tạo đối tượng cookie truyền name và value cho cookie
		cookie.setMaxAge(60*60*hours); // thời gian tồn tại = giây * phút * giờ 
		cookie.setPath("/");
		response.addCookie(cookie);
		
		return cookie; // trả lại giá trị ,thông tin của cookie
	}
}
