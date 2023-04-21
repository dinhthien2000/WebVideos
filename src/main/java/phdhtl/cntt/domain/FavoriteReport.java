package phdhtl.cntt.domain;

import java.util.Date;

public class FavoriteReport {
	private String videotitle;
	private Long count ;
	private Date newsestdate,oldestdate; // sử dụng date của util không phải của sql
	
	
	
	
	public FavoriteReport() {
		super();
	}
	public FavoriteReport(String videotitle, Long count, Date newsestdate, Date oldestdate) {
		
		this.videotitle = videotitle;
		this.count = count;
		this.newsestdate = newsestdate;
		this.oldestdate = oldestdate;
	}
	public String getVideotitle() {
		return videotitle;
	}
	public void setVideotitle(String videotitle) {
		this.videotitle = videotitle;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Date getNewsestdate() {
		return newsestdate;
	}
	public void setNewsestdate(Date newsestdate) {
		this.newsestdate = newsestdate;
	}
	public Date getOldestdate() {
		return oldestdate;
	}
	public void setOldestdate(Date oldestdate) {
		this.oldestdate = oldestdate;
	}
	
	
}
