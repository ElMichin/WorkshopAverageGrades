package co.edu.unbosque.beans;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;


@ManagedBean
@RequestScoped
public class LoginBean {

	private String nombre = "";
	private double num1;
	private double num2;
	private double num3;
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	// https://mkyong.com/java/how-to-send-http-request-getpost-in-java/

	public String getNombre() {
		return nombre;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public double getNum3() {
		return num3;
	}

	public void setNum3(double num3) {
		this.num3 = num3;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public double getAverage() {
		return (num1 + num2 + num3) / 3;
	}

	public String getStatus() {
		double average = getAverage();
		if (average > 3 ) {
			return "Aprobado";
		} else if (average== 3){
			return "3 es nota lo demas es lujo";
		}else {
			return "Reprobado";
		}
	

	
	
	}}
