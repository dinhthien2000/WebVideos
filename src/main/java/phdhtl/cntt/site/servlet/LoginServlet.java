package phdhtl.cntt.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import phdhtl.cntt.common.CookieUtils;
import phdhtl.cntt.common.PageInfo;
import phdhtl.cntt.common.PageType;
import phdhtl.cntt.common.SessionUtils;
import phdhtl.cntt.dao.UserDAO;
import phdhtl.cntt.domain.LoginForm;
import phdhtl.cntt.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// chỉ có đăng nhập là sài cookie
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = CookieUtils.get("username", request); // lấy thông tin cookie nếu người dùng chức năng tự động
																// đăng nhập

		// cookie chưa tồn tại
		if (username == null) {
			PageInfo.prepareAndForwarSite(request, response, PageType.SITE_LOGIN_PAGE); // chuyển đến login page
			return;
		}

		// nếu cookie tồn tại sẽ lưu thông tin cookie username vào trong session
		SessionUtils.add(request, "username", username);

		request.getRequestDispatcher("/HomePage").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();

			BeanUtils.populate(form, request.getParameterMap()); // truyền thông tin từ form đăng nhập vào đối tượng
																	// LoginForm

			UserDAO dao = new UserDAO();

			User user = dao.findById(form.getUsername()); // truyền đối tượng tìm được từ csdl vào entity bằng username
															// từ form

			// nếu có user có username = form.getUsername() và password =
			// form.getPassword()) đúng thông tin user thì cho đăng nhập vào hệ thống
			if (user != null && user.getPassword().equals(form.getPassword())) {
				// đăng nhập thành công thêm vào session
				SessionUtils.add(request, "username", user.getUsername());
				
				// nếu chọn remember khi đăng nhập thì mới lưu vào cookie
				if (form.isRemember()) {
					CookieUtils.add("username", form.getUsername(), 24, response); // thiết lập cookie 24h có tên username, và giá trị là trường username trong obj form form.getUsername() 
				} else {
					CookieUtils.add("username", form.getUsername(), 0, response); // thiết lập cookie 0h nghĩa là hủy
																					// cookie không ghi nhớ đăng nhập
				}
				request.setAttribute("isLogin", true);

				SessionUtils.add(request, "fullname", user.getFullname());
				PageInfo.prepareAndForwarSite(request, response, PageType.SITE_HOME_PAGE);
				// request.getRequestDispatcher("/HomePage").forward(request, response);
				return;
			}else {
				request.setAttribute("error", "Valid username or password");
				PageInfo.prepareAndForwarSite(request, response, PageType.SITE_LOGIN_PAGE);
			}
			//request.getRequestDispatcher("/HomePage").forward(request, response);

			// PageInfo.prepareAndForwarSite(request, response, PageType.SITE_LOGIN_PAGE);
		} catch (Exception e) {
			request.setAttribute("error", "Valid username or password");
			PageInfo.prepareAndForwarSite(request, response, PageType.SITE_LOGIN_PAGE);
		}

	}

}
