package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParticipationId implements java.io.Serializable {
	
	private Integer id_user;
	private Integer id_reunion;
	
	public ParticipationId() {
	}
	
	public ParticipationId(Integer id_user, Integer id_reunion) {
		super();
		this.id_user = id_user;
		this.id_reunion = id_reunion;
	}
@Column(name="id_user", nullable=false)
	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	@Column(name="id_reunion", nullable=false)
	public Integer getId_reunion() {
		return id_reunion;
	}

	public void setId_reunion(Integer id_reunion) {
		this.id_reunion = id_reunion;
	}
	
	

}
