package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the couponbook database table.
 * 
 */
@Entity
@NamedQuery(name="Couponbook.findAll", query="SELECT c FROM Couponbook c")
public class Couponbook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String additional;

	private String description;

	private String name;

	public Couponbook() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdditional() {
		return this.additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}