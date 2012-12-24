package com.esprit.domain.gestionEntites;

import java.util.List;

public interface IGestionGeneric<T> {
	public void add(T t);

	void deleteByRef(int ref);

	void delete(T t);

	void update(T t);

	T findByRef(int ref);

	public List<T> findAll();

}
