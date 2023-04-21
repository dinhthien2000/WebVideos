package phdhtl.cntt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the favorites database table.
 * 
 */
@Entity
@Table(name="favorites")
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "favoriteid")
	private int favoriteid;

	@Temporal(TemporalType.DATE)
	private Date likeddate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="videoid")
	private Video video;

	public Favorite() {
	}

	public int getFavoriteid() {
		return this.favoriteid;
	}

	public void setFavoriteid(int favoriteid) {
		this.favoriteid = favoriteid;
	}

	public Date getLikeddate() {
		return this.likeddate;
	}

	public void setLikeddate(Date likeddate) {
		this.likeddate = likeddate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}