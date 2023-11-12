package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface CRUDOperation {
	
	public void create(Object o);
	public boolean delete(long id);
	public boolean update(long id, Object o);
	public ArrayList<?> findAll();
	public Object findOne(long id);

}
