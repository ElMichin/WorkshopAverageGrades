package co.edu.unbosque.service;

import java.util.List;

public interface CRUDOperation<T> {

	public int create(T data);

	public List<T> getAll();
}
