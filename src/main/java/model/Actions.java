/**
 * 
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author ma.raies
 * 4 janv. 2016 11:23:40
 */
@Entity
@Table(name = "actions", catalog = "molisdb")
public class Actions implements java.io.Serializable {

	private Integer id;
	private String title;
	private String description;
	private Date creation_date;
	private  Date realization_date;
	private Users user;
	private String type;
	private boolean stat;


	public Actions() {
	}

	public Actions(String title, String description, Date creation_date,
			Date realization_date, Users user) {
		this.title = title;
		this.description = description;
		this.creation_date = creation_date;
		this.realization_date = realization_date;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name = "title", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", nullable = false, length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "creation_date", nullable = false)
	public Date getCreationDate() {		
		return this.creation_date;
	}

	public void setCreationDate(Date creation_date) {
		this.creation_date = creation_date;
	}

	@Column(name = "realization_date", nullable = false)
	public Date getRealization_date() {
		return this.realization_date;
	}

	public void setRealization_date(Date realization_date) {
		this.realization_date = realization_date;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Column(name = "type", nullable = false, length = 10)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "stat")
	public boolean isStat() {
		return stat;
	}

	public void setStat(boolean stat) {
		this.stat = stat;
	}
	
	@Override
	public String toString() {
		return "####### Action [id=" + id + ", titre=" + title
				+ ", creation_date=" + creation_date + ", realization_date=" + realization_date + ", type="
				+ type +", etat="+stat+", user="+user.getFirstName();
	}
	
	
}





