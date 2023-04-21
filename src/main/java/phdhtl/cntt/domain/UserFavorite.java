package phdhtl.cntt.domain;

import java.util.Date;

public class UserFavorite {
	String username,fullname,email;
	Date favoritedate;
	
	public UserFavorite() {
		
	}
	
	public UserFavorite(String username, String fullname, String email, Date favoritedate) {
		
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.favoritedate = favoritedate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFavoritedate() {
		return favoritedate;
	}
	public void setFavoritedate(Date favoritedate) {
		this.favoritedate = favoritedate;
	}
	
	
	
}
