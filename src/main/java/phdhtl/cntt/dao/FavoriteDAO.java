package phdhtl.cntt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import phdhtl.cntt.domain.FavoriteReport;
import phdhtl.cntt.domain.UserFavorite;
import phdhtl.cntt.model.Favorite;

public class FavoriteDAO extends AbstractEntityDAO<Favorite> {

	public FavoriteDAO() {
		super(Favorite.class);

	}
	
	public List<UserFavorite> getUserFavorites(String videoid) {
		// f.user.username , f.user.fullname, f.user.email : gọi các thuộc tính của
		// entity (class) user vẫn cần biến đại diện f của entity favorite
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select new phdhtl.cntt.domain.UserFavorite(f.user.username , f.user.fullname, f.user.email , f.likeddate)"
				+ "from Favorite f where f.video.videoid = :videoid";

		List<UserFavorite> list = null;

		try {
			TypedQuery<UserFavorite> query = em.createQuery(jpql, UserFavorite.class);
			query.setParameter("videoid", videoid);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return list;
	}
	
 	public List<FavoriteReport> getReportFavoritesVideos() {
		// truy vấn jpql gọi contructor của lớp FavoriteReport để lưu kết quả truy vấn vào đối tượng vừa mới được tạo
		// f.video.title : do không dùng các hàm tổng hợp nên bắt buộc sài group by để gom vào 1 bảng
		// chi tiết java 4 video thứ 51,52
		// count(f) : đếm số lượng xuất hiện của video trong bảng favorite
		// câu truy vấn duyệt từng dòng lấy các thuộc tính cần yêu cầu và xét các kết quả theo các hàm tổng hợp rồi phù hợp thì in ra
		// f có thể truy cập đến các thuộc tính của entity khác nếu đã tạo ràng buộc
		String jpql = "select new phdhtl.cntt.domain.FavoriteReport (f.video.title, count(f), min(f.likeddate), max(f.likeddate)) "
				+ " from Favorite f group by f.video.title";

		EntityManager em = JpaUtils.getEntityManager();

		List<FavoriteReport> list = null;
		
		try {
			// TypedQuery đối tượng lưu trữ khi kết quả query trả về từ câu truy vấn và object cần lưu kết quả truy vấn ( entity )
			TypedQuery<FavoriteReport> query = em.createQuery(jpql,FavoriteReport.class);
			
			list = query.getResultList(); // khi kết quả lưu về đối tượng query thì gọi phương thức getResultList để trả về danh sách kết quả truy vấn được
			
		} finally {
			em.close();
		} 
		
		return list;
	}
}
