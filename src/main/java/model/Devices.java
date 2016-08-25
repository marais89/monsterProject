/**
 * 
 */
package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author ma.raies
 * 27 juil. 2016 22:48:16
 */

@Entity
@Table(name = "devices", catalog = "molisdb")
public class Devices implements java.io.Serializable {

	private Integer deviceId;
	private String nom;
	private String type;
	private String os;
	private String description;
	private boolean etat;

	public Devices() {
	}

	public Devices(String nom, String type, String os,
			String description, boolean etat) {
		this.nom = nom;
		this.type = type;
		this.os = os;
		this.description = description;
		this.etat = etat;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(Integer Id) {
		this.deviceId = Id;
	}

	@Column(name = "nom", unique = true, nullable = false, length = 80)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "type", nullable = false, length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "os", nullable = false, length = 50)
	public String getOS() {
		return this.os;
	}

	public void setOS(String os) {
		this.os = os;
	}

	@Column(name = "description", nullable = false, length = 41)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "etat", nullable = true)
	public boolean getEtat() {
		return this.etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
}
