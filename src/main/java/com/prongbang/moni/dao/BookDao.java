package com.prongbang.moni.dao;

import com.prongbang.moni.entities.Book;
import java.util.List;

/**
 *
 * @author prongbang
 */
public interface BookDao extends AbstractDao<Book, Integer> {
    
    public List<Book> findLastId() throws Exception;
    
}
