package br.com.sulamerica.ats.api.security.dao;

import com.google.appengine.api.datastore.ReadPolicy;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Result;

import java.util.List;
import java.util.Map;

import static com.googlecode.objectify.ObjectifyService.ofy;


public abstract class SecurityObjectifyGenericDAOImpl<T>  implements SecurityObjectifyGenericDAO<T> {

	protected Class<T> clazz;

   	protected SecurityObjectifyGenericDAOImpl(Class<T> clazz)
	{
		this.clazz = clazz;
		ObjectifyService.register(clazz);

	}

	public Key<T> save(T entity) {
		return ofy().consistency(ReadPolicy.Consistency.STRONG).save().entity(entity).now();
	}
	
	@Override
	public Result<Map<Key<T>, T>> saveAll(List<T> entities) {
		Result<Map<Key<T>, T>> entitiesr = ofy().save().entities(entities);
		return entitiesr;
	}
	
	@Override
	public List<T> list() {
		List<T> list = ofy().load().type(clazz).list();
		return list;
	}

	@SuppressWarnings("hiding")
	public <T> T get(Class<T> clazz, Long id) {
		T entityRow = ofy().load().type(clazz).id(id).now();
		return entityRow;
	}
	
	
}