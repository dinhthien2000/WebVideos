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
import phdhtl.cntt.common.SessionUtils;
import phdhtl.cntt.dao.UserDAO;
import phdhtl.cntt.domain.ChangePassword;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username =SessionUtils.getLoginedUsername(request);
		
		if (username==null) {
			PageInfo.prepareAndForwarSite(request, response, PageType.SITE_LOGIN_PAGE);
			return;
		}
		
		request.setAttribute("username", username);
		PageInfo.prepareAndForwarSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username =SessionUtils.getLoginedUsername(request); // lấy giá trị của session username
			request.setAttribute("username", username); // lấy username để hiển thị vào input username trong form
			
			// đổ dữ liệu từ form input vào object form
			ChangePassword form = new ChangePassword();
			BeanUtils.populate(form, request.getParameterMap());
			
			// so sánh mật khẩu mới và xác thực mật khẩu giống nhau k ( lưu ý có dấu ! )
			if (!form.getNewpassword().equals(form.getCofirmpassowrd())) {
				request.setAttribute("error", "New password and comfirm are not indentical ");
			}else {
				UserDAO dao = new UserDAO();
				dao.changePassword(form.getUsername(), form.getCurrentpassword(), form.getNewpassword());
				request.setAttribute("message", "Change password success !!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : "+e.getMessage());
		}
		PageInfo.prepareAndForwarSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}

}
