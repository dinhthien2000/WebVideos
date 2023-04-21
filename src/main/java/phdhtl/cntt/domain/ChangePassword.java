package phdhtl.cntt.domain;

public class ChangePassword {
	String username,currentpassword,newpassword,cofirmpassowrd;
	
	public ChangePassword() {
		super();
	}

	public ChangePassword(String username, String currentpassword, String newpassword, String cofirmpassowrd) {
		super();
		this.username = username;
		this.currentpassword = currentpassword;
		this.newpassword = newpassword;
		this.cofirmpassowrd = cofirmpassowrd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCurrentpassword() {
		return currentpassword;
	}

	public void setCurrentpassword(String currentpassword) {
		this.currentpassword = currentpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getCofirmpassowrd() {
		return cofirmpassowrd;
	}

	public void setCofirmpassowrd(String cofirmpassowrd) {
		this.cofirmpassowrd = cofirmpassowrd;
	}
	
	 
}
