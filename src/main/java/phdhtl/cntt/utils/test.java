package phdhtl.cntt.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import phdhtl.cntt.dao.JpaUtils;
import phdhtl.cntt.domain.UserFavorite;

public class test {
	public static void main(String[] args) {
		String title = "java";
		List<UserFavorite> list =  testUserFavorites(title);
		System.out.println("Tim thong tin nguoi dung thich video "+title);
		for (UserFavorite uf : list) {
			System.out.print(uf.getUsername() + "\t");
			System.out.print(uf.getFullname() + "\t");
			System.out.print(uf.getEmail() + "\t");
			System.out.print(uf.getFavoritedate() + "\t");
			System.out.println("");
		}
	}

	static List<UserFavorite> testUserFavorites(String title) {
		// f.user.username , f.user.fullname, f.user.email : gọi các thuộc tính của
		// entity (class) user vẫn cần biến đại diện f của entity favorite
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select new phdhtl.cntt.domain.UserFavorite(f.user.username , f.user.fullname, f.user.email , f.likeddate)"
				+ "from Favorite f where f.video.title = :title";

		List<UserFavorite> list = null;

		try {
			TypedQuery<UserFavorite> query = em.createQuery(jpql, UserFavorite.class);
			query.setParameter("title", title);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return list;
	}
}
