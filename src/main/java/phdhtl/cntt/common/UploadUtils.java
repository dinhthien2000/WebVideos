package phdhtl.cntt.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

public class UploadUtils {
	public static String processUploadField(String fieldName,HttpServletRequest request ,
			String storedFolder,String storedFileName) throws IOException, ServletException {
		Part filePart = request.getPart(fieldName); // lấy đường dẫn từ trường input file
		
		// nếu đường dẫn rỗng thì trả về ""
		if (filePart==null || filePart.getSize() == 0) {
			return "";
		}
		
		// lưu ý storedFolder : là tên thư mục để lưu trữ
		// nếu thư mục lưu trữ rỗng thì mặc định set là uploads
		if (storedFolder==null) {
			storedFolder="/uploads";
		}
		
		// nếu tên file lưu trữ rỗng thì get file name từ đường dẫn path ở input
		if (storedFileName==null) {
			storedFileName = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
		}
		// nếu storedFileName được truyền vào tham số hàm thì gán nó với phần mở rộng file từ FilenameUtils ( lấy phần mở rộng từ input file )
		// vd : storedFileName là img thì sẽ gán như này img.png hay img.jpg tùy vào path ở input
		else {
			storedFileName +="."+FilenameUtils.getExtension(Path.of(filePart.getSubmittedFileName()).toString());
		}
		String uploadFolder = request.getServletContext().getRealPath(storedFolder); // lấy đường dẫn thực tế của thư mục lưu trữ
		Path upaloadPath = Paths.get(uploadFolder); // đối tượng path lấy đường dẫn từ uploadFolder ( là đường dẫn đến thư mục storedFolder )
		
		// kiểm tra thư mục đã tồn tại ở đường dẫn đó chưa (upaloadPath)
		if (!Files.exists(upaloadPath)) {
			Files.createDirectories(upaloadPath); // chưa thì tạo 
		}
		
		filePart.write(Paths.get(uploadFolder.toString(),storedFileName).toString()); // ghi nội dung file vào thư mục uploadFolder
		
		return storedFileName;
	}
}
