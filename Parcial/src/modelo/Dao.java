package modelo;

import java.util.List;

public interface Dao<T> {
	
	public List<T> getAllData();
	public T getData(int id);
	public void updateData(T t);
	public void deleteData(int id);
	public void insert(T t);

}
