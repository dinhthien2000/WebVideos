package phdhtl.cntt.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import phdhtl.cntt.model.User;

public class UserDAO extends AbstractEntityDAO<User> {
	// các phương thức CRUD đã được định nghĩa kế thừa từ AbstractEntityDAO
	public UserDAO() {
		super(User.class);
		
	}
	
	public void changePassword(String username,String currentpassword, String newpassword) throws Exception {
		
		
		
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();// có cập nhật thông tin nên sài transaction
		
		String jpql = "select u from User u where u.username = :username and u.password = :password ";
		
		try {
			transaction.begin();
			
			TypedQuery<User> query = em.createQuery(jpql,User.class);
			query.setParameter("username", username);
			query.setParameter("password", currentpassword);
			
			User user = query.getSingleResult();
			
			if (user==null) {
				// ném exception là kết thúc câu lệnh lun
				throw new Exception("Current password or Username are incorrect"); // nếu không tìm thấy user có username và password  thì báo lỗi tài khoản không tồn tại
				
			}
			// nếu user tồn tại thì set mật khẩu mới 
			user.setPassword(newpassword);
			
			em.merge(user); // lưu bản mới vào entity
			
			transaction.commit();
		} catch (Exception e) {
			
			transaction.rollback();
			
			throw e;
		}finally {
			em.close();
		}
	}

	public User findByUsernameAndEmail(String username, String email) {
		EntityManager em = JpaUtils.getEntityManager();
		
		String jpql = "Select u from User u where u.username=:username and u.email=:email";
		
		try {
			TypedQuery<User> query = em.createQuery(jpql,User.class);
			query.setParameter("username", username);
			query.setParameter("email", email);
			
			return query.getSingleResult();
		}finally {
			em.close();
			
		}
	}
	
}
