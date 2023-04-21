package phdhtl.cntt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



//tìm kiếm entity theo id ( lưu ý trong hibernate jpa lưu trữ , thay đổi , xóa, tìm kiếm qua các class Entity trong model xong
//rồi mới chuyển đổi ( convert ) vào các bảng trong csdl ) )

public abstract class AbstractEntityDAO<T> { // <T> ở đây thể hiện là một kiểu entity
	private Class<T> entityClass;

	// hàm tạo : truyền vào Lớp thể hiện của lớp Class và xác định <T>
	public AbstractEntityDAO(Class<T> cls) {
		this.entityClass = cls;
	}

	// truyền vào T entity ( T là kiểu của entity nào đó vd như : videos,
	// shares,...)
	public void insert(T entity) {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			em.persist(entity);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public void update(T entity) {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			em.merge(entity);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	// hàm xóa entity dựa vào id
	public void delete(Object id) {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

			T entity = em.find(entityClass, id); // dùng phương thức find để tìm entity bằng id rồi gán vào thể entity

			em.remove(entity); // xóa entity
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	// thực hiện truy vấn không cần transaction
	public T findById(Object id) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			

			T entity = em.find(entityClass, id);

			return entity; // trả về thể hiện của entity ( một đối tượng được tìm thấy trong csdl truyền vào entity )
		} finally {
			em.close();
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	// tìm kiếm và trả về toàn bộ danh sách
	public List<T> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			// CriteriaQuery : cho phép xây dựng truy vấn và
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();

			cq.select(cq.from(entityClass)); // sử dụng phương thức from để tạo ra truy vấn từ entityClass , select tạo
												// ra mệnh đề select để truy vấn đến entityClass này

			return em.createQuery(cq).getResultList(); // em gọi createQuery ( tạo truy vấn ) và getResultList : tạo ra
														// và trả về danh sách tìm thấy được
		} finally {
			em.close(); // thực đóng EntityManager
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	// phân trang : all = true trả về tất cả còn false thì phân trang ,giá trị Entity đầu tiên , số Entity trả về
	public List<T> findAll(Boolean all, int firstResult, int maxResult) {
		EntityManager em = JpaUtils.getEntityManager();

		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();

			cq.select(cq.from(entityClass));
			Query q = em.createQuery(cq); // trả về một Query

			if (!all) {
				q.setFirstResult(firstResult); // trong Query thiết lập giá trị đầu
				q.setMaxResults(maxResult); // trong Query thiết lập giá trị tối đa ( số phần tử trả về )
			}

			return q.getResultList(); // trả về một danh sách tìm thấy thỏa mãn các điều kiện đưa ra
		} finally {

			em.close();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Long count() {
		EntityManager em = JpaUtils.getEntityManager();

		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery(); // xây dựng CriteriaQuery

			// Root<T> thành phần gốc <T>
			Root<T> rt = cq.from(entityClass);

			cq.select(em.getCriteriaBuilder().count(rt)); // count(rt) đếm số phần tử mà chúng ta xác định

			Query q = em.createQuery(cq); // đối tượng thể hiện của query
			return (Long) q.getSingleResult();
		}finally {
			em.close();
		}

	}

}
