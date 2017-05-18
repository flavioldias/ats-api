package br.com.sulamerica.ats.api.repository.datastore;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Result;

import java.util.List;
import java.util.Map;

public interface SecurityObjectifyGenericDAO<T> {

    public Key<T> save(T entity);
	public Result<Map<Key<T>, T>> saveAll(List<T> entity);
	public List<T> list();
	public <T> T get(Class<T> clazz, Long id);


}