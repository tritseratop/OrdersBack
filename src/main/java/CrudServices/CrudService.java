package CrudServices;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@Dependent
public class CrudService<T> implements CrudInterface<T> {
    @PersistenceContext(unitName = "orders-unit")
    EntityManager entityManager;

    public T save(T t) {
        return entityManager.merge((T)t);
    }

    public T find(Class type, int id) {
        return (T)entityManager.find(type, id);
    }

    public T change(T t) {
        return entityManager.merge(t);
    }

    public void remove(Class type, int id) {
        T t = (T)entityManager.find(type, id);
        entityManager.remove(t);
    }
    public List getAll(String queryName, Class type) {
        return entityManager.createNamedQuery(queryName, type).getResultList();
    }
}
