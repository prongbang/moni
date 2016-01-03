package com.prongbang.moni.webservice.controller;

import com.google.gson.Gson;
import com.prongbang.moni.entities.Book;
import com.prongbang.moni.service.BookService; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author prongbang
 */
@RestController
@RequestMapping("/service")
public class BookRestController {
    
    @Autowired
    BookService bookService;
    
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<Book> findAll() throws Exception {
        
        return bookService.findAll();
    }
    
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String findByPK(@PathVariable("id") Integer id) throws Exception {
        
        return new Gson().toJson(bookService.findByPK(id));
    }
}
