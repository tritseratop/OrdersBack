package CrudServices;

import Entities.Category;

public interface CrudInterface<T> {
    public T save(T t);
    public T find(Class type, int id);
    public void remove(Class type, int id);
    public T change(T t);
}
