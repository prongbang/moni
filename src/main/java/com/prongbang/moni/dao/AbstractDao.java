package com.prongbang.moni.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author prongbang
 * @param <T>
 * @param <PK>
 */
public interface AbstractDao<T, PK extends Serializable> {

    public T findByPK(PK pk) throws Exception;

    public void save(T entity) throws Exception;

    public void save(List<T> entityList) throws Exception;

    public void saveOrUpdate(T entity) throws Exception;

    public void saveOrUpdate(List<T> entityList) throws Exception;

    public void update(T entity) throws Exception;

    public void update(List<T> entityList) throws Exception;

    public void delete(T entity) throws Exception;

    public void delete(List<T> entityList) throws Exception;

    public List<T> findAll() throws Exception;

}
