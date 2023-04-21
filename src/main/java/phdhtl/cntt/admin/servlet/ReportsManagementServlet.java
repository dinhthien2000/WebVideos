package phdhtl.cntt.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phdhtl.cntt.common.PageInfo;
import phdhtl.cntt.common.PageType;
import phdhtl.cntt.dao.FavoriteDAO;
import phdhtl.cntt.dao.VideoDAO;
import phdhtl.cntt.domain.FavoriteReport;
import phdhtl.cntt.domain.UserFavorite;
import phdhtl.cntt.model.Video;

/**
 * Servlet implementation class ReportsManagementServlet
 */
@WebServlet("/Admin/ReportsManagement")
public class ReportsManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getFavoritesVideoById(request, response);
		getReportFavoritesVideo(request, response);
		PageInfo.prepareAndForwar(request, response, PageType.REPORT_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void getFavoritesVideoById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FavoriteDAO fdao = new FavoriteDAO();
		VideoDAO vdao = new VideoDAO();
		try {
			String vid = request.getParameter("videoid");
			
			List<Video> vList = vdao.findAll(); // lấy danh sách toàn bộ video để đổ vào combobox
			
			// video id  = null và danh sách entity video trong csdl > 0 thì sẽ lấy entity và id đầu tiền 
			if (vid == null && vList.size() >0) {
				vid = vList.get(0).getVideoid();
			}

			List<UserFavorite> reportUF = fdao.getUserFavorites(vid);
			
			request.setAttribute("vid", vid); // trả về vì nếu combobox rỗng hay chưa được chọn thì sẽ gửi cái này về để hiện thị vào combobox
			request.setAttribute("videoList", vList);
			request.setAttribute("ufReport", reportUF);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : " + e.getMessage());
		}

	}

	protected void getReportFavoritesVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FavoriteDAO dao = new FavoriteDAO();

		try {
			List<FavoriteReport> report = dao.getReportFavoritesVideos();
			request.setAttribute("favreport", report);
		} catch (Exception e) {
			request.setAttribute("error", "Error : " + e.getMessage());
		}

	}

}
