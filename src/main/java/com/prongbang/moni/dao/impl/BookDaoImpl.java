package com.prongbang.moni.dao.impl;

import com.prongbang.moni.dao.BookDao;
import com.prongbang.moni.entities.Book;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author prongbang
 */
@Repository
public class BookDaoImpl extends AbstractDaoImpl<Book, Integer> implements BookDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> findLastId() throws Exception {

        StringBuffer sql = new StringBuffer();
        sql.append("SELECT TOP 1 id FROM book order by id desc");
        SQLQuery query = getCurrentSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.aliasToBean(Book.class));
        try {
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
