package phdhtl.cntt.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phdhtl.cntt.common.EmailUtils;
import phdhtl.cntt.common.PageInfo;
import phdhtl.cntt.common.PageType;
import phdhtl.cntt.dao.UserDAO;
import phdhtl.cntt.domain.Email;
import phdhtl.cntt.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.prepareAndForwarSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String emailAddress = request.getParameter("email");
			
			UserDAO dao = new UserDAO();
			User user = dao.findByUsernameAndEmail(username, emailAddress);
			
			if (user==null) {
				request.setAttribute("error", "Username or email are inccorrect");
			}else {
				Email email = new Email();
				email.setFromAddress("thiendinhcm@gmail.com");
				email.setFromAddressPassword("zyqzswjvmtznqgky"); // mật khẩu ứng dụng gmail xác thực 2 bước
				email.setToAddress(emailAddress);
				email.setSubject("Forgot password function");
				
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append("<br/>");
				sb.append("You are use the forgot password function. <br/>");
				sb.append("Your password is <b>").append(user.getPassword()).append("</b> <br/>");
				sb.append("Regards <br/>");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				request.setAttribute("message", "Email sent password to the email address.<br/>"
						+ "Please check and get your password");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : " + e.getMessage());
		}
		
		PageInfo.prepareAndForwarSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

}
