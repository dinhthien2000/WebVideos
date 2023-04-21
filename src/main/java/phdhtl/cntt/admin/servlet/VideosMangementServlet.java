package phdhtl.cntt.admin.servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import phdhtl.cntt.common.PageInfo;
import phdhtl.cntt.common.PageType;
import phdhtl.cntt.common.UploadUtils;
import phdhtl.cntt.dao.VideoDAO;
import phdhtl.cntt.model.Video;

/**
 * Servlet implementation class VideosMangementServlet
 */
@WebServlet({ "/Admin/VideosMangement", "/Admin/VideosMangement/create", "/Admin/VideosMangement/update",
		"/Admin/VideosMangement/delete", "/Admin/VideosMangement/reset", "/Admin/VideosMangement/edit", })
@MultipartConfig
public class VideosMangementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI().toString();
		Video video = new Video();

		if (url.contains("edit")) {
			edit(request, response);
			return;
		} else if (url.contains("delete")) {
			delete(request, response);
			return;
		} else if (url.contains("reset")) {
			reset(request, response);
			return;
		}

		video.setPoster("/images/desktop.png");
		request.setAttribute("video", video);
		findAll(request, response);

		PageInfo.prepareAndForwar(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		if (url.contains("create")) {
			create(request, response);
			return;
		} else if (url.contains("update")) {
			update(request, response);
			return;
		} else if (url.contains("reset")) {
			reset(request, response);
			return;
		}
		findAll(request, response);
		PageInfo.prepareAndForwar(request, response, PageType.VIDEO_MANAGEMENT_PAGE);

	}

	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		Video video = new Video();
		VideoDAO dao = new VideoDAO();
		try {
			String id = request.getParameter("id");

			if (id != null) {
				video = dao.findById(id);
				request.setAttribute("video", video);
			} else {
				request.setAttribute("message", "Id not exits");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		findAll(request, response);
		PageInfo.prepareAndForwar(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) {
		Video video = new Video();
		video.setPoster("images/desktop.png");
		request.setAttribute("video", new Video());

		findAll(request, response);
		PageInfo.prepareAndForwar(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) {
		Video video = new Video();
		VideoDAO dao = new VideoDAO();
		try {
			BeanUtils.populate(video, request.getParameterMap()); // nếu để boolean trong model video thì mặc định false
																	// còn Boolean thì true ảo :v
			// System.out.println(video.getActive());
			video.setPoster(
					"uploads/" + UploadUtils.processUploadField("cover", request, "/uploads", video.getVideoid()));
			// Boolean active =Boolean.parseBoolean( request.getParameter("active"));
			// video.setActive(active);
			// System.out.println(video.getActive());
			dao.insert(video);

			request.setAttribute("message", "Insert video success !!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : " + e.getMessage());
		}

		findAll(request, response);
		request.setAttribute("video", video);
		PageInfo.prepareAndForwar(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		Video video = new Video();
		VideoDAO dao = new VideoDAO();
		try {
			BeanUtils.populate(video, request.getParameterMap());

			Video oldVideo = dao.findById(video.getVideoid());

			if (request.getPart("cover").getSize() == 0) {
				video.setPoster(oldVideo.getPoster());
			} else {
				video.setPoster(
						"uploads/" + UploadUtils.processUploadField("cover", request, "/uploads", video.getVideoid()));

			}
			dao.update(video);
			request.setAttribute("video", video);
			request.setAttribute("message", "Update video success !!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : " + e.getMessage());
		}

		findAll(request, response);
		PageInfo.prepareAndForwar(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (id == null) {
			request.setAttribute("error", "ID is required");
			PageInfo.prepareAndForwar(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
			return;

		}

		try {
			Video video = new Video();
			VideoDAO dao = new VideoDAO();
			video = dao.findById(id);

			if (video == null) {
				request.setAttribute("error", "video id not exits");
				PageInfo.prepareAndForwar(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
				return;
			}

			dao.delete(id);

			request.setAttribute("message", "Video is deleted !!");
			request.setAttribute("video", new Video());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		findAll(request, response);
		PageInfo.prepareAndForwar(request, response, PageType.VIDEO_MANAGEMENT_PAGE);

	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {

		VideoDAO dao = new VideoDAO();
		try {

			List<Video> list = dao.findAll();

			request.setAttribute("videos", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : " + e.getMessage());
		}

	}
}
