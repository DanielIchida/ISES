package modelos;

import java.util.List;

public interface DAO<T> {
    public boolean add(T entity);
    public T item(Object o);
    public boolean update(T entity);
    public boolean delete(T entity);
    public List<T> getList();
}
