package phdhtl.cntt.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phdhtl.cntt.common.PageInfo;
import phdhtl.cntt.common.PageType;

/**
 * Servlet implementation class UsersManagementServlet
 */
@WebServlet("/UsersManagementServlet")
public class UsersManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.prepareAndForwar(request, response, PageType.USER_MANAGEMENT_PAGE);// chuyển hướng tới user management
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
