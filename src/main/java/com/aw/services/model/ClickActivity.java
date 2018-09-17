package com.aw.services.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClickActivity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer pageX;
	
	private Integer pageY;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
