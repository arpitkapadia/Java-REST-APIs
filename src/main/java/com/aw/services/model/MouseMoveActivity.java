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
public class MouseMoveActivity {


	private Integer id;
	
	private Integer pageX;
	
	private Integer pageY;
	
	private User user;
	
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    String documentName;

	
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

	public Integer getPageX() {
		return pageX;
	}

	public void setPageX(Integer pageX) {
		this.pageX = pageX;
	}

	public Integer getPageY() {
		return pageY;
	}

	public void setPageY(Integer pageY) {
		this.pageY = pageY;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USERTABLE_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User userId) {
		this.user = userId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
}

