package co.edu.unbosque.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userating")
public class User {

	private @Id @GeneratedValue(strategy = GenerationType.TABLE) Long id;
	private String username;
	private String firstCut;
	private String secondCut;
	private String thirdCut;
	private String result;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String firstCut, String secondCut, String thirdCut, String result) {
		super();
		this.username = username;
		this.firstCut = firstCut;
		this.secondCut = secondCut;
		this.thirdCut = thirdCut;
		this.result = result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstCut() {
		return firstCut;
	}

	public void setFirstCut(String firstCut) {
		this.firstCut = firstCut;
	}

	public String getSecondCut() {
		return secondCut;
	}

	public void setSecondCut(String secondCut) {
		this.secondCut = secondCut;
	}

	public String getThirdCut() {
		return thirdCut;
	}

	public void setThirdCut(String thirdCut) {
		this.thirdCut = thirdCut;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
