package org.psvmsa.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T, ID> {

    T create(T entity);

    Optional<T> get(ID id);

    List<T> getAll();

    void update(T entity);

    void delete(T entity);
}
