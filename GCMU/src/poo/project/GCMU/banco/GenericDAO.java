package poo.project.GCMU.banco;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <PK, T>{
	
	public boolean insert(T entity) throws SQLException;

	public void update(T entity) throws SQLException;

	public boolean delete(PK pk) throws SQLException;

	public List<T> getAll() throws SQLException;

	public T getById(PK pk) throws SQLException;

	public List<T> find(T entity) throws SQLException;

}
