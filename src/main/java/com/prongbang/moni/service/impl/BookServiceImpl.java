package com.prongbang.moni.service.impl;

import com.prongbang.moni.dao.BookDao;
import com.prongbang.moni.entities.Book;
import com.prongbang.moni.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prongbang
 */
@Service
@Transactional
public class BookServiceImpl extends AbstractServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book findByPK(Integer pk) throws Exception {
        return bookDao.findByPK(pk);
    }

    @Override
    public void save(Book entity) throws Exception {
        bookDao.save(entity);
    }

    @Override
    public void save(List<Book> entityList) throws Exception {
        bookDao.save(entityList);
    }

    @Override
    public void saveOrUpdate(Book entity) throws Exception {
        bookDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdate(List<Book> entityList) throws Exception {
        bookDao.saveOrUpdate(entityList);
    }

    @Override
    public void update(Book entity) throws Exception {
        bookDao.update(entity);
    }

    @Override
    public void update(List<Book> entityList) throws Exception {
        bookDao.update(entityList);
    }

    @Override
    public void delete(Book entity) throws Exception {
        bookDao.delete(entity);
    }

    @Override
    public void delete(List<Book> entityList) throws Exception {
        bookDao.delete(entityList);
    }

    @Override
    public List<Book> findAll() throws Exception {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findLastId() throws Exception {
        return bookDao.findLastId();
    }

}
