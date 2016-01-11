package com.prongbang.moni.web.controller;

import com.prongbang.moni.entities.Book;
import com.prongbang.moni.service.BookService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author prongbang
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap model) throws Exception {

        model.addAttribute("books", bookService.findAll());
        model.addAttribute("book", bookService.findLastId());

        return "book";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Object add(@RequestBody Book book) throws Exception {

        Map<String, Object> result = new HashMap<String, Object>();

        try {

            bookService.save(book);
            result.put("result", 1);

        } catch (Exception ex) {

            result.put("result", 0);

        }
        List<Book> b = bookService.findLastId();
        Long id = 1L;
        if (b != null) {

            id = Long.parseLong(b.get(0).getId() + "") + 1;

        }
        result.put("id", id);

        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") Integer id) throws Exception {

        Map<String, Object> result = new HashMap<String, Object>();

        try {

            Book book = new Book();
            book.setId(id);
            bookService.delete(book);

        } catch (Exception ex) {

        }

        return "redirect:../book/";
    }

}
