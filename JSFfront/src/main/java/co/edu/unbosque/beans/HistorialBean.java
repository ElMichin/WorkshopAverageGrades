package co.edu.unbosque.beans;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;


@ManagedBean
@RequestScoped
public class HistorialBean {

	private List<String> historial;
	
	
	 public HistorialBean() {
		historial = new ArrayList<>();
		historial.add("Busqueda 1");
		historial.add("Busqueda 2");
		historial.add("Busqueda 3");
	}


	public List<String> getHistorial() {
		return historial;
	}


	public void setHistorial(List<String> historial) {
		this.historial = historial;
	}
	 
}
