package phdhtl.cntt.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phdhtl.cntt.common.CookieUtils;
import phdhtl.cntt.common.SessionUtils;

/**
 * Servlet implementation class LogoffServlet
 */
@WebServlet("/Logoff")
public class LogoffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// chức năng đăng xuất
		
		CookieUtils.add("username", null, 0, response);// reset cookie
		SessionUtils.invalidate(request); // vô hiệu session
		
		request.setAttribute("isLogin", false);
		request.getRequestDispatcher("/HomePage").forward(request, response);
	}

}
