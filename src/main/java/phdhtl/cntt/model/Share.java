package phdhtl.cntt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the shares database table.
 * 
 */
@Entity
@Table(name="shares")
@NamedQuery(name="Share.findAll", query="SELECT s FROM Share s")
public class Share implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "shareid")
	private int shareid;
	
	@Column(name = "emails")
	private String emails;

	@Temporal(TemporalType.DATE)
	private Date shareddate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="videoid")
	private Video video;

	public Share() {
	}

	public int getShareid() {
		return this.shareid;
	}

	public void setShareid(int shareid) {
		this.shareid = shareid;
	}

	public String getEmails() {
		return this.emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public Date getShareddate() {
		return this.shareddate;
	}

	public void setShareddate(Date shareddate) {
		this.shareddate = shareddate;
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