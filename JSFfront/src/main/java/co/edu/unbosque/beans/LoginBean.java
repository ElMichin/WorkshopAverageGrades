package co.edu.unbosque.beans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String nombre = "";
	private int num1;
	private int num2;
	private int num3;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	// https://mkyong.com/java/how-to-send-http-request-getpost-in-java/

	public String getNombre() {
		return nombre;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAverage() {
		return (num1 + num2 + num3) / 3;
	}

	public String getStatus() {
		int average = getAverage();
		if (average > 3 ) {
			return "Aprobado";
		} else if (average== 3){
			return "3 es nota lo demas es lujo";
		}else {
			return "Reporabdo";
		}
	}
}
