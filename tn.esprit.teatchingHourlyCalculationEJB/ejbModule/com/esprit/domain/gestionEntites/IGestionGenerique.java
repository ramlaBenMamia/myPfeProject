package com.esprit.domain.gestionEntites;

import java.util.List;

public interface IGestionGenerique<T> {
	public void add(T t);

	void deleteByMat(String mat);
	void delete(T t);

	void update(T t);

	T findByMat(String mat);

	public List<T> findAll();

}
