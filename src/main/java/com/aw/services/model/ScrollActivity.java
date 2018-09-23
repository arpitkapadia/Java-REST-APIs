package com.aw.services.model;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ScrollActivity {


	private Integer id;
	
	private Integer scrollTop;
		
	private User user;
	
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USERTABLE_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User userId) {
		this.user = userId;
	}

	public Integer getScrollTop() {
		return scrollTop;
	}

	public void setScrollTop(Integer scrollTop) {
		this.scrollTop = scrollTop;
	}
}
