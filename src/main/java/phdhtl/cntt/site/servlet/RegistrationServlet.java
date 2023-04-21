package phdhtl.cntt.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import phdhtl.cntt.common.PageInfo;
import phdhtl.cntt.common.PageType;
import phdhtl.cntt.dao.UserDAO;
import phdhtl.cntt.model.User;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.prepareAndForwarSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
		
		try {			
			BeanUtils.populate(user, request.getParameterMap());
			
			UserDAO dao = new UserDAO();
			dao.insert(user);
			
			PageInfo.prepareAndForwarSite(request, response, PageType.SITE_LOGIN_PAGE);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
		
		}
		request.setAttribute("user", user);
		PageInfo.prepareAndForwarSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	}

}
