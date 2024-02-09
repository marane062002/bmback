package com.bmh.services;
import java.util.List;

public interface IUtileService<T> {
    T save(T paramT);

    T update(Long paramLong, T paramT);

    List<T> all();

    void delete(Long paramLong);

    T findById(Long paramLong);
}

