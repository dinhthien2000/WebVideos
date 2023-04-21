package phdhtl.cntt.domain;

// lớp này sử dụng để lấy thông tin từ form login
public class LoginForm {
	private String username,password;
	private boolean remember;
	
	
	
	public LoginForm() {
		// bỏ super()
	}
	public LoginForm(String username, String password, boolean remember) {
		
		this.username = username;
		this.password = password;
		this.remember = remember;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}
	
	
}
