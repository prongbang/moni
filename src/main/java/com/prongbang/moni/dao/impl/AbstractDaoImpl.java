package com.prongbang.moni.dao.impl;

import com.prongbang.moni.dao.AbstractDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author prongbang
 * @param <T>
 * @param <PK>
 */
public class AbstractDaoImpl<T, PK extends Serializable> implements AbstractDao<T, PK>, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDaoImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findByPK(PK pk) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        T entity = (T) session.get(this.persistentClass, pk);
        return entity;
    }

    @Override
    public void save(T entity) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    @Override
    public void save(List<T> entityList) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        try {
            for (T entity : entityList) {
                session.save(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(T entity) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public void update(List<T> entityList) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        try {
            for (T entity : entityList) {
                session.update(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(T entity) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
    }

    @Override
    public void delete(List<T> entityList) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        try {
            for (T entity : entityList) {
                session.delete(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() throws Exception {
        Session session = sessionFactory.getCurrentSession();
        List<T> entityList = session.createCriteria(this.persistentClass).list();
        return entityList;
    }

    @Override
    public void saveOrUpdate(T entity) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdate(List<T> entityList) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        try {
            for (T entity : entityList) {
                session.saveOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
