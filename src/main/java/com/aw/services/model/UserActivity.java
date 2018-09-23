package com.aw.services.model;


import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class UserActivity {
	

	private Integer id;
	
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private User user;
    
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean status;
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ACTIVITY_ID")
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
