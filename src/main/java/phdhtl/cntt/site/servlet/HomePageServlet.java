package phdhtl.cntt.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phdhtl.cntt.common.PageInfo;
import phdhtl.cntt.common.PageType;
import phdhtl.cntt.dao.VideoDAO;
import phdhtl.cntt.model.Video;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePage")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VideoDAO dao = new VideoDAO();
			
			List<Video> list = dao.findAll();
			
			request.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
		}
		
		PageInfo.prepareAndForwarSite(request, response, PageType.SITE_HOME_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
