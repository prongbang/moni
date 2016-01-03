package com.prongbang.moni.service;

import com.prongbang.moni.entities.Book;
import java.util.List;

/**
 *
 * @author prongbang
 */
public interface BookService extends AbstractService<Book, Integer> {

    public List<Book> findLastId() throws Exception;  

}
