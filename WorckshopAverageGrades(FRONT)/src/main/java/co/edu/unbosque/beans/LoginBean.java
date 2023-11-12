package co.edu.unbosque.beans;

import co.edu.unbosque.controller.HttpClientSynchronous;
import co.edu.unbosque.util.AESUtil;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String nombre = "";
	private long num1 = 0;
	private long num2 = 0;
	private long num3 = 0;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	// https://mkyong.com/java/how-to-send-http-request-getpost-in-java/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getNum1() {
		return num1;
	}

	public void setNum1(long num1) {
		this.num1 = num1;
	}

	public long getNum2() {
		return num2;
	}

	public void setNum2(long num2) {
		this.num2 = num2;
	}

	public long getNum3() {
		return num3;
	}

	public void setNum3(long num3) {
		this.num3 = num3;
	}

	public Long getAverage() {
		return (num1 + num2 + num3) / 3;
	}
	
	public void create() {
		HttpClientSynchronous.doPost("http://localhost:8081/user/createuserjson",
				"{\r\n" + "\r\n" + "  \"username\": \"" + AESUtil.encrypt(nombre) + "\",\r\n" + "  \"firstCut\": \""
						+ AESUtil.encrypt(String.valueOf(num1)) + "\",\r\n" + "  \"secondCut\": \""
						+ AESUtil.encrypt(String.valueOf(num2)) + "\",\r\n" + "  \"thirdCut\": \""
						+ AESUtil.encrypt(String.valueOf(num3)) + "\",\r\n" + "  \"result\": \""
						+ AESUtil.encrypt(String.valueOf(getAverage())) + "\"\r\n" + "}");
	}

	public String getStatus() {
		Long average = getAverage();
		if (average > 3) {
			create();
			return "Aprobado";
		} else if (average == 3) {
			create();
			return "3 es nota lo demas es lujo";
		} else {
			create();
			return "Reporabdo";
		}
	}


}
