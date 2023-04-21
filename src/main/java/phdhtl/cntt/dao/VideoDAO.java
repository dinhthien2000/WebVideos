package phdhtl.cntt.dao;




import phdhtl.cntt.model.Video;

// kế thừa AbstractEntityDAO<T> và xác định kiểu <T> là Video ( thực thể hay Entity )
public class VideoDAO extends AbstractEntityDAO<Video> {

	public VideoDAO() {
		super(Video.class); // gọi thưc hiện phương thức hay là gọi hàm dựng của lớp cha truyền vào đối tượng là thể hiện của lớp  Class trong java
		
	}
	
	// các phương thức CRUD đã được định nghĩa kế thừa từ AbstractEntityDAO
	/*public void insert(Video video) {
		EntityManager em = JpaUtils.getEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			
			em.persist(video); // lưu dữ liệu user class rồi chuyển vào tbl user
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			em.close();
		}
		
	}*/
}
