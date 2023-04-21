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
import phdhtl.cntt.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = SessionUtils.getLoginedUsername(request); // lấy session đã lưu khi đăng nhập
		// null là chưa đăng nhập chuyển đến đăng nhập
		if (username == null) {
			PageInfo.prepareAndForwarSite(request, response, PageType.SITE_LOGIN_PAGE); // chuyển đến login
			return;
		}

		try {
			// tìm đối tượng user bằng username để setAttribute để hiển thị thông tin vào
			// form chỉnh sửa profile
			UserDAO dao = new UserDAO();
			User user = dao.findById(username);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}

		PageInfo.prepareAndForwarSite(request, response, PageType.SITE_PROFILE_PAGE); // chuyển đến profile
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap()); // lưu thông tin từ form vào user

			String username = SessionUtils.getLoginedUsername(request);
			UserDAO dao = new UserDAO();
			User oldUser = dao.findById(username); // tìm kiếm username và truyền old user

			// các trường dữ liệu này không được đổi từ form nên k cho hiện ra
			user.setAdmin(oldUser.getAdmin());
			// user.setPassword(oldUser.getPassword());

			dao.update(user);
			request.setAttribute("message", "Update success !!");
			request.setAttribute("user", user);
			
			SessionUtils.update(request, "fullname", user.getFullname());

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}

		PageInfo.prepareAndForwarSite(request, response, PageType.SITE_PROFILE_PAGE); // chuyển đến profile

	}

}
