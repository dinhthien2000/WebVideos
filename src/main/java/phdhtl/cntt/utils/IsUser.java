package phdhtl.cntt.utils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import phdhtl.cntt.dao.JpaUtils;
import phdhtl.cntt.model.User;

public class IsUser {
	public static int checkUserRegister(String username) {
		EntityManager em = JpaUtils.getEntityManager();
		
		try {
			String jqpl = "select u from User u where u.username = :username";
			//Query query = em.createNamedQuery(jqpl);
			TypedQuery<User> query = em.createQuery(jqpl,User.class);
			query.setParameter("username", username);
			
			if (query.getResultList()!=null) {
				return 0;
			}else {
				return 1;
			}
		} finally {
			em.close();
		}
	}
}
