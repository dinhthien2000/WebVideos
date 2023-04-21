package phdhtl.cntt.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	// thêm vào session
	public static void add(HttpServletRequest request,String name, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}
	
	// update session
	public static void update(HttpServletRequest request,String name, Object value) {
		HttpSession session = request.getSession();
		session.removeAttribute(name);
		session.setAttribute(name, value);
	}
	
	// xóa session
	public static void remove(HttpServletRequest request,String name) {
		HttpSession session = request.getSession();
		session.removeAttribute(name);
	}
	
	// lấy session có tên name
		public static Object get(HttpServletRequest request, String name) {
			HttpSession session = request.getSession();
			
			return session.getAttribute(name);
		}
	
	// vô hiệu session username
	public static void invalidate(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username"); // hủy giá trị session username
		session.invalidate();
		
	}
	
	// kiểm tra đăng nhập với session có tên username có tồn tại chưa , nếu rồi trả về true còn chưa trả về false
	// kiểm tra có đăng nhập chưa bằng biến username
	public static boolean isLogin(HttpServletRequest request) {
		return get(request, "username") !=null;
	}
	
	// trả về giá trị của session tên username , kiểm tra username có đăng nhập với session có username
	// đăng nhập chưa nếu true ( đã đăng nhập ) trả về value của session username
	public static String getLoginedUsername(HttpServletRequest request) {
		Object username = get(request, "username");
		return username == null? null : username.toString(); 
	}
}
